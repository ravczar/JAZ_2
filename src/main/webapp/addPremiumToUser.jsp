<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<form action="PremiumSettingsServlet" method="get">
		<h1>Dodaj / Usun status Premium wybranemu userowi. (Admin Only)</h1>
	<fieldset>
		<p><label>Nazwa użytkownika:<input type="text" id="username" name="username"/></label></p>
		<p><label>Dodaj :<input type="radio" name="premium" value="add"></label></p>
		<p><label>Usun :<input type="radio" name="premium" value="remove"></label></p>
		<br>
			<input name="submit" type="submit" value="submit" >
			<input name= "reset" type="reset"  value="reset" >
			<p><a href="/"><input type="button" value="Main Page"></a></p>
	</fieldset>	
	</form>
</div>	
</body>
</html>
