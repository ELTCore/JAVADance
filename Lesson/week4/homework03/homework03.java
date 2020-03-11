package week4.homework03;

import java.util.Scanner;

// -------------------------------------------------------------------------------------
// 3.Holmesglen’s computer system requires a procedure for teachers to 
// print out a list of their students on class lists that include the 
// subject ID, subject name, Semester and year.
// Write a Java application to implement the above classes.
// The Driver class can create up to a maximum of 2 class attendance lists. 
// each list must have 2 students.
// Validation – the application must check the following:
// -  A list cannot be printed if it has not been created yet
// -------------------------------------------------------------------------------------

public class homework03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("date: 2020-03-11\n");
        int choose = 0;
        ClassList list = new ClassList();

        do {
            msg();
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    list.setSubject();
                    list.setStudent();
                    break;

                case 2:
                    list.printSubject();
                    list.printStudent();
                    break;

                case 3:
                    sc.close();
                    System.exit(0);

            }
        } while (choose != 3);

    }

    static void msg() {
        System.out.println("===============MENU===============");
        System.out.println("* 1. Create Attendance List");
        System.out.println("* 2. Print Attendance List");
        System.out.println("\n* 3. Exit");
        System.out.println("===============MENU===============");
        System.out.print("Enter your choice:");

    }
}

class ClassList {
    static Scanner sc = new Scanner(System.in);
    private int semester;
    private int year;
    private Subject subj = new Subject();
    private Student s1 = new Student();
    private Student s2 = new Student();

    class Subject {
        private String subjectID;
        private String subjectName;
        private boolean ifSet = false;

        public String getSubjectID() {
            return subjectID;
        }

        public void setSubjectID(String subjectID) {
            this.subjectID = subjectID;
        }

        public String getSubjectName() {
            return subjectName;
        }

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

        public boolean isIfSet() {
            return ifSet;
        }

        public void setIfSet(boolean ifSet) {
            this.ifSet = ifSet;
        }

    }

    class Student {
        private String studentID = "NULL";
        private String firstName = "NULL";
        private String lastName = "NULL";
        private boolean ifSet = false;

        public String getStudentID() {
            return studentID;
        }

        public void setStudentID(String studentID) {
            this.studentID = studentID;
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

        public boolean isIfSet() {
            return ifSet;
        }

        public void setIfSet(boolean ifSet) {
            this.ifSet = ifSet;
        }

    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void printSubject() {
        if (subj.ifSet) {
            System.out.println("---------------Subject---------------");
            System.out.println("* ID:\t" + subj.subjectID);
            System.out.println("* NAME:\t" + subj.subjectName);
            System.out.println("=====================================\n");
        } else {
            System.out.println("---------------Subject---------------");
            System.out.println("* NULL *");
            System.out.println("=====================================\n");
        }
    }

    public void setSubject() {
        System.out.println("---------------Subject---------------");
        System.out.print("Enter The ID: ");
        subj.subjectID = sc.next();
        System.out.print("Enter The Name: ");
        subj.subjectName = sc.next();
        subj.ifSet = true;
        System.out.println("=====================================\n");
    }

    public void printStudent() {
        if (s1.ifSet) {
            System.out.println("---------------StudentA---------------");
            System.out.println("* ID:\t" + s1.studentID);
            System.out.println("* FirstName:\t" + s1.firstName);
            System.out.println("* LastName:\t" + s1.lastName);
            System.out.println("======================================\n");
        } else {
            System.out.println("---------------StudentA---------------");
            System.out.println("* NULL *");
            System.out.println("======================================\n");
        }
        if (s2.ifSet) {
            System.out.println("---------------StudentB---------------");
            System.out.println("* ID:\t" + s2.studentID);
            System.out.println("* FirstName:\t" + s2.firstName);
            System.out.println("* LastName:\t" + s2.lastName);
            System.out.println("======================================\n");

        } else {
            System.out.println("---------------StudentB---------------");
            System.out.println("* NULL *");
            System.out.println("======================================\n");
        }
    }

    public void setStudent() {
        System.out.println("---------------StudentA---------------");
        System.out.print("Enter The ID: ");
        s1.studentID = sc.next();
        System.out.print("Enter The FirstName: ");
        s1.firstName = sc.next();
        System.out.print("Enter The LastName: ");
        s1.lastName = sc.next();
        s1.ifSet = true;
        System.out.println("======================================\n");

        System.out.println("---------------StudentB---------------");
        System.out.print("Enter The ID: ");
        s2.studentID = sc.next();
        System.out.print("Enter The FirstName: ");
        s2.firstName = sc.next();
        System.out.print("Enter The LastName: ");
        s2.lastName = sc.next();
        s2.ifSet = true;
        System.out.println("======================================\n");
    }

}