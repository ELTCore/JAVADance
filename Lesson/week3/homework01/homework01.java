package week3.homework01;

import java.util.Scanner;

// -------------------------------------------------------------------------------------
// Create a class called Employee with private fields to record the first and last name,EmployeeID, department and baseSalary.
// Create two constructors - one default and another that accepts data as parameters.
// Create appropriate set and get methods.
// Create an instance method named updateSalary() that increases an Employees baseSalary by 3.5%.
// Add an instance method named displayEmployee() that prints all these values.
// Create a separate test driver with a main() that instantiates 2 objects and populates them with data from the keyboard. 
// Display the baseSalary for each employee and then use the updateSalary() method to increase the pay for each employee.
// Re-display the new baseSalary. Then print all employee details.
// -------------------------------------------------------------------------------------

public class homework01 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Employee staffA = new Employee();
        Employee staffB = new Employee();
        Boolean stA = false;
        Boolean stB = false;
        int choose = 0;

        System.out.println("date: 2020-02-22\n");
        do {
            msg();
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    setEmployee(staffA);
                    stA = true;
                    break;
                case 2:
                    setEmployee(staffB);
                    stB = true;
                    break;
                case 3:
                    System.out.print("Enter A or B: ");
                    char ch = sc.next().charAt(0);
                    if (ch == 'A') {
                        if (stA == false) {
                            System.out.println("\n -= NO DATA =-\n");
                        } else {
                            displayEmployee(staffA);
                        }
                    } else if (ch == 'B') {
                        if (stB == false) {
                            System.out.println("\n -= NO DATA =-\n");
                        } else {
                            displayEmployee(staffB);
                        }
                    } else {
                        System.out.println("\n-= ERROR =-\n");
                    }
                    break;
                case 4:
                    System.out.print("Enter A or B: ");
                    ch = sc.next().charAt(0);
                    if (ch == 'A') {
                        if (stA == false) {
                            System.out.println("\n -= NO DATA =-\n");
                        } else {
                            updateSalary(staffA);
                        }
                    } else if (ch == 'B') {
                        if (stB == false) {
                            System.out.println("\n -= NO DATA =-\n");
                        } else {
                            updateSalary(staffB);
                        }
                    } else {
                        System.out.println("\n -= ERROR =-\n");
                    }

                    break;
                case 0:
                    sc.close();
                    System.exit(1);
            }

        } while (choose != 0);

    }

    static void msg() {
        System.out.println("\n------------------------------");
        System.out.println("\n* 1. Set Staff A");
        System.out.println("\n* 2. Set Staff B");
        System.out.println("\n* 3. DisplayEmoloyee");
        System.out.println("\n* 4. UpdateSalary");
        System.out.println("\n* 0. Exit");
        System.out.println("\n------------------------------");
        System.out.print("\nEnter the function: ");
    }

    static void updateSalary(Employee staff) {
        staff.setBaseSalary((float) (staff.getBaseSalary() * 1.035));
        System.out.println("\n -= UPDATE FINISHED =-\n");
    }

    static void displayEmployee(Employee staff) {
        System.out.println("\n----------OUTPUT START----------");
        System.out.println("Name:\t" + staff.getName());
        System.out.println("EmployeeID:\t" + staff.getEmployeeID());
        System.out.println("Department:\t" + staff.getDepartment());
        System.out.println("BaseSalary:\t" + staff.getBaseSalary());
        System.out.println("\n---------OUTPUT FINISHED---------");
    }

    static void setEmployee(Employee staff) {
        System.out.println("\n-= SET STAFF =-\n");
        System.out.print("\nName: ");
        staff.setName(sc.next());
        System.out.print("\nEmployeeID: ");
        staff.setEmployeeID(sc.next());
        System.out.print("\nDepartment: ");
        staff.setDepartment(sc.next());
        do {
            System.out.print("\nBaseSalary: ");
            staff.setBaseSalary(sc.nextFloat());
            if (staff.getBaseSalary() < 0) {
                System.out.println("\nERROR, please re-enter.");
            }
        } while (!(staff.getBaseSalary() >= 0));
        System.out.println("\n-= SET FINISHED =-\n");
    }

}

class Employee {
    private String name;
    private String EmployeeID;
    private String department;
    private float baseSalary;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeID() {
        return this.EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }
}