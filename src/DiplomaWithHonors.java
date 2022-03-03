package src;

public class DiplomaWithHonors extends Diploma{

    public DiplomaWithHonors(String n, String d) {
        super(n, d);
    }
    public String toString(){
        return super.toString() + "\n** WITH HONORS **";
    }
}
