import java.util.regex.Pattern;
import java.io.*;

// ----------------------------------------------------------------------------------------
// Count the equation in "question.txt", output the answer in "answer.txt"
// ----------------------------------------------------------------------------------------

public class Homework01 {
    public static void main(String[] args) throws IOException {
        System.out.println("date: 2020-04-27\n");
        FileTools.scan(".\\");
    }
}

class FileTools {
    public static void scan(String s) throws IOException {
        String qPath = s + "question.txt";
        String aPath = s + "answer.txt";

        String text = "";

        // ----------------------------------------------------------------------------------------
        // load question.txt
        // ----------------------------------------------------------------------------------------

        File qFile = new File(qPath);

        FileReader fr = new FileReader(qFile);
        BufferedReader br = new BufferedReader(fr);

        String str = br.readLine();

        while (str != null) {
            System.out.println(str + " = " + CountTools.scan(str));
            text += (str + " = " + CountTools.scan(str) + "\n");

            str = br.readLine();
        }
        br.close();
        fr.close();

        // System.out.println(text);

        // ----------------------------------------------------------------------------------------
        // create answer.txt
        // ----------------------------------------------------------------------------------------
        File aFilePath = new File(aPath);

        if (!aFilePath.exists()) {
            aFilePath.createNewFile();
        }
        FileWriter resultFile = new FileWriter((".\\answer.txt"));
        PrintWriter aFile = new PrintWriter(resultFile);
        aFile.println(text);
        resultFile.close();

    }
}

class CountTools {
    // ----------------------------------------------------------------------------------------
    // maybe I should call it Core or ...API?
    // ----------------------------------------------------------------------------------------

    static boolean scanError = false;

    public static String scan(String s) {

        if (scanError) {
            return "Format Error, Please Check!";
        }

        String doublePatternTemp = "^(add|sub|max|min|muti|div)\\((.*?),(.*?)\\)$";
        String singlePatternTemp = "^doubleMe\\((.*?)\\)$";

        String doublePatternFinal = "^(add|sub|max|min|muti|div)\\(\\d+(\\.\\d+)?,\\d+(\\.\\d+)?\\)$";
        String singlePatternFinal = "^doubleMe\\(\\d+(\\.\\d+)?\\)$";

        String justNumber = "^\\d+(\\.\\d+)?$";
        // String error = "Formate Error, Please Check!";

        boolean doubleTempMatch = Pattern.matches(doublePatternTemp, s);
        boolean singleTempMatch = Pattern.matches(singlePatternTemp, s);
        boolean doubleFinalMatch = Pattern.matches(doublePatternFinal, s);
        boolean singleFinalMatch = Pattern.matches(singlePatternFinal, s);

        boolean justNumberMatch = Pattern.matches(justNumber, s);
        // boolean errorMatch = Pattern.matches(error, s);

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
                case "muti":
                    return mutiCount(scan(p2), scan(p3));
                case "div":
                    return divCount(scan(p2), scan(p3));

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
                case "muti":
                    return mutiCount(p2, p3);
                case "div":
                    return divCount(p2, p3);
                default:
                    System.out.println("\nUNKNOWN ERROR\n");
                    return ("\nUNKNOWN ERROR\n");
            }

        }

        if (singleTempMatch && singleFinalMatch) {
            String p = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
            return doubleMeCount(p);
        }

        scanError = true;

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
        if (scanError == true) {
            return "Format Error, Please Check!";
        }
        double t = Double.parseDouble(p1) + Double.parseDouble(p2);
        return ("" + t);
    }

    private static String subCount(String p1, String p2) {
        if (scanError == true) {
            return "Format Error, Please Check!";
        }

        double t = Double.parseDouble(p1) - Double.parseDouble(p2);
        return ("" + t);
    }

    private static String maxCount(String p1, String p2) {
        if (scanError == true) {
            return "Format Error, Please Check!";
        }

        double t = (Double.parseDouble(p1) > Double.parseDouble(p2)) ? (Double.parseDouble(p1))
                : (Double.parseDouble(p2));
        return ("" + t);
    }

    private static String minCount(String p1, String p2) {
        if (scanError == true) {
            return "Format Error, Please Check!";
        }

        double t = (Double.parseDouble(p1) < Double.parseDouble(p2)) ? (Double.parseDouble(p1))
                : (Double.parseDouble(p2));
        return ("" + t);
    }

    private static String mutiCount(String p1, String p2) {
        if (scanError == true) {
            return "Format Error, Please Check!";
        }

        double t = Double.parseDouble(p1) * Double.parseDouble(p2);
        return ("" + t);
    }

    private static String divCount(String p1, String p2) {
        if (scanError == true) {
            return "Format Error, Please Check!";
        }

        double t = Double.parseDouble(p1) / Double.parseDouble(p2);
        return ("" + t);
    }

    private static String doubleMeCount(String p) {
        if (scanError == true) {
            return "Format Error, Please Check!";
        }

        double t = (2 * Double.parseDouble(p));
        return ("" + t);
    }

}