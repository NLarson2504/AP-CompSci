import java.util.Locale;
import java.util.Scanner;

/**
 * THE FRICKEN JAVADOC OK SO IT CONVERTS THINGS FROM ROMAN TO DECIMAL OR THE OTHER WAY AROUND ITS REALLY COOL HOPEFULLY YOU LIKE IT
 * @version Sunday, October 3rd, 2021
 * @author 23larson
 */

public class RomanToDecimal {

    /**
     * A METHOD THAT TAKES DECIMAL INPUT FROM THE COMMAND LINE AND CONVERTS IT INTO ROMAN VALUES
     * @param decimal DECIMAL INPUT FROM USER
     * @return RETURNS A STRING REPRESENTING ROMAN VALUE
     */
    public static String decimalToRoman(int decimal) {
        String romanOut = "";
        String[] alphabet = {"a", "b", "c", "d", "e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        while (decimal >= 1000) {
            romanOut = romanOut + "M";
            decimal -=1000;
        }
        while (decimal >= 900) {
            romanOut = romanOut + "CM";
            decimal -= 900;
        }
        while (decimal >= 500) {
            romanOut = romanOut + "D";
            decimal -= 500;
        }
        while (decimal >= 400) {
            romanOut = romanOut + "CD";
            decimal -= 400;
        }
        while (decimal >= 100) {
            romanOut = romanOut + "C";
            decimal -= 100;
        }
        while (decimal >= 90) {
            romanOut = romanOut + "XC";
            decimal -= 90;
        }
        while (decimal >= 50) {
            romanOut = romanOut + "L";
            decimal -= 50;
        }
        while (decimal >= 40) {
            romanOut = romanOut + "XL";
            decimal -= 40;
        }
        while (decimal >= 10) {
            romanOut = romanOut + "X";
            decimal -= 10;
        }
        while (decimal >= 9) {
            romanOut = romanOut + "IX";
            decimal -= 9;
        }
        while (decimal >= 5) {
            romanOut = romanOut + "V";
            decimal -= 5;
        }
        while (decimal >= 4) {
            romanOut = romanOut + "IV";
            decimal -= 4;
        }
        while (decimal >= 1) {
            romanOut = romanOut + "I";
            decimal -= 1;
        }
        return romanOut;


    }

    /**
     * A METHOD THAT TAKES STRING INPUT FROM THE COMMAND LINE AND RETURNS THE INTEGER DECIMAL VALUE OF THE GIVEN ROMAN VALUE
     * @param roman is the input that represents a roman number value
     * @return returns the decimal integer value of the roman input.
     */
    public static int romanToDecimal(String roman){
        int decimal = 0;
        for(int i = 0; i < roman.length(); i++) {
            //System.out.print(roman.substring(i, i+1).toUpperCase());
            if(roman.substring(i, i+1).toUpperCase().equals("I"))
                decimal += 1;
            else if(roman.substring(i, i+1).toUpperCase().equals("V"))
                decimal += 5;
            else if(roman.substring(i, i+1).toUpperCase().equals("X"))
                decimal += 10;
            else if(roman.substring(i, i+1).toUpperCase().equals("L"))
                decimal += 50;
            else if(roman.substring(i, i+1).toUpperCase().equals("C"))
                decimal += 100;
            else if(roman.substring(i, i+1).toUpperCase().equals("D"))
                decimal += 500;
            else if(roman.substring(i, i+1).toUpperCase().equals("M"))
                decimal += 1000;
            else
                //INVALID CHARACTER
                return -1;
        }
        if(roman.toUpperCase().indexOf("IV") != -1)
            decimal -= 2;
        if(roman.toUpperCase().indexOf("IX") != -1)
            decimal -= 2;
        if(roman.toUpperCase().indexOf("XL") != -1)
            decimal -= 20;
        if(roman.toUpperCase().indexOf("XC") != -1)
            decimal -= 20;
        if(roman.toUpperCase().indexOf("CD") != -1)
            decimal -= 200;
        if(roman.toUpperCase().indexOf("CM") != -1)
            decimal -= 200;
        return decimal;
    }

    /**
     * THE MAIN ENTRY GATE FOR THE CODE TO RUN
     * @param args ARGUMENTS PROVIDED BY CODER
     */
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        String decision;

        boolean RTD = true;
        boolean DTR = false;
        boolean isOn = true;

        for(String temp2 : args) {
            int val2 = romanToDecimal(temp2);
            if(val2 == -1)
                System.out.println("Input: " + temp2 + " => output: invalid");
            else
                System.out.println("Input: " + temp2 + " => output: " + romanToDecimal(temp2));
        }

        while(isOn) {

            while(RTD && !DTR) { //ROMAN TO DECIMAL

                System.out.println("Enter Roman Numeral: ");
                String temp = input.nextLine();
                int val = romanToDecimal(temp);
                if (val == -1)
                    System.out.println("Input: " + temp + " => output: invalid");
                else
                    System.out.println("Input: " + temp + " => output: " + romanToDecimal(temp));
                System.out.println("Roman To Decimal / Decimal To Roman / Exit (r/d/e)");
                decision = input.nextLine().toLowerCase().strip();
                if (decision.indexOf('d') != -1) {
                    RTD = false;
                    DTR = true;
                }
                if (decision.indexOf('e') != -1) {
                    RTD = false;
                    isOn = false;
                }

                while(!RTD && DTR) { //DECIMAL TO ROMAN
                    String[] alphabet = {"a", "b", "c", "d", "e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
                    boolean works = true;
                    int thing = 0;
                    System.out.println("Enter Decimal Value: ");
                    String thingy = input.nextLine();
                    for (String s : alphabet) {
                        if (thingy.contains(s)) {
                            thing = -1;
                        }
                    }
                    if(thing != -1) {
                        thing = Integer.valueOf(thingy);
                        works = false;
                    } else {
                        System.out.println("INVALID INPUT >:(");
                    }
                    String romVal = decimalToRoman(thing);
                    System.out.println("Input: " + thing + " => Output: " + romVal);
                    System.out.println("Roman To Decimal / Decimal To Roman / Exit (r/d/e)");
                    decision = input.nextLine().toLowerCase();
                    if (decision.equals("r")) {
                        RTD = true;
                        DTR = false;

                    }
                    if (decision.equals("e")) {
                        System.out.println("WOAH");
                        DTR = false;
                        isOn = false;

                    }
                }

            }

        }

    }
}
