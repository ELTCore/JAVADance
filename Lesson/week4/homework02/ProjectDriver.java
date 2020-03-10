package week4.homework02;

import java.util.Scanner;

// -------------------------------------------------------------------------------------
// Write a main() method in a file called ProjectDriver.java that creates one Project.
// You also need create 2 employee objects required for the Project object.
// Get the data for these objects from the keyboard.
// Using the appropriate class instance method update the projects budget
// and then display the new budget value on the screen using the getBudget() method.
// Print the details of the Project and its Employees using their appropriate output methods.
// -------------------------------------------------------------------------------------

public class ProjectDriver {
    public static void main(String[] args) {
        System.out.println("date: 2020-03-10");
        Project pj = new Project();
        Employee ep01 = new Employee();
        Employee ep02 = new Employee();
        int choose = 0;
        Scanner sc = new Scanner(System.in);

        do {
            msg();
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    pj.setProject();
                    break;
                case 2:
                    System.out.println("----------EMPLOYEE 01----------");
                    ep01.setEmployee();
                    System.out.println("----------EMPLOYEE 02----------");
                    ep02.setEmployee();
                    break;
                case 3:
                    pj.printProject();
                    System.out.println("----------EMPLOYEE 01----------");
                    ep01.printEmployee();
                    System.out.println("----------EMPLOYEE 02----------");
                    ep01.printEmployee();
                    break;
                case 0:
                    sc.close();
                    System.exit(0);

            }

        } while (choose != 0);

    }

    static void msg() {
        System.out.println("===============MENU===============");
        System.out.println("* 1. Set Project");
        System.out.println("* 2. Set two Employees");
        System.out.println("* 3. Print the details of the Project");
        System.out.println("* 0. Exit;");
        System.out.println("===============MENU===============");
        System.out.print("Enter the function: ");
    }
}

class Project {
    private String name = "NULL";
    private double budget = 0.00;
    private boolean ifSet = false;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return this.budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public boolean getIfSet() {
        return this.ifSet;
    }

    public void setIfSet(boolean ifSet) {
        this.ifSet = ifSet;
    }

    public void setProject() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name:");
        this.name = sc.next();

        System.out.print("Enter the budget:");
        this.budget = sc.nextDouble();

        this.ifSet = true;
    }

    public void printProject() {
        if (ifSet) {
            System.out.println("===============Project===============");
            System.out.println("* Name:\t" + this.name);
            System.out.printf("* Budget:\t%.2f\n", this.budget);
            System.out.println("=====================================");

        } else {
            System.out.println("===============Project===============");
            System.out.println("The project have not set.");
            System.out.println("=====================================");

        }
    }

}

class Employee {
    private String name = "NULL";
    private int age = 0;
    private char sex = 'M';
    private double salary = 0.00;
    private boolean ifSet = false;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return this.sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean getIfSet() {
        return this.ifSet;
    }

    public void setIfSet(boolean ifSet) {
        this.ifSet = ifSet;
    }

    public void setEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name:");
        this.name = sc.next();

        System.out.print("Enter the age:");
        this.age = sc.nextInt();

        do {
            System.out.print("Enter the sex(M/F):");
            this.sex = sc.next().charAt(0);
        } while (!(getSex() == 'M' || getSex() == 'F'));

        System.out.print("Enter the salary:");
        this.salary = sc.nextDouble();

        this.ifSet = true;

    }

    public void printEmployee() {
        if (ifSet) {
            System.out.println("* Name:\t" + this.name + "\n* Sex:\t" + this.sex + "\n* Age:\t" + this.age);
            System.out.printf("* Salary:\t%.2f\n", this.salary);
        }
    }

}