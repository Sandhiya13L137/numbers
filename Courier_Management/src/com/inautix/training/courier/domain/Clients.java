package com.inautix.training.courier.domain;

//import com.inautix.training.courier.exception.Amountpaid;


public class Clients{
	String name,address,password,address2,date;
	int id;
	//int amount,id;
	public void setid(int id)
	{
		this.id=id;
	}
	public void setaddress2(String address2)
	{
		this.address2=address2;
	}
	public void setdate(String date)
	{
		this.date=date;
	}
	public void setname(String name)
	{
	this.name=name;	
	}
	public void setpassword(String password)
	{
		this.password=password;
	}
	public void setaddress(String address)
	{
	this.address=address;
	}
	public int getid()
	{
		return id;
	}
	public String getdate()
	{
		return date;
	}
	public String getaddress2()
	{
		return address2;
	}
	public String getpassword()
	{
		return password;
	}
	
	public String getname()
	{
		
		return name;
	}
	public String getaddress()
	{
	
	return address;
	}
	
	
 /*  int a=super.getamount(amount1);
	public void compute(int a) throws Amountpaid
	{
	if(a>amount)
	{
		throw new Amountpaid();
	}
	else
	{
		System.out.println("Amount received");
	}
	}*/ }
	