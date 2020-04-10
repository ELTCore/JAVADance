import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

// -------------------------------------------------------------------------------------
// Write a Java program, input several student information from the keyboard,
// solve the number of all students, the number of male students,
// the number of female students and their respective percentage,
// all students from which provinces and the number of each province,
// at the same time show each province is which students.
// Program running process:
// Please enter the basic information of the students :
// (one line for each student in the format of "student number, name, gender, province",
// such as "001, Zhang San, male, hubei", when the input "end")
// --------------------
// 001,ZhangShan,female,hubei

// 002,LiYun,male,hubei

// 003,WangYan,female,hunan

// 004,LiuHua,male,beijing

// 005,BiLi,male,guang♂door

// 006,LiLi,female,beijing

// end
// --------------------
// The result is as follows:
// Total number: 6
// Male: 2, 33.3%; female: 4, 66.7%
// Students from the following provinces:
// Hubei: 2 (zhang shan, li yun)
// Hunan: 1 person (wang yan)
// Beijing: 2 persons (liu hua, li li)
// Guangdong: 1 person (xu ze)
// -------------------------------------------------------------------------------------

public class Homework01 {
    static ArrayList<Student> studentList = new ArrayList<Student>();
    static ArrayList<String> provinceList = new ArrayList<String>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("date: 2020-04-10\n");
        System.out.println(
                "// Please enter the basic information of the students :\n// (one line for each student in the format of \"student number, name, gender, province\",\n// such as \"001, Zhang San, male, hubei\", when the input \"end\")\n\nEg:\n// --------------------\n// 001,ZhangShan,female,hubei\n// 002,LiYun,male,hubei\n// 003,WangYan,female,hunan\n// 004,LiuHua,male,beijing\n// 005,BiLi,male,guang♂door\n// 006,LiLi,female,beijing\n// end\n// --------------------\nInput:\n        ");
        System.out.println(scan(sc.nextLine()));
    }

    static String scan(String s) {
        String pattern = "^(\\w+),(\\w+),(\\w+),(\\w+)$";
        if (!(Pattern.matches(pattern, s))) {
            return ("\nFormat Error, Please Input Again.\n");
        } else {
            return ("\nInput Success\n");
        }
    }

}

class Student {
    private String studentId = "NULL";
    private String name = "NULL";
    private String sex = "NULL";
    private String province = "NULL";

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}