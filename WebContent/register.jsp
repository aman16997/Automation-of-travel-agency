<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Automation | SignUp</title>
<link rel="icon" href="css/Airplane_Blue.png" type="image/x-icon">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


</head>
<body>

	<%@ include file="header.html"%>

	<div class="container">
		<div class="jumbotron">
			<div class="row">
				<h2 style="text-align: center">Sign Up Here</h2>
				<div style="width: 30%; margin: 25px auto">
				<!-- Form -->
					<form action="SignUp" method="post" onsubmit="return validateForm()"
						name="myForm">

						<!-- First Name -->
						<div class="form-group">
							<div class="input-group">
								<input class="form-control" id="firstName" name="firstName"
									type="text" placeholder="First Name" required />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-user"></span>
								</div>
							</div>
						</div>

						<!-- Last Name -->
						<div class="form-group">
							<div class="input-group">
								<input class="form-control" id="lastName" name="lastName"
									type="text" placeholder="Last Name" required />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-user"></span>
								</div>
							</div>
						</div>

						<!-- Date of Birth  -->
						<div class="form-group">
							<div class="input-group">
								<input class="form-control" id="lastName" name="lastName"
									type="date" placeholder="Date of Birth" required />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-calendar"></span>
								</div>
							</div>
						</div>

						<!-- Gender -->
						<div class="form-group form-inline">
							<label for="gender">Gender </label>
							<div class="radio">
								<label> <input type="radio" name="gender" value="Male"
									required="false" />&nbsp&nbsp&nbspMale&nbsp&nbsp&nbsp
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="gender" value="Female"
									required="false" />&nbsp&nbsp&nbspFemale
								</label>
							</div>
						</div>



						<!-- Email -->
						<div class="form-group">
							<div class="input-group">
								<input class="form-control" id="email" name="email" type="email"
									placeholder="Email Address" required />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-envelope"></span>
								</div>
							</div>
						</div>

						<!-- Password -->
						<div class="form-group">
							<div class="input-group">
								<input class="form-control" id="password" name="password"
									type="password" placeholder=" New Password" required />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-eye-open"></span>
								</div>
							</div>
						</div>
						<!-- Confirm Password -->
						<div class="form-group">
							<div class="input-group">
								<input class="form-control" id="confirm_password"
									name="confirm_password" type="password"
									placeholder="Confirm Password" required />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-eye-open"></span>
								</div>
							</div>
						</div>


						<!-- Street -->
						<div class="form-group">
							<div class="input-group">
								<input class="form-control" id="street" name="street"
									type="text" placeholder="Street" required />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-road"></span>
								</div>
							</div>
						</div>

						<!-- Location -->
						<div class="form-group">
							<div class="input-group">
								<input class="form-control" id="location" name="location"
									type="text" placeholder="Location" required />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-home"></span>
								</div>
							</div>
						</div>

						<!-- City -->
						<div class="form-group">
							<div class="input-group">
								<input class="form-control" id="city" name="city" type="text"
									placeholder="City" required />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-signal"></span>
								</div>
							</div>
						</div>

						<!-- Select State -->
						<div class="form-group">
							<div class="input-group">
								<select name="state" class="form-control selectpicker"
									required="false">
									<option value=" ">Please select your state</option>
									<option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
									<option value="Andhra Pradesh">Andhra Pradesh</option>
									<option value="Arunachal Pradesh">Arunachal Pradesh</option>
									<option value="Assam">Assam</option>
									<option value="Bihar">Bihar</option>
									<option value="Chandigarh">Chandigarh</option>
									<option value="Chhattisgarh">Chhattisgarh</option>
									<option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>
									<option value="Daman and Diu">Daman and Diu</option>
									<option value="Delhi">Delhi</option>
									<option value="Goa">Goa</option>
									<option value="Gujarat">Gujarat</option>
									<option value="Haryana">Haryana</option>
									<option value="Himachal Pradesh">Himachal Pradesh</option>
									<option value="Jammu and Kashmir">Jammu and Kashmir</option>
									<option value="Jharkhand">Jharkhand</option>
									<option value="Karnataka">Karnataka</option>
									<option value="Kerala">Kerala</option>
									<option value="Lakshadweep">Lakshadweep</option>
									<option value="Madhya Pradesh">Madhya Pradesh</option>
									<option value="Maharashtra">Maharashtra</option>
									<option value="Manipur">Manipur</option>
									<option value="Meghalaya">Meghalaya</option>
									<option value="Mizoram">Mizoram</option>
									<option value="Nagaland">Nagaland</option>
									<option value="Orissa">Orissa</option>
									<option value="Pondicherry">Pondicherry</option>
									<option value="Punjab">Punjab</option>
									<option value="Rajasthan">Rajasthan</option>
									<option value="Sikkim">Sikkim</option>
									<option value="Tamil Nadu">Tamil Nadu</option>
									<option value="Tripura">Tripura</option>
									<option value="Uttaranchal">Uttaranchal</option>
									<option value="Uttar Pradesh">Uttar Pradesh</option>
									<option value="West Bengal">West Bengal</option>
								</select> <span class="input-group-addon"><i
									class="glyphicon glyphicon-list"></i></span>
							</div>
						</div>

						<!-- PinCode -->
						<div class="form-group">
							<div class="input-group">
								<input class="form-control" id="pincode" name="pincode"
									type="text" placeholder="PinCode" required />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-random"></span>
								</div>
							</div>
						</div>

						<!-- Mobile Number -->
						<div class="form-group">
							<div class="input-group">
								<input class="form-control" id="mobileNumber"
									name="mobileNumber" type="text" placeholder="Contact No."
									required />
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-phone"></span>
								</div>
							</div>
						</div>


						<!-- Submit Button -->
						<div class="form-group">
							<input class="btn btn-lg btn-primary btn-block" type="submit"
								value="Submit">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>