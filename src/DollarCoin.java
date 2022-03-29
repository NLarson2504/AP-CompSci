package src;

public class DollarCoin extends Coin{

    /**
     * This method gives the value of a dollar coin
     * @return returns value of dollar coin
     */
    public double getValue() {
        return 1.00;
    }

    /**
     * Gives name of coin
     * @return returns name of coin, dollar coin
     */
    public String getName() {
        return "dollar coin";
    }
}
