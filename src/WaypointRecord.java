package src;

public record WaypointRecord(String type, String name, String state, double toSpringer, double toKatahdin, int elevation) implements Comparable<WaypointRecord>{

    @Override
    public int compareTo(WaypointRecord o) {
        return this.elevation - o.elevation;
    }

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
}
