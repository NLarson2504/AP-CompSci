package src;


/**
 * HalfDollarObject is a type of coin
 * @version Thursday 3/31/22
 * @author 23larson
 */
public class HalfDollar extends Coin{

    /**
     * This method gives the value of a half dollar
     * @return returns value of half dollar
     */
    public double getValue() {
        return 0.50;
    }

    /**
     * Gives name of coin
     * @return returns name of coin, half dollar
     */
    public String getName() {
        return "half dollar";
    }
}
