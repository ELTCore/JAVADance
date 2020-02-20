package week1.homework04;

import java.util.Scanner;

// --------------------------------------------------------------------------------
// You have several pictures of different sizes that you would like to frame. A
// local picture framing store offers two types of frames - regular and fancy. The
// frames are available in white and can be ordered in any color the customer
// desires. Suppose that each frame is 1 inch wide. The cost of coloring the
// frame is $0.10 per inch. The cost of a regular frame is $0.15 per inch and the
// cost of a fancy frame is $0.25 per inch. The cost of putting a board paper
// behind the picture is $0.02 per square inch and the cost of putting glass on top
// of the picture is $0.07 per square inch. The customer can also choose to put
// crowns on the corners, which cost $0.35 per crown.
// Write a program that prompts the user to input the following information and
// then output the cost of framing the picture.
// a) The length and width, in inches, of the picture
// b) The type of the frame
// c) Customer's choice of color to color the frame
// d) If the user wants to put the crowns, then the number of crowns.
// --------------------------------------------------------------------------------

public class homework04 {
    public static void main(String[] args) {
        System.out.println("date: 2020-02-19\n");
        Scanner sc = new Scanner(System.in);
        String form = "NULL";
        char board = 'w';
        char glass = 'w';
        char crown = 'w';
        int numOfCrowns = 0;
        float money = 0;

        System.out.print("\nEnter the length: ");
        int length = sc.nextInt();
        System.out.print("\nEnter the width: ");
        int width = sc.nextInt();

        while (!(form.equals("regular") || form.equals("fancy"))) {
            System.out.print("\nChoose a form(regular or fancy):");
            form = sc.next();
        }
        money += (form.equals("regular")) ? (2 * (width + length) * 0.1) : (2 * (width + length) * 0.25);

        System.out.print("\nEnter a color of the frame: ");
        String color = sc.next();

        while (board != 'y' && board != 'Y' && board != 'n' && board != 'N') {
            System.out.print("\nDo you want to put a board paper behind the picture?(y/n): ");
            board = sc.next().charAt(0);
        }
        money += (board == 'y' || board == 'Y') ? (width * length * 0.02) : (0);

        while (glass != 'y' && glass != 'Y' && glass != 'n' && glass != 'N') {
            System.out.print("\nDo you want to put a glass on top of the picture?(y/n): ");
            glass = sc.next().charAt(0);
        }
        money += (glass == 'y' || glass == 'Y') ? (width * length * 0.25) : (0);

        while (crown != 'y' && crown != 'Y' && crown != 'n' && crown != 'N') {
            System.out.print("\nDo you need crowns?(y/n): ");
            crown = sc.next().charAt(0);

            if (crown == 'y' || crown == 'Y') {
                while (!(numOfCrowns >= 1 && numOfCrowns <= 4)) {
                    System.out.print("\nEnter the number:");
                    numOfCrowns = sc.nextInt();
                }
                money += numOfCrowns * 0.35;
            }
        }
        System.out.println("\n-------------------------");
        System.out.println("Length:\t" + length);
        System.out.println("Width:\t" + width);
        System.out.println("Squre:\t" + length * width);
        System.out.println("Color:\t" + color);
        System.out.println("Board:\t" + board);
        System.out.println("Glass:\t" + glass);
        System.out.println("Crown:\t" + numOfCrowns);
        System.out.println("\n-------------------------");
        System.out.printf("Price:\t %.2f", money);
        System.out.println("\n-------------------------\n");

        sc.close();
    }
}
// oh my god it finally works!