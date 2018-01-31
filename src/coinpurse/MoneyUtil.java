package coinpurse;

/**
 * This class is a test class of Coin.
 * Include most of the methods in Coin class.
 * @author Dechabhol Kotheeranurak
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MoneyUtil {
	
	/**
	 * Print one coin at a time using for each loop.
	 * @param List of coins 
	 */
	public static void printMoney(List<Valuable> money) {
		for (Valuable c : money) {
			System.out.println(c);
		}
	}
	
	/**
	 * Sort into an ascending order of coins.
	 * @param List of coins
	 */
	public static void sortMoney(List<Valuable> money) {
		Comparator<Valuable> comp = new ValueComparator();
		Collections.sort(money,comp);
	}
	
	/**
	 * Add a coin with the same currency.
	 * @param List of coins
	 * @param currency
	 * @return List of coins that contains only the coins from the parameter
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> money, String currency) {
		List<Valuable> filteredList = new ArrayList<Valuable>();
		for (Valuable c : money) {
			if (c.getCurrency().equals(currency)) filteredList.add(c);
		}
		return filteredList;
	}
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		List<Valuable> valuable = new ArrayList<Valuable>();
		valuable.add(new Coin(10.0, "Baht"));
		valuable.add(new Coin(6.9, "USD"));
		valuable.add(new Coin(0.25, "Baht"));
		valuable.add(new Coin(1.0, "Baht"));
		printMoney(valuable);
		sortMoney(valuable);
		System.out.println("--Sorted--");
		printMoney(valuable);
		
		
		
		
	}
	
	
}
