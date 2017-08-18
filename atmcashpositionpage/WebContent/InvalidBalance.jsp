<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="style.css">
<center>
<h1>Sorry your transaction cannot be performed</h1>
<h2>your balance is
<%=  request.getAttribute("Balance")  %></h2>
<br><br>
<form action="AtmLoginPage.html">
<input type="submit" class="button" value="submit" formaction="AtmLoginPage.html" >
</form>
</center>
</body>
</html>