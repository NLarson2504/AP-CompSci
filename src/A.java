package src;

public class A {
    public void show(){
        System.out.println("A");
    }
    public static class B extends A {
        public void show(){
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        A obj = new B();
        obj.show();
    }
}
