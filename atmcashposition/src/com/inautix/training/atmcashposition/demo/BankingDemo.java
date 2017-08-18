package com.inautix.training.atmcashposition.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.inautix.training.atmcashposition.controller.CashController;
import com.inautix.training.atmcashposition.dao.CustomerDAO;
//import com.inautix.training.atmcashposition.controller.CustomerController;
import com.inautix.training.atmcashposition.domain.Cash;
//import com.inautix.training.atmcashposition.domain.Customer;

public class BankingDemo {
	public static void main(String args[]){
		/*CustomerController customerController = new CustomerController();
		List customerAccList = customerController.getAccDetails(123);
		Iterator itr = customerAccList.iterator();
		 while(itr.hasNext()){
			 Customer customer1 =(Customer)itr.next();
			 System.out.println("Account Number: "+customer1.getAccnum());
			 System.out.println("Account type: "+customer1.getAcctype());
			 System.out.println("balance: "+customer1.getBalance());
			 
			 
		 }*/
		/*System.out.println("Available cash are");
		CashController cashController = new CashController();
		List CashList = cashController.getAllCashPosition();
		Iterator itr = CashList.iterator();
		while(itr.hasNext()){
			Cash cash = (Cash)itr.next();
			System.out.println("number of "+cash.getNote()+" : "+cash.getAmount());
		}*/
		Scanner scan = new Scanner(System.in);
		System.out.println("cardnum");
		int cardnum=scan.nextInt();
		CustomerDAO cusDAO = new CustomerDAO();
		boolean auth=cusDAO.getCostumerDetail(cardnum);
		System.out.println(auth);
		
	}

}
