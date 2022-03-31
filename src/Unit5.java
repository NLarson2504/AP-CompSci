package src;

public class Unit5

    {

        private static int status = 0;

        public Unit5()

        {

            status = 10;

        }

        public static void setStatus(int s)

        {

            status = s;

        }



    public static void main(String[] args) {
        Unit5 a = new Unit5();
        System.out.println(Unit5.status);

        Unit5.setStatus(3);
        System.out.println(Unit5.status);

        Unit5 b = new Unit5();
        System.out.println(Unit5.status);
    }
}
