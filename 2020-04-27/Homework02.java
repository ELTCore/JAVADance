import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class Homework02 {
    static ArrayList<Student> studentList = new ArrayList<Student>();

    public static void main(String[] args) throws IOException {
        System.out.println("date: 2020-04-27\n");
        OrderRecognize.menu(studentList);
    }
}

// ----------------------------------------------------------------------------------------
// Driver
// ----------------------------------------------------------------------------------------

class OrderRecognize {
    static Scanner sc = new Scanner(System.in);

    // ----------------------------------------------------------------------------------------
    // MENU
    // ----------------------------------------------------------------------------------------

    public static void menu(ArrayList<Student> studentList) throws IOException {
        Pattern loadPattern = Pattern.compile("^load (.*?)(\\s*)$", Pattern.CASE_INSENSITIVE);
        Pattern selectPattern = Pattern.compile("^select (.*?)$", Pattern.CASE_INSENSITIVE);
        Pattern selectWherePattern = Pattern.compile("^select (.*?) where (.*?)$", Pattern.CASE_INSENSITIVE);
        Pattern sortPattern = Pattern.compile("^sort (.*?)(\\s*)$", Pattern.CASE_INSENSITIVE);

        int length = 0;

        do {
            System.out.println("\nINPUT(input \"help\" to show the order-list):");
            String order = sc.nextLine();

            Matcher loadMatcher = loadPattern.matcher(order);
            boolean isLoad = loadMatcher.find();

            Matcher selectMatcher = selectPattern.matcher(order);
            boolean isSelect = selectMatcher.find();

            Matcher selectWhereMatcher = selectWherePattern.matcher(order);
            boolean isSelectWhere = selectWhereMatcher.find();

            Matcher sortMatcher = sortPattern.matcher(order);
            boolean isSort = sortMatcher.find();

            if (order.equals("exit")) {
                System.exit(0);

            } else if (order.equals("help")) {
                helpMsg();

            } else if (isLoad) {

                length = Tools.load(loadMatcher.group(1), studentList);

                if (length == 0) {
                    System.out.println("\nLoad Failed, Please Check.");

                } else {
                    System.out.println("\nLoad Scucess. length: " + length);

                }

            } else if (isSelectWhere) {
                if (length == 0) {
                    System.out.println("\nPlease load file first.");

                } else {
                    Tools.selectWhere(studentList, selectWhereMatcher.group(1), selectWhereMatcher.group(2));

                }

            } else if (isSelect) {
                if (length == 0) {
                    System.out.println("\nPlease load file first.");

                } else {
                    Tools.select(studentList, selectMatcher.group(1));

                }

            } else if (isSort) {
                if (length == 0) {
                    System.out.println("\nPlease load file first.");
                } else {
                    Tools.sort(studentList, sortMatcher.group(1));
                }
            } else {
                System.out.println("Unkown order, input \"help\" to get the order-list");

            }

        } while (true);
    }

    // ----------------------------------------------------------------------------------------
    // Help massage
    // ----------------------------------------------------------------------------------------

    private static void helpMsg() {
        System.out.println(
                "\nOrder List\n------------------------------\n1. help\n2. load *\n3. select *\t(e.g. select name province)\n4. select * where *\t(e.g. select studentId name province where grade >= 70)\n5. sort *\t(e.g. sort studentId(or grade))\n6. exit\n------------------------------\n");
    }

}

// ----------------------------------------------------------------------------------------
// Tools
// ----------------------------------------------------------------------------------------

class Tools {
    // ----------------------------------------------------------------------------------------
    // Load file
    // ----------------------------------------------------------------------------------------
    public static int load(String s, ArrayList<Student> studentList) throws IOException {
        String path = ".\\" + s;
        int length = 0;

        File file = new File(path);

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String str = br.readLine();

        while (str != null) {
            System.out.println(str);

            if (scan(str, studentList)) {
                ++length;
            }

            str = br.readLine();
        }

        br.close();
        fr.close();

        return length;
    }

