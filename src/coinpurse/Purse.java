package coinpurse;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// You will use Collections.sort() to sort the coins

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Dechabhol Kotheeranurak
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Valuable> money;

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create new ValueComparator object as a private attribute.
	 */
	private Comparator<Valuable> comp = new ValueComparator();

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		money = new ArrayList<Valuable>();
		this.capacity = capacity;
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double total = 0.0;
		for (Valuable c : money)
			total += c.getValue();
		return total;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (this.count() == this.capacity) {
			return true;
		}
		return false;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable coin) {
		// if the purse is already full then can't insert anything.
		if (this.isFull() || coin.getValue() <= 0) {
			return false;
		}
		money.add(coin);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {

		if (amount < 0)
			return null;

		List<Valuable> templist = new ArrayList<Valuable>();
		Collections.sort(money, comp);
		Collections.reverse(money);
		double amountNeededToWithdraw = amount;

		for (Valuable c : money) {
			if (amountNeededToWithdraw >= c.getValue()) {
				templist.add(c);
				amountNeededToWithdraw -= c.getValue();

			}
			if (amountNeededToWithdraw == 0)
				break;

		}

		if (amountNeededToWithdraw != 0)
			return null;
		for (Valuable c : templist)
			money.remove(c);

		Valuable[] array = new Valuable[templist.size()];
		templist.toArray(array);

		// Success.
		// Remove the valuable you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
		return array;
	}
	
	/**
	 * Withdraw the requested amount of money with the same currency. Return an array of Valuable
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {

		if (amount == null && amount.getValue() < 0)
			return null;
		List<Valuable> templist = new ArrayList<Valuable>();
		Collections.sort(money, comp);
		Collections.reverse(money);
		double amountNeededToWithdraw = amount.getValue();
		String amountCurrency = amount.getCurrency();

		for (Valuable c : money) {
			if (amountCurrency.equalsIgnoreCase(c.getCurrency())) {
				if (amountNeededToWithdraw >= c.getValue()) {
					templist.add(c);
					amountNeededToWithdraw -= c.getValue();

				}
			}
			if (amountNeededToWithdraw == 0)
				break;

		}

		if (amountNeededToWithdraw != 0)
			return null;
		for (Valuable c : templist)
			money.remove(c);

		Valuable[] array = new Valuable[templist.size()];
		templist.toArray(array);
		return array;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return String.format("This purse have %d coin(s) with a value of %.1f and %d capacity.", this.count(),
				this.getBalance(), this.capacity);
	}

}
