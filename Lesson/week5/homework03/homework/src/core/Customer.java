package core;

import java.util.Scanner;

public class Customer {
    private Scanner sc = new Scanner(System.in);
    SavingAccount SA = new SavingAccount();
    CheckingAccount CA = new CheckingAccount();

    public void setSA() {
        System.out.println("-= SAVING ACCOUNT =-");
        System.out.print("Name:");
        SA.setName(sc.next());
        System.out.print("SSN:");
        SA.setSsn(sc.next());
        System.out.print("AccountNum:");
        SA.setAccountNum(sc.next());
        System.out.print("Interest:");
        SA.setInterest(sc.nextDouble());
        SA.setIfSet(true);
    }

    public void setCA() {
        System.out.println("-= CHECKING ACCOUNT =-");
        System.out.print("Name:");
        CA.setName(sc.next());
        System.out.print("SSN:");
        CA.setSsn(sc.next());
        System.out.print("AccountNum:");
        CA.setAccountNum(sc.next());
        System.out.print("ServiceCharge:");
        CA.setServiceCharge(sc.nextDouble());
        CA.setIfSet(true);
    }

    public void defaultSA() {
        SA.setAccountNum("NULL");
        SA.setInterest(0);
        SA.setName("NULL");
        SA.setSsn("NULL");
        SA.setIfSet(false);
    }

    public void defaultCA() {
        CA.setAccountNum("NULL");
        CA.setServiceCharge(0);
        CA.setName("NULL");
        CA.setSsn("NULL");
        CA.setIfSet(false);
    }

    public void printAccount() {
        if (this.CA.isIfSet() || this.SA.isIfSet()) {
            System.out.println("-= PRINT BEGIN =-");
            if (this.CA.isIfSet()) {
                System.out.println("----------------CHECKING ACCOUNT----------------");
                System.out.println("AccountNum:\t" + CA.getAccountNum());
                System.out.println("------Name:\t" + CA.getName());
                System.out.println("-------SSN:\t" + CA.getSsn());
                System.out.println("---Service:\t" + String.format("%.2f", CA.getServiceCharge()));
                System.out.println("\n---Balance:\t" + String.format("%.2f", CA.getMoney()));
                System.out.println("----------------CHECKING ACCOUNT----------------\n\n");

            }
            if (this.SA.isIfSet()) {
                System.out.println("-----------------SAVING ACCOUNT-----------------");
                System.out.println("AccountNum:\t" + SA.getAccountNum());
                System.out.println("------Name:\t" + SA.getName());
                System.out.println("-------SSN:\t" + SA.getSsn());
                System.out.println("--Interest:\t" + String.format("%.2f", SA.getInterest()));
                System.out.println("\n---Balance:\t" + String.format("%.2f", SA.getMoney()));
                System.out.println("-----------------SAVING ACCOUNT-----------------\n\n");
            }
            System.out.println("-= PRINT FINISHED =-\n");

        } else {
            System.out.println("-= ERROR =-");
            System.out.println("Please create an accout first.");
        }
    }

}
