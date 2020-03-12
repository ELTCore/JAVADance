package week5.homework01;

import java.util.Scanner;

// -------------------------------------------------------------------------------------
// Create a class called Employee with private fields to record the first and last name,
// EmployeeID, department and baseSalary.
// Create two constructors – one default and another that accepts data as parameters.
// Create appropriate set and get methods.
// Create an instance method named updateSalary() that increases an Employees
// baseSalary by 7.25%.
// Add an instance method named displayEmployee() that prints all these values.
// -------------------------------------------------------------------------------------

public class homework01 {
    // ====================MAIN====================

    public static void main(String[] args) {
        System.out.println("date: 2020-03-12\n");

        Driver.menu();
    }
    // ====================MAIN====================

}

class Driver {
    static Scanner sc = new Scanner(System.in);

    static byte choose = 0;

    static Employee[] eplyes = new Employee[6];

    static void initialize() {
        for (int i = 1; i <= eplyes.length - 1; ++i) {
            eplyes[i] = new Employee();
        }
    }

    static void changeChoose() {
        do {
            System.out.print("Please enter the sequence number(1~5):");
            choose = (byte) (sc.nextInt());
        } while (!(choose > 0 && choose < 6));
    }

    static void menu() {
        initialize();
        do {
            msg();
            choose = sc.nextByte();

            switch (choose) {
                case 1:
                    changeChoose();
                    setEmployee(eplyes[choose]);
                    break;

                case 2:
                    changeChoose();
                    deleteEmployee(eplyes[choose]);
                    break;

                case 3:
                    displayEmployee();
                    break;

                case 4:
                    changeChoose();
                    updateSalary(eplyes[choose]);
                    break;

                case 0:
                    sc.close();
                    System.exit(0);
            }
        } while (choose != 0);

    } // menu

    private static void msg() {
        System.out.println("===============MENU===============");
        System.out.println("* 1. Create an Employee");
        System.out.println("* 2. Delete an Employee");
        System.out.println("* 3. Display Employees");
        System.out.println("* 4. Increases an Employee's baseSalary by 7.25%");
        System.out.println("\n* 0. Exit");
        System.out.println("===============MENU===============");
        System.out.print("Enter your choice:");

    } // msg

    private static void setEmployee(Employee employee) {
        System.out.println("\n-= SET BEGIN =-\n");

        System.out.print("Input the FirstName:");
        employee.setFirstName(sc.next());

        System.out.print("Input the LastName:");
        employee.setLastName(sc.next());

        System.out.print("Input the EmployeeID:");
        employee.setEmployeeID(sc.next());

        System.out.print("Input the department:");
        employee.setDepartment(sc.next());

        System.out.print("Input the baseSalary:");
        employee.setBaseSalary(sc.nextDouble());

        employee.setIfSet(true);

        System.out.println("\n-= SET FINISHED =-\n");
    } // setEmployee

    private static void deleteEmployee(Employee employee) {
        employee.defaultAll();
        employee.setIfSet(false);
        System.out.println("\n-= DELETE FINISHED =-\n");
    }

    private static void displayEmployee() {
        System.out.println("\n-= PRINT BEGIN =-\n");
        for (int i = 1; i <= eplyes.length - 1; ++i) {
            if (eplyes[i].isIfSet()) {
                System.out.printf("----------EMPLOYEE %02d----------\n", i);
                System.out.println("FirstName:\t" + eplyes[i].getFirstName());
                System.out.println("LastName:\t" + eplyes[i].getLastName());
                System.out.println("EmployeeID:\t" + eplyes[i].getEmployeeID());
                System.out.println("Department:\t" + eplyes[i].getDepartment());
                System.out.printf("BaseSalary:\t%.2f\n", eplyes[i].getBaseSalary());
                System.out.println("-------------------------------\n");

            } else {
                System.out.printf("----------EMPLOYEE %02d----------\n", i);
                System.out.println("NO DATA");
                System.out.println("-------------------------------\n");
            }
        }

        System.out.println("\n-= PRINT FINISHED =-\n");
    } // displayEmployee

    static void updateSalary(Employee employee) {
        employee.setBaseSalary(employee.getBaseSalary() * 1.0725);
        System.out.println("\n-= UPDATE FINISHED =-\n");
    }

}// Driver

class Employee {
    private String firstName = "NULL";
    private String lastName = "NULL";
    private String employeeID = "NULL";
    private String department = "NULL";
    private double baseSalary = 0.00;
    private boolean ifSet = false;

    public void defaultAll() {
        this.firstName = "NULL";
        this.lastName = "NULL";
        this.employeeID = "NULL";
        this.department = "NULL";
        this.baseSalary = 0.00;
        this.ifSet = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public boolean isIfSet() {
        return ifSet;
    }

    public void setIfSet(boolean ifSet) {
        this.ifSet = ifSet;
    }
}// Employee