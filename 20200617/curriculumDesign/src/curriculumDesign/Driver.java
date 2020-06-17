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
		System.out.println("* 1. 随机生成数据");
		System.out.println("* 2. 从xls文件读取数据");
		System.out.println("* 3. 生成条码二维码");
		System.out.println("* 4. 生成jpg图片");
		System.out.println("* 5. 生成pdf文件");
		System.out.println("\n* 0. 退出");
		System.out.println("==========MENU==========");
		System.out.print("请输入你的选择(0-5):");

		return choose;
	}
}
