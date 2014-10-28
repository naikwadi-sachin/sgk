package org.sgk.bank;

public class AccountServiceImpl implements AccountService{

	private AccountDao accountDao;
	
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	@Override
	public void createAccount(String accountNo) throws DuplicateAccountException {
		accountDao.createAccount(new Account(accountNo, 0));
	}

	@Override
	public void removeAccount(String accountNo) throws AccountNotFoundException {
		Account account = accountDao.findAccount(accountNo);
		accountDao.removeAccount(account);
	}

	@Override
	public void deposit(String accountNo, double amount) throws AccountNotFoundException {
		Account account = accountDao.findAccount(accountNo);
		if(account == null)
			throw new AccountNotFoundException();
		account.setBalance(account.getBalance() + amount);
		accountDao.updateAccount(account);
	}

	@Override
	public void withdraw(String accountNo, double amount) throws InsufficienBalanceException, AccountNotFoundException {
		Account account = accountDao.findAccount(accountNo);
		if(account == null)
			throw new AccountNotFoundException();
		else if(account.getBalance() < amount)
			throw new InsufficienBalanceException();
		account.setBalance(account.getBalance() - amount);
		accountDao.updateAccount(account);
	}

	@Override
	public double getBalance(String accountNo) throws AccountNotFoundException {
		Account account = accountDao.findAccount(accountNo);
		if(account == null)
			throw new AccountNotFoundException();
		return account.getBalance();
	}

}
