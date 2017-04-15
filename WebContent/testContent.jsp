<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.Queue" import = "java.util.ArrayList" import="ru.mirea.web.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="userss" class="java.util.ArrayList" scope="request"/> 
	<% 
		session.getAttribute("users");
		Object obj = session.getAttribute("users");
		ArrayList<User> users = obj == null ? null : (ArrayList<User>)obj;
		if (obj != null) {
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
	
		<!--  <c: foreach items=${users} var="u">
		<tr><td>login: ${u.login}</td></tr></c:> -->
</body>
</html>