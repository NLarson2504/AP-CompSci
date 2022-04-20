package src;

public class Waypoint implements Comparable<Waypoint>{
    private String type, name, state;
    private double toSpringer, toKatahdin;
    private int elevation;


    public Waypoint(String type, String name, String state, double toSpringer, double toKatahdin, int elevation) {
        this.type = type;
        this.name = name;
        this.state = state;
        this.toSpringer = toSpringer;
        this.toKatahdin = toKatahdin;
        this.elevation = elevation;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public double getToSpringer() {
        return toSpringer;
    }

    public double getToKatahdin() {
        return toKatahdin;
    }

    public int getElevation() {
        return elevation;
    }

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

    @Override
    public int compareTo(Waypoint o) {
        return (this.name.compareTo(o.name))*-1;
    }
}
