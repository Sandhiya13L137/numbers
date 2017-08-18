<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<CENTER>
<fieldset>
<legend>CONFIRMATION PAGE</legend>
<H1> Payee account number 
<%=request.getAttribute("payeeAccNum")%></H1><br><br>
<h1>amount to be transfered
<%=request.getAttribute("transferAmount")%></h1>
<form action="completeTransfer.html">
<input type="submit" class="button" value="submit">
</form>
</fieldset>
</CENTER>
</body>
</html>