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
 <form action="TranctionServlet" method="post"> 
<h1>enter the amount needed</h1>
<% 
CashDAO cashDAO = new CashDAO();
Cash cash1 = cashDAO.getCashDetails(100);
%>
<h1>number of 100 note is 
<%=cash1.getAmount() %></h1>
<input type="text" name="100" value="0">

<%Cash cash2 = cashDAO.getCashDetails(500); 
%>
<h1>number of 500 note is
<%=cash2.getAmount() %></h1>
<input type="text" name="500" value="0">

<%Cash cash3 = cashDAO.getCashDetails(1000); 
%>
<h1>number of 1000 note is
<%=cash3.getAmount() %></h1>
<input type="text" name="1000" value="0">

<%Cash cash4 = cashDAO.getCashDetails(2000); 
%>
<h1>number of 2000 note is
<%=cash4.getAmount() %></h1>
<input type="text" name="2000" value="0"><br>
	


	<input type="submit" class="button" value="submit" >
	</form>	
	
</center>



</body>
</html>