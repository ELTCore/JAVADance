package week5.homework02;

import java.util.Scanner;

// -------------------------------------------------------------------------------------
// Extend the Employee class from question 1 by creating 2 new classes. The classes
// are Administrator and SalesPerson which inherit all instance fields and methods from
// the Employee class. In addition, the Administrator has a bonus field which is a one
// off payment that is added to the baseSalary. The SalesPerson class has a new field:
// yearlySales. Commission is calculated as 10% of yearlySales. This commission is
// added to the baseSalary after the updateSalary() method is called.
// Create updateSalary() methods for both new classes. You will add bonus and
// commission respectively to the baseSalary. You will need to include updateSalary()
// class from the Employee class by using super.
// Add an instance method named displayEmployee() for both classes in which in
// addition to the data from the Employee class you also display the bonus field
// (Administrator) and yearlySales and commission fields (SalesPerson).
// Create a test driver with a main () that instantiates 2 objects – 1 of Administrator and
// 1 of SalesPerson. Add appropriate data (hard coded or from keyboard) and display
// details on the screen using the appropriate displayEmployee() method.
// Update the salary of each employee and then display only the new base salary.
// -------------------------------------------------------------------------------------

public class homework02p2 {
    // WARNING: THIS PROGRAM DOES NOT FINISHE!
    // WARNING: THIS PROGRAM DOES NOT FINISHE!
    // WARNING: THIS PROGRAM DOES NOT FINISHE!

    // ====================MAIN====================
    public static void main(String[] args) {
        System.out.println("date: 2020-03-13\n");
        NewDriver.menu();
    }

    // ====================MAIN====================
}

class NewDriver {
    static Scanner sc = new Scanner(System.in);
    static byte choose = 0;
    static Administrator Adm = new Administrator(null, null, null, null, 0.00, false);
    static SalesPerson SP = new SalesPerson(null, null, null, null, 0.00, false);

    static void test() {
        Adm.defaultAll();
        Adm.setFirstName("test");
        System.out.println(Adm.getFirstName());
    }

    static void changeChoose() {
        do {
            System.out.print("Please enter the sequence number(1~5):");
            choose = (byte) (sc.nextInt());
        } while (!(choose > 0 && choose < 6));
    }

    static void menu() {

        do {
            msg();
            choose = sc.nextByte();

            switch (choose) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 0:
            }
        } while (choose != 0);

    }

    static void msg() {
        System.out.println("===============MENU===============");
        System.out.println("* 1. Create an Aministrator");
        System.out.println("* 2. Create a Salesperson");
        System.out.println("* 3. Display information");
        System.out.println("* 4. Update Salary");
        System.out.println("\n* 0. Exit");
        System.out.println("===============MENU===============");
        System.out.print("Enter your choice:");

    }

}

class Administrator extends Employee {

    public Administrator(String firstName, String lastName, String employeeID, String department, double baseSalary,
            boolean ifSet) {
        super(firstName, lastName, employeeID, department, baseSalary, ifSet);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Administrator []";
    }

    @Override
    public void updateSalary() {
        // TODO Auto-generated method stub
        super.updateSalary();
    }

}

class SalesPerson extends Employee {

    public SalesPerson(String firstName, String lastName, String employeeID, String department, double baseSalary,
            boolean ifSet) {
        super(firstName, lastName, employeeID, department, baseSalary, ifSet);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void updateSalary() {
        // TODO Auto-generated method stub
        super.updateSalary();
    }
    

}