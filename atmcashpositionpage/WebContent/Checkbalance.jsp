<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.inautix.training.atmcashposition.dao.CustomerDAO"%>
    <%@ page import="com.inautix.training.atmcashposition.domain.Customer" %>
    <%@ page import="javax.servlet.http.HttpSession" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<CENTER>
<form action="Option.html" method="post">
<FIELDSET>
<h1>YOUR CURRENT BALANCE
<%=request.getAttribute("newBalance")
%></h1>
</FIELDSET>
<input type="submit" class="button" value="submit">
</form>
</CENTER>
</body>
</html>