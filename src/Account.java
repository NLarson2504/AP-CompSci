package src;

import java.text.DecimalFormat;

public abstract class Account
{
    private int idNumber; // identity number for this account
    private double balance; // current balance for this account

    public Account(int idNum, double startBal)
    {
        idNumber = idNum;
        balance = startBal;
    }

    public int idNumber() {
        return idNumber;
    }

    public double currentBalance() {
        return balance;
    }
    /** precondition: amount >= 0.0
     * postcondition: the current balance of this account has been increased
     * by amount */
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean decreaseBalance(double amount) {
        if (amount > balance){
            return false;
        } else{
            balance -= amount;
            return true;
        }
    }
    public String toString(){
        DecimalFormat df = new DecimalFormat("$.00");
        return getClass().toString().substring(10) + " " + idNumber + ": " + df.format(balance);
    }
    /** @return the monthly interest due for this account */
    public abstract double monthlyInterest();
}
