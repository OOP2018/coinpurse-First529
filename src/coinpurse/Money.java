package coinpurse;

public class Money implements Valuable {
	
	private double value;
	
	private String currency;
	
	public Money(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	public int compareTo( Valuable o ) {
		if(this.getCurrency().equals(o.getCurrency())) {
			return Double.compare(this.getValue(), o.getValue());
		}
		return this.getCurrency().compareTo(o.getCurrency());
	}
	
	public double getValue() {
		return value;
	}
	
	public String getCurrency() {
		return currency;
	}

	/**
	 * Comparing two objects together.
	 * @param obj
	 * @return true or false
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Money other = (Money) obj;
		return this.getValue() == other.getValue() && this.getCurrency() == other.getCurrency();
	}

}
