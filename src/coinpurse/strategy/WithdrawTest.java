package coinpurse.strategy;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Coin;
import coinpurse.MoneyFactory;
import coinpurse.ThaiMoneyFactory;
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
	
		list.add(new Coin(1.0, "Baht"));
		assertEquals(new Coin(1, "Baht"), strategy.withdraw(new Coin(1, "Baht"), list).get(0));
		list.clear();
		list.add(new Coin(2.0, "Baht"));
		assertEquals(new Coin(2, "Baht"), strategy.withdraw(new Coin(2, "Baht"), list).get(0));
		list.clear();
		list.add(new Coin(5.0, "Baht"));
		assertEquals(new Coin(5, "Baht"), strategy.withdraw(new Coin(5, "Baht"), list).get(0));
	
	}
	
	@Test
	public void testWithdrawZero() { 
		list.add(new Coin(0.0, "Baht"));
		assertEquals( new Coin(0.0,"Baht") ,strategy.withdraw(new Coin(0, "Baht"), list).get(0));
	}
	
	@Test
	public void testMultipleWithdraw() {
		list.add(new Coin(1.0, "Baht"));
		list.add(new Coin(2.0, "Baht"));
		list.add(new Coin(5.0, "Baht"));
		List<Valuable> temp = strategy.withdraw(new Coin(8, "Baht"), list);
		double sum = 0.0;
		for (int i = 0; i < temp.size(); i++) {
			sum += temp.get(i).getValue();
		}
		assertEquals(8,sum,TOL);
	}
	
	@Test
	public void testImpossibleWithdraw() {
		list.add(new Coin(1.0, "Baht"));
		list.add(new Coin(2.0, "Baht"));
		assertEquals(null, strategy.withdraw(new Coin(10, "Baht"), list));
	}
	
	@Test
	public void testWithdrawDifferentCurrency() {

		list.add(new Coin(1.0, "BTC"));
		list.add(new Coin(1.0, "Dollar"));
		list.add(new Coin(1.0, "Baht"));
		
		assertEquals(new Coin(1, "Baht"), strategy.withdraw(new Coin(1.0, "Baht"), list).get(0));
	}
	
	@Test
	
	
	

}
