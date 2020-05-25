package studentManage;

import java.util.ArrayList;
import java.util.Scanner;

import studentManage.dao.StudentDao;
import studentManage.dao.UserDao;
import studentManage.tools.Global;
import studentManage.vo.Student;
import studentManage.vo.User;

public class Driver {

	public static void main(String[] args) throws Exception {
		// 获取Driver类所在目录下的data子目录的绝对路径，并全局保存
		String classPath = Driver.class.getResource("data").getPath();
		Global.classPath = classPath + "/";

		if (!login()) {
			System.out.println("你已经尝试了三次，程序退出！欢迎下次访问！");
			System.exit(0);
		}

		StudentDao studentDao = new StudentDao();
		UserDao userDao = new UserDao();
		ArrayList<Student> studentList = new ArrayList<Student>();
		int choose = menu(Global.currentUser);
		while (choose != 12) {
			switch (choose) {
			case 1:
				studentList = studentDao.loadDataFromXLS(Global.classPath + Global.XLS_FILENAME, studentList);
				break;
			case 2:
				studentList = studentDao.loadDataFromTxt(Global.classPath + Global.TXT_FILENAME, studentList);
				break;
			case 3:
				studentList = studentDao.loadDataFromXML(Global.classPath + Global.XML_FILENAME, studentList);
				break;
			case 4:
				studentList = studentDao.loadDataFromJson(Global.classPath + Global.JSON_FILENAME, studentList);
				break;
			case 5:
				studentList = studentDao.loadDataFromKeyboard(studentList);
				break;
			case 6:
				studentDao.getScoreById(studentList);
				break;
			case 7:
				studentDao.writeToXLS(Global.classPath + Global.SCORE_XLS_FILENAME, studentList);
				break;
			case 8:
				studentDao.writeToTxt(Global.classPath + Global.SCORE_TXT_FILENAME, studentList);
				break;
			case 9:
				studentDao.writeToXML(Global.classPath + Global.SCORE_XML_FILENAME, studentList);
				break;
			case 10:
				studentDao.writeToJson(Global.classPath + Global.SCORE_JSON_FILENAME, studentList);
				break;
			case 11:
				userDao.changePassword();
				break;
			default:
				System.out.println("选择无效，请重新选择！");
			}

			choose = menu(Global.currentUser);
		}

		System.out.println("bye！欢迎下次访问！");

	}

	// 系统登录
	public static boolean login() throws Exception {
		boolean result = false;
		UserDao userDao = new UserDao();
		for (int i = 1; i <= 3; i++) {
			Scanner scan = new Scanner(System.in);
			System.out.print("请输入用户名:");
			String userName = scan.nextLine();
			System.out.print("请输入密码:");
			String password = scan.nextLine();
			User user = new User(userName, password);
			if (userDao.login(user)) {
				Global.currentUser = user; // 保存当前用户信息
				result = true;
				break;
			} else {
				System.out.println("你输入的用户名或密码不正确，请重新输入！");
			}
		}
		return result;
	}

	// 显示主菜单并选择选项
	public static int menu(User user) {

		System.out.println("======欢迎访问学生管理系统=============");
		System.out.println("1.从excel中加载数据");
		System.out.println("2.从文本文件加载数据");
		System.out.println("3.从xml文件加载数据");
		System.out.println("4.从json文件中加载数据");
		System.out.println("5.键盘输入数据");
		System.out.println("6.成绩查询");
		System.out.println("7.输出到excel文件");
		System.out.println("8.输出到纯文本文件");
		System.out.println("9.输出到xml文件");
		System.out.println("10.输出到json文件");
		System.out.println("11.修改密码");
		System.out.println("12.退出");
		System.out.println("当前用户：" + user.getUserName());
		System.out.print("请输入选项(1-12):");
 
		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();
		
		return choose;
	}

}
