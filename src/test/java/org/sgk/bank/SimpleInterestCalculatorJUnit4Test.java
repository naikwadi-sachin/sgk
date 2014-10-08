package org.sgk.bank;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.sgk.bank.InterestCalculator;
import org.sgk.bank.SimpleInterestCalculator;

public class SimpleInterestCalculatorJUnit4Test {

	private InterestCalculator interestCalculator;
	
	@Before
	public void init() {
		interestCalculator = new SimpleInterestCalculator();
		interestCalculator.setRate(5.0);
	}
	
	@Test
	public void calculate()
	{
		double interest = interestCalculator.calculate(100, 2);
		assertEquals(1000.0, interest,0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegelCalculate()
	{
		interestCalculator.calculate(-1000, 2);
	}
}
