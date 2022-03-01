package src;

public class Chicken extends Animal{
    private String type;
    public Chicken(String s, boolean a, int l, String g, String t){
        super(s, a, l, g);
        type = t;
    }
    public String speak(){
        return (isAlive()) ? "cluck cluck" : "...";
    }
}
