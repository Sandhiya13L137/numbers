package com.inautix.training.courier.demo;
import java.util.Iterator; 
import java.util.List;
import java.util.Scanner;

import com.inautix.training.courier.controller.ClientController;
import com.inautix.training.courier.dao.ClientDAO;
import com.inautix.training.courier.domain.Clients;
//import com.inautix.training.banking.domain.Customer;
public class ClientProfileForm {
	
		
		public static void main(String arg[]){
		Scanner scan= new Scanner(System.in);
		ClientController clientController =new ClientController();

		 
		 
		
			
		
		System.out.println("Enter client name:");
		String name1=scan.next();
		System.out.println("Enter password:");
		String pswd=scan.next();
		System.out.println("Enter client address:");
		String address=scan.next();
		System.out.println("Enter delivery address:");
		String address1=scan.next();
		
		Clients client1=new Clients();
		
		
		client1.setname(name1);
		client1.setpassword(pswd);
		client1.setaddress(address);
		client1.setaddress2(address1);
		clientController.createClient(client1);
			
			//clientController.deleteAllClients(client);
		// clientController.deleteClient(clientId);
		 //clientController.deleteClient(clientId);
		
		}

	}
/*public static void main(String arg[]){
	Scanner scan= new Scanner(System.in);
	CustomerController customerController =new CustomerController();

	System.out.println("Enter customer Id: ");
	int customerId=scan.nextInt();
	System.out.println("Enter customer name:");
	String customerName=scan.next();
	System.out.println("Enter customer location:");
	String customerLocation=scan.next();
	
	Customer customer = new Customer();
	
	customer.setCustomerId(customerId);
	customer.setCustomerName(customerName);
	customer.setLocation(customerLocation);
		
	customerController.createCustomer(customer);
		
		
	}
	}
*/