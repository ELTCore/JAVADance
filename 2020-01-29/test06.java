// Why this place always has a error? The follow:
// The declared package "" does not match the expected package "2020-01-29"Java(536871240)

public class test06 {
    static final int a;
    // Member methods with the 'final' modification cannot be overridden by
    // subclasses, but can be overloaded and called.
    static {
        a = 6;
    }

    static int b = 2;

    // static {
    // a = 8;
    // }

    // Error: The final field a may already have been assignedJava(33554514)

    public static void main(String[] args) {
        System.out.println("\n2020-01-29\nby HaikiYuuki\n");
        System.out.println("a = " + a);
        b++;
        System.out.println("b = " + b);
        // a++;
        // System.out.println("a = " + a);
        // This will appear a error.
        System.out.println("\nFinished.\n");
    }

}