package coinpurse;
/**
 * Coin represents money with fixed value and currency.
 * @author Dechabhol Kotheeranurak
 */

public class Coin extends Money {
		
	/**
	 * Initializing parameters.
	 * @param value
	 * @param currency
	 */
	public Coin (double value, String currency) {
		super(value, currency);
	}
	
	
	/**
	 * Value and currency of coin.
	 * @return String in a specific format
	 */
	public String toString() {
		return String.format("%.2f-%s", this.getValue(), this.getCurrency());
	}

}
