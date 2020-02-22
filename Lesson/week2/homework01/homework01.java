package week2.homework01;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

// -------------------------------------------------------------------------------------
// Write a program that plays the game of "Guess the number" as follows:
// Your program chooses the number to be guessed by selecting an integer at random
// in the range 1 to 1000. The program then displays in an input dialog box:
// ------------------------------------------------------------
// I have a number between 1 and 1000.
// Can you guess my number?
// Please type your first guess.
// ------------------------------------------------------------

// The player then types a first guess. The program responds with one of the following:
// ------------------------------------------------------------
// 1. Excellent! You guessed the number (message dialog box)
// 2. Too Low. Try Again. (input dialog box)
// 3. Too High. Try Again. (input dialog box)
// ------------------------------------------------------------

// If the player’s guess is incorrect, your program should loop until the player finally gets
// the number right in which case you "break" from the loop. Your program should keep
// telling the player Too high or Too low to help the player narrow the range of values
// to guess.

// Random numbers
// There are 2 ways to generate a random number:
// · The random() method of the Math class
// · The Random class in java.util

// E.g. int startNum = 1;
// int randomNumber;
// randomNumber = startNum + (int)(Math.random()*1000);

// Modify the above program so that after the number is guessed the user of the
// program can start a new game and can play as many games as they like until
// the user quits the program. Use a do…while loop and print the message
// "Would you like to play again (y or n)?" to play the game again. Declare a counter
// variable to display the number of guesses it took the user to guess the random
// number.
// -------------------------------------------------------------------------------------

public class homework01 {
    public static void main(String[] args) {
        JFrame jf = new JFrame("homework01  date:2020-02-20");
        jf.setSize(800, 600);
        jf.setVisible(true);
        int guess = 1;
        int randomNumber = 1 + (int) (Math.random() * 1000);
        int tryTimes = 1;
        int n = 0;

        do {
            n = JOptionPane.showConfirmDialog(null,
                    "I have a number between 1 and 1000.\nCan you guess my number?\nIf so, please choose \"Yes\".",
                    "Hello", JOptionPane.YES_NO_OPTION);
            if (n == 1) {
                System.exit(0);
            } else {
                guess = Integer.valueOf(JOptionPane.showInputDialog(null, "Very Well, your first number?: "))
                        .intValue();
                while (guess != randomNumber) {
                    if (tryTimes > 10) {
                        JOptionPane.showMessageDialog(null, "Well, the answer is " + randomNumber, "Have a nice day",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    if (guess < randomNumber) {
                        guess = Integer
                                .valueOf(JOptionPane.showInputDialog(null, "Too Low, try again(" + tryTimes + "/10)"))
                                .intValue();
                        ++tryTimes;
                        continue;
                    } else if (guess > randomNumber) {
                        guess = Integer
                                .valueOf(JOptionPane.showInputDialog(null, "Too high, try again(" + tryTimes + "/10)"))
                                .intValue();
                        ++tryTimes;
                        continue;
                    }
                }
                if (guess == randomNumber) {
                    JOptionPane.showMessageDialog(null, "Excellent! You guessed the number", "Have a nice day",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } while (n != 1);

    }
}