public class Car implements Comparable<Car> {
    private String name, origin;
    private int cylinders, model;
    private double mpg, displacement, horsepower, weight, acceleration;

    public Car(String n, double mp, int c, double d, double h, double w, double a, int mo, String o) {
        name = n;
        mpg = mp;
        cylinders = c;
        displacement = d;
        horsepower = h;
        weight = w;
        acceleration = a;
        model = mo;
        origin = o;
    }

    public String toString() {
        return name + " MPG: " + mpg;
    }

    public int compareTo(Car other) {
        Double one = this.mpg;
        Double two = other.mpg;
        int difference = -one.compareTo(two);
        return (-one.compareTo(two) == 0) ? this.name.compareTo(other.name) : -one.compareTo(two);
        //return this.name.compareTo(other.name);
    }
}
