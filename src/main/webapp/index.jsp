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
	<form action="index" method="get">
			
		<fieldset>
		<legend> Command Center: </legend>
			<p><a href="/login.jsp"><input type="button" value="Kliknij by sie zalogowac"></a></p>
			
			<p><a href="/register.jsp"><input type="button" value="Kliknij by sie zarejestrowac"></a></p>
			
			<p><a href="/UserProfileServlet"><input type="button" value="Kliknij by przejsc na swoj profil"></a></p>
	
			<p><a href="/ShowAllUsersServlet"><input type="button" value="Wszyscy uzytkownicy"></a></p>
		
			<p><a href="premiumZone.jsp"><input type="button" value="Kliknij by przejsc do strefy Premium"></a></p>
			
			<p><a href="addPremiumToUser.jsp"><input type="button" value="Ustaw komus Premium"></a></p>

		</fieldset>
		
	</form>
</div>
</body>
</html>