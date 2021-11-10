import java.text.DecimalFormat;
import java.util.*;

/**
 * A Standard BMI Calculator: takes height and weight inputs, and outputs a calculated body-mass index.
 * @version 11/9/21
 * @author 23larson
 */
public class BMICalculator {
    /**
     * computeBMI sanitizes the input by removing 0 or negative values, and then returns a double of their BMI
     * @param inches the height input
     * @param pounds the weight input
     * @return returns calculated BMI
     */
    public static double computeBMI(int inches, int pounds) {
        if(inches <= 0)
            return 0;
        if(pounds <= 0)
            return 0;
        return (pounds*0.454)/Math.pow((inches*0.0254), 2);
    }

    /**
     * extractInches takes string input, extracts the feet and inch values, and then converts it to only inches.
     * @param value inputed height in ft'in" format
     * @return returns the total number of inches from input
     */
    public static int extractInches(String value) {
        int qtPos = value.indexOf("'");
        int dblQtPos = value.indexOf("\"");
        if (qtPos == -1 || dblQtPos == -1)
            return -1;
        int feet = Integer.parseInt(value.substring(0, qtPos));
        int inches = Integer.parseInt(value.substring(qtPos+1, dblQtPos));
        if(inches < 0 || inches > 11 || feet < 0)
            return -1;
        return (feet*12 + inches == 0) ? -1 : feet*12+inches;
    }

    /**
     * The main entry point for the code
     * @param args args are the arguments that can be set for the entry point. None specifically for this project.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        String cont;
        do {
            System.out.print("Enter height in ft'in\" : ");
            String height = in.nextLine();
            System.out.print("Enter weight in lbs: ");
            String weight = in.nextLine();
            int pounds = Integer.parseInt(weight.substring(0, weight.length()));
            //print BMI here
            System.out.println("Your BMI is: " + df.format(computeBMI(extractInches(height), pounds)) + " kg/m^2");
            System.out.print("End? (Y/N): ");
            cont = in.nextLine();
        } while(!cont.toLowerCase().equals("y"));
        System.out.println("~*~*~*END OF PROGRAM*~*~*~");
    }
}

