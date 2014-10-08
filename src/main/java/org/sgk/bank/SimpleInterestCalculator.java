package org.sgk.bank;

public class SimpleInterestCalculator implements InterestCalculator{

	private double rate;
	
	@Override
	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public double calculate(double amount, double year) {
		if(amount < 0 || year < 0)
			throw new IllegalArgumentException("Amount or Year must be greater than 0"); 
		return rate * amount * year;
	}

}
