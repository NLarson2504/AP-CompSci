package src;

import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


/**
 * CoinSorterMachine opens a data file, reads, and prints a summary of the deposit
 * @version Thursday 3/31/22
 * @author 23larson
 */
public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    private int pennyNum;
    private int nickelNum;
    private int dimeNum;
    private int quarterNum;
    private int dollarNum;
    private int halfDolNum;
    private int other;

    /**
     * initializes the coins ArrayList
     */
    public CoinSorterMachine(){
        coins = new ArrayList<>();
    }

    /**
     * uses a Scanner object, prompting user for the appropriate file
     * name and importing the data from filename – handles diabolic values
     */
    public void depositCoins(){
        try {
            Scanner input = new Scanner(System.in);
            pennyNum = 0; nickelNum = 0; dimeNum = 0; quarterNum = 0; dollarNum = 0; halfDolNum = 0;
            System.out.print("Enter the name of the data file for coin deposit: ");
            String file = "datafiles/" + input.nextLine().toLowerCase();
            input.close();
            Scanner in = new Scanner(new File(file));
            System.out.println("Depositing coins...");
            while(in.hasNext()){
                String number = in.next();
                switch (number) {
                    case "100" -> {
                        coins.add(new DollarCoin());
                        dollarNum += 1;
                    }
                    case "50" -> {
                        coins.add(new HalfDollar());
                        halfDolNum += 1;
                    }
                    case "25" -> {
                        coins.add(new Quarter());
                        quarterNum += 1;
                    }
                    case "10" -> {
                        coins.add(new Dime());
                        dimeNum += 1;
                    }
                    case "5" -> {
                        coins.add(new Nickel());
                        nickelNum += 1;
                    }
                    case "1" -> {
                        coins.add(new Penny());
                        pennyNum += 1;
                    }
                }
            }
        } catch(Exception e) {
            System.out.println("ERROR... Enter valid file ya dum dum");
            System.out.println(e);
        }


    }


    /**
     * Prints deposit summary using a Numberformat object
      */
    public void printDepositSummary(){
        System.out.println("Summary of deposit:");
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        if(pennyNum ==1)
            System.out.println("\t" + pennyNum + " pennie " + (n.format(0.01*pennyNum)));
        else
            System.out.println("\t" + pennyNum + " pennies " + (n.format(0.01*pennyNum)));

        if(nickelNum == 1)
            System.out.println("\t" + nickelNum + " nickle " + (n.format(0.05*nickelNum)));
        else
            System.out.println("\t" + nickelNum + " nickles " + (n.format(0.05*nickelNum)));


        if(dimeNum == 1)
            System.out.println("\t" + dimeNum + " dime " + (n.format(0.1*dimeNum)));
        else
            System.out.println("\t" + dimeNum + " dimes " + (n.format(0.1*dimeNum)));

        if(quarterNum == 1)
            System.out.println("\t" + quarterNum + " quarter " + (n.format(0.25*quarterNum)));
        else
            System.out.println("\t" + quarterNum + " quarters " + (n.format(0.25*quarterNum)));
        if(halfDolNum == 1)
            System.out.println("\t" + halfDolNum + " half dollar coin " + (n.format(halfDolNum*0.5)));
        else
            System.out.println("\t" + halfDolNum + " half dollar coins " + (n.format(halfDolNum*0.5)));
        if(dollarNum == 1)
            System.out.println("\t" + dollarNum + " dollar coin " + (n.format(dollarNum)));
        else
            System.out.println("\t" + dollarNum + " dollar coins " + (n.format(dollarNum)));
        System.out.println("TOTAL DEPOSIT: " + n.format(getTotalValue()));
    }


    /**
     * returns the total value of all Coin objects stored in coins as a double
      */
    public double getTotalValue(){
        double val = 0;
        for(Coin c : coins)
            val += c.getValue();
        return val;
    }

    /**
     * main method for the class CoinSorterMachine
      */
    public static void main(String[] args){
        //CoinSorterMachine app = new CoinSorterMachine();
        //app.depositCoins();
        //app.printDepositSummary();

        Coin myCoin = new Nickel();
        System.out.println(myCoin.getName());
    }
}
