package coinpurse;
/**
 * Coin represents money with fixed value and currency.
 * @author Dechabhol Kotheeranurak
 */

public class Coin implements Comparable<Coin>, Valuable {
	
	/** value of the coin*/
	private double value;
	/** currency of the coin*/
	private String currency;
	
	/**
	 * Initializing parameters.
	 * @param value
	 * @param currency
	 */
	public Coin (double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * This method will return the value of the coin.
	 * @return value
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * This method will return the currency of the coin.
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * Comparing two objects and return the value in a boolean format.
	 * @param arg
	 * @return true of false
	 */
	public boolean equals(Object arg) {
		if (arg == null) return false;
		if (arg.getClass() != this.getClass()) return false;
		Coin other = (Coin) arg;
		return this.value == other.value && this.currency == other.currency;
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
		return String.format("%.2f-%s", this.value, this.currency);
	}

}
