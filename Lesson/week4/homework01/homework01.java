package week4.homework01;

// -------------------------------------------------------------------------------------
// Write a second class called Project. A project has a projectName (e.g. AlphaOne),
// a budget (e.g. $20,000) and two Employees assigned to the project.
// Write a constructor for the Project class.
// Write set and get methods for the projectName and the budget. 
// Management have realised that the budget is undervalued. Write an instance method called updateBudget().
// This method will increase the budget by 20%. 
// Write a toString() method to display in a user friendly way the project details projectName and budget. 
// -------------------------------------------------------------------------------------

import java.util.Scanner;

public class homework01 {
    static Scanner sc = new Scanner(System.in);
    // ====================MAIN====================

    public static void main(String[] args) {
        System.out.println("date: 2020-02-28\n");
        Pj AlphaOne = new Pj();

        test(AlphaOne);
    }
    // ====================MAIN====================

    static void test(Pj pj) {
        int choose = 0;
        do {
            msg(pj);
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    setProject(pj);
                    break;
                case 2:
                    updateBudge(pj);
                    break;
                case 3:
                    deleteProject(pj);
                    break;
                case 0:
                    System.exit(1);
            }
        } while (choose != 0);
    }

    static void msg(Pj pj) {
        System.out.println("==============================");
        System.out.println("ProjectName:\t" + pj.getName());
        System.out.printf("ProjectBudge:\t%.2f\n", pj.getbudge());
        System.out.println("==============================");
        System.out.println("*1. Set Project");
        System.out.println("*2. Update Budge 20%");
        System.out.println("*3. Delete Project");
        System.out.println("*0. Exit");
        System.out.println("==============================");
        System.out.print("Enter a function: ");
    }

    static void setProject(Pj pj) {
        System.out.println("\n-= SET START =-\n");
        System.out.print("Enter the project's name:\t");
        pj.setName(sc.next());
        System.out.print("Enter the project's budge:\t");
        pj.setBudge(sc.nextDouble());
        pj.SetIfSet(true);
        System.out.println("\n-= SET FINISHED =-\n");
    }

    static void updateBudge(Pj pj) {
        if (pj.getIfSet()) {
            pj.setBudge(pj.getbudge() * 1.2);
            System.out.println("\n-= UPDATE FINISHED =-\n");
        } else {
            System.out.println("\n-= ERROR =-\n");
        }
    }

    static void deleteProject(Pj pj) {
        if (pj.getIfSet()) {
            pj.defaultPj();
            System.out.println("\n-= DELETE FINISHED =-\n");
        } else {
            System.out.println("\n-= ERROR =-\n");
        }
    }

}

class Pj {
    private String name = "NULL";
    private double budge = 0;
    private Boolean ifSet = false;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getbudge() {
        return this.budge;
    }

    public void setBudge(double budge) {
        this.budge = budge;
    }

    public Boolean getIfSet() {
        return this.ifSet;
    }

    public void SetIfSet(Boolean ifSet) {
        this.ifSet = ifSet;
    }

    public void defaultPj() {
        this.name = "NULL";
        this.budge = 0;
        this.ifSet = false;
    }

}