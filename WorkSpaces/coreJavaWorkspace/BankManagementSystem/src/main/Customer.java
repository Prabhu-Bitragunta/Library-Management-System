package main;

public class Customer {
	private String customerName;
	private int customerId;
	private long phone;
	private String dob;
	private String gender;
	private Address address;
	private Account account;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String displayCustomerDetails() {
		return "Customer Name :" + customerName + " \nCustomer Id :" + customerId + "\n Phone Number :" + phone
				+ "\n Date of Birth :" + dob + " \nGender :" + gender + " \nAddress :" + address.displayAddress()
				+ "\n--------Account Details-------\n" + account.displayAccountDetails();
	}

}
