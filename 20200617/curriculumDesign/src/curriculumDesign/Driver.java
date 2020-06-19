package curriculumDesign;

import java.util.ArrayList;
import java.util.Scanner;

import curriculumDesign.dao.OrderDao;
import curriculumDesign.tools.Global;
import curriculumDesign.vo.Order;

public class Driver {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String classPath = Driver.class.getResource("data").getPath();
		Global.classPath = classPath + "/";

		OrderDao orderDao = new OrderDao();
		ArrayList<Order> orderList = new ArrayList<Order>();

		int choose;
		do {
			choose = menu();
			switch (choose) {
			case 1:
				orderList = orderDao.loadDataFromXLS(Global.classPath + Global.XLS_FILENAME, orderList);
				break;

			case 2:
				
				break;

			case 3:
				break;

			case 4:
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
		System.out.println("\n* 0. �˳�");
		System.out.println("==========MENU==========");
		System.out.print("���������ѡ��(0-5):");

		choose = sc.nextInt();

		return choose;
	}
}
