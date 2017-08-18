
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.inautix.training.courier.domain.Employees"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Please check your status here...!!</h1></center>
<table border="1">
<tr>
    <th>Employee Name                 </th>
     <th>Date               </th> 
     <th>ID</th>
    <th>Amount</th>
    <th>Status</th>
</tr>

<%
Employees customer=new Employees();
Employees s=(Employees)request.getAttribute("m");

       %>
       <tr>
       <td><%=s.getname() %></td>
	<td><%=s.getdate() %></td>
	<td><%=s.getid() %></td>
	<td><%=s.getamount() %></td>
	<td><%=s.getstatus()%></td>
	</tr>
</table><br><br>
</body>
</html>