    // ----------------------------------------------------------------------------------------
    // Select
    // ----------------------------------------------------------------------------------------
    public static void select(ArrayList<Student> studentList, String lineName) {
        Pattern studentIdPattern = Pattern.compile("studentId", Pattern.CASE_INSENSITIVE);
        Pattern namePattern = Pattern.compile("name", Pattern.CASE_INSENSITIVE);
        Pattern genderPattern = Pattern.compile("gender", Pattern.CASE_INSENSITIVE);
        Pattern provincePattern = Pattern.compile("province", Pattern.CASE_INSENSITIVE);
        Pattern birthdayPattern = Pattern.compile("birthday", Pattern.CASE_INSENSITIVE);
        Pattern gradePattern = Pattern.compile("grade", Pattern.CASE_INSENSITIVE);

        Matcher studentIdMatcher = studentIdPattern.matcher(lineName);
        Matcher nameMatcher = namePattern.matcher(lineName);
        Matcher genderMatcher = genderPattern.matcher(lineName);
        Matcher provinceMatcher = provincePattern.matcher(lineName);
        Matcher birthdayMatcher = birthdayPattern.matcher(lineName);
        Matcher gradeMatcher = gradePattern.matcher(lineName);

        boolean hasStudentID = studentIdMatcher.find();
        boolean hasName = nameMatcher.find();
        boolean hasGender = genderMatcher.find();
        boolean hasProvince = provinceMatcher.find();
        boolean hasBirthday = birthdayMatcher.find();
        boolean hasGrade = gradeMatcher.find();

        for (int i = 0; i < studentList.size(); ++i) {
            String studentId = (hasStudentID) ? (studentList.get(i).getStudentId()) : ("");
            String name = (hasName) ? (studentList.get(i).getName()) : ("");
            String gender = (hasGender) ? (studentList.get(i).getGender()) : ("");
            String province = (hasProvince) ? (studentList.get(i).getProvince()) : ("");
            String birthday = (hasBirthday) ? (studentList.get(i).getBirthday()) : ("");
            String grade = (hasGrade) ? ("" + studentList.get(i).getGrade()) : ("");

            System.out.println(
                    studentId + "\t" + name + "\t" + gender + "\t" + province + "\t" + birthday + "\t" + grade);
        }
    }

