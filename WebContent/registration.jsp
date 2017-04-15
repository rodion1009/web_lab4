<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Registration</title>
</head>
<body>
	<form name="reg" method="POST" action="MainServlet" onSubmit="validate()">
		<b>Please, enter new login and password</b>
		<br>
		<b>Login</b>
		<input type="text" name="login" id="NameInput" />
		<br>
		<b>Password</b>
		<input type="text" name="password" id="PasswordInput" />
		<br>
		<input type="radio" name="type" value="common" checked>Обычный пользователь<br>
		<input type="radio" name="type" value="admin">Администратор<br>
		<input type="submit" value="Send" />
	</form>
</body>
<script>
	function validate() {
		var inputName = document.getElementById("NameInput");
		var inputPassword = document.getElementById("PasswordInput");
		
		if (inputName.value.search(/\W/) != -1 || inputName.value == '') {
			alert("Error: empty field or unacceptable symbol in login! It can only contain latin lettern, digits and '_' sign.");
			this.event.stopPropagation(true);
			this.event.preventDefault();
			return false;
		}
		
		if (/.{6,20}/.test(inputPassword.value) == false) {
			alert("Error: empty password field or too short password (must be 6-20 symbols)");
			this.event.stopPropagation(true);
			this.event.preventDefault();
			return false;
		}
		
	}

</script>
</html>