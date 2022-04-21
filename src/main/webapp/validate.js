function validate(){  
	var name=document.check.username.value;  
	var password=document.check.password.value; 
	var email=document.check.email.value;
	var phone=document.check.phone.value;
	var status=true;  
	  var arr=name.split("");
	  if(name.length>1){
		for(var i=0;i<name.length;i++){
			if(!(arr[i]>='a'&&arr[i]<='z')){
	document.getElementById("errorname").innerHTML= "No special characters Allowed for Username";  
	status=false;  
	}
		}}
	if(password.length<6){  
	document.getElementById("errorpass").innerHTML= "Please Enter a Password more than 6 char long";  
	status=false;  
	}
	if(!(phone.length==10)){
		document.getElementById("errorphone").innerHTML="Please Enter a valid 10 Digit Phone Number";
		status=false;
	}
	if(!(email.includes("@")&&email.includes(".com"))){
		document.getElementById("erroremail").innerHTML="Please enter a valid email address";
		status=false;
	}
	return status;  
	}  