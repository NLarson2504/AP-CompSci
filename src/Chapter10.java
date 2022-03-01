package src;

public class Chapter10 {
    //public String methodThing(String x, char y) {

    //}

    public static class Complex{
        private double hello;
        private double hi;
        public Complex(double x, double y){
            hi = x;
            hello = y;
        }
        public Complex(double x) {
            hi = x;
            hello = 0.0;
        }
        public void hello(){
            System.out.println(hi);
        }


    }
    public class Rectangle{
        private int width;
        private int height;
        public Rectangle(int rectWidth, int rectHeight){
            this.width = rectWidth;
            this.height = rectHeight;
        }
        public Rectangle(int rectSide){
            this(rectSide, rectSide);
        }
    }

    public static void main(String[] args) {
        Complex z = new Complex(1.0, 2.0);
        Complex a = new Complex(1.0, 2);
        Complex l = new Complex(0);
        Complex x = new Complex(1, 2);
        Complex n = new Complex(0.0);
        n.hello();
    }
}
