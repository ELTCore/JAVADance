package week1.exercise02;

import java.util.Scanner;

// --------------------------------------------------------------------------------
// A box of biscuits can hold 24 biscuits and a container can hold 75 boxes of
// biscuits. Write a program that prompts the user to enter the total number of
// biscuits. The program then outputs the number of boxes and the number of
// containers to ship the biscuits. Note that each box must contain the specified
// number of biscuits and each container must contain the specified number of
// boxes. If the last box of biscuits contains less than the number of specified
// biscuits, you can discard it, and output the number of leftover biscuits.
// Similarly, if the last container contains less than the number of specified
// boxes, you can discard it, and output the number of leftover boxes
// --------------------------------------------------------------------------------
public class exercise02 {
    public static void main(String[] args) {
        System.out.println("date: 2020-02-18\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of biscuits: ");
        int biscuit = sc.nextInt();
        int box = biscuit / 24;
        int leftBiscuit = biscuit - box * 24;
        int container = box / 75;
        int leftBox = box - container * 75;
        leftBiscuit += leftBox * 24;

        System.out.println("\nBox: " + box + "\nContainers:" + container + "\nLeftover biscuits: " + leftBiscuit
                + "\nLeftover boxes:" + leftBox);
        sc.close();
    }
}