<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="./mail" method="post">
		To:<input type="text" name="to" /><br /> Subject:<input type="text"
			name="subject" /><br /> Message:<input type="text" name="message" /><br />
		Your Email id:<input type="text" name="user"><br /> Password<input
			type="password" name="pass" /><br /> <input type="submit"
			value="send" />
	</form>

</body>
</html>