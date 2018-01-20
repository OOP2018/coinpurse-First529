package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {
	
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(6.9, "Baht"));
		coins.add(new Coin(0.25, "Baht"));
		coins.add(new Coin(1.0, "Baht"));
		printCoins(coins);
		
		sortCoins(coins);
		System.out.println("Sorted");
		printCoins(coins);
	}
	
	public static void printCoins(List<Coin> coins) {
		for (Coin c : coins) {
			System.out.println(c);
		}
	}
	
	public static void sortCoins(List<Coin> coins) {
		java.util.Collections.sort(coins);
	}
}
