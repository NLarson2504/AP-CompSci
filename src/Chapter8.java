public class Chapter8 {
    public static String cutOut(String str, String x) {
        if(str.indexOf(x) > -1)
            return str.substring(0, str.indexOf(x)) + str.substring(str.indexOf(x) + x.length());
        return str;
    }

    public static boolean isDigits(String str) {
        try {
            return ((Integer.parseInt(str) + "").equals(str));
        } catch(Exception e) {
            return false;
        }
    }

    public static void testHypothesiss(String s1, String s2){
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        System.out.println(((s1.compareTo(s2) * (n1-n2) )> 0));
        System.out.println(s1.compareTo(s2));
    }

    public static void main(String[] args) {
        //System.out.println(cutOut("Hi-ho, hi-ho", "-ho"));
        //System.out.println(isDigits("123456"));
        testHypothesiss("4", "5210");
    }
}
