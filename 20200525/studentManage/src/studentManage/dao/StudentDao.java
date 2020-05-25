package studentManage.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import studentManage.vo.Score;
import studentManage.vo.Student;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

//封装对Student对象的各类操作，一个操作对应一个方法
public class StudentDao {

	/**
	 * 从txt文件中读取数据，创建对象，将对象存放于集合中， 增加到集合时需要检查对象的id和courceName是否与集合中的对象重复，如果重复，则不增加
	 */

	public ArrayList<Student> loadDataFromTxt(String fileName, ArrayList<Student> studentList) throws Exception {

		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		br.readLine();
		String aLine = "";
		int count = 0;
		while ((aLine = br.readLine()) != null) {
			Student student = new Student(aLine);
			if (!checkStudentExist(student, studentList)) {
				studentList.add(student);
				count++;
			}
		}

		br.close();
		fr.close();
		System.out.println("成功导入" + count + "个数据！");
		displayStudent(studentList);
		return studentList;

	}

	/**
	 * 从XLS文件中读取数据，创建对象，将对象存放于集合中， 增加到集合时需要检查对象的id和courceName是否与集合中的对象重复，如果重复，则不增加
	 */
	public ArrayList<Student> loadDataFromXLS(String fileName, ArrayList<Student> studentList) throws Exception {

		Workbook workbook = Workbook.getWorkbook(new File(fileName));
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		int count = 0;
		for (int i = 1; i < rows; i++) {
			String id = sheet.getCell(0, i).getContents();
			String studentName = sheet.getCell(1, i).getContents();
			String gender = sheet.getCell(2, i).getContents();
			String courceName = sheet.getCell(3, i).getContents();
			String score = sheet.getCell(4, i).getContents();
			Student student = new Student(id, studentName, gender, courceName, Double.parseDouble(score));
			if (!checkStudentExist(student, studentList)) {
				studentList.add(student);
				count++;
			}

		}
		workbook.close();
		System.out.println("成功导入" + count + "个数据！");
		displayStudent(studentList);

		return studentList;

	}

