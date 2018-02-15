package coinpurse;

import java.util.Arrays;

public class PurseTestMain {
	
	public static void main(String[] args) {
		
		Purse n = new Purse(3);
		Valuable v = new Coin (20, "Baht");
		Valuable v1 = new Coin (10, "Baht");
		Valuable v2 = new Coin(10, "BTC");
		System.out.println(n.insert(v));
		System.out.println(n.insert(v1));
		System.out.println(n.insert(v2));
		
		
		System.out.println(Arrays.toString(n.withdraw(new BankNote(20, "Baht"))));
		System.out.println(n.getBalance());
		
		
	}

}
