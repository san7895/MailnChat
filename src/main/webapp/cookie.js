function cookiefind(){
	if(!(~document.cookie.indexOf("em=") && ~document.cookie.indexOf("pwd="))){
		
	}
	else{
		location.href="http://localhost:8085/registration/CheckdbServlet";
	}
}