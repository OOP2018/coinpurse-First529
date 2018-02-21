package coinpurse;
/**
 * MoneyFactory class for Malaysia.
 * @author Dechabhol Kotheeranurak
 *
 */

public class MalayMoneyFactory extends MoneyFactory {
	
	private static long malaySerial = 1000000; 
	
	@Override
	public Valuable createMoney(double value) {
		if (isCoin(value)) {
			return new Coin(value, "Ringgit");
		}
		else if (isBankNote(value)) {
			return new BankNote(value, "Ringgit", malaySerial);
		}
		else throw new IllegalArgumentException("The input value doesn't exist in Malaysia currency.");
	}
	
	public boolean isCoin(double value) {
		int valueSen = (int) (value*100);
		int[] coins = {5,10,20,50};
		for (int i = 0; i < coins.length; i++) {
			if (valueSen == coins[i]) {
				valueSen = 0;
				return true;
			}
		}
		return false;
	}
	
	public boolean isBankNote(double value) {
		int[] banknotes = {1,2,5,10,20,50,100};
		for (int i = 0; i < banknotes.length; i++) {
			if (value == banknotes[i]) {
				malaySerial++;
				return true;
			}
		}
		return false;
	}

}
