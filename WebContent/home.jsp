<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home | Automation of Travel Agency</title>
<link rel="icon" href="css/Airplane_Blue.png" type="image/x-icon">
</head>
<body>

<%@ include file="header.html" %>
	<center>
	<%
		String name = request.getAttribute("Name").toString();
		String result = request.getAttribute("Result").toString();
		
		if(!result.equalsIgnoreCase("Fail") && result != null)
		{
			out.write("<h2>"+name+"</h2>");
			out.write("<p><h3>"+result+"</h3></p>");
		}
		else
		{
			out.write("<h2>Error :"+result+"</h2>");
		}
	
	%>
	</center>

</body>
</html>