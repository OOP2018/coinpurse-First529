package coinpurse;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * JUNIT 4 test for MoneyFactory class.
 * @author Dechabhol Kotheeranurak
 *
 */

public class MoneyFactoryTest {
	
	private static final double TOL = 1.0E-6;
	private final double[] THAIMONEY = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

	@Test
	public void testSetThaiMoneyFactory() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass(), ThaiMoneyFactory.getInstance().getClass());
	}
	
	@Test
	public void testSetMalayMoneyFactory() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass(),MalayMoneyFactory.getInstance().getClass());
	}
	
	@Test
	public void testCreateMoneyDouble() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory thai = MoneyFactory.getInstance();
		for (double m : THAIMONEY) {
			if (m >= 20) {
				assertEquals(new BankNote(m,"Baht"), thai.createMoney(m));
			} else {
				assertEquals(new Coin(m,"Baht"), thai.createMoney(m));
			}
		}
		
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory malay = MoneyFactory.getInstance();
		double[] malayMoney = {0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100};
		for (double m : malayMoney) {
			if (m <= 0.5) {
				assertEquals(new Coin(m, "Sen"), malay.createMoney(m));
			} else {
				assertEquals(new BankNote(m,"Ringgit"), malay.createMoney(m));
			}
		}
	}
	
	@Test
	public void testCreateMoneyString() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory thai = MoneyFactory.getInstance();
		String[] thaiCoins = {"1","2","5","10"};
		String[] thaiBankNotes = {"20","50","100","500","1000"};
		int i = 0;
		for (i = 0; i < thaiCoins.length; i++) {
			assertEquals(new Coin(THAIMONEY[i], "Baht"), thai.createMoney(thaiCoins[i]));
		}
		for (int j = i, k = 0; j < thaiBankNotes.length; j++) {
			assertEquals(new BankNote(THAIMONEY[j], "Baht"), thai.createMoney(thaiBankNotes[k]));
		}
		
	}
	
	

}
