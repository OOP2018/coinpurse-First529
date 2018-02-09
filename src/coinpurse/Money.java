package coinpurse;
/**
 * Superclass of BankNote and Coin provide the value, currency, getValue, and getCurrency for subclasses.
 * @author Dechabhol Kotheeranurak
 *
 */

public class Money implements Valuable {
	
	/** Value of Money in double.*/
	private double value;
	/** Currency of Money in String.*/
	private String currency;
	/**
	 * The constructor for Money.
	 * @param value
	 * @param currency
	 */
	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	/**
	 * Compare two valuable objects by currency.
	 * @param o
	 * @return 0 or -1 or 1
	 */
	public int compareTo( Valuable o ) {
		if(this.getCurrency().equals(o.getCurrency())) {
			return Double.compare(this.getValue(), o.getValue());
		}
		return this.getCurrency().compareTo(o.getCurrency());
	}
	
	/**
	 * return the value in double.
	 * @return value
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * return the currency in string.
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Comparing two objects together.
	 * @param obj
	 * @return true or false
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Money other = (Money) obj;
		return this.getValue() == other.getValue() && this.getCurrency() == other.getCurrency();
	}

}
