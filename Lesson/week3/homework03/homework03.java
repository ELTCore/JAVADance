package week3.homework03;

import java.util.Scanner;

// -------------------------------------------------------------------------------------
// a) Write a program to implement a Rectangle class. The class has
// private fields to record the length and width of a rectangle.
// b) Add a default constructor that has no arguments and sets the
// length and width to 1.0. Add a second Constructor that takes
// the width and length of the rectangle as parameters.
// c) Add the instance methods to calculate the area and perimeter
// of the rectangle
// d) Add a separate test driver class. In main, instantiate several
// Rectangles and display the area and perimeter of each.
// -------------------------------------------------------------------------------------

public class homework03 {
    // ====================MAIN====================
    public static void main(String[] args) {
        System.out.println("date: 2020-02-22\n");
        Rectangle[] rec = new Rectangle[6];

        TestDriver.menu(rec);
    }
    // ====================MAIN====================

}

class TestDriver {
    static Scanner sc = new Scanner(System.in);

    static void menu(Rectangle[] rec) {
        int choose = 0;

        initializeList(rec);
        do {
            msg();
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    setRectangle(rec);
                    break;
                case 2:
                    displayList(rec);
                    break;
                case 3:
                    deleteRectangle(rec);
                    break;
                case 0:
                    sc.close();
                    System.exit(1);
            }
        } while (choose != 0);

    }

    static void msg() {
        System.out.println("\n------------------------------");
        System.out.println("\n* 1. Set a rectangle");
        System.out.println("\n* 2. Rectangle List");
        System.out.println("\n* 3. Delete a rectangle");
        System.out.println("\n* 0. Exit");
        System.out.println("\n------------------------------");
        System.out.print("\nEnter the function: ");
    }

    static void initializeList(Rectangle[] rec) {
        for (int i = 1; i <= 5; ++i) {
            rec[i] = new Rectangle();
            rec[i].setExist(false);
            rec[i].setDefault();
        }
    }

    static void setRectangle(Rectangle[] rec) {
        int choose = -1;
        double length = 1.0;
        double width = 1.0;
        System.out.println("\n-= SET START =-\n");
        do {
            System.out.print("Enter the number of rectangle(1-5): ");
            choose = sc.nextInt();
        } while (!(choose >= 1 && choose <= 5));

        do {
            System.out.print("Enter the length: ");
            length = sc.nextDouble();
            System.out.print("Enter the width: ");
            width = sc.nextDouble();
        } while (!(length > 0 && width > 0));
        rec[choose].setCustom(length, width);
        rec[choose].setExist(true);
    }

    static void displayList(Rectangle[] rec) {
        System.out.println("\n-= PRINT START =-\n");
        for (int i = 1; i <= 5; ++i) {
            if (rec[i].getExist()) {
                double a = rec[i].getLength();
                double b = rec[i].getWidth();
                System.out.println("--------------------");
                System.out.printf("No. %d\n-- Length:\t%.4f\n-- Width:\t%.4f\n-- Squre:\t%.2f\n-- Perimeter:\t%.2f\n",
                        i, a, b, a * b, (a + b) * 2);
                System.out.println("--------------------");

            }
        }
        System.out.println("\n-= PRINT FINISHED =-\n");
    }

    static void deleteRectangle(Rectangle[] rec) {
        System.out.println("\n-= DELETE START =-\n");
        int choose = -1;
        do {
            System.out.print("Enter the number of rectangle(1-5): ");
            choose = sc.nextInt();
        } while (!(choose >= 1 && choose <= 5));
        rec[choose].setDefault();
        rec[choose].setExist(false);
        System.out.println("\n-= DELETE FINISHED =-\n");
    }

}

class Rectangle {
    private double length;
    private double width;
    private Boolean ifExist = false;

    public void setDefault() {
        this.length = 1.0;
        this.width = 1.0;
    }

    public void setCustom(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setExist(Boolean exist) {
        this.ifExist = exist;
    }

    public Boolean getExist() {
        return ifExist;
    }

}