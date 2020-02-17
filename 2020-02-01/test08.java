import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test08 {
    public static void main(String args[]) throws IOException {
        char c;
        // use System.in to create BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input chars, enter 'q' to exit");
        // load chars
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
}