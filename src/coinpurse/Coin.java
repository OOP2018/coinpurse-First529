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
	 * Order coins in which the smallest value comes first.
	 * @param coin	
	 * @return x > 0 , x < 0 , x == 0
	 */
	public int compareTo(Coin coin) {
		if (coin.getValue() < this.getValue()) return 1;
		if (coin.getValue() > this.getValue()) return -1;
		return 0;
				
	}
	
	/**
	 * Value and currency of coin.
	 * @return String in a specific format
	 */
	public String toString() {
		return String.format("%.2f-%s", this.getValue(), this.getCurrency());
	}

}
