<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View order</title>
</head>
<body>
	<center>
		<h3>Sales Order Application</h3>
	</center>

	<form action="LogoutServlet" method="post">
		<table align="right">
			<tr>
				<td><input type="submit" value="Logout"></input></td>
			</tr>
		</table>
	</form>

	<table align="center">
		<tr>
			<td>Firstname</td>
			<td><%=(request.getAttribute("fn") == null) ? "" : request.getAttribute("fn")%></td>
		</tr>
		<tr>
			<td>Lastname</td>
			<td><%=(request.getAttribute("ln") == null) ? "" : request.getAttribute("ln")%></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><%=(request.getAttribute("a") == null) ? "" : request.getAttribute("a")%></td>
		</tr>
		<tr>
			<td>Product</td>
			<td><%=(request.getAttribute("p") == null) ? "" : request.getAttribute("p")%></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><%=(request.getAttribute("q") == null) ? "" : request.getAttribute("q")%></td>
		</tr>
		<tr>
			<td><a href="${pageContext.request.contextPath}/homepage.jsp">Home</a></td>
		</tr>
	</table>
</body>
</html>