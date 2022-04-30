package src;

public class Waypoint implements Comparable<Waypoint>{
    private String type, name, state;
    private double toSpringer, toKatahdin;
    private int elevation;

    /**
     * constructor for a Waypoint
     * @param type type of point
     * @param name name of point
     * @param state state where the point is
     * @param toSpringer distance from point to Springer
     * @param toKatahdin distance from point to Katahdin
     * @param elevation elevation of point
     */
    public Waypoint(String type, String name, String state, double toSpringer, double toKatahdin, int elevation) {
        this.type = type;
        this.name = name;
        this.state = state;
        this.toSpringer = toSpringer;
        this.toKatahdin = toKatahdin;
        this.elevation = elevation;
    }

    /**
     * Getting method
     * @return returns type
     */
    public String getType() {
        return type;
    }

    /**
     * Getting method
     * @return returns name
     */
    public String getName() {
        return name;
    }

    /**
     * Getting method
     * @return returns state
     */
    public String getState() {
        return state;
    }

    /**
     * Getting method
     * @return returns distance to Springer
     */
    public double getToSpringer() {
        return toSpringer;
    }

    /**
     * Getting method
     * @return returns distance to Katahdin
     */
    public double getToKatahdin() {
        return toKatahdin;
    }

    /**
     * Getting method
     * @return returns elevation
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * Overridden toString method for a Waypoint
     * @return returns the formatted string output
     */
    @Override
    public String toString() {
        return "Waypoint{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", toSpringer=" + toSpringer +
                ", toKatahdin=" + toKatahdin +
                ", elevation=" + elevation +
                '}';
    }

    /**
     * Overridden compareTo method to compare Waypoints
     * @param o the object to be compared.
     * @return returns an int that represents if the first Waypoint is greater than, equal to, or less than the other Waypoint
     */
    @Override
    public int compareTo(Waypoint o) {
        return (this.name.compareTo(o.name))*-1;
    }
}
