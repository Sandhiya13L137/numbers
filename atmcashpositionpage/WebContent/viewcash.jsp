<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="com.inautix.training.atmcashposition.dao.CashDAO"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.Iterator" %>
    <%@ page import="com.inautix.training.atmcashposition.domain.Cash" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="style.css">
<center>
<%
CashDAO cashDAO = new CashDAO();
List cashList=cashDAO.getAllCashPosition();
Iterator itr = cashList.iterator();
%>
<h1>AVAILABLE CASH ARE</h1>
<%
while(itr.hasNext())
{
	Cash cash = (Cash)itr.next();
	%>
	<h1>NUMBER OF <%=cash.getNote() %> is <%=cash.getAmount() %></h1>
	
	<%
}
	%>
	<FORM ACTION="AdminService.html" method="post">
	<input type="submit" class="button" value="BACK" formaction="AdminService.html">
	</FORM>
	</center>
</body>
</html>