package org.sgk.bank;

public class Account {

	private String accountNo;
	private double balance;
	
	public Account() {
	}
	
	public Account(String accountNo, double balance) {
		super();
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Account))
			return false;
		Account account = (Account) obj;
		return account.getAccountNo().equals(accountNo) && account.getBalance()==balance;
	}
}
