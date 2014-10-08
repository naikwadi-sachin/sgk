package org.sgk.bank;

//import org.t
public class SimpleInterestCalculatorTestNJTest {

	private InterestCalculator interestCalculator;
	
//	@bef
	public void init()
	{
		interestCalculator = new SimpleInterestCalculator();
		interestCalculator.setRate(0.5);
	}
}
