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
		<%=(request.getAttribute("loginerror") == null) ? "" : request.getAttribute("loginerror")%>
		<%=(request.getAttribute("registererror") == null) ? "" : request.getAttribute("registererror")%>
		<%=(request.getAttribute("viewerror") == null) ? "" : request.getAttribute("viewerror")%>
		<%=(request.getAttribute("registerloginerror") == null) ? "" : request.getAttribute("registerloginerror")%>
		<%=(request.getAttribute("viewloginerror") == null) ? "" : request.getAttribute("viewloginerror")%>
	</center>
</body>
</html>