<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="cookie.js"></script>
<style>
body {
    font-family: "Lato", sans-serif;
}
.main-head{
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
    .sidenav {padding-top: 15px;}
}

@media screen and (max-width: 450px) {
    .login-form{
        margin-top: 10%;
    }

    .register-form{
        margin-top: 10%;
    }
}
@media screen and (min-width: 768px){
    .main{
        margin-left: 40%; 
    }

    .sidenav{
        width: 40%;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
    }

    .login-form{
        margin-top: 80%;
    }

    .register-form{
        margin-top: 20%;
    }
}
.login-main-text{
    margin-top: 20%;
    padding: 60px;
    color: #fff;
}

.login-main-text h2{
    font-weight: 300;
}

.btn-black{
    background-color: #000 !important;
    color: #fff;
} 
</style>
<script>
function myFunction() {
	  var x = document.getElementById("pin");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
</script>
</head>
<body onLoad="cookiefind()">
<div class="sidenav">
         <div class="login-main-text">
         <h1><br>Welcome To Mail N chat</h1>
            <h2><br> Login Page</h2>
            <p>Login To Use Mail N Chat</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
            
               <form name="checkdb" action="CheckdbServlet"  method="post">
                  <div class="form-group">
                     <label>Email</label>
                     <input id="ein" type="text" class="form-control"  name="email" placeholder="Email" required>
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input id="pin" type="password" class="form-control" name="password" placeholder="Password" required>
                  </div>
                  <input type="checkbox" onclick="myFunction()">Show Password <br><br>
                  <button type="submit"  class="btn btn-black">Login</button>
               </form>
            </div>
         </div>
      </div>
</body>
</html>
