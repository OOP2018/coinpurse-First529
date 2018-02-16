package coinpurse;
/**
 * This class represent money in form of a bank note with fixed value, currency and serial number.
 * @author Dechabhol Kotheeranurak
 */

public class BankNote extends Money {
	
	/**serial number of the bank note.*/
	private long serialNumber;
	/**The next serial number of the bank note.*/
	private static long nextSerialNumberThai = 1000000;
	private static long nextSerialNumberMalay = 1000000;

	/**
	 * The constructor.
	 * @param value
	 * @param currency
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		if (currency.equals("Ringgit")) {
			this.serialNumber = nextSerialNumberMalay++;
		}
		if (currency.equals("Baht")) {
			this.serialNumber = nextSerialNumberThai++;
		}
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
