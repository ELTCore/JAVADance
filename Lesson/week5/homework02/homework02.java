package week5.homework02;

import java.util.Scanner;

// -------------------------------------------------------------------------------------
// Extend the Employee class from question 1 by creating 2 new classes. The classes
// are Administrator and SalesPerson which inherit all instance fields and methods from
// the Employee class. In addition, the Administrator has a bonus field which is a one
// off payment that is added to the baseSalary. The SalesPerson class has a new field:
// yearlySales. Commission is calculated as 10% of yearlySales. This commission is
// added to the baseSalary after the updateSalary() method is called.
// Create updateSalary() methods for both new classes. You will add bonus and
// commission respectively to the baseSalary. You will need to include updateSalary()
// class from the Employee class by using super.
// Add an instance method named displayEmployee() for both classes in which in
// addition to the data from the Employee class you also display the bonus field
// (Administrator) and yearlySales and commission fields (SalesPerson).
// Create a test driver with a main () that instantiates 2 objects – 1 of Administrator and
// 1 of SalesPerson. Add appropriate data (hard coded or from keyboard) and display
// details on the screen using the appropriate displayEmployee() method.
// Update the salary of each employee and then display only the new base salary.
// -------------------------------------------------------------------------------------

public class homework02 {
    // WARNING: THIS PROGRAM DOES NOT FINISHE!
    // WARNING: THIS PROGRAM DOES NOT FINISHE!
    // WARNING: THIS PROGRAM DOES NOT FINISHE!

    // ====================MAIN====================
    public static void main(String[] args) {
        System.out.println("date: 2020-03-13\n");
        NewDriver.menu();
    }

    // ====================MAIN====================
}

class NewDriver {
    static Scanner sc = new Scanner(System.in);
    static byte choose = 0;
    static Administrator Adm = new Administrator(null, null, null, null, 0.00, false);
    static SalesPerson SP = new SalesPerson(null, null, null, null, 0.00, false);

    static void test() {
        Adm.defaultAll();
        Adm.setFirstName("test");
        System.out.println(Adm.getFirstName());
    }

    static void menu() {

    }

}

class Administrator extends Employee {
    public Administrator(String eFirstName, String eLastName, String eEmployeeID, String eDepartment,
            double eBaseSalary, boolean eIfSet) {
        super(eFirstName, eLastName, eEmployeeID, eDepartment, eBaseSalary, eIfSet);
        // TODO Auto-generated constructor stub
    }

    private double bounus = 0.0;

    @Override
    public void defaultAll() {
        // TODO Auto-generated method stub
        super.defaultAll();
    }

    @Override
    public double getBaseSalary() {
        // TODO Auto-generated method stub
        return super.getBaseSalary();
    }

    @Override
    public String getDepartment() {
        // TODO Auto-generated method stub
        return super.getDepartment();
    }

    @Override
    public String getEmployeeID() {
        // TODO Auto-generated method stub
        return super.getEmployeeID();
    }

    @Override
    public String getFirstName() {
        // TODO Auto-generated method stub
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        // TODO Auto-generated method stub
        return super.getLastName();
    }

    @Override
    public boolean isIfSet() {
        // TODO Auto-generated method stub
        return super.isIfSet();
    }

    @Override
    public void setBaseSalary(double baseSalary) {
        // TODO Auto-generated method stub
        super.setBaseSalary(baseSalary);
    }

    @Override
    public void setDepartment(String department) {
        // TODO Auto-generated method stub
        super.setDepartment(department);
    }

    @Override
    public void setEmployeeID(String employeeID) {
        // TODO Auto-generated method stub
        super.setEmployeeID(employeeID);
    }

    @Override
    public void setFirstName(String firstName) {
        // TODO Auto-generated method stub
        super.setFirstName(firstName);
    }

    @Override
    public void setIfSet(boolean ifSet) {
        // TODO Auto-generated method stub
        super.setIfSet(ifSet);
    }

    @Override
    public void setLastName(String lastName) {
        // TODO Auto-generated method stub
        super.setLastName(lastName);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    public double getBounus() {
        return bounus;
    }

    public void setBounus(double bounus) {
        this.bounus = bounus;
    }

}

class SalesPerson extends Employee {
    public SalesPerson(String eFirstName, String eLastName, String eEmployeeID, String eDepartment, double eBaseSalary,
            boolean eIfSet) {
        super(eFirstName, eLastName, eEmployeeID, eDepartment, eBaseSalary, eIfSet);
        // TODO Auto-generated constructor stub
    }

    private double yearlySales = 0.0;

    @Override
    public void defaultAll() {
        // TODO Auto-generated method stub
        super.defaultAll();
    }

    @Override
    public double getBaseSalary() {
        // TODO Auto-generated method stub
        return super.getBaseSalary();
    }

    @Override
    public String getDepartment() {
        // TODO Auto-generated method stub
        return super.getDepartment();
    }

    @Override
    public String getEmployeeID() {
        // TODO Auto-generated method stub
        return super.getEmployeeID();
    }

    @Override
    public String getFirstName() {
        // TODO Auto-generated method stub
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        // TODO Auto-generated method stub
        return super.getLastName();
    }

    @Override
    public boolean isIfSet() {
        // TODO Auto-generated method stub
        return super.isIfSet();
    }

    @Override
    public void setBaseSalary(double baseSalary) {
        // TODO Auto-generated method stub
        super.setBaseSalary(baseSalary);
    }

    @Override
    public void setDepartment(String department) {
        // TODO Auto-generated method stub
        super.setDepartment(department);
    }

    @Override
    public void setEmployeeID(String employeeID) {
        // TODO Auto-generated method stub
        super.setEmployeeID(employeeID);
    }

    @Override
    public void setFirstName(String firstName) {
        // TODO Auto-generated method stub
        super.setFirstName(firstName);
    }

    @Override
    public void setIfSet(boolean ifSet) {
        // TODO Auto-generated method stub
        super.setIfSet(ifSet);
    }

    @Override
    public void setLastName(String lastName) {
        // TODO Auto-generated method stub
        super.setLastName(lastName);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    public double getYearlySales() {
        return yearlySales;
    }

    public void setYearlySales(double yearlySales) {
        this.yearlySales = yearlySales;
    }

}