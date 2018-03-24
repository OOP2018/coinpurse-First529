package coinpurse;

/**
 * Coin represents money with fixed value and currency.
 * 
 * @author Dechabhol Kotheeranurak
 */

public class Coin extends Money {

	/**
	 * Initializing parameters.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	/**
	 * Value and currency of coin.
	 * 
	 * @return String in a specific format
	 */
	public String toString() {
		if (this.getCurrency().equals("Ringgit"))
			return String.format("%.2f-%s coin", this.getValue() * 100, "Sen");
		return String.format("%.2f-%s coin", this.getValue(), "Baht");
	}

}
