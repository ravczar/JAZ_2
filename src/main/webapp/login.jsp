<%@ page language = "java" contentType = "text/html; charset=UTF-8"
	pageEncoding = "UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO8859-1">
<title>LOG IN</title>
</head>
<body>
<div align="center">
	<form action="login" method="get">
		<fieldset>
		 <br><br>
		 <legend> WANNA LOG IN?? </legend>
		
		   <p><label>USERNAME :<input type="text" id="username" name="username"/></label></p>
		   <p><label>PASSWORD :<input type="password" id="password" name="password"/></label></p>
		  <br>
			<input name="submit" type="submit" value="submit" >
			<input name= "reset" type="reset"  value="reset" >
			<br><br>
			<h2> <font color = "red">Don't have an account? Register Here: </font></h2>
			<a href="/register.jsp"><input type="button" value="Register"></a>
			<a href="/"><input type="button" value="Main Page"></a>
		</fieldset>
		
				
	</form>
</div>
</body>
</html>