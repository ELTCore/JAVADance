package week2.homework02;

import java.util.Scanner;

// -------------------------------------------------------------------------------------
// Create a Java program to input 5 student results as a numeric grade (0-100). If a
// grade entered is less than 0 or greater than 100 ask for re-entry of that particular
// grade. Your program is to calculate and display the class average grade and also
// display the highest and lowest grades when the appropriate
// menu option is chosen.

// -------------------------
// 1. Enter Student Results
// 2. Class Average
// 3. Highest Grade
// 4. Lowest Grade
// 5. Exit
// -------------------------

// -------------------------------------------------------------------------------------

public class homework02 {
    static int[] studentGrade = { 0, 0, 0, 0, 0, 0 };
    static int highestGrade = 100;
    static int lowestGrade = 0;
    static int classAverage = 0;
    static Scanner sc = new Scanner(System.in);
    static Boolean ifTheResultExist = false;

    public static void main(String[] args) {
        System.out.println("date: 2020-02-21\n");
        int choose = 0;
        do {
            msg();
            choose = sc.nextInt();
            System.out.println();
            switch (choose) {
                case 1:
                    inputStudentGrade();
                    break;
                case 2:
                    if (ifTheResultExist == false) {
                        System.out.println("\nPlease create a result firstly.\n");
                        break;
                    } else {
                        printStudentResult();
                    }
                    break;
                case 3:
                    if (ifTheResultExist == false) {
                        System.out.println("\nPlease create a result firstly.\n");
                        break;
                    } else{
                        printAverage();
                    }
                    break;
                case 4:
                    if (ifTheResultExist == false) {
                        System.out.println("\nPlease create a result firstly.\n");
                        break;
                    } else{
                        printHighest();
                    }
                    break;
                case 5:
                    if (ifTheResultExist == false) {
                        System.out.println("\nPlease create a result firstly.\n");
                        break;
                    } else{
                        printLowest();
                    }
                    break;
                case 0:
                    System.exit(1);
            }

        } while (choose != 0);
    }

    static void msg() {
        // The format:
        // ==============================================
        // System.out.print(
        // "\n------------------------------"
        // + "\n* 1. Enter/Re-enter Student Results"
        // + "\n* 2. Print the student result"
        // + "\n* 3. Class Average"
        // + "\n* 4. Highest Grade"
        // + "\n* 5. Lowest Grade"
        // + "\n* 0. Exit"
        // + "\n------------------------------"
        // + "\nEnter the function: "
        // );
        // ==============================================
        System.out.print("\n------------------------------" + "\n* 1. Enter/Re-enter Student Results"
                + "\n* 2. Print the student result" + "\n* 3. Class Average" + "\n* 4. Highest Grade"
                + "\n* 5. Lowest Grade" + "\n* 0. Exit" + "\n------------------------------"
                + "\nEnter the function: ");
    }

    static void inputStudentGrade() {
        for (int i = 1; i <= 5; ++i) {
            do {
                System.out.printf("Enter the student's grade( %d / 5 ): ", i);
                studentGrade[i] = sc.nextInt();
                if (studentGrade[i] < 0 || studentGrade[i] > 100) {
                    System.out.println("\nPlease re-enter the grade!\n");
                }
            } while (!(studentGrade[i] >= 0 && studentGrade[i] <= 100));
        }
        ifTheResultExist = true;
        System.out.println("\n-=INPUT FINISHED=-\n");
    }

    static void printStudentResult() {
        for (int i = 1; i <= 5; ++i) {
            System.out.printf("The Student %d:\t%d\n", i, studentGrade[i]);
        }
        System.out.println("\n-=PRINT FINISHED=-\n");
    }

    static void printAverage() {
        int average = 0;
        for (int i = 1; i <= 5; ++i) {
            average += studentGrade[i];
        }
        average /= 5;
        System.out.println("\nThe average:\t" + average);
        System.out.println("\n-=PRINT FINISHED=-\n");
    }

    static void printHighest() {
        int highest = studentGrade[1];
        for (int i = 2; i <= 5; ++i) {
            if (studentGrade[i] >= highest) {
                highest = studentGrade[i];
            }
        }
        System.out.println("\nThe highest:\t" + highest);
        System.out.println("\n-=PRINT FINISHED=-\n");
    }

    static void printLowest() {
        int lowest = studentGrade[1];
        for (int i = 2; i <= 5; ++i) {
            if (studentGrade[i] <= lowest) {
                lowest = studentGrade[i];
            }
        }
        System.out.println("\nThe lowest:\t" + lowest);
        System.out.println("\n-=PRINT FINISHED=-\n");
    }

}