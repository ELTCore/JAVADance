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

// Input: add(53.1,31.2), output: 84.3

// Input:sub (20.2,10.1), output: 10.1

// Input:doubleMe (12), output: 24

// or...

// Input:add(doubleMe(1),add(sub(2,1),max(min(4,6),3)))
// Output: 7.0
// -------------------------------------------------------------------------------------

public class Homework02 {
    public static void main(String[] args) {
        System.out.println("date: 2020-04-21\n");

        Scanner sc = new Scanner(System.in);

        char ch = 'n';

        System.out.println(
                "Welcome\n For example, common operations such as add, sub, max, min, doubleMe, etc.,\n input an operational expression from the keyboard to solve the result.\n add means to adds two operands                \n sub means to subtracts two operands                \n max solves for the larger of the two Numbers                \n min solves for the smaller of the two Numbers                \n doubleMe doubles an operand(times 2)                \n For example,                \n Input: add(53.1,31.2), output: 84.3                \n Input:sub (20.2,10.1), output: 10.1                \n Input:doubleMe (12), output: 24                \n or...                \n Input:add(doubleMe(1),add(sub(2,1),max(min(4,6),3)))        \n Output: 7.0        \n :3        ");
        do {
            System.out.println("\nTips:\nadd(x,y)\nsub(x,y)\nmax(x,y)\nmin(x,y)\ndoubleMe(x)\nINPUT:");

            String s = sc.next();

            System.out.println("\nOUTPUT:");
            System.out.println(tools.scan(s));

            System.out.print("\nAgain?(y/n):");
            ch = sc.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');

        sc.close();
    }
}

class tools {
    // ----------------------------------------------------------------------------------------
    // maybe I should call it Core or ...API?
    // ----------------------------------------------------------------------------------------

    public static String scan(String s) {
        String doublePatternTemp = "^(add|sub|max|min)\\((.*?),(.*?)\\)$";
        String singlePatternTemp = "^doubleMe\\((.*?)\\)$";

        String doublePatternFinal = "^(add|sub|max|min)\\(\\d+(\\.\\d+)?,\\d+(\\.\\d+)?\\)$";
        String singlePatternFinal = "^doubleMe\\(\\d+(\\.\\d+)?\\)$";

        String justNumber = "^\\d+(\\.\\d+)?$";

        boolean doubleTempMatch = Pattern.matches(doublePatternTemp, s);
        boolean singleTempMatch = Pattern.matches(singlePatternTemp, s);
        boolean doubleFinalMatch = Pattern.matches(doublePatternFinal, s);
        boolean singleFinalMatch = Pattern.matches(singlePatternFinal, s);

        boolean justNumberMatch = Pattern.matches(justNumber, s);

        if (justNumberMatch) {
            return s;
        }
        // EG:add(add(add(1,add(1,1)1),doubleMe(1)),add(1,1))
        if (doubleTempMatch && !doubleFinalMatch) {
            String p1 = s.substring(0, s.indexOf("("));
            String p2 = s.substring(s.indexOf("(") + 1, getTheCommaIndex(s));
            String p3 = s.substring(getTheCommaIndex(s) + 1, s.length() - 1);
            switch (p1) {
                case "add":
                    return addCount(scan(p2), scan(p3));
                case "sub":
                    return subCount(scan(p2), scan(p3));
                case "max":
                    return maxCount(scan(p2), scan(p3));
                case "min":
                    return minCount(scan(p2), scan(p3));
                default:
                    System.out.println("\nUNKNOWN ERROR\n");
                    return ("\nUNKNOWN ERROR\n");
            }

        }

        if (singleTempMatch && !singleFinalMatch) {
            String p = s.substring(s.indexOf("(") + 1, s.length() - 1);
            return doubleMeCount(scan(p));
        }

        if (doubleTempMatch && doubleFinalMatch) {
            String p1 = s.substring(0, s.indexOf("("));
            String p2 = s.substring(s.indexOf("(") + 1, s.indexOf(","));
            String p3 = s.substring(s.indexOf(",") + 1, s.indexOf(")"));

            switch (p1) {
                case "add":
                    return addCount(p2, p3);
                case "sub":
                    return subCount(p2, p3);
                case "max":
                    return maxCount(p2, p3);
                case "min":
                    return minCount(p2, p3);
                default:
                    System.out.println("\nUNKNOWN ERROR\n");
                    return ("\nUNKNOWN ERROR\n");
            }

        }

        if (singleTempMatch && singleFinalMatch) {
            String p = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
            return doubleMeCount(p);
        }

        return "Format Error, Please Check!";
    }

    // ----------------------------------------------------------------------------------------
    // I need a more convenient way to get the index of ','
    // ----------------------------------------------------------------------------------------
    private static int getTheCommaIndex(String s) {
        for (int i = 0, t1 = 0, t2 = 0; i < s.length(); ++i) {
            // t1 -> the number of '('
            // t2 -> the number of ')'
            if (s.charAt(i) == '(') {
                ++t1;
            }
            if (s.charAt(i) == ')') {
                ++t2;
            }
            if ((t2 == t1 - 1) && s.charAt(i) == ',') {
                return i;
            }
        }
        return -1;
    }

    // ----------------------------------------------------------------------------------------
    // String to Double to String : 3
    // ----------------------------------------------------------------------------------------
    private static String addCount(String p1, String p2) {
        double t = Double.parseDouble(p1) + Double.parseDouble(p2);
        return ("" + t);
    }

    private static String subCount(String p1, String p2) {
        double t = Double.parseDouble(p1) - Double.parseDouble(p2);
        return ("" + t);
    }

    private static String maxCount(String p1, String p2) {
        double t = (Double.parseDouble(p1) > Double.parseDouble(p2)) ? (Double.parseDouble(p1))
                : (Double.parseDouble(p2));
        return ("" + t);
    }

    private static String minCount(String p1, String p2) {
        double t = (Double.parseDouble(p1) < Double.parseDouble(p2)) ? (Double.parseDouble(p1))
                : (Double.parseDouble(p2));
        return ("" + t);
    }

    private static String doubleMeCount(String p) {
        double t = (2 * Double.parseDouble(p));
        return ("" + t);
    }

}

// OHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH, I FINALLY GET IT OVER!!