    // ----------------------------------------------------------------------------------------
    // Select where
    // ----------------------------------------------------------------------------------------
    public static void selectWhere(ArrayList<Student> studentList, String lineName, String condition) {
        Pattern studentIdPattern = Pattern.compile("studentId", Pattern.CASE_INSENSITIVE);
        Pattern namePattern = Pattern.compile("name", Pattern.CASE_INSENSITIVE);
        Pattern genderPattern = Pattern.compile("gender", Pattern.CASE_INSENSITIVE);
        Pattern provincePattern = Pattern.compile("province", Pattern.CASE_INSENSITIVE);
        Pattern birthdayPattern = Pattern.compile("birthday", Pattern.CASE_INSENSITIVE);
        Pattern gradePattern = Pattern.compile("grade", Pattern.CASE_INSENSITIVE);

        Matcher studentIdMatcher = studentIdPattern.matcher(lineName);
        Matcher nameMatcher = namePattern.matcher(lineName);
        Matcher genderMatcher = genderPattern.matcher(lineName);
        Matcher provinceMatcher = provincePattern.matcher(lineName);
        Matcher birthdayMatcher = birthdayPattern.matcher(lineName);
        Matcher gradeMatcher = gradePattern.matcher(lineName);

        boolean hasStudentID = studentIdMatcher.find();
        boolean hasName = nameMatcher.find();
        boolean hasGender = genderMatcher.find();
        boolean hasProvince = provinceMatcher.find();
        boolean hasBirthday = birthdayMatcher.find();
        boolean hasGrade = gradeMatcher.find();

        Pattern studentIdConditionPattern = Pattern.compile("(studentId) (>|=|<|(>=)|(<=)) (\\d+)$",
                Pattern.CASE_INSENSITIVE);
        Pattern nameConditionPattern = Pattern.compile("(name) = (.*?)$", Pattern.CASE_INSENSITIVE);
        Pattern genderConditionPattern = Pattern.compile("(gender) = (.*?)$", Pattern.CASE_INSENSITIVE);
        Pattern provinceConditionPattern = Pattern.compile("(province) = (.*?)$", Pattern.CASE_INSENSITIVE);
        Pattern birthdayConditionPattern = Pattern.compile("(birthday) = (.*?)$", Pattern.CASE_INSENSITIVE);
        Pattern gradeConditionPattern = Pattern.compile("(grade) (>|=|<|(>=)|(<=)) ([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$",
                Pattern.CASE_INSENSITIVE);

        Matcher studentIdConditionMatcher = studentIdConditionPattern.matcher(condition);
        Matcher nameConditionMatcher = nameConditionPattern.matcher(condition);
        Matcher genderConditionMatcher = genderConditionPattern.matcher(condition);
        Matcher provinceConditionMatcher = provinceConditionPattern.matcher(condition);
        Matcher birthdayConditionMatcher = birthdayConditionPattern.matcher(condition);
        Matcher gradeConditionMatcher = gradeConditionPattern.matcher(condition);

        boolean hasStudentIDCondition = studentIdConditionMatcher.find();
        boolean hasNameCondition = nameConditionMatcher.find();
        boolean hasGenderCondition = genderConditionMatcher.find();
        boolean hasProvinceCondition = provinceConditionMatcher.find();
        boolean hasBirthdayCondition = birthdayConditionMatcher.find();
        boolean hasGradeCondition = gradeConditionMatcher.find();

        // test
        // System.out.println("\nProvinceCondition.group(1)" +
        // provinceConditionMatcher.group(1)
        // + "\nProvinceCondition.group(2)" + provinceConditionMatcher.group(2));

        // System.out.println(
        // "\nhasProvinceCondition: " + hasProvinceCondition + "\nhasGradeCondition:" +
        // hasGradeCondition);

        // System.out.println("\ngradeCondition.group(2):" +
        // gradeConditionMatcher.group(2) + "\ngradeCondition.group(3):"
        // + gradeConditionMatcher.group(3) + "\ngradeCondition.group(4):" +
        // gradeConditionMatcher.group(4));
        // System.out.println("gradeCondition.group(5):" +
        // gradeConditionMatcher.group(5));

        String studentIdConditionSymbol = "";
        int studentIdConditionValue = 0;
        String nameCondition = "";
        String genderCondition = "";
        String provinceCondition = "";
        String birthdayCondition = "";
        String gradeConditionSymbol = "";
        Double gradeConditionValue = 0.0;

        if (hasStudentIDCondition) {
            studentIdConditionSymbol = studentIdConditionMatcher.group(2);
            studentIdConditionValue = (int) Double.parseDouble(studentIdConditionMatcher.group(5));
            System.out.println("\nstudentIdCondition: " + studentIdConditionSymbol + studentIdConditionValue);
        }

        if (hasNameCondition) {
            nameCondition = nameConditionMatcher.group(2);
            System.out.println("\nnameCondition: " + nameCondition);
        }

        if (hasGenderCondition) {
            genderCondition = genderConditionMatcher.group(2);
            System.out.println("\ngenderCondition: " + genderCondition);
        }

        if (hasProvinceCondition) {
            provinceCondition = provinceConditionMatcher.group(2);
            System.out.println("\nprovinceCondition: " + provinceCondition);
        }

        if (hasBirthdayCondition) {
            birthdayCondition = birthdayConditionMatcher.group(2);
            System.out.println("\nbirthdayCondition: " + birthdayCondition);
        }

        if (hasGradeCondition) {
            gradeConditionSymbol = gradeConditionMatcher.group(2);
            gradeConditionValue = Double.parseDouble(gradeConditionMatcher.group(5));
            System.out.println("\ngradeCondition: " + gradeConditionSymbol + gradeConditionValue);
        }

        for (int i = 0; i < studentList.size(); ++i) {
            String studentId = (hasStudentID) ? (studentList.get(i).getStudentId()) : ("");
            String name = (hasName) ? (studentList.get(i).getName()) : ("");
            String gender = (hasGender) ? (studentList.get(i).getGender()) : ("");
            String province = (hasProvince) ? (studentList.get(i).getProvince()) : ("");
            String birthday = (hasBirthday) ? (studentList.get(i).getBirthday()) : ("");
            String grade = (hasGrade) ? ("" + studentList.get(i).getGrade()) : ("");

            if (hasStudentIDCondition) {
                if (studentIdConditionSymbol.equals(">")) {
                    if (!((int) Double.parseDouble(studentList.get(i).getStudentId()) > studentIdConditionValue)) {
                        continue;
                    }
                }
                if (studentIdConditionSymbol.equals("=")) {
                    if (!((int) Double.parseDouble(studentList.get(i).getStudentId()) == studentIdConditionValue)) {
                        continue;
                    }
                }
                if (studentIdConditionSymbol.equals("<")) {
                    if (!((int) Double.parseDouble(studentList.get(i).getStudentId()) < studentIdConditionValue)) {
                        continue;
                    }
                }
                if (studentIdConditionSymbol.equals(">=")) {
                    if (!((int) Double.parseDouble(studentList.get(i).getStudentId()) >= studentIdConditionValue)) {
                        continue;
                    }
                }
                if (studentIdConditionSymbol.equals("<=")) {
                    if (!((int) Double.parseDouble(studentList.get(i).getStudentId()) <= studentIdConditionValue)) {
                        continue;
                    }
                }
            }
            if (hasNameCondition) {
                if (!studentList.get(i).getName().equals(nameCondition)) {
                    continue;
                }
            }
            if (hasGenderCondition) {
                if (!studentList.get(i).getGender().equals(genderCondition)) {
                    continue;
                }
            }
            if (hasProvinceCondition) {
                if (!studentList.get(i).getProvince().equals(provinceCondition)) {
                    continue;
                }
            }
            if (hasBirthdayCondition) {
                if (!studentList.get(i).getBirthday().equals(birthdayCondition)) {
                    continue;
                }
            }
            if (hasGradeCondition) {
                if (gradeConditionSymbol.equals(">")) {
                    if (!(studentList.get(i).getGrade() > gradeConditionValue)) {
                        continue;
                    }
                }
                if (gradeConditionSymbol.equals("=")) {
                    if (!(studentList.get(i).getGrade() == gradeConditionValue)) {
                        continue;
                    }
                }
                if (gradeConditionSymbol.equals("<")) {
                    if (!(studentList.get(i).getGrade() < gradeConditionValue)) {
                        continue;
                    }
                }
                if (gradeConditionSymbol.equals(">=")) {
                    if (!(studentList.get(i).getGrade() >= gradeConditionValue)) {
                        continue;
                    }
                }
                if (gradeConditionSymbol.equals("<=")) {
                    if (!(studentList.get(i).getGrade() <= gradeConditionValue)) {
                        continue;
                    }
                }
            }

            System.out.println(
                    studentId + "\t" + name + "\t" + gender + "\t" + province + "\t" + birthday + "\t" + grade);
        }
    }

