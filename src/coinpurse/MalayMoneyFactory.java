package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
	
	@Override
	public Valuable createMoney(double value) {
		if (isCoin(value)) {
			return new Coin(value, "Sen");
		}
		else if (isBankNote(value)) {
			return new BankNote(value, "Ringgit");
		}
		else throw new IllegalArgumentException();
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
			if (value == banknotes[i]) return true;
		}
		return false;
	}

}
