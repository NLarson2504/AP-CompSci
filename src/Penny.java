package src;

/**
 * Penny Object is a type of coin
 * @version Thursday 3/31/22
 * @author 23larson
 */
public class Penny extends Coin{

    /**
     * This method gives the value of a penny
     * @return returns value of penny
     */
    public double getValue() {
        return 0.01;
    }

    /**
     * Gives name of coin
     * @return returns name of coin, penny
     */
    public String getName() {
        return "penny";
    }
}
