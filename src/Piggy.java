package src;

public class Piggy extends Animal{
    private boolean isCoveredInMud;
    public Piggy(String s, boolean a, int l, String g, boolean c){
        super(s, a, l, g);
        isCoveredInMud = c;
    }
    public String speak(){
        return (isAlive()) ? "oink oink" : "...";
    }
}