	/**
	 * 从XML文件中读取数据，创建对象，将对象存放于集合中， 增加到集合时需要检查对象的id和courceName是否与集合中的对象重复，如果重复，则不增加
	 */
	public ArrayList<Student> loadDataFromXML(String fileName, ArrayList<Student> studentList) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(fileName));
		Element rootElement = document.getRootElement();
		int count = 0;
		for (Iterator it = rootElement.elementIterator(); it.hasNext();) {
			Element element = (Element) it.next();
			String id = element.element("id").getText();
			String studentName = element.element("studentName").getText();
			String gender = element.element("gender").getText();
			String courceName = element.element("courceName").getText();
			String score = element.element("score").getText();
			Student student = new Student(id, studentName, gender, courceName, Double.parseDouble(score));
			if (!checkStudentExist(student, studentList)) {
				studentList.add(student);
				count++;
			}
		}

		System.out.println("成功导入" + count + "个数据！");
		displayStudent(studentList);

		return studentList;

	}

	/**
	 * 从JSON文件中读取数据，创建对象，将对象存放于集合中， 增加到集合时需要检查对象的id和courceName是否与集合中的对象重复，如果重复，则不增加
	 */
	public ArrayList<Student> loadDataFromJson(String fileName, ArrayList<Student> studentList) throws Exception {

		/**
		 * 请注意文件的编码类型，默认以ANSI编码打开，如果文件中有汉字，文件编码是其他编码类型（如utf-8），直接打开会出现汉字打开乱码，
		 * 此时必须使用转换流，指定编码类型
		 */
		BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
		// BufferedReader br = new
		// BufferedReader(newInputStreamReader(newFileInputStream(fileName),"utf-8"));

		StringBuffer sb = new StringBuffer();

		String aLine = "";

		while ((aLine = br.readLine()) != null) {
			sb.append(aLine);
		}
		br.close();

		String json = sb.toString();

		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(json);

		int count = 0;
		JsonArray jsonArray = element.getAsJsonArray();
		for (JsonElement jsonElement : jsonArray) {
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			String id = jsonObject.get("id").getAsString();
			String studentName = jsonObject.get("studentName").getAsString();
			String gender = jsonObject.get("gender").getAsString();
			String courceName = jsonObject.get("courceName").getAsString();
			double score = jsonObject.get("score").getAsDouble();

			Student student = new Student(id, studentName, gender, courceName, score);
			if (!checkStudentExist(student, studentList)) {
				studentList.add(student);
				count++;
			}
		}

		System.out.println("成功导入" + count + "个数据！");
		displayStudent(studentList);

		return studentList;

	}

	/**
	 * 通过键盘输入数据，创建对象，将对象存放于集合中， 增加到集合时需要检查对象的id和courceName是否与集合中的对象重复，如果重复，则不增加
	 */
	public ArrayList<Student> loadDataFromKeyboard(ArrayList<Student> studentList) {
		System.out.println("请输入学生信息(各字段间以tab键分隔，如10001	小张	男	网络原理	90)：");
		Scanner scan = new Scanner(System.in);
		String aLine = scan.nextLine();
		Student student = new Student(aLine);
		if (!checkStudentExist(student, studentList)) {
			studentList.add(student);
			System.out.println("成功增加");
		} else {
			System.out.println("id和课程名已存在，增加失败！");
		}

		displayStudent(studentList);

		return studentList;

	}

	// 按学号查询显示所有课程的成绩
	public void getScoreById(ArrayList<Student> studentList) {
		System.out.println("请输入待查询的学生学号：");
		Scanner scan = new Scanner(System.in);
		String id = scan.nextLine();

		ArrayList<Student> findList = new ArrayList<Student>();

		for (Student student : studentList) {
			if (id.equals(student.getId())) {
				findList.add(student);
			}
		}

		if (findList.size() == 0) {
			System.out.println("没查到该id的成绩！");
		} else {
			displayStudent(findList);
		}

	}

	// 写入到txt文件
	public void writeToTxt(String fileName, ArrayList<Student> studentList) throws Exception {
		ArrayList<Score> scoreList = scoreStatics(studentList);

		File file = new File(fileName);
		PrintWriter pw = new PrintWriter(new FileWriter(file));

		// PrintWriter pw=new PrintWriter(new OutputStreamWriter(new
		// FileOutputStream(file),"utf-8"));

		pw.println("学号\t姓名\t性别\t总分\t平均分");
		pw.println("===============================");
		for (Score score : scoreList) {
			pw.println(score.toString());
		}

		System.out.println("写入TXT文件成功！");

		pw.close();
	}

	// 写入到XLS文件
	public void writeToXLS(String fileName, ArrayList<Student> studentList) throws Exception {
		ArrayList<Score> scoreList = scoreStatics(studentList);

		WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
		WritableSheet sheet = workbook.createSheet("成绩统计", 0);
		String title[] = { "学号", "姓名", "性别", "总成绩", "平均分" };

		Label label = null;
		// 第一行标题
		for (int i = 0; i < title.length; i++) {
			label = new Label(i, 0, title[i]);
			sheet.addCell(label);
		}
		// 从第二行开始写数据
		for (int i = 1; i <= scoreList.size(); i++) {
			Score score = scoreList.get(i - 1);

			label = new Label(0, i, score.getId());
			sheet.addCell(label);

			label = new Label(1, i, score.getStudentName());
			sheet.addCell(label);

			label = new Label(2, i, score.getGender());
			sheet.addCell(label);

			label = new Label(3, i, String.valueOf(score.getTotalScore()));
			sheet.addCell(label);

			label = new Label(4, i, String.valueOf(score.getAverage()));
			sheet.addCell(label);
		}

		workbook.write();
		workbook.close();

		System.out.println("写入XLS文件成功！");

	}

	// 写入到XML文件
	public void writeToXML(String fileName, ArrayList<Student> studentList) throws Exception {
		ArrayList<Score> scoreList = scoreStatics(studentList);

		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("data");// 创建根节点

		for (Score score : scoreList) {
			Element scoreElement = root.addElement("student");

			scoreElement.addElement("id").setText(score.getId());
			scoreElement.addElement("studentName").setText(score.getStudentName());
			scoreElement.addElement("gender").setText(score.getGender());
			scoreElement.addElement("totalScore").setText(String.valueOf(score.getTotalScore()));
			scoreElement.addElement("average").setText(String.valueOf(score.getAverage()));
		}

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8"); // 指定XML文档申明处的编码
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName)), "utf-8"),
				format);

		// XMLWriter writer = new XMLWriter(new FileWriter(fileName),format);
		writer.write(document);
		writer.close();

		System.out.println("写入XML文件成功！");

	}

	//// 写入到JSON文件
	public void writeToJson(String fileName, ArrayList<Student> studentList) throws Exception {

		String jsonStr = (new Gson()).toJson(studentList);

		File file = new File(fileName);
		PrintWriter pw = new PrintWriter(new FileWriter(file));
		pw.print(jsonStr);

		pw.close();

		System.out.println("写入JSON文件成功！");

	}

	/**
	 * 检查给定对象的id与courceName是否与集合中的对象重复
	 */
	public boolean checkStudentExist(Student student, ArrayList<Student> studentList) {
		boolean result = false;
		for (Student stu : studentList) {
			if (stu.getId().equals(student.getId()) && stu.getCourceName().equals(student.getCourceName())) {
				result = true;
				break;
			}
		}
		return result;
	}

	// 求解每个学生的总分及平均分，存放于集合中
	public ArrayList<Score> scoreStatics(ArrayList<Student> studentList) {
		ArrayList<Score> scoreList = new ArrayList<Score>();
		for (Student student : studentList) {
			String id = student.getId();

			int index = existInScoreList(scoreList, id);
			// 该id在结果集合中存在,则修改集合中相应的对象
			if (index != -1) {
				Score score = scoreList.get(index);
				score.setCount(score.getCount() + 1); // 课程门数加1
				score.setTotalScore(score.getTotalScore() + student.getScore()); // 总分累加
				score.setAverage(score.getTotalScore() / score.getCount());
				scoreList.set(index, score); // 修改结果集合中该对象
			} else { // 不存在，增加到结果集合中
				Score score = new Score(student.getId(), student.getStudentName(), student.getGender(),
						student.getScore(), 1, student.getScore());

				scoreList.add(score);
			}
		}

		return scoreList;
	}

	// 在scoreList中查询指定id的对象，返回该对象在集合中的位置，如返回为-1，则表示未找到
	public int existInScoreList(ArrayList<Score> scoreList, String id) {
		int index = -1;
		for (int i = 0; i < scoreList.size(); i++) {
			Score score = scoreList.get(i);
			if (score.getId().equals(id)) {
				index = i;
				break;
			}
		}

		return index;
	}

	/**
	 * 输出集合中的数据
	 * 
	 * @param studentList
	 */
	public void displayStudent(ArrayList<Student> studentList) {
		System.out.println("学号\t姓名\t性别\t课程\t成绩");
		System.out.println("===================================");
		for (Student student : studentList) {
			System.out.println(student.toString());
		}

	}

}
