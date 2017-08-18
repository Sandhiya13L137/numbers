<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.inautix.training.courier.domain.Clients"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="C:\Users\XBBNHC2\Desktop\REFERENCE\new13.jpg">
<div align="right"><a href="Index.html">Log Out</a></div>
<center><h1>CLIENT LIST</h1></center>
<%
List ClientList=(List)request.getAttribute("clients");
Iterator itr=ClientList.iterator();
%>
<table border="1">
<tr>
    <th>Client ID</th>
    <th>Client Name</th>
    <th>Date</th>
    <th>Password</th>
      <th>Client Address</th>
      <th>Delivery Address</th>
    
</tr>
<%
while(itr.hasNext())
{
	Clients customer = (Clients)itr.next();
	%>
	<tr>
	<td><%=customer.getid() %></td>
	<td><%=customer.getname() %></td>
	<td><%=customer.getdate() %></td>
	<td><%=customer.getpassword() %></td>
	<td><%=customer.getaddress() %></td>
	<td><%=customer.getaddress2() %></td>
	
	</tr>
	
<%   
}

%>

</table>
</body>