package coinpurse;
/**
 * An interface for objects having a monetary value and currency.
 * @author Dechabhol Kotheeranurak
 */
public interface Valuable {
	
	/**
	 * Get the value of this object. 
	 * @return value
	 */
	public double getValue();
	
	/**
	 * Get the currency of this object.
	 * @return currency
 	 */
	public String getCurrency();

}
