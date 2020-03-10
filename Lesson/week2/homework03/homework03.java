package week2.homework03;

import java.util.Scanner;

// -------------------------------------------------------------------------------------
// Write a program that uses while loops to perform the following steps:
// a. Prompt the user to input two integers: firstNum and secondNum
// (firstNum must be less than secondNum)
// b. Output all the odd numbers between firstNum and secondNum.
// c. Output the sum of all the even numbers between firstNum and secondNum.
// d. Output all the numbers and their squares between 1 and 10.
// e. Output the sum of the squares of all the odd numbers between firstNum and
// secondNum.
// f. Output all the uppercase letters. (use ASCII).
// -------------------------------------------------------------------------------------

public class homework03 {
    static Scanner sc = new Scanner(System.in);
    static Boolean ifTheNumExist = false;
    static int firstNum = 0;
    static int secondNum = 0;

    public static void main(String[] args) {
        System.out.println("date: 2020-02-21\n");
        int choose = 0;
        do {
            msg();
            choose = sc.nextInt();
            System.out.println();
            switch (choose) {
                case 1:
                    inputNum();
                    break;
                case 2:
                    if (ifTheNumExist == false) {
                        System.out.println("\nPlease input the nums firstly.\n");
                        break;
                    } else {
                        outputOddNum();
                    }
                    break;
                case 3:
                    if (ifTheNumExist == false) {
                        System.out.println("\nPlease input the nums firstly.\n");
                        break;
                    } else {
                        outputTheSum();
                    }
                    break;
                case 4:
                    outputTheSqures();
                    break;
                case 5:
                    if (ifTheNumExist == false) {
                        System.out.println("\nPlease input the nums firstly.\n");
                        break;
                    } else {
                        outputTheSquresSum();
                    }
                    break;
                case 6:
                    if (ifTheNumExist == false) {
                        System.out.println("\nPlease input the nums firstly.\n");
                        break;
                    } else {
                        outputTheUppercaseLetters();
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
        // "\n----------------------------------------------------------------------"
        // + "\n* 1. Enter the firstNum and the secondNum"
        // + "\n* 2. Output all the odd numbers between firstNum and secondNum."
        // + "\n* 3. Output the sum of all the even numbers between firstNum and
        // secondNum."
        // + "\n* 4. Output all the numbers and their squares between 1 and 10."
        // + "\n* 5. Output the sum of the squares of all the odd numbers between
        // firstNum and secondNum."
        // + "\n* 6. Output all the uppercase letters."
        // + "\n* 0. Exit"
        // + "\n----------------------------------------------------------------------"
        // + "\nEnter the function: "
        // );
        // ==============================================

        System.out.print("\n----------------------------------------------------------------------"
                + "\n* 1. Enter the firstNum and the secondNum"
                + "\n* 2. Output all the odd numbers between firstNum and secondNum."
                + "\n* 3. Output the sum of all the even numbers between firstNum and secondNum."
                + "\n* 4. Output all the numbers and their squares between 1 and 10."
                + "\n* 5. Output the sum of the squares of all the odd numbers between firstNum and secondNum."
                + "\n* 6. Output all the uppercase letters between firstNum and secondNum." + "\n* 0. Exit"
                + "\n----------------------------------------------------------------------"
                + "\nEnter the function: ");
    }

    static void inputNum() {
        do {
            System.out.print("Please enter the first number: ");
            firstNum = sc.nextInt();
            System.out.print("Please enter the second number: ");
            secondNum = sc.nextInt();

            if (firstNum > secondNum) {
                System.out.println("\nThe firstNum must smaller then the secondNum!\n");
            }

        } while (!(firstNum < secondNum));
        ifTheNumExist = true;
        System.out.println("\n-=INPUT FINISHED=-\n");
    }

    static void outputOddNum() {
        int n = firstNum + 1;
        System.out.println("\n-=OUTPUT START=-\n");
        for (int i = 1; n < secondNum; ++n, ++i) {
            System.out.print((n % 2 == 0) ? ("") : ((i % 5 == 0) ? (n + "\n") : (n + "\t")));
        }
        System.out.println("\n-=OUTPUT FINISHED=-\n");
    }

    static void outputTheSum() {
        int sum = 0;
        int n = firstNum + 1;
        System.out.println("\n-=THE SUM=-\n");
        for (; n < secondNum; ++n) {
            sum += (n % 2 == 0) ? (n * n) : (0);
        }
        System.out.println(sum);
        System.out.println("\n-=OUTPUT FINISHED=-\n");
    }

    static void outputTheSqures() {
        System.out.println("\n-=OUTPUT START=-\n");
        for (int n = 2; n < 10; ++n) {
            System.out.printf("%d ^ 2 = %d\n", n, n * n);
        }
        System.out.println("\n-=OUTPUT FINISHED=-\n");
    }

    static void outputTheSquresSum() {
        int n = firstNum + 1;
        int sum = 0;
        System.out.println("\n-=THE SUM=-\n");
        for (; n < secondNum; ++n) {
            sum += (n % 2 == 0) ? (0) : (n * n);
        }
        System.out.println(sum);
        System.out.println("\n-=OUTPUT FINISHED=-\n");
    }

    static void outputTheUppercaseLetters() {
        System.out.println("\n-=OUTPUT START=-\n");

        if (firstNum < 65) {
            int n = 65;
            for (int i = 1; n <= 90 && n <= secondNum; ++i, ++n) {

                System.out.print((i % 5 == 0) ? ((char) n + "\n") : ((char) n + "\t"));
            }
        } else if (firstNum >= 65 && firstNum <= 90) {
            int n = firstNum;
            for (int i = 1; n <= 90 && n <= secondNum; ++i, ++n) {

                System.out.print((i % 5 == 0) ? ((char) n + "\n") : ((char) n + "\t"));
            }

        } else {
            // nothing happen
        }
        System.out.println("\n-=OUTPUT FINISHED=-\n");
    }

}