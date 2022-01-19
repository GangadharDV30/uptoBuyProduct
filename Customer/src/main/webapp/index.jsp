<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In Page</title>
<link rel="stylesheet" href="./index.css"> 
</head>
<body class="first">
	<div  class="logo1">
	<h2 class="h2"> PS Online Shop</h2>
	<img src="Publicis_Sapient_Logo.jpg" alt="add crt logo" class="logo"></div>
		<div class="container">
		<form action="./signin" method="post">
		
			<h2>Log In Here</h2>
			
				Enter UserName : <input type="text" placeholder="UserName" name="uname" class="namepass"><br><br>
			    Enter Password :<input type="password" placeholder="Enter Password" name="pwd" class="namepass"><br><br>
				<button type="submit" class="btn">Login</button>
				<br>
				<p>If you are new user please click here to Register!!</p>
				<br>
		</form>
			<a href="./newuser.jsp">
				<button 	type="submit" class="btn">signup</button>
			</a>
	</div>
</body>
</html>
