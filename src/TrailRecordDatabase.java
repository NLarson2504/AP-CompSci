package src;
import java.util.ArrayList;
import java.util.Collections;

public class TrailRecordDatabase {
    private ArrayList<WaypointRecord> database;

    public TrailRecordDatabase(){
        database = new ArrayList<WaypointRecord>();
        database.add(new WaypointRecord("FEATURE", "Springer Mt (3782 ft)", "GA", 0, 2174.6, 3782));
        database.add(new WaypointRecord("FEATURE", "Clingmans Dome (6643 ft)", "TN", 195.2, 1917.3, 6643));
        database.add(new WaypointRecord("FEATURE", "Mt Katahdin (5268 ft)", "ME", 2174.6, 0, 5268));
    }

    public void printDB(){
        for(WaypointRecord w : database)
            System.out.println(w);
    }

    public void sortDB(){
        Collections.sort(database);
    }

    public static void main(String[] args) {
        TrailDatabase db = new TrailDatabase();
        db.sortDB();
        db.printDB();
    }
}
