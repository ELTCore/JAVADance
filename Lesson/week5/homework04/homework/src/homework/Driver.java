package homework;

import java.util.Scanner;

//-------------------------------------------------------------------------------------
//SubjectEnrolment System
//allow the user to select from menu options.
// -------------------------
// 1. Create new Subject
// 2. Add a student
// 3. Print subject details
// 4. Exit
// -------------------------
//The menu should allow the user to:
//The user should not be able to add a student if
//a new subject has not been created.
//Create a new class called SubjectEnrolmentDriver.
//This class is used to create a new Student and,
//if appropriate, add it to the instance of Enrolment.
//Allow the user to enter student details and add them to Enrolment until
//the Student array in SubjectEnrolment is full.
//Notify the user each time a student is added successfully.
//If the array is full, return a user friendly message to the driver program.
//The program should now print the subject name, the names and IDs of all
//students enrolled to the screen.
//-------------------------------------------------------------------------------------

public class Driver {
	public static void main(String[] args) {
		System.out.println("date: 2020-03-20\n");

		menu();

	}

	static int choose = 0;
	static Scanner sc = new Scanner(System.in);

	static void menu() {
		StudentEnrolment SE = new StudentEnrolment(0);
		boolean ifSet = false;

		do {
			msg();
			changeChoose();

			switch (choose) {
				case 1:
					System.out.print("Enter the number of the Students:");
					SE = new StudentEnrolment(sc.nextInt());
					ifSet = true;
					break;

				case 2:
					if (ifSet) {
						System.out.print("Enter the student's name:");
						String name = sc.next();
						System.out.print("Enter the student's ID:");
						String ID = sc.next();
						if (SE.add(new Student(ID, name))) {
							System.out.println("\nAdded successfully\n");
						} else {
							System.out.println("\nError,please check.\n");
						}
					} else {
						System.out.println("Please create a subject firstly.");
					}
					break;

				case 3:
					System.out.println(SE.toString());
					break;

				case 0:
					sc.close();
					System.exit(0);

			}

		} while (choose != 0);

	}

	static void changeChoose() {
		System.out.print("Enter the number:");
		choose = sc.nextInt();
	}

	static void msg() {
		System.out.println("\n========== MENU ==========");
		System.out.println("* 1. Create new Subject");
		System.out.println("* 2. Add a student");
		System.out.println("* 3. Print subject details");
		System.out.println("\n* 0. Exit");
		System.out.println("\n========== MENU ==========");

	}

}
