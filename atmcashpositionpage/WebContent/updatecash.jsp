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
<fieldset>
<FORM ACTION="updatecashservlet" method="post">
<legend>TO UPDATE CASH POSITION</legend>
<H1>NUMBER OF 100 NOTE IS</H1><BR>
<input type="text" name="100">
<H1>NUMBER OF 500 NOTE IS</H1><BR>
<input type="text" name="500">
<H1>NUMBER OF 1000 NOTE IS</H1><BR>
<input type="text" name="1000">
<H1>NUMBER OF 2000 NOTE IS</H1><BR>
<input type="text" name="2000">
</fieldset>

<input type="submit"  value="update" class="button" formaction="updatecashservlet">
</FORM>
</body>
</html>