<%@ page language = "java" contentType = "text/html; charset=UTF-8"
	pageEncoding = "UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO8859-1">
<title>Registration Form</title>
</head>
<body>
<div align="center">
	<form action="register" method="get">
		<fieldset>
		 <br><br>
		 <legend> REGISTER NEW USER </legend>
		   <h2> <font color = "red">Type in following data and press submit to register </font></h2>
		   <p><label>USERNAME :<input type="text" id="username" name="username"/></label></p>
		   <p><label>PASSWORD :<input type="password" id="password" name="password"/></label></p>
		   <p><label>CONFIRM PW :<input type="password" id="conpassword" name="conpassword"/></label></p>
		   <p><label>EMAIL :<input type="text" id="email" name="email"/></label></p>
		  <br>
			<input name="submit" type="submit" value="submit" >
			<input name= "reset" type="reset"  value="reset" >
			<br><br>
			<h2> <font color = "red">Already got account? Log in here:</font></h2>
			<a href="/login.jsp"><input type="button" value="Log In"></a>
			<a href="/"><input type="button" value="Main Page"></a>
		</fieldset>
	</form>
</div>
</body>
</html>