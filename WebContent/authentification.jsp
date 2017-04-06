<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authentification</title>
</head>
<body>
	<form name="reg" method="post" action="AuthentificationServlet">
	<b>Sign in</b>
	<br>
	<b>Login</b>
	<input type="text" name="login">
	<br>
	<b>Password</b>
	<input type="text" name="password">
	<br>
	<input type="submit" value="Send">
	</form>
</body>
</html>