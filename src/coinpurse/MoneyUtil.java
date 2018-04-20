package coinpurse;

/**
 * This class is a test class of Coin.
 * Include most of the methods in Coin class.
 * @author Dechabhol Kotheeranurak
 */

import java.util.ArrayList;
import java.util.Arrays;
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
	public static void sortMoney(List<? extends Valuable> money) {
		Comparator<Valuable> comp = new ValueComparator();
		Collections.sort(money,comp);
	}
	
	/**
	 * Add a coin with the same currency.
	 * @param List of coins
	 * @param currency
	 * @return List of coins that contains only the coins from the parameter
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<E> money, String currency) {
		List<E> filteredList = new ArrayList<E>();
		for (Valuable c : money) {
			if (c.getCurrency().equals(currency)) filteredList.add((E) c);
		}
		return filteredList;
	}
	
	/**
	 * Return the larger argument, based on sort order, using
	 * the objects' own compareTo method for comparing.
	 * @param args one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException if no arguments given.
	 */
	public static <E extends Comparable<Valuable>> E max(E ... args) {
		try {
			E max = args[0];
			for (int i = 0; i < args.length; i++) {
				if (args[i].compareTo((Valuable) max) > 0) {
					max = args[i];
				}
			}
			return max;
			
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException();
		}
		
	}
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
//		List<Valuable> valuable = new ArrayList<Valuable>();
//		valuable.add(new Coin(10.0, "Baht"));
//		valuable.add(new Coin(6.9, "USD"));
//		valuable.add(new Coin(0.25, "Baht"));
//		valuable.add(new Coin(1.0, "Baht"));
//		printMoney(valuable);
//		sortMoney(valuable);
//		System.out.println("--Sorted--");
//		printMoney(valuable);
		
		Money m1 = new Coin(10, "Baht");
		Money m2 = new Coin(5, "Baht");
		Money m3 = new Coin(1, "Baht");
		Money max = MoneyUtil.max(m1,m2,m3);
		System.out.println(max);
		
		List<Coin> list = new ArrayList<Coin>();
		list.add(new Coin(1.0, "USD"));
		list.add(new Coin(10.0, "Baht"));
		list.add(new Coin(5.0, "Baht"));
		list.add(new Coin(2.0, "Baht"));
		MoneyUtil.sortMoney(list);
		System.out.println(list);
		
		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		System.out.println(result);
		
		
		
		
	}
	
	
}
