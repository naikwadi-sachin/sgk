package org.sgk.bank;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/beans.xml"})
public class AccountServiceJUnit4ContextText implements ApplicationContextAware{

	private static final String TEST_ACCOUNT_NO = "1234";
	private AccountService accountService;
	private ApplicationContext applicationContext;
	
	@Before
	public void init() throws DuplicateAccountException, AccountNotFoundException
	{
		accountService = (AccountService) applicationContext.getBean("accountService");
		accountService.createAccount(TEST_ACCOUNT_NO);
		accountService.deposit(TEST_ACCOUNT_NO, 100);
	}
	
	@Test
	public void deposit() throws AccountNotFoundException
	{
		accountService.deposit(TEST_ACCOUNT_NO, 50);
		assertEquals(accountService.getBalance(TEST_ACCOUNT_NO), 150, 0);
	}
	
	@Test
	public void withdraw() throws AccountNotFoundException, InsufficienBalanceException
	{
		accountService.withdraw(TEST_ACCOUNT_NO, 50);
		assertEquals(accountService.getBalance(TEST_ACCOUNT_NO), 50,0);
	}
	
	@After
	public void cleanUp() throws AccountNotFoundException
	{
		accountService.removeAccount(TEST_ACCOUNT_NO);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}
