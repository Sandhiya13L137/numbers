<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.inautix.training.courier.domain.Employees"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body background="C:\Users\XBBNHC2\Desktop\REFERENCE\new9.jpg">
<div align="right"><a href="Index.html">Log Out</a></div>
<center><h1>EMPLOYEE LIST</h1></center>
<hr>
<%
List EmployeeList=(List)request.getAttribute("clients");
Iterator itr=EmployeeList.iterator();
%>
<table border="1">
<tr>
    <th>Employee Name</th>
    <th>Date</th>
      <th>Courier ID</th>
    <th>Amount</th>
    <th>Status</th>
</tr>
<%
while(itr.hasNext())
{
	Employees customer = (Employees)itr.next();
	%>
	<tr>
	<td><%=customer.getname() %></td>
	<td><%=customer.getdate() %></td>
	<td><%=customer.getid() %></td>
	<td><%=customer.getamount() %></td>
	<td><%=customer.getstatus() %></td>
	</tr>
	
<%   
}

%>

</table>
</body>
</html>


