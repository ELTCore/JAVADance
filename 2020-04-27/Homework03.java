import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework03 {
    public static void main(String[] args) throws IOException {
        System.out.println("data: 2020-04-30\n");
        ArrayList<variable> vList = new ArrayList<variable>();
        Scanner sc = new Scanner(System.in);

        String className = "";

        System.out.println("Please input the name of your class:");
        className = sc.next();

        char ch = 'n';
        do {
            String type = "";
            String name = "";

            String s = sc.nextLine();
            System.out.println("Please input a variable:\t(e.g. int t)");
            s = sc.nextLine();

            Pattern vPattern = Pattern.compile("(.*?)(\\s)(.*?)$");
            Matcher vMatcher = vPattern.matcher(s);

            if (!vMatcher.find()) {
                System.out.println("Format Error");
            } else {
                type = vMatcher.group(1);
                name = vMatcher.group(3);

                vList.add(new variable());
                vList.get(vList.size() - 1).setType(type);
                vList.get(vList.size() - 1).setName(name);
            }

            System.out.println("Continue?(y/n):");
            ch = sc.next().charAt(0);

        } while (ch == 'y' || ch == 'Y');

        StringBuilder sb = new StringBuilder();

        sb.append("class " + className + " {\r\n");
        for (int i = 0; i < vList.size(); ++i) {
            sb.append("    private " + vList.get(i).getType() + " " + vList.get(i).getName() + ";\r\n");
        }

        for (int i = 0; i < vList.size(); ++i) {
            String Name = vList.get(i).getName().substring(0, 1).toUpperCase() + vList.get(i).getName().substring(1);
            String name = vList.get(i).getName();
            String type = vList.get(i).getType();

            sb.append("    public " + type + " get" + Name + "() {\r\n");
            sb.append("        return " + name + ";\r\n");
            sb.append("    }\r\n");

            sb.append("    public void set" + Name + "(" + type + " " + name + ") {\r\n");
            sb.append("        this." + name + " = " + name + ";\r\n");
            sb.append("    }\r\n");
        }

        sb.append("}\r\n");

        File file = new File(".\\file.java");

        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter resultFile = new FileWriter((".\\file.java"));
        PrintWriter pw = new PrintWriter(resultFile);

        pw.print(sb);
        resultFile.close();
        sc.close();
    }
}

class variable {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}