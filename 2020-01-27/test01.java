// Write a function that outputs all primes within 1 to 100
// Prime: also called prime number, a number that is divisible by 1 and itself, but not by any other number.

public class test01 {
    public static void main(String[] args) {
        System.out.println("2020-01-27\n by HaikiYuuki\n");
        // The follow is just a test, to confirm 7 if a Prime.
        int i = 7;
        boolean ifPmember = true;
        for (int j = 2; j < i; ++j) {
            if (i % j == 0) {
                ifPmember = false;
                break;
            }
        }
        System.out.println(ifPmember ? i + " is a Prime Member" : i + " is not a Prime Member");

    }
}