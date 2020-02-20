package week1.homework03;

import java.util.Scanner;

// --------------------------------------------------------------------------------
// Emulate a vending machine. Calculate the number of dollars and coins
// required to express a given amount of change in dollars, 50, 20, 10 and 5 cent
// coins. For example, $9.85 would be $9, 1 x 50c, 1 x 20x and 1 x 5c coins.
// Then modify it so that it also prints out the number of $1 and $2 coins.
// --------------------------------------------------------------------------------

public class homework03 {
    public static void main(String[] args) {
        System.out.println("date: 2020-02-18\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the money: ");
        float money = sc.nextFloat();
        money = (int)(money*100);
        int d2 = (int) ((money / 200));
        money -= d2*200;
        int d1 = (int) ((money % 200) / 100);
        money -= d1*100;
        int c50 = (int) ((money % 100) / 50);
        money -= c50*50;
        int c20 = (int) ((money % 50) / 20);
        money -= c20*20;
        int c10 = (int) ((money % 20) / 10);
        money -= c10*10;
        int c5 = (int) ((money % 10) / 5);
        System.out.printf("\nThe result:\n$2: %d \n$1: %d \n50c: %d \n20c: %d \n10c: %d\n5c: %d\n", d2, d1, c50, c20, c10, c5);
        
        sc.close();
    }
}