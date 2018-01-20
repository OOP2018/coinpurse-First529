package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoneyUtil {
	
	public static void printCoins(List<Coin> coins) {
		for (Coin c : coins) {
			System.out.println(c);
		}
	}
	
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}
	
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> filteredList = new ArrayList<Coin>();
		for (Coin c : coins) {
			if (c.getCurrency().equals(currency)) filteredList.add(c);
		}
		return filteredList;
	}
	
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(6.9, "USD"));
		coins.add(new Coin(0.25, "Baht"));
		coins.add(new Coin(1.0, "Baht"));
		printCoins(coins);
		
		sortCoins(coins);
		System.out.println("Sorted");
		printCoins(coins);
	}
	
	
}
