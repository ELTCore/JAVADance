package week7.homework01;

import java.util.Scanner;

// -------------------------------------------------------------------------------------
// Develop an application to check the validity of a password
// Must be between 8 and 15 characters in length
// May not contain spaces
// Must contain at least one nonnumeric uppercase character and one nonnumeric lowercase character
// Must contain at least one numeric digit
// -------------------------------------------------------------------------------------

public class CheckPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;

        System.out.println("date: 2020-03-27\n");
        msg();
        s = sc.nextLine();

        boolean length = checkLenghOK(s);
        boolean noSpace = checkNoSpace(s);
        boolean bigCh = checkAtLeastBigCh(s);
        boolean smallCh = checkAtLeastSmallCh(s);
        boolean number = checkAtLeastNumber(s);

        if (length && noSpace && bigCh && smallCh && number) {
            System.out.println("\nCongratulations,your password \"" + s + "\" is valid.");
        } else {
            System.out.println("\nYour password \"" + s + "\" is not valid for the following reason<s>:");
            System.out.println(
                    ((!length) ? ("\nIts lengh is not valid.") : ("")) + ((!noSpace) ? ("\nIt contains a space") : (""))
                            + ((!bigCh) ? ("\nIt does not contain an upper case character.") : (""))
                            + ((!smallCh) ? ("\nIt does not contain a lower case character.") : (""))
                            + ((!number) ? ("\nIt does not cantain a digit") : ("")));

        }

        sc.close();
    }

    static boolean checkLenghOK(String s) {
        if (s.length() < 8 || s.length() > 15) {
            return false;
        }
        return true;
    }

    static boolean checkNoSpace(String s) {
        if (s.indexOf(" ") != -1) {
            return false;
        }
        return true;
    }

    static boolean checkAtLeastBigCh(String s) {
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                return true;
        }
        return false;
    }

    static boolean checkAtLeastSmallCh(String s) {
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                return true;
        }
        return false;
    }

    static boolean checkAtLeastNumber(String s) {
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9')
                return true;
        }
        return false;
    }

    static void msg() {
        System.out.println(
                "Enter a password that meets all the following conditions:\n\n1. It contains a total of 8 to 15 characters, no spaces\n2. It contains at least one uppercase non-numeric character\n3. It contains at least one numeric digit\n\n");
    }
}