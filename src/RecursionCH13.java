package src;

public class RecursionCH13 {
    public static int multiply(int a, int b){
        //base class
        if(a==0) return 0;
        if(a==1) return b;
        else return b + multiply(a-1, b);
    }
    public static void enigma(int n){
        for(int i = 0; i < n; i++)
            enigma(i);
        System.out.print(n);
    }
    public static int sumDigits(int i){
        if (i==0)
            return 0;
        else
            return i%10 + sumDigits(i/10);
    }
    public static boolean thingy(int i){
        if(i == 3 || i == 6 || i == 9){
            return true;
        } else if(i < 10){
            return false;
        } else {
            return thingy(sumDigits(i));
        }
    }

    public static void printX(int i){
        if(i <= 0)
            System.out.print(0);
        else{
            printX(i-1);
            System.out.print(i);
            printX(i-2);
        }
    }
    public static void main(String[] args) {
        printX(3);
    }
}
