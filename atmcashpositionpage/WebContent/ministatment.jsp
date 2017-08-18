<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.inautix.training.atmcashposition.domain.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
Customer cus = (Customer)request.getAttribute("customer");

%>
<center>
<fieldset>
<legend>WELCOME <%=cus.getCusname() %></legend>
<h1> YOUR ACCOUNT DETAILS <BR><BR>ACCOUNT TYPE  :
<%=cus.getAcctype() %><br><br>
ACCOUNT NUMBER : <%=cus.getAccnum() %><br><br>
BALANCE : <%=cus.getBalance() %>  </h1>

</fieldset>
<form action="Option.html">
<input type="submit" class="button" value="submit">
</form>
</center>
</body>
</html>