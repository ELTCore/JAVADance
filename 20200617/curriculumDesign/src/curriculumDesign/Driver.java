package curriculumDesign;

import java.util.ArrayList;

import curriculumDesign.dao.OrderDao;

import curriculumDesign.tools.Global;
import curriculumDesign.vo.Order;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String classPath = Driver.class.getResource("data").getPath();
		Global.classPath = classPath + "/";

		OrderDao oderFormDao = new OrderDao();
		ArrayList<Order> orderList = new ArrayList<Order>();

	}

	public static int menu() {
		int choose = 0;

		System.out.println("==========MENU==========");
		System.out.println("* 1. �����������");
		System.out.println("* 2. ��xls�ļ���ȡ����");
		System.out.println("* 3. ���������ά��");
		System.out.println("* 4. ����jpgͼƬ");
		System.out.println("* 5. ����pdf�ļ�");
		System.out.println("\n* 0. �˳�");
		System.out.println("==========MENU==========");
		System.out.print("���������ѡ��(0-5):");

		return choose;
	}
}
