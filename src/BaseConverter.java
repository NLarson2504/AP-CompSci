import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

/**
 * BaseConverter opens a data file, reads, converts, numbers, prints
 * My extra is a JFileChooser method that allows you to select one of the 4 files (values10, values20, values30, values500) and runs the conversions on the selected file.
 * @version Thursday 11/18/21
 * @author 23larson
 */
public class BaseConverter {
    /**
     * Constructor for class.
      */
    public BaseConverter() {

    }

    /**
     * Displays UI to choose a file from the computer
     * @return returns the chosen file
     */
    public String fileChooser() {
        JFileChooser j = new JFileChooser();
        j.showSaveDialog(null);

        return j.getSelectedFile().getAbsolutePath();
    }
    /**
     * Convert a String num in fromBase to base-10 int.
     */
    public int strToInt(String num, String fromBase) {
        int base = Integer.parseInt(fromBase);
        String alpha = "0123456789ABCDEF";
        int sum = 0, exp = 0;
        for (int i = num.length()-1;  i >= 0; i--){
            sum += alpha.indexOf(""+num.charAt(i))*Math.pow(base, exp);
            exp++;
        }


        return sum;
    }

    /**
     * Convert a base-10 int to a String number of base toBase.
     */
    public String intToStr(int num, int toBase) {
        String alpha = "0123456789ABCDEF";
        String toNum = "";
        while(num>0){
            toNum = alpha.charAt(num%toBase) + toNum;
            num /= toBase;
        }
        if (toNum.equals(""))
            return "0";
        return toNum;
        }

    /**
     * Opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
     */
    public void inputConvertPrintWrite() {
        Scanner s = null;
        PrintWriter pw = null;
        boolean isOn = true;
        String parsedFile = "";
        String theFile = "";
        while (isOn) {
            theFile = fileChooser();
            parsedFile = theFile.substring(theFile.indexOf("datafiles/")+10);
            if (parsedFile.equals("values10.dat") || parsedFile.equals("values20.dat") || parsedFile.equals("values30.dat") || parsedFile.equals("values500.dat")) {
                isOn = false;
            }
        }
        try {
            File file = new File(theFile);
            s = new Scanner(file);
            pw = new PrintWriter("datafiles/converted.dat");
            while(s.hasNextLine()) {
                String[] line = s.nextLine().split("\t");
                int fromBase = Integer.parseInt(line[1]);
                int toBase = Integer.parseInt(line[2]);
                if (fromBase < 2 || fromBase > 16) {
                    System.out.println("Invalid input base " + fromBase);
                } else if(toBase < 2 || toBase > 16) {
                    System.out.println("Invalid output base " + toBase);
                } else {
                    System.out.println(line[0] + " base " + line[1] + " = " + intToStr(strToInt(line[0], line[1]), toBase) + " base " + toBase);
                    pw.println(line[0] + "\t" + line[1] + "\t" + intToStr(strToInt(line[0], line[1]), toBase) + "\t" + toBase);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No file :(");
        }
        if(s != null)
            s.close();
        if(pw != null)
            pw.close();


    }

    /**
     * Main method for base converter
     * @param args provided arguments, if needed.
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
    }
}
