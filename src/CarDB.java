import java.util.*;
import java.io.*;

public class CarDB {
    private ArrayList<Car> database;

    public CarDB() {
        database = new ArrayList<>();
    }

    public void importData() {
        try {
            Scanner in = new Scanner(new File("cars.csv"));
            while(in.hasNext()) {
                String[] oneline = in.nextLine().split(";");
                Car temp = new Car(oneline[0], Double.parseDouble(oneline[1]), Integer.parseInt(oneline[2]),
                        Double.parseDouble(oneline[3]), Double.parseDouble(oneline[4]),Double.parseDouble(oneline[5]),
                        Double.parseDouble(oneline[6]), Integer.parseInt(oneline[7]), oneline[8]);
                //System.out.println(Arrays.toString(oneline));
                database.add(temp);
            }
            in.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void printDB() {
        /*System.out.println("UNSORTED DB");
        for(Car c : database) {
            System.out.println(c);
        }*/
        System.out.println(" ");
        System.out.println("SORTED DB");
        Collections.sort(database);
        for(Car c : database)
            System.out.println(c);
    }

    public Car[] convertToArray() {
        Car[] carArray = new Car[database.size()];
        for(int i = 0; i < carArray.length; i++) {
            carArray[i] = database.get(i);
        }
        Arrays.sort(carArray);
        return carArray;
    }

    public static void main(String[] args) {
        CarDB db = new CarDB();
        db.importData();
        //db.printDB();
        Car[] cars = db.convertToArray();
        //for(Car c: )
            System.out.println();
        /*ArrayList<Integer> doesThisWork = new ArrayList<>();
        doesThisWork.add(0, 12);
        doesThisWork.add(0, 123);
        doesThisWork.add(0, 1234);
        doesThisWork.add(0, 12345);
        doesThisWork.add(0, 123456);
        doesThisWork.add(0, 1234567);
        Collections.sort(doesThisWork);
        System.out.println(doesThisWork);*/
    }
}
