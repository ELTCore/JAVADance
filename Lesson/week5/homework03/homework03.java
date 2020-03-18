package week5.homework03;

// -------------------------------------------------------------------------------------
// Banking application

// · Develop a simple banking application
// - Checking accounts have a monthly service fee
// - Savings accounts pay interest monthly

// · Three tasks
// - Identify all object-defining classes required
// - Sketch a class diagram
// - Plan the application class with a flowchart

// · Nouns are modeled by objects
// - Bank account, checking account, savings account，customer

// · Verbs are modeled with methods
// - Assess fee, pay interest，saving, withDraw

// · Create a class diagram
// - Focus on customer, bank account, checking account, and savings account

// · Checking and savings accounts are specialized bank accounts
// · Class name in the top section, instance variables in the middle, methods in
// the bottom
// · Composition is represented by solid diamonds and inheritance is represented
// by open arrows
// · Application class is represented with a flowchart

// · Customer.java defines Customer objects
// - SSN, name, checking account, savings account
// - Constructor, getter/setter methods for accounts

// · BankAccount.java defines BankAccount objects, members common to all accounts
// - Account number, balance, getter/setter methods, toString

// · CheckingAccount.java and SavingsAccount.java nearly identical
// - Checking accounts incur a service charge
// - Savings accounts accrue interest

// · Both CheckingAccount and SavingsAccount class definitions include extends
// BankAccount
// -------------------------------------------------------------------------------------

public class homework03 {
    public static void main(String[] args) {
        System.out.println("date: 2020-03-18\n");

    }
}

class CheckingAccount {

}

class SavingsAccount {

}