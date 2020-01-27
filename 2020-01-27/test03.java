import java.util.Scanner;

public class test03{
    public static void main(String[] args) {
        System.out.println("2020-01-27\nby HaikiYuuki\n");
        Scanner scan = new Scanner(System.in);
        // Get data from keyboard

        // Receive the character string by 'nextLine'
        System.out.println("Receive the character string by \"nextLine\": ");
        
        // Judge if there is still input
        if (scan.hasNext()){
            String str1 = scan.nextLine();
            System.out.println("The string is: " + str1);
        }
        scan.close();
    }
}