package src;

public class Time implements Comparable<Time>{
    private int hours;
    private int mins;
    /**
     * Default Constructor
     */
    public Time(){
        hours = 0;
        mins = 0;
    }

    public int totalMins(){
        return hours*60 + mins;
    }

    /**
     * Constructor for time
     * @param hours
     * @param mins
     */
    public Time(int hours, int mins){
        this.hours = hours; this.mins = mins;
    }

    public boolean equals(Object other){
        if(other instanceof Time){
            Time t = (Time) (other);
            return (this.hours == t.hours) && (this.mins == t.mins);
        }
        return false;
    }
    public int compareTo(Time other){
        return this.totalMins() - other.totalMins();
    }

    public String toString(){
        if (hours >= 10)
            return hours + ":" + mins;
        else
            return "0" + hours + ":" + mins;
    }

    public static void main(String[] args) {
        Time t1 = new Time(9, 30);
        Time t2 = new Time(10, 45);
        DailySchedule sean = new DailySchedule();

    }
}
