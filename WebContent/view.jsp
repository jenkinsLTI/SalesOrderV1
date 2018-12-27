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
	</center>
	<form action="LogoutServlet" method="post">
		<table align="right">
			<tr>
				<td><input type="submit" value="Logout"></input></td>
			</tr>
		</table>
	</form>
	<form action="ViewController" method="post">
		<table align="center">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="View" /></td>
			</tr>
			<tr>
				<td><%=(request.getAttribute("errormessage") == null) ? "" : request.getAttribute("errormessage")%></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/homepage.jsp">Home</a></td>
			</tr>
		</table>

	</form>
</body>
</html>