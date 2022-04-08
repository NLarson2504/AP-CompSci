package src;

public class UnderDog extends Unit5 {
    public void act() {
        super.act();
        System.out.print("sleep ");
    }

    public void eat() {
        super.eat();
        System.out.print("bark ");
    }

    public static void main(String[] args) {
        UnderDog fido = new UnderDog();
    }
}
