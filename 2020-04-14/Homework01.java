import java.util.Scanner;
import java.util.regex.Pattern;

// -------------------------------------------------------------------------------------
// Write a Validate class that encapsulates the common data format
// (user name, password, phone number, phone number, QQ number, id number,
// postal code, Email, website, date of birth, name)
// of the test methods, such as isMobile (), isPhone (), etc., to write a driver
// program,
// input the corresponding data in turn, calls the Validate class complete input
// data inspection,
// if the check is not passed, prompted to input,
// until the input is correct.
// --------------------------------------------------------------------------------------
public class Homework01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("date: 2020-04-14\n");
        do {
            System.out.println("Please input a userName:");
        } while (!Validate.isUserName(sc.nextLine()));

        do {
            System.out.println("Please input a password:");
        } while (!Validate.isPassword(sc.nextLine()));

        do {
            System.out.println("Please input a phoneNumber:");
        } while (!Validate.isPhoneNumber(sc.nextLine()));

        do {
            System.out.println("Please input a qqNumber:");
        } while (!Validate.isQQNumber(sc.nextLine()));

        do {
            System.out.println("Please input a idNumber:");
        } while (!Validate.isIdNumber(sc.nextLine()));

        do {
            System.out.println("Please input a postalCode:");
        } while (!Validate.isPostalCode(sc.nextLine()));

        do {
            System.out.println("Please input a email:");
        } while (!Validate.isEmail(sc.nextLine()));

        do {
            System.out.println("Please input a website:");
        } while (!Validate.isWebsite(sc.nextLine()));

        do {
            System.out.println("Please input a birthday");
        } while (!Validate.isBirthday(sc.nextLine()));

        do {
            System.out.println("Please input a Chinese name:");
        } while (!Validate.isName(sc.nextLine()));

        sc.close();
    }
}

class Validate {
    private static String userName = "[a-zA-Z][a-zA-Z0-9_]{4,15}";
    private static String password = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\s\\S]{8,16}$";
    private static String phoneNumber = "0?(13|14|15|17|18|19)[0-9]{9}";
    private static String qqNumber = "^[1-9][0-9]{4,11}$";
    private static String idNumber = "^\\d{17}[\\d|x]|\\d{15}$";
    private static String postalCode = "^[1-9]\\d{5}$";
    private static String email = "^\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}$";
    private static String website = "^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+$";
    private static String birthday = "\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}";
    private static String name = "[\u4e00-\u9fa5]{1,6}";

    public static boolean isUserName(String s) {
        return Pattern.matches(userName, s);
    }

    public static boolean isPassword(String s) {
        return Pattern.matches(password, s);
    }

    public static boolean isPhoneNumber(String s) {
        return Pattern.matches(phoneNumber, s);
    }

    public static boolean isQQNumber(String s) {
        return Pattern.matches(qqNumber, s);
    }

    public static boolean isIdNumber(String s) {
        return Pattern.matches(idNumber, s);
    }

    public static boolean isPostalCode(String s) {
        return Pattern.matches(postalCode, s);
    }

    public static boolean isEmail(String s) {
        return Pattern.matches(email, s);
    }

    public static boolean isWebsite(String s) {
        return Pattern.matches(website, s);
    }

    public static boolean isBirthday(String s) {
        return Pattern.matches(birthday, s);
    }

    public static boolean isName(String s) {
        return Pattern.matches(name, s);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getBirthday() {
        return birthday;
    }

    public static void setBirthday(String birthday) {
        Validate.birthday = birthday;
    }
}