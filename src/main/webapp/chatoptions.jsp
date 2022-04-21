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
	.sidebar a {
		float: right;
	}
	div.content {
		margin-right: 0;
	}
}

@media screen and (max-width: 400px) {
	.sidebar a {
		text-align: center;
		float: none;
	}
}

h1 {
	text-align: center;
}
</style>
<script>
	if(!(~document.cookie.indexOf("em=") && ~document.cookie.indexOf("pwd="))){
		location.href="http://localhost:8085/registration/loginforreg.jsp";
	}
</script>
</head>
<body>
	<div class="sidebar">
		<a class="active" href="sendmessage.jsp">Send Message</a> <a
			href="CheckServlet">Check Message</a>
	</div>
	<div class="content">
		<h1>CHOOSE SEND OR CHECK MESSAGE</h1>
	</div>
</body>
</html>