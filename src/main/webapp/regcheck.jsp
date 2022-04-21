<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*,java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<script>
    history.forward();
</script>
<meta charset="ISO-8859-1">
<title>registration</title>
<script>
	if(!(~document.cookie.indexOf("em=") && ~document.cookie.indexOf("pwd="))){
		location.href="http://localhost:8085/registration/loginforreg.jsp";
	}
</script>
</head>
<h1>REGISTRATION</h1>
<body>
<%
String username=request.getParameter("username");
String password=request.getParameter("password");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","sanjith");
PreparedStatement st=con.prepareStatement("insert into register values(?,?,?,?) ");
st.setString(1,username);
st.setString(2,password);
st.setString(3,email);
st.setString(4,phone);
if(st.executeUpdate()>0){
	
	response.sendRedirect("loginforreg.jsp");
}
else{
	out.println("enter valid details ");
}
%>

</body>
</html>