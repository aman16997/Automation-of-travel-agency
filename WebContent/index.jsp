<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home | Automation of Travel Agency</title>
<link rel="icon" href="css/Airplane_Blue.png" type="image/x-icon">

<link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>

<!-- Header of the page -->	
<%@ include file="header.html" %>


	<div class="container">
		<header class="jumbotron">
		<div class="container">

			<div class="row">
				<h2 style="text-align: center">Login</h2>
				<div style="width: 30%; margin: 25px auto">
					
					<form action="AddUser" method="post"
						onsubmit="return validateForm()" name="myForm">
					
						<label>UserName</label>
						<div class="form-group" style="display: inline-flex">
							<input class="form-control" type="text" id="userName"
								name="userName" placeholder="Username">
						</div>
					
						<label>Password</label>
						<div class="form-group" style="display: inline-flex">
							<input class="form-control" type="text" id="userName"
								name="userName" placeholder="Username">
						</div>
					
						<div class="checkbox">
							<label> <input type="checkbox" name="remember">Remember
								me on this computer
							</label> <input class="btn btn-sml btn-primary" type="submit"
								value="LogIn">
						</div>
					</form>
				</div>
			</div>
		</div>
		<h4>
			New User? <a href="register.jsp"> Register Here</a>
		</h4>
		</p>

		<p>
		<h5>
			Forgot your Password ? <a href="forgot.jsp"> Click here to reset
				it.</a>
		</h5>
		</p>
	</div>
	</header>
	</div>


</body>
</html>