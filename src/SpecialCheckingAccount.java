package src;

public class SpecialCheckingAccount extends CheckingAccount{
    private double minimumBalance;
    private double interestRate;
    public SpecialCheckingAccount(int idNum, double startBal, double chkCharge, double minBal, double intRate) {
        super(idNum, startBal, chkCharge);
        minimumBalance = minBal;
        interestRate = intRate;
    }
    public void clearCheck(double amount) {
        Double curBal = super.currentBalance();
        Double min = minimumBalance;
        if(curBal.compareTo(min) >= 0)
            decreaseBalance(amount);
        else{
            super.clearCheck(amount);
        }
    }

    public double monthlyInterest() {
        return (super.currentBalance() >= minimumBalance) ? super.currentBalance()*interestRate/12 : super.monthlyInterest();
    }
}
