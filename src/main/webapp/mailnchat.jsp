<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="cookie.js"></script>
<style>
body {
  margin: 0;
  font-family: "Lato", sans-serif;
}

.sidebar {
  margin: 0;
  padding: 0;
  width: 200px;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
}

.sidebar a {
  display: block;
  color: black;
  padding: 16px;
  text-decoration: none;
}
 
.sidebar a.active {
  background-color: #000000;
  color: white;
}

.sidebar a:hover:not(.active) {
  background-color: #555;
  color: white;
}

div.content {
  margin-left: 200px;
  padding: 1px 16px;
  height: 1000px;
  text-align: center;
}

@media screen and (max-width: 700px) {
  .sidebar {
    width: 100%;
    height: auto;
    position: relative;
  }
  .sidebar a {float: left;}
  div.content {margin-left: 0;}
}

@media screen and (max-width: 400px) {
  .sidebar a {
    text-align: center;
    float: none;
  }
}
h1{
text-align:center;
}
.find {
  position: fixed;
  left: 3%;
  bottom:10px;
  transform: translate(-50%, -50%);
  margin: 0 auto;
  display: block;
  color: black;
  padding: 16px;
  text-decoration: none;
}
</style>
<script>
	if(!(~document.cookie.indexOf("em=") && ~document.cookie.indexOf("pwd="))){
		location.href="http://localhost:8085/registration/loginforreg.jsp";
	}
</script>
<script>
function delcookie(){
	  var allCookies = document.cookie.split(';');
      for (var i = 0; i < allCookies.length; i++)
          document.cookie = allCookies[i] + "=;expires="
          + new Date(0).toUTCString();
		location.href="http://localhost:8085/registration/loginforreg.jsp";
}
</script>
</head>
<body>
<div class="sidebar">
  <a class="active" href="mailoptions.jsp">Mail</a>
  <a href="chatoptions.jsp">Chat</a>
</div>
<div class="content">
  <h1>CHOOSE MAIL OR CHAT</h1>
</div>
<div class="find">
	<button  id="manipulate"
			onclick="delcookie()">LOG OUT</button>
			</div>
</body>
</html>