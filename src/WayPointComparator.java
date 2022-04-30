package src;

import java.util.Comparator;

/**
 * Is a comparator for waypoints and allows waypoints to be compared on every attribute attributed to them.
 */
public class WayPointComparator implements Comparator<Waypoint> {
    private int category;
    private boolean asc;

    /**
     * common constructor for a waypoint (2 args)
     * @param c category for comparing
     * @param a determines if the order is ascending or descending.
     */
    public WayPointComparator(int c, boolean a){
        category = c;
        asc = a;
    }

    /**
     * another common constructor for a waypoint (1 arg)
     * @param c category for comparing
     */
    public WayPointComparator(int c){
        category = c;
        asc = true;
    }

    /**
     * yet another common constructor for a waypoint (0 args)
     */
    public WayPointComparator(){
        category = 4;
        asc = true;
    }

    /**
     * This method runs all the comparisons based on the user-given category and order.
     * @param one the first object to be compared.
     * @param two the second object to be compared.
     * @return returns an int which represents if one Waypoint is greater, equal, or less than another.
     */
    public int compare(Waypoint one, Waypoint two) {
        int diff = 0;
        if (category == 1)
            diff = one.getType().compareTo(two.getType());
        else if (category == 2)
            diff = one.getName().compareTo(two.getName());
        else if (category == 3)
            diff = one.getState().compareTo(two.getState());
        else if (category == 4) {
            Double d1 = one.getToSpringer();
            Double d2 = two.getToSpringer();
            diff = d1.compareTo(d2);
        } else if (category == 5) {
            Double d1 = one.getToKatahdin();
            Double d2 = two.getToKatahdin();
            diff = d1.compareTo(d2);
        } else if (category == 6) {
            diff = one.getElevation() - (two.getElevation());
        }
        return (asc) ? diff : -diff;
    }
}
