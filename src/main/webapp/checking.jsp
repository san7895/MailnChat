<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<p id="x"></p>
<body>

	<%
	try {
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail", "root", "sanjith");
		PreparedStatement st = con.prepareStatement("select*from register where emailid=? and password=?");
		st.setString(1, email);
		st.setString(2, pwd);
		ResultSet rs = st.executeQuery();
		int flag = 0;
		while (rs.next()) {
			String u = rs.getString(4);
			String p = rs.getString(3);
			//String email=rs.getString(3);
			session.setAttribute("useremail", email);
			if (email.equals(u) && pwd.equals(p)) {

		flag = 1;
		response.sendRedirect("loggedin.jsp");
			}
		}
		if (flag == 0) {
			session.setAttribute("errorMessage", "Invalid user or password");
			response.sendRedirect("loginforreg.jsp");
		}
		con.close();
	} catch (Exception e) {
		out.println(e);
	}
	%>
	<div style="color: red">${errorMessage}</div>
</body>
</html>