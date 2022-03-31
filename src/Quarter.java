package src;


/**
 * Quarter Object is a type of coin
 * @version Thursday 3/31/22
 * @author 23larson
 */
public class Quarter extends Coin{

    /**
     * This method gives the value of a quarter
     * @return returns value of quarter
     */
    public double getValue() {
        return 0.25;
    }

    /**
     * Gives name of coin
     * @return returns name of coin, quarter
     */
    public String getName() {
        return "quarter";
    }
}

