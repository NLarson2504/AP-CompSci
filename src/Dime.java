package src;


/**
 * Dime Object is a type of coin
 * @version Thursday 3/31/22
 * @author 23larson
 */
public class Dime extends Coin{

    /**
     * This method gives the value of a dime
     * @return returns value of dime
     */
    public double getValue() {
        return 0.1;
    }

    /**
     * Gives name of coin
     * @return returns name of coin, dime
     */
    public String getName() {
        return "dime";
    }
}