    // ----------------------------------------------------------------------------------------
    // Sort
    // ----------------------------------------------------------------------------------------
    public static void sort(ArrayList<Student> studentList, String lineName) {
        if (lineName.equals("studentId")) {
            for (int i = 0; i < studentList.size(); ++i) {
                for (int j = i + 1; j < studentList.size(); ++j) {
                    if (Double.parseDouble(studentList.get(i).getStudentId()) > Double
                            .parseDouble(studentList.get(j).getStudentId())) {
                        exchange(studentList, i, j);
                    }
                }
            }
            for (int i = 0; i < studentList.size(); ++i) {
                System.out.println(studentList.get(i).toString());
            }

        } else if (lineName.equals("grade")) {
            for (int i = 0; i < studentList.size(); ++i) {
                for (int j = i + 1; j < studentList.size(); ++j) {
                    if (studentList.get(i).getGrade() < studentList.get(j).getGrade()) {
                        exchange(studentList, i, j);
                    }
                }
            }
            for (int i = 0; i < studentList.size(); ++i) {
                System.out.println(studentList.get(i).toString());
            }

        } else {
            System.out.println("\nError, please input \"studentId\" or \"grade\".");
        }

    }

    private static void exchange(ArrayList<Student> studentList, int p, int q) {
        Student t = new Student();
        t = studentList.get(p);

        studentList.set(p, studentList.get(q));
        studentList.set(q, t);
        // System.out.println("\nExchange!\n");
    }

    // ----------------------------------------------------------------------------------------
    // Scan str
    // ----------------------------------------------------------------------------------------
    private static boolean scan(String s, ArrayList<Student> studentList) {
        Pattern dataPattern = Pattern.compile("(\\d+) (.*?) (.*?) (.*?) (\\d+-\\d+-\\d+) (\\d+(\\.\\d+)?)");

        Matcher dataMatcher = dataPattern.matcher(s);

        boolean isRight = dataMatcher.find();

        if (isRight) {
            String studentId = dataMatcher.group(1);
            String name = dataMatcher.group(2);
            String gender = dataMatcher.group(3);
            String province = dataMatcher.group(4);
            String birthday = dataMatcher.group(5);
            double grade = Double.parseDouble(dataMatcher.group(6));

            studentList.add(new Student());
            int index = studentList.size() - 1;

            studentList.get(index).setStudentId(studentId);
            studentList.get(index).setName(name);
            studentList.get(index).setGender(gender);
            studentList.get(index).setProvince(province);
            studentList.get(index).setBirthday(birthday);
            studentList.get(index).setGrade(grade);

            return true;
        }

        return false;
    }

}

class Student {
    private String studentId = "NULL";
    private String name = "NULL";
    private String gender = "NULL";
    private String province = "NULL";
    private String birthday = "NULL";
    private double grade = 0.0;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", name=" + name + ", gender=" + gender + ", province=" + province
                + ", birthday=" + birthday + ", grade=" + grade + "]";
    }

}