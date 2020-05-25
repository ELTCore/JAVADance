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

//��װ��Student����ĸ��������һ��������Ӧһ������
public class StudentDao {

	/**
	 * ��txt�ļ��ж�ȡ���ݣ��������󣬽��������ڼ����У� ���ӵ�����ʱ��Ҫ�������id��courceName�Ƿ��뼯���еĶ����ظ�������ظ���������
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
		System.out.println("�ɹ�����" + count + "�����ݣ�");
		displayStudent(studentList);
		return studentList;

	}

	/**
	 * ��XLS�ļ��ж�ȡ���ݣ��������󣬽��������ڼ����У� ���ӵ�����ʱ��Ҫ�������id��courceName�Ƿ��뼯���еĶ����ظ�������ظ���������
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
		System.out.println("�ɹ�����" + count + "�����ݣ�");
		displayStudent(studentList);

		return studentList;

	}

	/**
	 * ��XML�ļ��ж�ȡ���ݣ��������󣬽��������ڼ����У� ���ӵ�����ʱ��Ҫ�������id��courceName�Ƿ��뼯���еĶ����ظ�������ظ���������
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

		System.out.println("�ɹ�����" + count + "�����ݣ�");
		displayStudent(studentList);

		return studentList;

	}

	/**
	 * ��JSON�ļ��ж�ȡ���ݣ��������󣬽��������ڼ����У� ���ӵ�����ʱ��Ҫ�������id��courceName�Ƿ��뼯���еĶ����ظ�������ظ���������
	 */
	public ArrayList<Student> loadDataFromJson(String fileName, ArrayList<Student> studentList) throws Exception {

		/**
		 * ��ע���ļ��ı������ͣ�Ĭ����ANSI����򿪣�����ļ����к��֣��ļ������������������ͣ���utf-8����ֱ�Ӵ򿪻���ֺ��ִ����룬
		 * ��ʱ����ʹ��ת������ָ����������
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

		System.out.println("�ɹ�����" + count + "�����ݣ�");
		displayStudent(studentList);

		return studentList;

	}

	/**
	 * ͨ�������������ݣ��������󣬽��������ڼ����У� ���ӵ�����ʱ��Ҫ�������id��courceName�Ƿ��뼯���еĶ����ظ�������ظ���������
	 */
	public ArrayList<Student> loadDataFromKeyboard(ArrayList<Student> studentList) {
		System.out.println("������ѧ����Ϣ(���ֶμ���tab���ָ�����10001	С��	��	����ԭ��	90)��");
		Scanner scan = new Scanner(System.in);
		String aLine = scan.nextLine();
		Student student = new Student(aLine);
		if (!checkStudentExist(student, studentList)) {
			studentList.add(student);
			System.out.println("�ɹ�����");
		} else {
			System.out.println("id�Ϳγ����Ѵ��ڣ�����ʧ�ܣ�");
		}

		displayStudent(studentList);

		return studentList;

	}

	// ��ѧ�Ų�ѯ��ʾ���пγ̵ĳɼ�
	public void getScoreById(ArrayList<Student> studentList) {
		System.out.println("���������ѯ��ѧ��ѧ�ţ�");
		Scanner scan = new Scanner(System.in);
		String id = scan.nextLine();

		ArrayList<Student> findList = new ArrayList<Student>();

		for (Student student : studentList) {
			if (id.equals(student.getId())) {
				findList.add(student);
			}
		}

		if (findList.size() == 0) {
			System.out.println("û�鵽��id�ĳɼ���");
		} else {
			displayStudent(findList);
		}

	}

	// д�뵽txt�ļ�
	public void writeToTxt(String fileName, ArrayList<Student> studentList) throws Exception {
		ArrayList<Score> scoreList = scoreStatics(studentList);

		File file = new File(fileName);
		PrintWriter pw = new PrintWriter(new FileWriter(file));

		// PrintWriter pw=new PrintWriter(new OutputStreamWriter(new
		// FileOutputStream(file),"utf-8"));

		pw.println("ѧ��\t����\t�Ա�\t�ܷ�\tƽ����");
		pw.println("===============================");
		for (Score score : scoreList) {
			pw.println(score.toString());
		}

		System.out.println("д��TXT�ļ��ɹ���");

		pw.close();
	}

	// д�뵽XLS�ļ�
	public void writeToXLS(String fileName, ArrayList<Student> studentList) throws Exception {
		ArrayList<Score> scoreList = scoreStatics(studentList);

		WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
		WritableSheet sheet = workbook.createSheet("�ɼ�ͳ��", 0);
		String title[] = { "ѧ��", "����", "�Ա�", "�ܳɼ�", "ƽ����" };

		Label label = null;
		// ��һ�б���
		for (int i = 0; i < title.length; i++) {
			label = new Label(i, 0, title[i]);
			sheet.addCell(label);
		}
		// �ӵڶ��п�ʼд����
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

		System.out.println("д��XLS�ļ��ɹ���");

	}

	// д�뵽XML�ļ�
	public void writeToXML(String fileName, ArrayList<Student> studentList) throws Exception {
		ArrayList<Score> scoreList = scoreStatics(studentList);

		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("data");// �������ڵ�

		for (Score score : scoreList) {
			Element scoreElement = root.addElement("student");

			scoreElement.addElement("id").setText(score.getId());
			scoreElement.addElement("studentName").setText(score.getStudentName());
			scoreElement.addElement("gender").setText(score.getGender());
			scoreElement.addElement("totalScore").setText(String.valueOf(score.getTotalScore()));
			scoreElement.addElement("average").setText(String.valueOf(score.getAverage()));
		}

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8"); // ָ��XML�ĵ��������ı���
		XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName)), "utf-8"),
				format);

		// XMLWriter writer = new XMLWriter(new FileWriter(fileName),format);
		writer.write(document);
		writer.close();

		System.out.println("д��XML�ļ��ɹ���");

	}

	//// д�뵽JSON�ļ�
	public void writeToJson(String fileName, ArrayList<Student> studentList) throws Exception {

		String jsonStr = (new Gson()).toJson(studentList);

		File file = new File(fileName);
		PrintWriter pw = new PrintWriter(new FileWriter(file));
		pw.print(jsonStr);

		pw.close();

		System.out.println("д��JSON�ļ��ɹ���");

	}

	/**
	 * �����������id��courceName�Ƿ��뼯���еĶ����ظ�
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

	// ���ÿ��ѧ�����ּܷ�ƽ���֣�����ڼ�����
	public ArrayList<Score> scoreStatics(ArrayList<Student> studentList) {
		ArrayList<Score> scoreList = new ArrayList<Score>();
		for (Student student : studentList) {
			String id = student.getId();

			int index = existInScoreList(scoreList, id);
			// ��id�ڽ�������д���,���޸ļ�������Ӧ�Ķ���
			if (index != -1) {
				Score score = scoreList.get(index);
				score.setCount(score.getCount() + 1); // �γ�������1
				score.setTotalScore(score.getTotalScore() + student.getScore()); // �ܷ��ۼ�
				score.setAverage(score.getTotalScore() / score.getCount());
				scoreList.set(index, score); // �޸Ľ�������иö���
			} else { // �����ڣ����ӵ����������
				Score score = new Score(student.getId(), student.getStudentName(), student.getGender(),
						student.getScore(), 1, student.getScore());

				scoreList.add(score);
			}
		}

		return scoreList;
	}

	// ��scoreList�в�ѯָ��id�Ķ��󣬷��ظö����ڼ����е�λ�ã��緵��Ϊ-1�����ʾδ�ҵ�
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
	 * ��������е�����
	 * 
	 * @param studentList
	 */
	public void displayStudent(ArrayList<Student> studentList) {
		System.out.println("ѧ��\t����\t�Ա�\t�γ�\t�ɼ�");
		System.out.println("===================================");
		for (Student student : studentList) {
			System.out.println(student.toString());
		}

	}

}
