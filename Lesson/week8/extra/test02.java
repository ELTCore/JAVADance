import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

// -------------------------------------------------------------------------------------

// Each transaction contains a serial number, 
// called a serial number, which contains a lot of information.
// Suppose a supermarket's serial number format is yyyyMMdd****.
// For example, 202003300001 (year 4, month 2, day 2, sequence 4)refers to 
// the first sales record of the supermarket on March 30, 2020.
// Write a Java cash register system and input the product name, 
// product unit price, sales quantity and other information in turn (each item is divided by,
// and the cash register ends when the input is 0000).
// ---------------
// For example:
// toothpaste,2,2
// cigarette,3,20
// mineral water,10,1.5
// 0000
// ---------------
// output:
// SerialNumber     Name            Quantity        UnitPrice       TotalPrices
// 202003300001     toothpaste          2               2               4
// 202003300002     cigarette           3               20              60
// 202003300003     mineral water       10              1.5             15

// Total:
//      Number of sales:    3
//      Number of quantity: 15
//      Sales Amount:       79
// -------------------------------------------------------------------------------------

public class test02 {
    static Scanner sc = new Scanner(System.in);
    static deal[] list = new deal[64];
    static int count = 0;
    static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
    static Date today = new Date();
    static String todayStr = df.format(today);
    static int totalQuantity = 0;
    static double salesAmount = 0.0;

    public static void main(String[] args) {
        System.out.println("date: 2020-04-03\n");

        char ch = 'n';
        String s = "";

        System.out.println(
                "        \n// Each transaction contains a serial number,         \n// called a serial number, which contains a lot of information.        \n// Suppose a supermarket's serial number format is yyyyMMdd****.        \n// For example, 202003300001 (year 4, month 2, day 2, sequence 4)refers to         \n// the first sales record of the supermarket on March 30, 2020.        \n// Write a Java cash register system and input the product name,         \n// product unit price, sales quantity and other information in turn (each item is divided by,        \n// and the cash register ends when the input is 0000).        \n// ---------------        \n// For example:        \n// toothpaste,2,2        \n// cigarette,3,20        \n// mineral water,10,1.5        \n// 0000        \n// ---------------");

        do {
            System.out.println("Input:");
            do {
                s = sc.nextLine();
                if (s.equals("0000")) {
                    break;
                }
                System.out.println(scan(s));

            } while (count < 64);

            output();

            System.out.print("Again?(y/n):");
            ch = sc.next().charAt(0);
            count = 0;
            totalQuantity = 0;
            salesAmount = 0.0;
        } while (ch == 'y' || ch == 'Y');

        sc.close();
    }

    static void output() {
        System.out.println("\nOUTPUT\n");
        System.out.println("SerialNumber\t\tName\t\t\tQuantity\t\tUnitPrice\t\tTotalPrices");
        for (int i = 0; i < count; ++i) {
            System.out.println(list[i].getSerialNumber() + "\t\t" + list[i].getName() + "\t\t\t" + list[i].getQuantity()
                    + "\t\t\t" + list[i].getUnitPrice() + "\t\t\t" + list[i].getQuantity() * list[i].getUnitPrice());
        }
        System.out.println("\nTotal:\nNumber of Sales:\t" + count + "\nNumber of quantity:\t" + totalQuantity
                + "\nSales Amount:\t\t" + salesAmount);
        System.out.println(
                "\nOUTPUT FINISHED\n-------------------------------------------------------------------------------------");
    }

    static String scan(String s) {
        String pattern = "^(\\w+),\\d+,\\d+(\\.\\d+)?$";

        if (!(Pattern.matches(pattern, s))) {
            return ("\nFormat Error, Please Input Again.\n");
        } else {
            list[count] = new deal();
            list[count].setSerialNumber(todayStr + String.format("%04d", count + 1));
            list[count].setName(s.substring(0, s.indexOf(",")));
            list[count].setQuantity(
                    (int) Double.parseDouble(s.substring(s.indexOf(",") + 1, s.indexOf(",", s.indexOf(",") + 1))));
            list[count].setUnitPrice(Double.parseDouble(s.substring(s.indexOf(",", s.indexOf(",") + 1) + 1)));

            totalQuantity += list[count].getQuantity();
            salesAmount += list[count].getQuantity() * list[count].getUnitPrice();

            ++count;
            return ("\nInput Success\n");
        }
    }

}

class deal {
    private String serialNumber = "NULL";
    private String name = "NULL";
    private int quantity = 0;
    private double unitPrice = 0.0;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

}