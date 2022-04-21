<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="validate.js"></script>
<title>Register</title>
</head>
<style>
.error {
	color: #D8000C;
	background-color: #FFBABA;
}

body {
	font-family: "Lato", sans-serif;
}

.main-head {
	height: 150px;
	background: #FFF;
}

.sidenav {
	height: 100%;
	background-color: #000;
	overflow-x: hidden;
	padding-top: 20px;
}

.main {
	padding: 0px 10px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
}

@media screen and (max-width: 450px) {
	.login-form {
		margin-top: 10%;
	}
	.register-form {
		margin-top: 10%;
	}
}

@media screen and (min-width: 768px) {
	.main {
		margin-left: 40%;
	}
	.sidenav {
		width: 40%;
		position: fixed;
		z-index: 1;
		top: 0;
		left: 0;
	}
	.login-form {
		margin-top: 40%;
	}
	.register-form {
		margin-top: 20%;
	}
}

.login-main-text {
	margin-top: 20%;
	padding: 60px;
	color: #fff;
}

.login-main-text h2 {
	font-weight: 300;
}

.btn-black {
	background-color: #000 !important;
	color: #fff;
}
</style>
<body>
	<div class="sidenav">
		<div class="login-main-text">
			<h2>
				<br>Registration
			</h2>
			<p>Register To Login and Use Mail N Chat</p>
		</div>
	</div>
	<div class="main">
		<div class="col-md-6 col-sm-12">
			<div class="login-form">
				<form name="check" action="RegcheckServlet"
					onsubmit="return validate()" method="post">
					<div class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							name="username" placeholder="No Special Characters">
						<p
							style="text-align: center; font-family: Copperplate; font-size: 15px">
							<span class="error" id="errorname"></span>
						</p>
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="password"
							placeholder="Minimum 6 Characters">
						<p
							style="text-align: center; font-family: Copperplate; font-size: 15px">
							<span class="error" id="errorpass"></span>
						</p>
					</div>
					<div class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							name="email" placeholder="Only Gmail">
						<p
							style="text-align: center; font-family: Copperplate; font-size: 15px">
							<span class="error" id="erroremail"></span>
						</p>
					</div>
					<div class="form-group">
						<label>Phone Number</label> <input type="tel" class="form-control"
							name="phone" placeholder="Enter 10-Digit Number">
						<p
							style="text-align: center; font-family: Copperplate; font-size: 15px">
							<span class="error" id="errorphone"></span>
						</p>
					</div>
					<div class="form-group">
						<input type="submit" value="Submit">
					</div>
				</form>
				<button type="submit" class="btn btn-black"
					onclick="window.location='loginforreg.jsp'">Already User
					? Login</button>
			</div>
		</div>
	</div>
</body>
</html>
