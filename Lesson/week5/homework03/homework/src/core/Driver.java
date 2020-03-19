package core;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("date: 2020-03-18\n");
		menu();

	}

	static Scanner sc = new Scanner(System.in);
	static byte choose = 0;

	static void menu() {
		Customer ctm = new Customer();

		do {
			msg();
			changeChoose("Enter your choice:", 0, 7);
			switch (choose) {
				case 1:
					dvdL();
					msg_chooseAccount();
					changeChoose("Enter your choice:", 0, 2);
					switch (choose) {
						case 1:
							ctm.setCA();
							break;
						case 2:
							ctm.setSA();
							break;
						case 0:
							choose = -1;
							break;
					}
					break;
				case 2:
					dvdL();
					msg_chooseAccount();
					changeChoose("Enter your choice:", 0, 2);
					switch (choose) {
						case 1:
							ctm.CA.save();
							break;
						case 2:
							ctm.SA.save();
							break;
						case 0:
							choose = -1;
							break;
					}
					break;
				case 3:
					dvdL();
					msg_chooseAccount();
					changeChoose("Enter your choice:", 0, 2);
					switch (choose) {
						case 1:
							ctm.CA.withdraw();
							break;
						case 2:
							ctm.SA.withdraw();
							break;
						case 0:
							choose = -1;
							break;
					}
					break;
				case 4:
					dvdL();
					msg_chooseAccount();
					changeChoose("Enter your choice:", 0, 2);
					switch (choose) {
						case 1:
							ctm.CA.comsume();
							break;
						case 2:
							ctm.SA.comsume();
							break;
						case 0:
							choose = -1;
							break;
					}
					break;
				case 5:
					dvdL();
					ctm.CA.repay();
					break;
				case 6:
					dvdL();
					ctm.CA.settle();
					ctm.SA.settle();
					break;
				case 7:
					dvdL();
					ctm.printAccount();
					break;
				case 0:
					sc.close();
					System.exit(0);
			}

		} while (choose != 0);
	}

	static void changeChoose(String s, int i, int j) {
		do {
			System.out.print(s);
			choose = (byte) sc.nextInt();
		} while (!(choose >= i && choose <= j));
	}

	static void dvdL() {
		System.out.println("\n------------------------------\n");
	}

	static void msg() {
		dvdL();
		System.out.println("===============MENU===============");
		System.out.println("* 1. Create");
		System.out.println("* 2. Save");
		System.out.println("* 3. Withdraw");
		System.out.println("* 4. Comsume");
		System.out.println("* 5. Repay");
		System.out.println("* 6. Settle");
		System.out.println("* 7. Balance");
		System.out.println("\n* 0. Exit");
		System.out.println("===============MENU===============");

	}

	static void msg_chooseAccount() {
		System.out.println("===============MENU===============");
		System.out.println("* 1. Checking Account");
		System.out.println("* 2. Saving Account");
		System.out.println("\n* 0. Back");
		System.out.println("===============MENU===============");
	}

}
