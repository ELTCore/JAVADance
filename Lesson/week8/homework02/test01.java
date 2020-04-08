import java.util.Scanner;
import java.util.regex.Pattern;

// -------------------------------------------------------------------------------------

// For example, common operations such as add, sub, max, min, doubleMe, etc., input an operational expression from the keyboard to solve the result.

// add means to adds two operands

// sub means to subtracts two operands

// max solves for the larger of the two Numbers

// min solves for the smaller of the two Numbers

// doubleMe doubles an operand(times 2)

// For example,

// Input: add(53.1,31.2), output: add(53.1,31.2)=84.3

// Input:sub (20.2,10.1), output: sub(20.2,10.1)=10.1

// Input:doubleMe (12), output: doubleMe(12)=24
// -------------------------------------------------------------------------------------

public class test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = 'n';

        System.out.println("date: 2020-04-02\n");

        System.out.println(
                "add means to adds two operands\n\nsub means to subtracts two operands\n\nmax solves for the larger of the two Numbers\n\nmin solves for the smaller of the two Numbers\n\ndoubleMe doubles\n\nan operand (times 2)\n\nFor example,\nInput: add(53.1,31.2), output: add(53.1,31.2)=84.3\n\nInput:sub (20.2,10.1), output: sub(20.2,10.1)=10.1\n\nInput:doubleMe (12), output: doubleMe(12)=24\n\n");

        do {
            System.out.print("Input:");

            System.out.println(scan(sc.next()));

            System.out.print("Again?(y/n):");
            ch = sc.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');

        sc.close();
    }

    static String scan(String s) {
        String p1 = "NULL";
        String p2 = "NULL";
        String p3 = "NULL";
        double result = 0.0;

        String doublePattern = "^(add|sub|max|min)\\(\\d+(\\.\\d+)?,\\d+(\\.\\d+)?\\)$";
        String singlePattern = "^doubleMe\\(\\d+(\\.\\d+)?\\)$";

        boolean doubleMatch = Pattern.matches(doublePattern, s);
        boolean singleMatch = Pattern.matches(singlePattern, s);

        if (!(doubleMatch || singleMatch)) {
            return "\nFormat Error, Please Check!";
        }
        // else{
        // return "OK!";
        // }

        if (doubleMatch) {
            p1 = s.substring(0, s.indexOf("("));
            p2 = s.substring(s.indexOf("(") + 1, s.indexOf(","));
            p3 = s.substring(s.indexOf(",") + 1, s.indexOf(")"));

            double t1 = Double.parseDouble(p2);
            double t2 = Double.parseDouble(p3);

            switch (p1) {
                case "add":
                    result = t1 + t2;
                    break;
                case "sub":
                    result = t1 - t2;
                    break;
                case "max":
                    result = (t1 > t2) ? (t1) : (t2);
                    break;
                case "min":
                    result = (t1 < t2) ? (t1) : (t2);
                    break;
                default:
                    System.out.println("\nERROR\n");
                    return ("\nERROR\n");
            }

            return ("output: " + p1 + "(" + p2 + "," + p3 + ")= " + String.format("%.4f", result));
        } else {
            p1 = "doubleMe";
            p2 = s.substring(s.indexOf("(") + 1, s.indexOf(")"));

            result = 2 * (Double.parseDouble(p2));

            return ("output: " + p1 + "(" + p2 + ")= " + String.format("%.4f", result));
        }
    }

}
