// Something about the ArrayList in JAVA
// At first, I think the way arrays are used in JAVA is closer to Python, not C
// It seems that I was wrong

public class test04 {
    public static void main(String[] args) {
        System.out.println("2020-01-28\nby HaikiYuuki\n");
        // int[] arrayTest01 = { 0, 1, 2, 3, 4, 5 }; // First choice
        // int arrayTest02[] = { 0, 1, 2, 3, 4, 5 }; // Same effect, but not preferred

        double[] myList03 = { 0.1, 0.2, 0.3, 0.4, 0.5 }; // better alternative
        double myList04[] = { 0.1, 0.2, 0.3, 0.4, 0.5 };

        // System.out.println("Test01: " + arrayTest01 + "\n" + "Test02: " +
        // arrayTest02);
        // Well, it can't output the whole array...
        System.out.println("Test03: " + myList03[0] + "\n" + "Test04: " + myList04[0]);

        // So..Let's begin
        System.out.print("Test03:" + " ");
        for (int i = 0; i < myList03.length; i++) {
            System.out.print(myList03[i] + " ");
        }
        // Aha...At least I don't have to worry about the length of the array

        // then I find another more simple way :D
        // It seems called 'For-Each Cycle' or 'Enhanced Cycle'
        // It can traverse groups without using subscripts
        System.out.println("\n\nIn a new way:");
        for (double element : myList03) {
            System.out.print(element + " ");
        }

        System.out.println("\nFinished.\n");
    }
}