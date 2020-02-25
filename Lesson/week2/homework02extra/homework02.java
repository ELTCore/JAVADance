package week2.homework02extra;

import java.util.Scanner;

// -------------------------------------------------------------------------------------
// Daffodils Numbers are also known as superperfect number invariants, narcissistic Numbers, self-power Numbers,
// and Armstrong Numbers. Daffodils number refers to a number of n digits (n>=3),
// the sum of the digits on each of its bits to the NTH power is equal to its own requirements.
// Write a program to calculate the number of daffodils in n bits (3<=n<=7).
// Input format:
// Given a positive integer n (3<=n<=7).
// Output format:
// Output all n-bit daffodils in ascending order, one line for each digit.
// Input sample:

// Here's a set of inputs. Such as:
// 3

// Output sample:

// 153
// 370
// 371
// 407
// -------------------------------------------------------------------------------------
public class homework02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("date: 2020-02-25\n");
        char ch = 'n';
        do {
            System.out.print("Please input a positive integer n(3 <= n <= 7): ");
            int n = sc.nextInt();

            while (!(n >= 3 && n <= 7)) {
                System.out.print("Please re-enter(3 <= n <= 7): ");
                n = sc.nextInt();
            }

            System.out.println("-= PRINT START =-\n");

            for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); ++i) {
                // int i = 153;
                int sum = 0, temp = i;
                for (int t = 1; t <= n; ++t) {
                    sum += (int) Math.pow((int) temp % 10, n);
                    temp /= 10;
                }
                if (sum == i) {
                    System.out.println(i);
                } else {
                    continue;
                }
            }
            System.out.println("-= PRINT END =-\n");

            System.out.print("Again?(y/n):");

            ch = sc.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');
        sc.close();
        System.exit(1);
    }
}