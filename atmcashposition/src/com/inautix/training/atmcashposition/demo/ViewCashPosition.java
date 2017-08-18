package com.inautix.training.atmcashposition.demo;

import java.util.Scanner;

import com.inautix.training.atmcashposition.controller.CashController;
import com.inautix.training.atmcashposition.domain.Cash;

public class ViewCashPosition {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		CashController cashController = new CashController();
		System.out.println("Enter the cash you need");
		int note=scan.nextInt();
		
		Cash cash=cashController.getCashDetails(note);
		System.out.println("the number of"+note+" is:"+cash.getAmount());
		scan.close();
	}

}
