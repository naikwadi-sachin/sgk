package org.sgk.bank;

public interface AccountService {

	public void createAccount(String accountNo) throws DuplicateAccountException;
	public void removeAccount(String accountNo) throws AccountNotFoundException;
	public void deposit(String accountNo, double amount) throws AccountNotFoundException;
	public void withdraw(String accountNo, double amount) throws AccountNotFoundException,InsufficienBalanceException;
	public double getBalance(String accountNo) throws AccountNotFoundException;
}
