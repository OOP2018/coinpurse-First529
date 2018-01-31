package coinpurse;
/**
 * This class represent money in form of a bank note with fixed value, currency and serial number.
 * @author Dechabhol Kotheeranurak
 */

public class BankNote implements Valuable {
	/**value of the bank note.*/
	private double value;
	/**currency of the bank note.*/
	private String currency;
	/**serial number of the bank note.*/
	private long serialNumber;
	/**The next serial number of the bank note.*/
	private static long nextSerialNumber = 1000000;

	/**
	 * The constructor.
	 * @param value
	 * @param currency
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
	}
	
	/**
	 * Get the value of the bank note.
	 * @return value
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * Get the currency of the bank note.
	 * @return currency
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	
	/**
	 * Get the serial number of the bank note.
	 * @return serialNumber
	 */
	public long getSerial() {
		return serialNumber;
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
		BankNote other = (BankNote) obj;
		return this.value == other.value && this.currency == other.currency;
	}

	/**
	 * String format.
	 * @return the format of the string in the specific form.
	 */
	public String toString() {
		return String.format("%.0f-%s(note) [%d]", value, currency, serialNumber);
	}

	
	

}
