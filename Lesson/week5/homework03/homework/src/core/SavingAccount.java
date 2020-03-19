package core;

public class SavingAccount extends Account {
    private double interest = 0.0;

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void settle() {
        if (isIfSet()) {
            this.setMoney(this.getMoney() * (1 + this.getInterest()));
            System.out.println("-= Saving Account settle finished! =-");
        }
    }

}
