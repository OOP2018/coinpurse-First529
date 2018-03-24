package coinpurse.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.Valuable;

public class WithdrawTest {
	
	private static final double TOL = 1.0E-6;
	
	private WithdrawStrategy strategy;
	
	private List<Valuable> list;
	
	
	@Before
	public void setUp() {
		strategy = new RecusiveWithdrawStrategy();
		list = new ArrayList<>();		
	}
	
	@Test
	public void testWithdrawEverything() {
	
		list.add(new Money(1.0, "Baht"));
		assertEquals(new Money(1, "Baht"), strategy.withdraw(new Money(1, "Baht"), list).get(0));
		list.clear();
		list.add(new Money(2.0, "Baht"));
		assertEquals(new Money(2, "Baht"), strategy.withdraw(new Money(2, "Baht"), list).get(0));
		list.clear();
		list.add(new Money(5.0, "Baht"));
		assertEquals(new Money(5, "Baht"), strategy.withdraw(new Money(5, "Baht"), list).get(0));
	
	}
	
	@Test
	public void testWithdrawNothing() { 
		list.clear();
		assertNull(strategy.withdraw(new Coin(0, "Baht"), list));
		assertNull(strategy.withdraw(new Money(0, "Baht"), list));
	}
	
	@Test
	public void testMultipleWithdraw() {
		list.add(new Money(1.0, "Baht"));
		list.add(new Money(2.0, "Baht"));
		list.add(new Money(5.0, "Baht"));
		List<Valuable> temp = strategy.withdraw(new Money(8, "Baht"), list);
		double sum = 0.0;
		for (int i = 0; i < temp.size(); i++) {
			sum += temp.get(i).getValue();
		}
		assertEquals(8,sum,TOL);
	}
	
	@Test
	public void testImpossibleWithdraw() {
		list.add(new Money(1.0, "Baht"));
		list.add(new Money(2.0, "Baht"));
		assertEquals(null, strategy.withdraw(new Money(10, "Baht"), list));
	}
	
	@Test
	public void testWithdrawDifferentCurrency() {

		list.add(new Money(1.0, "BTC"));
		list.add(new Money(1.0, "Dollar"));
		list.add(new Money(1.0, "Baht"));
		
		assertEquals(new Money(1, "Baht"), strategy.withdraw(new Money(1.0, "Baht"), list).get(0));
	}
	
	@Test
	public void testEasyWithdraw() {
		
		assertEquals(strategy.withdraw(new BankNote(0,"Baht",1000000), list),null);
		assertEquals(strategy.withdraw(new Money(0,"Baht"), list), null);
		assertEquals(strategy.withdraw(new Coin(0,"Baht"), list), null);
	}
	
	

	

	
	
	

}
