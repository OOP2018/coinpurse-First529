package coinpurse;
/**
 * Comparing two Valuable objects and define which one is more valuable.
 * @author Dechabhol Kotheeranurak
 */
import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {

	/**
	 * Compare two objects that implement Valuable. First compare them by
	 * currency, so that "Baht" < "Dollar". If both objects have the same
	 * currency, order them by value.
	 * 
	 * @param a Valuable object
	 * @param b Valuable object
	 * @return 0 if these two objects have the same currency and value
	 *			-1 if these two objects have the same currency and a has a higher value than b
	 *			1 if these two objects have the same currency and b has a higher value than a								
	 */
	public int compare(Valuable a, Valuable b) {
		if (a.getCurrency().equals(b.getCurrency())) {
			if (a.getValue() == b.getValue())
				return 0;
			if (a.getValue() > b.getValue())
				return 1;
			if (a.getValue() < b.getValue())
				return -1;
		} else if (a.getCurrency().contains("B") && b.getCurrency().contains("D"))
			return -1;
		return 1;

	}
}
