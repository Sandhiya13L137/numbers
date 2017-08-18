package com.inautix.training.atmcashposition.demo;

import java.util.Scanner;

import com.inautix.training.atmcashposition.controller.CashController;
import com.inautix.training.atmcashposition.domain.Cash;

public class CashPositionFrom {
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		CashController cashController = new CashController();
		
		System.out.println("Type of note");
		int note = scan.nextInt();
		System.out.println("number of notes");
		int amount = scan.nextInt();
		
		Cash cash = new Cash();
		
		cash.setNote(note);
		cash.setAmount(amount);
		cashController.createCashPosition(cash);
		scan.close();
	}

}
