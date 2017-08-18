package com.inautix.training.atmcashposition.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.inautix.training.atmcashposition.controller.CashController;
import com.inautix.training.atmcashposition.domain.Cash;

public class CashUpdateFrom {
	public static void main(String args[]){
	Scanner scan = new Scanner(System.in);
	CashController cashController = new CashController();
	
	System.out.println("Enter the type of note to be updated:");
	int note=scan.nextInt();
	System.out.println("enter the number of notes");
	int amount = scan.nextInt();
	
	List CashList =cashController.getCashUpdate(note,amount);
	System.out.println("updated cash list");
	Iterator itr = CashList.iterator();
	while(itr.hasNext()){
		Cash cash = (Cash)itr.next();
		System.out.println("number of "+cash.getNote()+" : "+cash.getAmount());
		scan.close();
	}
	
}
}
