package src;

import java.util.ArrayList;

public class DailySchedule {
    private ArrayList<Time> myschedule;

    public DailySchedule(){
        myschedule = new ArrayList<>();

    }

    public void setUpSeansSchedule(){
        myschedule.add(new Time(8, 15));
        myschedule.add(new Time(9, 30));
        myschedule.add(new Time(10, 30));
        myschedule.add(new Time(11, 45));
        myschedule.add(new Time(12, 35));
        myschedule.add(new Time(13, 50));
    }
    public int seansTotalTimeInClass(){
        int totalTime = 0;
        for(int i = myschedule.size()-1; i>=0; i += 2){
            totalTime += myschedule.get(i).totalMins() - myschedule.get(i+1).totalMins();
        }
        return totalTime;
    }
}
