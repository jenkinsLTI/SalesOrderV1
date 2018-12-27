
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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
		<form name="form" action="RegisterServlet" method="post">

			<input type="hidden" value=""></input>
			<table align="center">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastname" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><textarea rows="4" cols="50" name="address"></textarea></td>
				</tr>
				<tr>
					<td>Product</td>
					<td><select name="product">
							<option value="iPhone">iPhone</option>
							<option value="iPod">iPod</option>
							<option value="TV">TV</option>
							<option value="Watch">Watch</option>
					</select></td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><input type="text" name="quantity" /></td>
				</tr>
				<tr>
					<td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register"></input> <input
						type="reset" value="Reset"></input></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>