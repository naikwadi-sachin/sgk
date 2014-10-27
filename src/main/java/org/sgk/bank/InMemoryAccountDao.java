package org.sgk.bank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountDao implements AccountDao{

	private Map<String, Account> accounts = null;
	
	public InMemoryAccountDao() {
		accounts = Collections.synchronizedMap(new HashMap<String, Account> ());
	}
	
	public boolean accountExists(String accountNo)
	{
		return accounts.containsKey(accountNo);
	}
	
	@Override
	public void createAccount(Account account) throws DuplicateAccountException {
		if(accountExists(account.getAccountNo()))
			throw new DuplicateAccountException();
		accounts.put(account.getAccountNo(), account);
	}

	@Override
	public void updateAccount(Account account) throws AccountNotFoundException {
		if(!accountExists(account.getAccountNo()))
				throw new AccountNotFoundException();
		accounts.put(account.getAccountNo(), account);
	}

	@Override
	public void removeAccount(Account account) throws AccountNotFoundException {
		if(!accountExists(account.getAccountNo()))
			throw new AccountNotFoundException();
		accounts.remove(account.getAccountNo());
	}

	@Override
	public Account findAccount(String accountNo) throws AccountNotFoundException {
		Account account = accounts.get(accountNo);
		if(account == null)
			throw new AccountNotFoundException();
		return account;
	}

}
