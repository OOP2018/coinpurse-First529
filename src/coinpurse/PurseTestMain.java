package coinpurse;

import java.util.Arrays;

public class PurseTestMain {
	
	public static void main(String[] args) {
		Purse p = new Purse(25);
		System.out.println(p.insert(new Coin(20,"Baht")));
		System.out.println(Arrays.toString(p.withdraw(20)));
		System.out.println(p.getBalance());
		Purse q = new Purse(50);
		System.out.println(q.insert(new BankNote(35, "Dollar")));
		System.out.println(Arrays.toString(q.withdraw(20)));
		System.out.println(q.getBalance());
		BankNote b = new BankNote(20, "Baht");
		BankNote c = new BankNote(20, "Baht");
		System.out.println(b.getSerial());
		System.out.println(c.getSerial());
		Money a = new Coin(20,"baht");
		Money d = new Coin(20, "baht");
		System.out.println(a.equals(d));
		Purse n = new Purse(30);
		System.out.println(n.insert(new Coin(20,"BTC")));
		System.out.println(n.insert(new BankNote(30,"BTC")));
		System.out.println(Arrays.toString(n.withdraw(new Money(20,"BTC"))));
		System.out.println(Arrays.toString(n.withdraw(new Money(20,"BTC"))));
		
		
	}

}
