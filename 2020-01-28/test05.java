
// But soon I find this...
import java.util.Arrays;

// intersting

public class test05 {
    public static void printIntArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
    }

    public static int[] reverse(int[] list) {
        int[] result = new int[list.length];

        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
            result[j] = list[i];
        }

        System.out.println("\nReverse Finished.\n");

        return result;
    }

    public static void main(String[] args) {
        System.out.println("2020-01-28\nby HaikiYuuki\n");
        
        int[] arrayTest05 = { 0, 1, 2, 3, 4 }; // Repeat, this way is the first alternative

        System.out.print("Test05:");
        printIntArray(arrayTest05);
        System.out.println();

        arrayTest05 = reverse(arrayTest05);
        System.out.print("Test05:");
        printIntArray(arrayTest05);
        System.out.println();


        int[] arr06 = new int[5]; // to request new memory space(like the way in C++)
        Arrays.fill(arr06, 2);

    }
}