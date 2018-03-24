package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;

public class GreedyWithdrawStrategy implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		if (amount == null || amount.getValue() <= 0) return null;
		List<Valuable> templist = new ArrayList<Valuable>();
		Collections.sort(money);
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


		return templist;
	}

}
