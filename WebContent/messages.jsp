<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comments</title>
</head>
<body>
	<div id="messages"></div>
	<form action="MessagesServlet" method="POST">
		Your message: <input type="text" name="message"/>
		<input type="submit" value="Send"/>
	</form>
	<script>
	setInterval(getFromServer, 1000);
	
	function getFromServer() {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.status === 200) {
				var messages = document.getElementById("messages");
				messages.innerHTML = xhr.responseText;
			}
		}
		xhr.open("GET", "MessagesServlet", true);
		xhr.send();
	}
	</script>
</body>
</html>