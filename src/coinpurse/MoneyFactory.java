package coinpurse;

public abstract class MoneyFactory {
	
	private static MoneyFactory instance = null;
	
	protected MoneyFactory() {
		
	}
	
	public static MoneyFactory getInstance() {
		if (instance == null) {
			instance = new ThaiMoneyFactory();
		}
		return instance;
	}
	
	public abstract Valuable createMoney(double value);
	
	public Valuable createMoney(String value) {
		double money = 0;
		try{
			money = Double.parseDouble(value);
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("The input String doesn't contain number.");
		}
		return createMoney(money);
	}
	
	public static void setFactory(MoneyFactory factory) {
		instance = factory;
	}

}
