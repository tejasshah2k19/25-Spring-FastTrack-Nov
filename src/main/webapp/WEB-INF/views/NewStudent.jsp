<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.error{
		color:red;
	}
</style>
</head>
<body>
<form action="savestudent" method="post">

	FirstName: <input type="text" name="firstName"/>
	<span class="error">  
	${result.getFieldError("firstName").getDefaultMessage()}
	</span>
	<br><br>  
	LastName:<input type="text" name="lastName"/>
	${result.getFieldError("lastName").getDefaultMessage()}
	<br><br>
	Email:<input type="text" name="email"/>
	${result.getFieldError("email").getDefaultMessage()}
	<br><br>
	Password: <input type="text" name="password"/>
	${result.getFieldError("password").getDefaultMessage()}
	<br><br>
	
	<input type="submit" value="Signup"/> 
</form>
</body>
</html>