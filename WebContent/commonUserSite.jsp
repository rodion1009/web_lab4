<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.Queue" import = "java.util.ArrayList" import="ru.mirea.web.User" import="ru.mirea.web.SiteContentServlet"%>
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
		<table>
	<% 	
			for (int i = 0; i < users.size(); i++) {
	%>
				<tr><td>login: <%=users.get(i).login%></td></tr>
	<%
			}
		}
	%>
		</table>
		<form method="POST" action="SiteContentServlet">
			<input type="submit" name="btn" value="Logout">
		</form>
		<a href="SiteContentServlet">Apply changes</a>
</body>
</html>