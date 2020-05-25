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
		// ��ȡDriver������Ŀ¼�µ�data��Ŀ¼�ľ���·������ȫ�ֱ���
		String classPath = Driver.class.getResource("data").getPath();
		Global.classPath = classPath + "/";

		if (!login()) {
			System.out.println("���Ѿ����������Σ������˳�����ӭ�´η��ʣ�");
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
				System.out.println("ѡ����Ч��������ѡ��");
			}

			choose = menu(Global.currentUser);
		}

		System.out.println("bye����ӭ�´η��ʣ�");

	}

	// ϵͳ��¼
	public static boolean login() throws Exception {
		boolean result = false;
		UserDao userDao = new UserDao();
		for (int i = 1; i <= 3; i++) {
			Scanner scan = new Scanner(System.in);
			System.out.print("�������û���:");
			String userName = scan.nextLine();
			System.out.print("����������:");
			String password = scan.nextLine();
			User user = new User(userName, password);
			if (userDao.login(user)) {
				Global.currentUser = user; // ���浱ǰ�û���Ϣ
				result = true;
				break;
			} else {
				System.out.println("��������û��������벻��ȷ�����������룡");
			}
		}
		return result;
	}

	// ��ʾ���˵���ѡ��ѡ��
	public static int menu(User user) {

		System.out.println("======��ӭ����ѧ������ϵͳ=============");
		System.out.println("1.��excel�м�������");
		System.out.println("2.���ı��ļ���������");
		System.out.println("3.��xml�ļ���������");
		System.out.println("4.��json�ļ��м�������");
		System.out.println("5.������������");
		System.out.println("6.�ɼ���ѯ");
		System.out.println("7.�����excel�ļ�");
		System.out.println("8.��������ı��ļ�");
		System.out.println("9.�����xml�ļ�");
		System.out.println("10.�����json�ļ�");
		System.out.println("11.�޸�����");
		System.out.println("12.�˳�");
		System.out.println("��ǰ�û���" + user.getUserName());
		System.out.print("������ѡ��(1-12):");
 
		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();
		
		return choose;
	}

}
