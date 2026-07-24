package main;

public class Account {
	private static long defaultAccountNumber = 45000450;
	private long accountNumber;
	private double balance;
	{
		accountNumber = defaultAccountNumber + 1;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println(amount + " successfully deposited!!");
		} else {
			System.out.println("Please enter valid amount to deposit!");
		}
	}

	public void withdraw(double amount) {
		if (amount < 0) {
			System.out.println("Enter a valid amount to withdraw");
		} else if (amount > balance) {
			System.out.println("Insufficient Funds!");
		} else {
			balance -= amount;
			System.out.println(amount + " withdraw successful ");
		}
	}

	public void checkBalance() {
		System.out.println("Balance in your account is " + balance);
	}

	public String displayAccountDetails() {
		return "Account Number :" + accountNumber + "\nCurrent balance :" + balance;
	}

}
