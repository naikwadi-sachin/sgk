package org.sgk.bank;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class AccountServiceImplMockTest {

	private static final String TEST_ACCOUNT_NO = "1234";
	private EasyMock easyMock;
	private AccountDao accountDao;
	private AccountService accountService;
	
	@Before
	public void init()
	{
		accountDao = easyMock.createMock(AccountDao.class);
		accountService = new AccountServiceImpl(accountDao);
	}
	
	@Test
	public void deposit() throws AccountNotFoundException
	{
		Account account = new Account(TEST_ACCOUNT_NO, 100);
		accountDao.findAccount(TEST_ACCOUNT_NO);
		easyMock.expectLastCall().andReturn(account);
		account.setBalance(150);
		accountDao.updateAccount(account);
		easyMock.replay();
		
		accountService.deposit(TEST_ACCOUNT_NO, 50);
		easyMock.verify();
	}
	
//	public void w
}
