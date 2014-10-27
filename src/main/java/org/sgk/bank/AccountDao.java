package org.sgk.bank;

public interface AccountDao {

	public void createAccount(Account account) throws DuplicateAccountException;
	public void updateAccount(Account account) throws AccountNotFoundException;
	public void removeAccount(Account account) throws AccountNotFoundException;
	public Account findAccount(String accountNo) throws AccountNotFoundException;
}
