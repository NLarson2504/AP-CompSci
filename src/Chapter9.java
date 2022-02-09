public class Chapter9 {
    //PROBLEM 17
     public static double positiveMax(int[][] m) {
         double max = 0;
         for (int row = 0; row < m.length; row++) {
             for (int col = 0; col < m[row].length; col++) {
                 if (m[row][col] > max)
                     max = m[row][col];
             }
         }
         return max;
     }

     //PROBLEM 18A
    public static int sumReturner(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        return sum;
    }

    //PROBLEM 18B
    public static int[] sums2D(int[][] t) {
         int[] sums = new int[t.length];
         int r = 0;
         for (int[] row : t) {
             //row[r] = sumArray(row);
             r++;
         }
         return sums;
    }
    //PROBLEM 21
    //{"One", "Two", "Three"}

    //PROBLEM 22
    //DONE

    //PROBLEM 23
    public boolean isMedian(double[] sample, double m) {
         int less = 0; int greater = 0;
         for(int i = 0; i <sample.length; i++) {
             if (sample[i] < m)
                 less++;
             else
                 greater++;
         }
         return less == greater;
         }



    public static void main(String[] args) {
        // FIX: change int i = 0; to int i = 1;

    }
}
