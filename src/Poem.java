package src;

public abstract class Poem {
    public abstract int numLines();
    public abstract int getSyllables(int k);

    public void printRhythm(){
        for(int i=1; i<=numLines(); i++){
            for(int j=0; j < getSyllables(i); j++){
                System.out.println("ta-");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Poem p = new Haiku();
        p.printRhythm();
    }
}
