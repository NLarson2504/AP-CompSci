package src;

public class Diploma {
    private String name, degree;

    public Diploma(String n, String d){
        name = n;
        degree = d;
    }

    public String getName(){ return name; }
    public String getDeegree(){ return degree; }

    public String toString(){
        return "This certifies that " + name + " has completed a MOOC in " + degree;
    }

}
