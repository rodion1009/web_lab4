<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="ru.mirea.web.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		ArrayList<User> users = SiteContentServlet.getUsers();
		if (users != null) {
	%>
		<form method="POST" action="SiteContentServlet">
	<% 	
			for (int i = 0; i < users.size(); i++) {
	%>
				<input type="radio" name="user" value=<%= users.get(i).login %>><%= users.get(i).login %><br>
	<%
			}
		}
	%>
			<input type="submit" name="btn" value="Delete">
			<br>
			<input type="submit" name="btn" value="Logout">
		</form>
</body>
</html>