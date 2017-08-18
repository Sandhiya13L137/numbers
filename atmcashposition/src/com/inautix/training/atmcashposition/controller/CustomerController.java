package com.inautix.training.atmcashposition.controller;

import java.util.List;

import com.inautix.training.atmcashposition.dao.CashDAO;
import com.inautix.training.atmcashposition.dao.CustomerDAO;
import com.inautix.training.atmcashposition.domain.Cash;
import com.inautix.training.atmcashposition.domain.Customer;


public class CustomerController {
	public Customer getCostumerDetails(int cardnum ) {
		// TODO Auto-generated method stub
		Customer customer= null;
		CustomerDAO customerDao = new CustomerDAO();
		customer = customerDao.getCostumerDetails(cardnum );
		return customer;
	}
	
}
