package coinpurse;

public class MoneyFactoryDemo {
	
	public static void main(String[] args) {
		
		// a)
		MoneyFactory f1 = MoneyFactory.getInstance();
		MoneyFactory f2 = MoneyFactory.getInstance();
		System.out.println(f1 == f2); // should print false.
		
		// b)
		String[] thaiCoins = {"1","2","5","10"};
		String[] thaiBanknotes = {"20","50","100","500","1000"};
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory f3 = MoneyFactory.getInstance();
		System.out.println("Creating thai's coin: ");
		for (String v : thaiCoins) {
			System.out.println(f3.createMoney(v));
		}
		System.out.println("Creating thai's banknote: ");
		for (String v : thaiBanknotes) {
			System.out.println(f3.createMoney(v));
		}
		
		
		
	}

}
