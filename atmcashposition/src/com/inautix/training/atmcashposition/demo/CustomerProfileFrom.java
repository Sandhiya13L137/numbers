package com.inautix.training.atmcashposition.demo;

import java.util.Scanner;

import com.inautix.training.atmcashposition.controller.CustomerController;
import com.inautix.training.atmcashposition.domain.Customer;

public class CustomerProfileFrom {
	public static void main(String args[]){
		
		Scanner scan = new Scanner(System.in);
		CustomerController customerController = new CustomerController();
		System.out.println("Enter your card number:");
		int cardnum=scan.nextInt();
		System.out.println("Enter your pin number:");
		int pinnum=scan.nextInt();
		Customer customer = customerController.getCostumerDetails(cardnum);
	
		System.out.println("WELCOME "+customer.getCusname());
		System.out.println("Your account details");
		System.out.println("ACCOUNT NUMBER:"+customer.getAccnum());
		System.out.println("ACCOUNT TYPE:"+customer.getAcctype());
	}

}
