package core;

import java.util.Scanner;

public class CheckingAccount extends Account {
    private double serviceCharge = 0.0;
    private Scanner sc = new Scanner(System.in);

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Override
    public void comsume() {
        if (isIfSet()) {
            System.out.println("-= COMSUME =-");
            System.out.print("Enter the number:");
            double t = sc.nextDouble();
            this.setMoney(this.getMoney() - t);
            System.out.println("-= FINISHED -=");
        } else {
            System.out.println("-= ERROR =-");
            System.out.println("Please create the accout first.");
        }

    }

    public void repay() {
        if (isIfSet()) {
            System.out.println("-= REPAY =-");
            System.out.println("Balance: " + this.getMoney() + "\n");
            System.out.print("Enter the number:");
            double t = sc.nextDouble();
            this.setMoney(this.getMoney() + t);
            System.out.println("-= FINISHED -=");

        } else {
            System.out.println("-= ERROR =-");
            System.out.println("Please create the accout first.");
        }
    }

    public void settle() {
        if (isIfSet()) {
            this.setMoney(this.getMoney() - this.getServiceCharge());
            System.out.println("-= Checking Account settle finished! =-");
        }
    }

}
