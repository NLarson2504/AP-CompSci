package src;

public class Cow extends Animal{
    private String type;

    public Cow(String s, boolean a, int l, String g, String t){
        super(s, a, l, g);
        type = t;
    }
    public String speak(){
        return (isAlive()) ? "moo moo" : "...";
    }
}
