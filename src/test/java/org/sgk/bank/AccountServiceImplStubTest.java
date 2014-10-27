package org.sgk.bank;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AccountServiceImplStubTest {

	private static final String TEST_ACCOUNT_NO = "1234";
	private AccountDaoStub accountDaoStub;
	private AccountService accountService;
	
	private class AccountDaoStub implements AccountDao
	{
		private String accountNo;
		private double balance;
		
		@Override
		public void createAccount(Account account)
				throws DuplicateAccountException {
		}

		@Override
		public void updateAccount(Account account)
				throws AccountNotFoundException {
			this.accountNo = account.getAccountNo();
			this.balance = account.getBalance();
		}

		@Override
		public void removeAccount(Account account)
				throws AccountNotFoundException {
		}

		@Override
		public Account findAccount(String accountNo)
				throws AccountNotFoundException {
			return new Account(this.accountNo, this.balance);
		}
	}
	
	@Before
	public void init()
	{
		accountDaoStub = new AccountDaoStub();
		accountDaoStub.accountNo = TEST_ACCOUNT_NO;
		accountDaoStub.balance = 100;
		accountService = new AccountServiceImpl(accountDaoStub);
	}
	
	@Test
	public void deposit() throws AccountNotFoundException
	{
		accountService.deposit(TEST_ACCOUNT_NO, 50);
		assertEquals(accountDaoStub.accountNo, TEST_ACCOUNT_NO);
		assertEquals(accountDaoStub.balance, 150,0);
	}
	
	@Test
	public void withdrawWithSufficientBalance() throws AccountNotFoundException, InsufficienBalanceException
	{
		accountService.withdraw(TEST_ACCOUNT_NO, 50);
		assertEquals(accountDaoStub.accountNo, TEST_ACCOUNT_NO);
		assertEquals(accountDaoStub.balance, 50,0);
	}
	
	@Test(expected = InsufficienBalanceException.class)
	public void withdrawWithInsufficientBalance() throws AccountNotFoundException, InsufficienBalanceException
	{
		accountService.withdraw(TEST_ACCOUNT_NO, 150);
	}
}
