public class test02 {
    public static void main(String[] args) {
        System.out.println("2020-01-27\n by HaikiYuuki\n");
        int n = 100;
        int count = 1;
        for (int i = 2; i <= n; ++i) {
            boolean ifPrime = true;
            for (int j = 2; j < i; ++j) {
                if (i % j == 0) {
                    ifPrime = false;
                    break;
                }
            }
            if (ifPrime) {
                System.out.print(i + " ");
                if (count % 5 == 0) {
                    System.out.println();
                }
                ++count;
            }
        }
    }
}