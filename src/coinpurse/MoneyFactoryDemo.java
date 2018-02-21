package coinpurse;
/**
 * Check whether MoneyFactory is a singleton and preview what is going to be in the JUNIT 4 test.
 * @author Dechabhol Kotheeranurak
 *
 */

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
		
		String[] malayMoney = {"0.05", "0.1", "0.2", "0.5", "1", "2", "5", "10", "20", "50", "100"};
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory f4 = MoneyFactory.getInstance();
		for (String m : malayMoney) {
			System.out.println(f4.createMoney(m));
		}
		
		
		
		
	}

}
