import java.util.Random;

public class test11 {
    public static void main(String[] args) {
        System.out.println("date: 2020-03-13\n");

        String s1 = "abcde";
        String s2 = "12345";
        // ======================================
        Random r = new Random();
        char[] t1 = s1.toCharArray();

        char ch = t1[0];

        for (int i = 0, j = 0; i < s1.length(); ++i) {
            j = r.nextInt(s1.length());
            ch = t1[i];
            t1[i] = t1[j];
            t1[j] = ch;
        }

        System.out.println("\n" + s1 + "\n" + s2 + "\n" + String.copyValueOf(t1));

    }
}