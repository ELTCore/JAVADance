package core;

import java.util.Scanner;

public class Account {
    private Scanner sc = new Scanner(System.in);
    private String ssn = "NULL";
    private String name = "NULL";
    private String accountNum = "NULL";
    private boolean ifSet = false;
    private double money = 0.0;

    public void save() {
        if (isIfSet()) {
            System.out.println("-= SAVE =-");
            System.out.print("Enter the number:");
            this.setMoney(this.getMoney() + sc.nextDouble());
            System.out.println("-= FINISHED -=");

        } else {
            System.out.println("-= ERROR =-");
            System.out.println("Please create the accout first.");
        }
    }

    public void withdraw() {
        if (isIfSet()) {
            System.out.println("-= WITHDRAW =-");
            System.out.print("Enter the number:");
            double t = sc.nextDouble();
            if (t < this.getMoney()) {
                this.setMoney(this.getMoney() - t);
                System.out.println("-= FINISHED -=");

            } else {
                System.out.println("-= ERROR =-");
                System.out.println("Not sufficient funds");
            }
        } else {
            System.out.println("-= ERROR =-");
            System.out.println("Please create the accout first.");
        }
    }

    public void comsume() {
        if (isIfSet()) {
            System.out.println("-= COMSUME =-");
            System.out.print("Enter the number:");
            double t = sc.nextDouble();
            if (t < this.getMoney()) {
                this.setMoney(this.getMoney() - t);
                System.out.println("-= FINISHED -=");

            } else {
                System.out.println("-= ERROR =-");
                System.out.println("Not sufficient funds");
            }
        } else {
            System.out.println("-= ERROR =-");
            System.out.println("Please create the accout first.");
        }
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public boolean isIfSet() {
        return ifSet;
    }

    public void setIfSet(boolean ifSet) {
        this.ifSet = ifSet;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

}