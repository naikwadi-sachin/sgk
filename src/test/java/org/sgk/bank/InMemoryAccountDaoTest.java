package org.sgk.bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InMemoryAccountDaoTest {

	private static final String EXISTING_ACCOUNT_NO ="1234";
	private static final String NEW_ACCOUNT_NO = "567";
	
	private Account existingAccount;
	private Account newAccount;
	private InMemoryAccountDao accountDao;
	
	@Before
	public void init() throws DuplicateAccountException
	{
		existingAccount = new Account(EXISTING_ACCOUNT_NO, 100);
		newAccount = new Account(NEW_ACCOUNT_NO, 200);
		accountDao = new InMemoryAccountDao();
		accountDao.createAccount(existingAccount);
	}
	
	@Test
	public void accountExists()
	{
		assertTrue(accountDao.accountExists(EXISTING_ACCOUNT_NO));
		assertFalse(accountDao.accountExists(NEW_ACCOUNT_NO));
	}
	
	@Test
	public void createNewAccount() throws DuplicateAccountException, AccountNotFoundException
	{
		accountDao.createAccount(newAccount);
		assertEquals(accountDao.findAccount(NEW_ACCOUNT_NO), newAccount);
	}
	
	@Test(expected=DuplicateAccountException.class)
	public void createDuplicateAccount() throws DuplicateAccountException
	{
		accountDao.createAccount(existingAccount);
	}
	
	@Test
	public void updateExistingAccount() throws AccountNotFoundException
	{
		existingAccount.setBalance(150);
		accountDao.updateAccount(existingAccount);
		assertEquals(accountDao.findAccount(EXISTING_ACCOUNT_NO), existingAccount);
	}
	
	@Test(expected = AccountNotFoundException.class)
	public void updateNonExistingAccount() throws AccountNotFoundException
	{
		accountDao.updateAccount(newAccount);
	}
	
	@Test
	public void removeExistingAccount() throws AccountNotFoundException
	{
		accountDao.removeAccount(existingAccount);
		assertFalse(accountDao.accountExists(EXISTING_ACCOUNT_NO));
	}
	
	@Test(expected = AccountNotFoundException.class)
	public void removeNonExistingAccount() throws AccountNotFoundException
	{
		accountDao.removeAccount(newAccount);
	}
	
	@Test
	public void findExistingAccount() throws AccountNotFoundException
	{
		Account account = accountDao.findAccount(EXISTING_ACCOUNT_NO);
		assertEquals(account, existingAccount);
	}
	
	@Test(expected = AccountNotFoundException.class)
	public void findNonExistingAccount() throws AccountNotFoundException
	{
		Account account = accountDao.findAccount(NEW_ACCOUNT_NO);
	}
}
