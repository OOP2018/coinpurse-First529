package coinpurse;

/**
 * This class is a test class of Coin.
 * Include most of the methods in Coin class.
 * @author Dechabhol Kotheeranurak
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoneyUtil {
	
	/**
	 * Print one coin at a time using for each loop.
	 * @param List of coins 
	 */
	public static void printCoins(List<Coin> coins) {
		for (Coin c : coins) {
			System.out.println(c);
		}
	}
	
	/**
	 * Sort into an ascending order of coins.
	 * @param List of coins
	 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}
	
	/**
	 * Add a coin with the same currency.
	 * @param List of coins
	 * @param currency
	 * @return List of coins that contains only the coins from the parameter
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> filteredList = new ArrayList<Coin>();
		for (Coin c : coins) {
			if (c.getCurrency().equals(currency)) filteredList.add(c);
		}
		return filteredList;
	}
	
	/**
	 * Main method.
	 * @param args
	 */
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
