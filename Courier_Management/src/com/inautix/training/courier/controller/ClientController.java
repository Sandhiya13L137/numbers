package com.inautix.training.courier.controller;
import java.util.Iterator;
import java.util.List;

import com.inautix.training.courier.dao.ClientDAO;
import com.inautix.training.courier.domain.Clients;
import java.util.List;



public class ClientController{

	public void createClient(Clients client){
		
		ClientDAO clientdao = new ClientDAO();
		clientdao.createClient(client);
				
	}
	
public List getAllClients(){
	List ClientList = null;
			
		ClientDAO clientdao = new ClientDAO();
		ClientList = clientdao.getAllClients();
		
		return ClientList;
	}

}