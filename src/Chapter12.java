package src;
import java.util.ArrayList;

public class Chapter12 {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Cow("Jerry", true, 4, "male", "FrenchVanillaIceCream"));
        animals.add(new Chicken("George", true, 2, "male", "TurkishStrawberry"));
        animals.add(new Piggy("Frank", true, 5, "male", true));
        animals.add(new Chicken("Jack", false, 2, "female", "Silky"));

        for(Animal a : animals){
            System.out.println("The " + a.getGender() + " " + a.getClass().toString().substring(10).toLowerCase() + " with " + a.numLegs() + " legs says " + a.speak());
        }
    }
}
