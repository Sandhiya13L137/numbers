package com.inautix.training.courier.domain;

public class Employees {
	String pswrd;
	int cid;
	String date;
	String amount;
	String name,status;
	public void setdate(String date)
	{
		this.date=date;
	}
	public void setpswrd(String i)
	{
		this.pswrd=i;
	}
	public void setname(String name)
	{
	this.name=name;	
	}
	public void setid(int cid)
	{
		this.cid=cid;
	}
	public void setamount(String i)
	{
	this.amount=i;
	}
	public void setstatus(String status)
	{
		this.status=status;
	}
	public String getdate()
	{
		return date;
	}
	public String getpswrd()
	{
		return pswrd;
	}
	public String getname()
	{
		return name;
	}
	
	public int getid()
	{
		
		return cid;
	}
	public String getstatus()
	{
	
	return status;
	}
	public String getamount()
	{
		return amount;
	}
	
}
	