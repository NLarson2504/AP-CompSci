package src;

import java.util.ArrayList;

public class Kennel {
    private ArrayList<Pet> petList;

    public Kennel(){
        petList = new ArrayList<>();
    }
    public void addPet(Pet p){
        petList.add(p);
    }
    public void allSpeak(){
        for (Pet p : petList){
            System.out.println("The " + p.getClass().toString().substring(10) + " named " + p.getName() + " says " + p.speak());
        }
    }

    public static void main(String[] args) {
        Kennel k = new Kennel();
        k.addPet(new Dog("Pluto"));
        k.addPet(new Cat("Gerald"));
        k.addPet(new LoudDog("Hans"));
        k.allSpeak();

    }
}
