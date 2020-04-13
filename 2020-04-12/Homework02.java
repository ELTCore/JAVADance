import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

// -------------------------------------------------------------------------------------
// Develop an application to read IDs,names, genders, course and scores of students 
// from two different input and display the average score for each student and average 
// score for each course.

// The program runs as follows:

// Please enter the basic information of students :
// (each student lines, enter the format of "studentID, name, gender", such as "001, ZhangSan, male", when the input "end")
// ------------------------------
// 001,ZhangShan,female
// 002,LiYun,male
// 003,WangYan,female
// 004,LiuHua,male
// end
// ------------------------------
// Please enter student grades :
// (one line for each grade, enter the format of "studentID, course name, grade", such as "001, Java, 90", when the input "end")

// ------------------------------
// 001,Java,90
// 002,Java,80
// 003,Java,70
// 004,Java,85
// 001,Internet,90
// 002,Internet,88
// 003,Internet,90
// 004,Internet,88
// 001,C,90
// 002,C,88
// 003,C,90
// 004,C,88
// end
// ------------------------------

// output:
// By students:
// studentId        name            gender      averageScore
//  001             ZhangShan       Female      90
//  002             LiYun           Male        80
//  003             WangYan         Female      78
//  004             LiuHua          Male        85

// By course:
// course           averageScore
//  Java                88
//  Internet            78
//  C                   85

// -------------------------------------------------------------------------------------

public class Homework02 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> studentList = new ArrayList<Student>();
    static ArrayList<String> courseList = new ArrayList<String>();
    static ArrayList<Score> scoreList = new ArrayList<Score>();

    public static void main(String[] args) {
        System.out.println("date: 2020-04-12\n");
        System.out.println(
                "// Develop an application to read IDs,names, genders, course and scores of students \n// from two different input and display the average score for each student and average \n// score for each course.        ");

        char ch = 'n';
        String s = "";

        do {
            System.out.println(
                    "\n// Please enter the basic information of students :\n// (each student lines, enter the format of \"studentID, name, gender\", such as \"001, ZhangSan, male\", when the input \"end\")\n// ------------------------------\n// 001,ZhangShan,female\n// 002,LiYun,male\n// 003,WangYan,female\n// 004,LiuHua,male\n// end\n// ------------------------------\nINPUT:\n        ");
            do {
                s = sc.nextLine();
                if (s.equals("end")) {
                    break;
                }
                System.out.println(scanStudent(s));

            } while (true);

            System.out.println(
                    "\n// Please enter student grades :\n// (one line for each grade, enter the format of \"studentID, course name, grade\", such as \"001, Java, 90\", when the input \"end\")\n\n// ------------------------------            \n// 001,Java,90            \n// 002,Java,80            \n// 003,Java,70            \n// 004,Java,85            \n// 001,Internet,90            \n// 002,Internet,88            \n// 003,Internet,90            \n// 004,Internet,88            \n// 001,C,90            \n// 002,C,88            \n// 003,C,90            \n// 004,C,88            \n// end            \n// ------------------------------\nINPUT:");
            do {
                s = sc.nextLine();
                if (s.equals("end")) {
                    break;
                }
                System.out.println(scanScore(s));

            } while (true);

            output();
            System.out.print("\nAgain?(y/n):");
            ch = sc.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');

        sc.close();
    }

    static String scanStudent(String s) {
        String pattern = "^(\\d+),(\\w+),(\\w+)$";
        if (!(Pattern.matches(pattern, s))) {
            return ("\nFormat Error, Please Input Again.\n");

        } else {
            String studentId = s.substring(0, s.indexOf(","));
            String name = s.substring(s.indexOf(",") + 1, s.indexOf(",", s.indexOf(",") + 1));
            String sex = s.substring(s.indexOf(",", s.indexOf(",") + 1) + 1);

            if (!(sex.equals("male") || sex.equals("female"))) {
                return ("\nSorry, please input \"male\" or \"female\".\n");
            }
            studentList.add(new Student());
            studentList.get(studentList.size() - 1).setStudentId(studentId);
            studentList.get(studentList.size() - 1).setName(name);
            studentList.get(studentList.size() - 1).setSex(sex);

            return ("\nInput Success\n");
        }

    }

    static String scanScore(String s) {
        String pattern = "^(\\d+),(\\w+),(\\d+(\\.\\d+)?)$";

        if (!(Pattern.matches(pattern, s))) {
            return ("\nFormat Error, Please Input Again.\n");

        } else {
            String studentId = s.substring(0, s.indexOf(","));
            boolean ifFound = false;

            for (int i = 0; i < studentList.size(); ++i) {
                if (studentList.get(i).getStudentId().equals(studentId)) {
                    String courseName = s.substring(s.indexOf(",") + 1, s.indexOf(",", s.indexOf(",") + 1));
                    double score = (Double.parseDouble(s.substring(s.indexOf(",", s.indexOf(",") + 1) + 1)));

                    courseList.add(courseName);

                    scoreList.add(new Score(courseName, score, studentId));

                    ifFound = true;
                    break;
                }
            }
            if (ifFound == false) {
                return ("\nCan not find the student,please input again.");
            } else {
                return ("\nInput Success\n");
            }

        }

    }

    static void output() {
        System.out.println("\nOUTPUT:\n");
        System.out.println("By students:");
        System.out.println("studentId\t\tname\t\t\tgender\t\taverageScore");
        for (int i = 0; i < studentList.size(); ++i) {
            String studentId = studentList.get(i).getStudentId();
            String name = studentList.get(i).getName();
            String gender = studentList.get(i).getSex();
            double averageScore = 0.0;
            int count = 0;

            for (int j = 0; j < scoreList.size(); ++j) {
                if (scoreList.get(j).getStudentId().equals(studentList.get(i).getStudentId())) {
                    averageScore += scoreList.get(j).getScore();
                    ++count;
                }
            }
            if (count != 0) {
                averageScore /= count;
            }
            System.out.println(
                    studentId + "\t\t\t" + name + "\t\t" + gender + "\t\t" + String.format("%.2f", averageScore));
        }
        System.out.println("\nBy course:");
        System.out.println("course\t\taverageScore");
        for (int i = 0; i < courseList.size(); ++i) {
            String courseName = courseList.get(i);
            double averageScore = 0.0;
            int count = 0;
            for (int j = 0; j < scoreList.size(); ++j) {
                if (courseName.equals(scoreList.get(j).getCourseName())) {
                    averageScore += scoreList.get(j).getScore();
                    ++count;
                }
            }
            if (count != 0) {
                averageScore /= count;
            }
            System.out.println(courseName + "\t\t\t" + averageScore);
        }
    }

}

class Score {
    private String courseName = "NULL";
    private double score = 0.0;
    private String studentId = "NULL";

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Score(String courseName, double score, String studentId) {
        this.courseName = courseName;
        this.score = score;
        this.studentId = studentId;
    }

}

class Student {
    private String studentId = "NULL";
    private String name = "NULL";
    private String sex = "NULL";

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
