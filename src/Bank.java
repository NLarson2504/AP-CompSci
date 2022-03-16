package src;

import java.util.ArrayList;

public class Bank
{
    private ArrayList<Account> accounts;
    public Bank(){
        accounts = new ArrayList<>();
    }
    public void postMonthlyInterest()
    {
        for(Account a : accounts){
            a.deposit(a.monthlyInterest());
        }
    }

    public void addAccount(Account a){
        accounts.add(a);
    }

    public static void main(String[] args) {
        Bank b = new Bank();
        b.addAccount(new SavingsAccount(1, 100, 4));
        b.addAccount(new CheckingAccount(2, 200, 10));
        b.addAccount(new SpecialCheckingAccount(3, 300, 10, 100, 4));
        b.postMonthlyInterest();
    }
}
