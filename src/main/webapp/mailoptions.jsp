<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  margin: 0;
  font-family: "Lato", sans-serif;
}

.sidebar {
  width: 200px;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
}

.sidebar .a {
text-align:left;
  display: block;
  color: black;
  padding: 16px;
  margin-left:0px;
  width:200px;
  border:none;
}
 
.sidebar .a.active {
  background-color: #000000;
  color: white;
}

.sidebar .a:hover:not(.active) {
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
  }

  div.content {margin-left: 0;}
}

@media screen and (max-width: 400px) {
  .sidebar .a {
    text-align: center;
   
  }
}
h1{
text-align:center;
}
</style>

</head>
<body>
<div class="sidebar">
  <button class="active a" onClick="re()" >SEND MAIL</button>
 <button class="a" onClick="cook()">CHECK MAIL</button>
</div>
<div class="content">
  <h1>CHOOSE SEND OR CHECK MAIL</h1>
</div>
<script>
if(!(~document.cookie.indexOf("em=") && ~document.cookie.indexOf("pwd="))){
	location.href="http://localhost:8085/registration/loginforreg.jsp";
}
function re(){
	location.href="http://localhost:8085/registration/loggedin.jsp";
}
function cook(){
	
	if(!(~document.cookie.indexOf("em=") && ~document.cookie.indexOf("pwd="))){
		location.href="http://localhost:8085/registration/loginforreg.jsp";
	}
	else{
		location.href="http://localhost:8085/registration/CheckMail"
	}
}
</script>
</body>
</html>