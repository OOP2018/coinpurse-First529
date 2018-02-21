package coinpurse;
/**
 * MoneyFactory class for Thailand.
 * @author Dechabhol Kotheeranurak
 *
 */

public class ThaiMoneyFactory extends MoneyFactory {
	
	private static long thaiSerial = 1000000; 
	
	@Override
	public Valuable createMoney(double value) {
		if (isCoin(value)) {
			return new Coin(value, "Baht");
		}
		else if (isBankNote(value)) {
			return new BankNote(value, "Baht", thaiSerial);
		}
		 else throw new IllegalArgumentException("The input value doesn't exist in Thailand currency.");
	}
	
	public boolean isCoin(double value) {
		int[] coins = {1,2,5,10};
		for (int i = 0; i < coins.length; i++) {
			if (value == coins[i]) return true;
		}
		return false;
	}
	
	public boolean isBankNote(double value) {
		int[] banknotes = {20,50,100,500,1000};
		for (int i = 0; i < banknotes.length; i++) {
			if (value == banknotes[i]) {
				thaiSerial++;
				return true;
			}
		}
		return false;
	}

}
