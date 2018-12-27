<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order success</title>
</head>
<body>
	<center>
		<h3>Sales Order Application</h3>

		<form action="LogoutServlet" method="post">
			<table align="right">
				<tr>
					<td><input type="submit" value="Logout"></input></td>
				</tr>
			</table>
		</form>
		Order Placed Successfully!

		<table align="center">
			<tr>
				<td>Your Order ID</td>
				<td><%=(request.getAttribute("id") == null) ? "" : request.getAttribute("id")%></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/homepage.jsp">Home</a></td>
				<td><a href="${pageContext.request.contextPath}/view.jsp">View</a></td>
			</tr>
		</table>
	</center>
</body>
</html>