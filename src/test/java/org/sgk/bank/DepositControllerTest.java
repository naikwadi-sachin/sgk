package org.sgk.bank;

import org.easymock.MockControl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.sgk.bank.controller.DepositController;
import org.springframework.ui.ModelMap;

public class DepositControllerTest {

	private static final String TEST_ACCOUNT_NO = "1234";
	private static final double TEST_AMOUNT = 50;
	private MockControl mockControl;
	private AccountService accountService;
	private DepositController depositController;
	
	@Before
	public void init()
	{
		mockControl = mockControl.createControl(AccountService.class);
		accountService = (AccountService) mockControl.getMock();
		depositController =  new DepositController(accountService);
	}
	
	@Test
	public void deposit() throws AccountNotFoundException
	{
		accountService.deposit(TEST_ACCOUNT_NO, TEST_AMOUNT);
		accountService.getBalance(TEST_ACCOUNT_NO);
		mockControl.setReturnValue(150.0);
		mockControl.replay();
		
		ModelMap model = new ModelMap();
		String viewName = depositController.deposit(TEST_ACCOUNT_NO, TEST_AMOUNT, model);
		mockControl.verify();
		
		assertEquals(viewName, "success");
		assertEquals(model.get("accountNo"), TEST_ACCOUNT_NO);
		assertEquals(model.get("balance"), 150.0);
	}
}
