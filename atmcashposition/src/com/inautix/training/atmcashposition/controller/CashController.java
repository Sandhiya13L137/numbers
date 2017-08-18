package com.inautix.training.atmcashposition.controller;

import java.util.List;

import com.inautix.training.atmcashposition.dao.CashDAO;
import com.inautix.training.atmcashposition.domain.Cash;
import com.inautix.training.atmcashposition.domain.Customer;

public class CashController {

	public void createCashPosition(Cash cash){
		CashDAO cashDao = new CashDAO();
		cashDao.createCashPosition(cash);
	}
	public List getAllCashPosition(){
		List CashList = null;
		CashDAO cashDao = new CashDAO();
		CashList=cashDao.getAllCashPosition();
		return CashList;
		
	}
	public Cash getCashDetails(int note) {
		// TODO Auto-generated method stub
		Cash cash= null;
		CashDAO cashDao = new CashDAO();
		cash = cashDao.getCashDetails(note);
		return cash;
	}
	public List getCashUpdate(int note ,int amount){
		List CashList = null;
		CashDAO cashDao = new CashDAO();
		CashList = cashDao.getCashUpdate(note, amount);
		return CashList;
	}
	public List getCashDelete(int note){
		List CashList = null;
		CashDAO cashDao = new CashDAO();
		CashList = cashDao.getCashDelete(note);
		return CashList;
	}

	
}
