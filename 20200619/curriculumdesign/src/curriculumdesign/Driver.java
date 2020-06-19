package curriculumdesign;

import java.util.ArrayList;
import java.util.Scanner;

import curriculumdesign.dao.OrderDao;
import curriculumdesign.tools.Global;
import curriculumdesign.vo.Order;

public class Driver {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String classPath = Driver.class.getResource("data").getPath();
		Global.classPath = classPath + "/";

		OrderDao orderDao = new OrderDao();
		ArrayList<Order> orderList = new ArrayList<Order>();

		Boolean f1 = false;
		Boolean f2 = false;
		Boolean f3 = false;

		int choose;
		do {
			choose = menu();
			switch (choose) {
			case 1:
				orderList = orderDao.loadDataFromXLS(Global.classPath + Global.XLS_FILENAME, orderList);
				if (f1 == false)
					f1 = true;
				break;

			case 2:
				if (f1 == false) {
					System.out.println("���ȵ�������!");
					continue;
				}
				orderDao.barCodeListCreate(orderList);
				if (f2 == false)
					f2 = true;
				break;

			case 3:
				if (f1 == false) {
					System.out.println("���ȵ�������!");
					continue;
				}
				if (f2 == false) {
					System.out.println("������������!");
					continue;
				}
				orderDao.outputJPGList(orderList);
				System.out.println("\n������ϣ�����ļ��Ѿ��������˳�������Ŀ¼��.");
				if (f3 == false)
					f3 = true;
				break;

			case 4:
				if (f1 == false) {
					System.out.println("���ȵ�������!");
					continue;
				}
				if (f2 == false) {
					System.out.println("������������!");
					continue;
				}
				if (f3 == false) {
					System.out.println("��������jpgͼƬ");
					continue;
				}
				orderDao.outputPDFList(orderList);
				System.out.println("\n������ϣ�����ļ��Ѿ��������˳�������Ŀ¼��.");
				break;

			case 5:
				orderList = orderDao.loadDataFromXLS(Global.classPath + Global.XLS_FILENAME, orderList);
				orderDao.barCodeListCreate(orderList);
				orderDao.outputJPGList(orderList);
				orderDao.outputPDFList(orderList);
				System.out.println("\n������ϣ�����ļ��Ѿ��������˳�������Ŀ¼��.");
				break;

			case 0:
				sc.close();
				System.exit(0);
			}
		} while (choose != 0);
	}

	public static int menu() {
		int choose = 0;

		System.out.println("==========MENU==========");
		System.out.println("* 1. ��xls�ļ���ȡ����");
		System.out.println("* 2. �������붩����");
		System.out.println("* 3. ����jpgͼƬ");
		System.out.println("* 4. ����pdf�ļ�");
		System.out.println("* 5. һ��ִ��(�Ƽ�)");
		System.out.println("\n* 0. �˳�");
		System.out.println("==========MENU==========");
		System.out.print("���������ѡ��(0-5):");

		choose = sc.nextInt();

		return choose;
	}
}
