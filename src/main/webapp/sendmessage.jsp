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
        margin-top: 20%;
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
.form-control {
   max-width: 100%;
}
</style>

<meta charset="ISO-8859-1">
<title>Send Message</title>
<script>
	if(!(~document.cookie.indexOf("em=") && ~document.cookie.indexOf("pwd="))){
		location.href="http://localhost:8085/registration/loginforreg.jsp";
	}
</script>
<script>
function cookiefind(){
	if(!(~document.cookie.indexOf("em=") && ~document.cookie.indexOf("pwd="))){
		location.href="http://localhost:8085/registration/loginforreg.jsp";
	}
}
</script>
</head>
<body>
<div class="sidenav">
         <div class="login-main-text">
         <h1><br>Chat</h1>
            <h2><br> Compose an E-Message</h2>
            <p>Super Fast ! Safer ! Secure</p>
         </div>
      </div>
	
	
	<div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
		<form name="sendmsg" action="SendServlet" method="get">
		<div class="form-group">
		<label>Enter Email To:</label>
                     <input id="to" type="text" class="form-control"  onClick="cookiefind()" name="mail" placeholder="Enter To Mail Id:" required>
                  </div>
                   <div class="form-group">
                 
                     <label class="form-label">Message:</label>
                    <textarea class="form-control"  id="word" name="msgarea" onClick="cookiefind()" placeholder="Enter Message:" rows="10" cols="50" required></textarea>
                  
                  </div>
                  <button type="submit"  class="btn btn-black">Send</button>
               </form>
            </div>
         </div>
      </div>


	
</body>

</html>