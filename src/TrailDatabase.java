package src;

/**
 * @version April 29th 2022
 * @author Nikolas Larson
 * This is a trail database that sorts waypoints based on the user's request.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Class for the Traildatabase. Holds information and is where the main entry point can be found.
 */
public class TrailDatabase {
    private ArrayList<Waypoint> database;
    private boolean asc;
    private int searchTerm;

    /**
     * Blank Constructor for database
     */
    public TrailDatabase() {
        database = new ArrayList<Waypoint>();
        populateDatabase();
    }

    /**
     * Builds the database by reading the file "apptrailDB.txt"
     */
    public void populateDatabase() {
        try {
            Scanner in = new Scanner(new File("datafiles/apptrailDB.txt"));
            while (in.hasNext()) {
                String[] data = in.nextLine().split("\t");
                database.add(new Waypoint(data[0], data[1], data[2], Double.parseDouble(data[5]), Double.parseDouble(data[6]), Integer.parseInt(data[7])));
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error opening file...");
        }
    }

    /**
     * takes user input for which search term should be searched by.
     */
    public void getSearchTerm() {
        System.out.println("*** Welcome to the Appalachian Trail Database ***\n" +
                "\t+ Menu of search terms to use for sorting waypoints +\n" +
                "\tTY: by name\n" +
                "\tNA: by name\n" +
                "\tST: by state\n" +
                "\tDS: by distance to Springer\n" +
                "\tDK: by distance to Katahdin\n" +
                "\tEL: by elevation");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your preferred sort by term or 'Q' to quit: ");
        String term = in.nextLine();
        switch (term) {
            case "TY" -> searchTerm = 1;
            case "NA" -> searchTerm = 2;
            case "ST" -> searchTerm = 3;
            case "DS" -> searchTerm = 4;
            case "DK" -> searchTerm = 5;
            case "EL" -> searchTerm = 6;
            default -> searchTerm = 0;
        }
        if (searchTerm != 0) {
            System.out.println("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
            term = in.nextLine();
            asc = (term.toLowerCase().equals("a"));
        }
    }


    /**
     * prints the database in the correct format.
     */
    public void printDB() {
        for (Waypoint w : database)
            System.out.println(w);
    }

    /**
     * sorts the database with my own specialized mergesort algorithm for waypoints. Ok it's not that special, but I like it so that good. Also, why are you still reading this javadoc comment. Stop. just stop reading.
     */
    public void sortDB() {
        WayPointComparator jeff = new WayPointComparator(searchTerm, asc);
        MergeSort carl = new MergeSort(database, jeff);
        carl.redHotChiliPeppers(0, database.size()-1);
        database = carl.getYoDataBaseUp();
    }

    /**
     * BIG BOY Main entry point for the code.
     * @param args are user defined arguments passed into the JVM
     */
    public static void main(String[] args) {
        TrailDatabase db = new TrailDatabase();
        while(true) {
            db.getSearchTerm();
            if(db.searchTerm == 0){
                System.out.println("End of program");
                break;}
            db.sortDB();
            db.printDB();
        }
    }
}
