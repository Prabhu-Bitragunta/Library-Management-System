package main;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	public static final String bankName = "Pradeep Bank of India";
	private List<Customer> customers = new ArrayList<>();

	public void addCustomer(Customer customer) {
		customers.add(customer);
		System.out.println("Added Successfully!");
	}

	public Customer searchCustomer(long id) {
		for (Customer c : customers) {
			if (c.getCustomerId() == id) {
				return c;
			}
		}
		return null;
	}

	public String deleteCustomer(long id) {
		Customer c = searchCustomer(id);
		if (c != null) {
			customers.remove(c);
			return "Delete Done";
		}

		return "Account Not Found to delete";
	}

	public void displayAllCustomers() {
		if (customers.isEmpty()) {
			System.out.println("No customers are there!!");
		} else {
			for (Customer c : customers) {
				System.out.println("Details are below");
				System.out.println(c.displayCustomerDetails());
			}
		}
	}

}
