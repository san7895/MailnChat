<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
<title>MENU BAR</title>
<link rel="stylesheet" href="style.css">
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
$('a').on('click',function(e){
	e.preventDefault();
	var pageinput=$this.attr('href');
	callpage(pageinput);
})

function callpage(pageinput){
	$ajax({
		url:pageinput,
		type:"GET",
		datatype:'text',
		
		success: function(response){
			$(.content).html(response);
		}
		
		
	});
}
</script>
<body>
<div class="content"></div>
<nav>
      <a href="h">MailNchat</a>
      <a href="loggedin.jsp">Send Email</a>
      <a href="sendmessage.jsp">Send Message</a>
      <a href="CheckMail">Check Email</a>
      <a href="CheckServlet">Check Message</a>
      <div class="animation start-home"></div>
    </nav>
</body>
</html>