package src;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    private int pennyNum;
    private int nickelNum;
    private int dimeNum;
    private int quarterNum;
    private int dollarNum;
    private int halfDolNum;
    private int other;

    // initializes coins ArrayList
    public CoinSorterMachine(){
        coins = new ArrayList<>();
    }
    // use one or two Scanner objects, prompting user for the appropriate file
// name and importing the data from filename – MUST handle diabolic values!
    public void depositCoins(){
        try {
            Scanner input = new Scanner(System.in);
            pennyNum = 0;
            nickelNum = 0;
            dimeNum = 0;
            quarterNum = 0;
            dollarNum = 0;
            halfDolNum = 0;
            other = 0;
            System.out.println("Enter the name of the data file for coin deposit: ");
            String file = "datafiles/" + input.nextLine().toLowerCase();
            input.close();
            Scanner in = new Scanner(new File(file));
            System.out.println("Depositing coins...");
            while(in.hasNext()){
                String number = in.next();
                System.out.println(number);
                if(number.equals("100")) {
                    coins.add(new DollarCoin());
                    dollarNum += 1;
                }else if(number.equals("50")) {
                    coins.add(new HalfDollar());
                    halfDolNum += 1;
                }else if(number.equals("25")) {
                    coins.add(new Quarter());
                    quarterNum += 1;
                }else if(number.equals("10")) {
                    coins.add(new Dime());
                    dimeNum += 1;
                }else if(number.equals("5")) {
                    coins.add(new Nickel());
                    nickelNum += 1;
                }else if(number.equals("1")) {
                    coins.add(new Penny());
                    pennyNum += 1;
                }else {
                    System.out.println("Coin value " + number + " not recognized");
                    other += Integer.parseInt(number)/100;
                }
            }
        } catch(Exception e) {
            System.out.println("ERROR... Enter valid file ya dum dum");
            System.out.println(e);
        }


    }


    // Prints deposit summary using a DecimalFormat object (see output section)
    public void printDepositSummary(){
        System.out.println("Summary of deposit:");
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        double totalPen = 0.01*pennyNum;
        System.out.println("\t" + pennyNum + " pennies " + (n.format(totalPen)));
        double totalNick = 0.05*nickelNum;
        System.out.println("\t" + nickelNum + " nickles " + (n.format(totalNick)));
        double totalDim = 0.1*dimeNum;
        System.out.println("\t" + dimeNum + " dimes " + (n.format(totalDim)));
        double totalQuart = 0.25*quarterNum;
        System.out.println("\t" + quarterNum + " quarters " + (n.format(totalQuart)));
        double totalHalfDol = 0.5*halfDolNum;
        System.out.println("\t" + halfDolNum + "  half dollar coins " + (n.format(totalHalfDol)));
        double totalDol = dollarNum;
        System.out.println("\t" + dollarNum + " dollar coins " + (n.format(totalDol)));

        System.out.println("TOTAL DEPOSIT: " + n.format(totalPen+totalNick+totalDim+totalQuart+totalHalfDol+totalDol+other));
    }


    // return the total value of all Coin objects stored in coins as a double
    public double getTotalValue(){
        return 0;
    }

    // main method for the class should use these exact three lines of code
    public static void main(String[] args){
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}
