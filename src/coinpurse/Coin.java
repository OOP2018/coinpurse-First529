package coinpurse;
/**
 * Coin represents money with fixed value and currency.
 * @author Dechabhol Kotheeranurak
 */

public class Coin implements Comparable<Coin> {
	
	private double value;
	private String currency;
	
	public Coin (double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	public double getValue() {
		return value;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public boolean equals(Object arg) {
		if (arg == null) return false;
		if (arg.getClass() != this.getClass()) return false;
		Coin other = (Coin) arg;
		return this.value == other.value && this.currency == other.currency;
	}
	
	public int compareTo(Coin coin) {
		if (coin.getValue() < this.getValue()) return 1;
		if (coin.getValue() > this.getValue()) return -1;
		return 0;
				
	}
	
	public String toString() {
		return String.format("%.2f-%s", this.value, this.currency);
	}

}
