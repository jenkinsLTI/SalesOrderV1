<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>

		<h3>Sales Order Application</h3>
		Welcome ${requestScope['user'].username}.


		<form action="LogoutServlet" method="post">
			<table align="right">
				<tr>
					<td><input type="submit" value="Logout" align="right"></input></td>
				</tr>
			</table>

		</form>
		<form>
			<table align="center">
				<tr>
					<td><a href="register.jsp">Click here to place order</a></td>
				</tr>
			</table>

			<table align="center">
				<tr>
					<td><a href="view.jsp">Click here to view order</a></td>
				</tr>
			</table>

		</form>
	</center>
</body>
</html>