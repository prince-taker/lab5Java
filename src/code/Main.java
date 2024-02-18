/**
 * Demonstrates the usage of the `Person` class and its various methods.
 * @author Prince Lesapo and Jimmy Aphane.
 * @version 1.0
 */
public class Main {
    public static void main(final String[] args)
    {
        final Person p1;
        final Person p2;
        final Person p3;

        p1 = new Person("Tiger", "Woods", 1975, "divorced", 200,
                "undergraduate");
        p2 = new Person("Jason", "Wilder", 2000, "no", 180,
                "graduate");
        p3 = new Person("Santa", "Claus", 1000, "yes", 280,
                "high school");

        p1.printDetails();
        System.out.println("\n--------------------");
        p1.printDetails(true);
        System.out.println("\n--------------------");
        p1.printDetails(true, true);
        System.out.println("\n--------------------");
        p1.printDetails(true, false);
        System.out.println("\n--------------------");
        p1.printDetails(false, true);
        System.out.println("\n--------------------");
        p1.printDetails(false, false);
        System.out.println("\n--------------------");

        p2.printDetails();
        System.out.println("\n--------------------");
        p2.printDetails(true);
        System.out.println("\n--------------------");
        p2.printDetails(true, true);
        System.out.println("\n--------------------");
        p2.printDetails(true, false);
        System.out.println("\n--------------------");
        p2.printDetails(false, true);
        System.out.println("\n--------------------");
        p2.printDetails(false, false);
        System.out.println("\n--------------------");

        p3.printDetails();
        System.out.println("\n--------------------");
        p3.printDetails(true);
        System.out.println("\n--------------------");
        p3.printDetails(true, true);
        System.out.println("\n--------------------");
        p3.printDetails(true, false);
        System.out.println("\n--------------------");
        p3.printDetails(false, true);
        System.out.println("\n--------------------");
        p3.printDetails(false, false);
        System.out.println("\n--------------------");
    }
}
