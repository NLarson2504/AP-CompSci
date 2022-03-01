package src;

public abstract class Animal {
    private String species;
    private boolean isAlive;
    private int numLegs;
    private String gender;

    public Animal(String s, boolean a, int l, String g){
        species = s;
        isAlive = a;
        numLegs = l;
        gender = g;
    }

    public String getSpecies(){ return species;}
    public boolean isAlive(){ return isAlive;}
    public int numLegs(){ return numLegs; }
    public String getGender(){ return gender;}

    public abstract String speak();
}
