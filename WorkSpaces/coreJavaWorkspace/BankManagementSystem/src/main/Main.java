package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bank b = new Bank();
		int choice;
		do {
			System.out.println("--------------------------------------");
			System.out.println("Welcome to Pradeep Bank of India!!");
			System.out.println("1. Add Customer");
			System.out.println("2. Search Customer");
			System.out.println("3. Display All Customers");
			System.out.println("4. Delete Customer");
			System.out.println("5. Deposit Money");
			System.out.println("6. Withdraw Money");
			System.out.println("7. Check Balance");
			System.out.println("8. Exit");
			System.out.println("Enter Your Choice :");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Customer customer = new Customer();
				Address address = new Address();
				Account account = new Account();
				System.out.println("-------Your Details-------");
				sc.nextLine();
				System.out.println("Enter customer name :");
				customer.setCustomerName(sc.nextLine());
				System.out.println("Enter customer Id :");
				customer.setCustomerId(sc.nextInt());
				System.out.println("Enter customer Gender :");
				customer.setGender(sc.next());
				System.out.println("Enter phone Number :");
				customer.setPhone(sc.nextLong());
				sc.nextLine();
				System.out.println("Enter DOB (dd-mm-yyyy) :");
				customer.setDob(sc.nextLine());
				System.out.println("-------Address Details-------");
				System.out.println("Enter Door Number :");
				address.setDoorNo(sc.nextLine());
				System.out.println("Enter State :");
				address.setState(sc.nextLine());
				System.out.println("Enter District :");
				address.setDistrict(sc.nextLine());
				System.out.println("Enter city :");
				address.setCity(sc.nextLine());
				System.out.println("Enter village :");
				address.setVillage(sc.nextLine());
				System.out.println("Enter Pincode :");
				address.setPincode(sc.nextLong());
				customer.setAddress(address);
				customer.setAccount(account);
				b.addCustomer(customer);
				System.out.println("--------------------------------------");
				break;
			case 2:
				System.out.println("Enter Customer Id to search :");
				Customer c = b.searchCustomer(sc.nextLong());
				if (c != null) {
					System.out.println(c.displayCustomerDetails());
				} else
					System.out.println("No customer found !!");
				System.out.println("--------------------------------------");
				break;
			case 3:
				System.out.println("All the Customers in PBI :");
				b.displayAllCustomers();
				System.out.println("--------------------------------------");
				break;
			case 4:
				System.out.println("Enter Customer Id :");
				int id = sc.nextInt();
				System.out.println( b.deleteCustomer(id));
				System.out.println("--------------------------------------");
				break;
			case 5:
				System.out.println("Enter your customer id :");
				int cid = sc.nextInt();
				Customer c1 = b.searchCustomer(cid);
				if (c1 != null) {
					System.out.println("Enter amount to deposit :");
					double amount = sc.nextDouble();
					c1.getAccount().deposit(amount);

				} else {
					System.out.println("No Account found with that Customer ID");
				}
				System.out.println("--------------------------------------");
				break;
			case 6:
				System.out.println("Enter your customer id :");
				int aid = sc.nextInt();
				Customer c2 = b.searchCustomer(aid);
				if (c2 != null) {
					System.out.println("Enter amount to withdraw :");
					double amount = sc.nextDouble();
					c2.getAccount().withdraw(amount);

				} else {
					System.out.println("No Account found with that Customer ID");
				}
				System.out.println("--------------------------------------");
				break;
			case 7:
				System.out.println("Enter your customer id :");
				int id1 = sc.nextInt();
				Customer c3 = b.searchCustomer(id1);
				if (c3 != null) {
					c3.getAccount().checkBalance();;

				} else {
					System.out.println("No Account found with that Customer ID");
				}
				System.out.println("--------------------------------------");
				break;
			case 8:
				System.out.println("Thank You for choosing Pradeep Bank of India!!");
				System.out.println("visit again!!!");
				break;

			default:
				System.out.println("Invalid choice Idiot!!!");

			}

		} while (choice != 8);
	}
}
