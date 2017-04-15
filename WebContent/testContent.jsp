<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.Queue" import = "java.util.LinkedList" import="ru.mirea.web.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="userss" class="java.util.LinkedList" scope="request"/> 
	<% 
		session.getAttribute("users");
		Object obj = session.getAttribute("users");
		Queue<User> users = obj == null ? null : (LinkedList<User>)obj;
		if (obj != null) {
	%>
		<table>
	<% 	
			while(!users.isEmpty()) {
				User user = users.poll();
	%>
	
				<tr><td>login: <%=user.login%></td></tr>
	<%
			}
		}
	%>
		</table>
	
		<!--  <c: foreach items=${users} var="u">
		<tr><td>login: ${u.login}</td></tr></c:> -->
</body>
</html>