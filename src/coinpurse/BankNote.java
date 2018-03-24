package coinpurse;
/**
 * This class represent money in form of a bank note with fixed value, currency and serial number.
 * @author Dechabhol Kotheeranurak
 */

public class BankNote extends Money {
	
	/**serial number of the bank note.*/
	private long serialNumber;

	/**
	 * The constructor.
	 * @param value
	 * @param currency
	 */
	public BankNote(double value, String currency, long serial) {
		super(value,currency);
		this.serialNumber = serial;
	}

	/**
	 * Get the serial number of the bank note.
	 * @return serialNumber
	 */
	public long getSerial() {
		return serialNumber;
	}

	/**
	 * String format.
	 * @return the format of the string in the specific form.
	 */
	public String toString() {
		return String.format("%.0f-%s(note) [%d]", this.getValue(), this.getCurrency(), serialNumber);
	}

	
	

}
