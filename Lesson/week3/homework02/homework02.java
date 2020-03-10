package week3.homework02;

import java.util.Scanner;

// -------------------------------------------------------------------------------------
// a) Create a class called Student with private fields to record the
// name, phone numbers and student number. Add a constructor
// that accepts the name, phone number and student number.
// b) Add an instance method named displayStudent() that prints all
// these values.
// c) Create a separate test driver with a main() method that
// instantiates yourself as a student and another student of your
// choice. Print the details of these objects.
// -------------------------------------------------------------------------------------

public class homework02 {
    // ====================MAIN====================
    public static void main(String[] args) {
        System.out.println("date: 2020-02-22\n");
        Student studentA = new Student();
        Student studentB = new Student();

        testDriver.test(studentA, studentB);

    }
    // ====================MAIN====================
}

class testDriver {
    static Scanner sc = new Scanner(System.in);

    static void test(Student studentA, Student studentB) {
        Boolean stA = false;
        Boolean stB = false;
        int choose = 0;

        do {
            msg();
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    setStudent(studentA);
                    stA = true;
                    break;
                case 2:
                    setStudent(studentB);
                    stB = true;
                    break;
                case 3:
                    System.out.print("Enter A or B: ");
                    char ch = sc.next().charAt(0);
                    if (ch == 'A' || ch == 'a') {
                        if (stA == false) {
                            System.out.println("\n -= NO DATA =-\n");
                        } else {
                            displayStudent(studentA);
                        }
                    } else if (ch == 'B' || ch == 'b') {
                        if (stB == false) {
                            System.out.println("\n -= NO DATA =-\n");
                        } else {
                            displayStudent(studentB);
                        }
                    } else {
                        System.out.println("\n-= ERROR =-\n");
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
        System.out.println("\n* 1. Set Student A");
        System.out.println("\n* 2. Set Student B");
        System.out.println("\n* 3. DisplayEmoloyee");
        System.out.println("\n* 0. Exit");
        System.out.println("\n------------------------------");
        System.out.print("\nEnter the function: ");
    }

    static void displayStudent(Student Student) {
        System.out.println("\n----------OUTPUT START----------");
        System.out.println("Name:\t" + Student.getName());
        System.out.println("StudentID:\t" + Student.getStudentNumber());
        System.out.println("PhoneNumber:\t" + Student.getPhoneNumber());
        System.out.println("\n---------OUTPUT FINISHED---------");
    }

    static void setStudent(Student Student) {
        System.out.println("\n-= SET Student =-\n");
        System.out.print("\nName: ");
        Student.setName(sc.next());
        System.out.print("\nStudentNumber: ");
        Student.setStudentNumber(sc.next());
        System.out.print("\nPhoneNumber: ");
        Student.setPhoneNumber(sc.next());
        System.out.println("\n-= SET FINISHED =-\n");
    }

}

class Student {
    private String name;
    private String phoneNumber;
    private String studentNumber;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStudentNumber() {
        return this.studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
