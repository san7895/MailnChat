package registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet(name = "checkmsg", urlPatterns = { "/CheckServlet" })
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession s = request.getSession();
			String Email = (String) s.getAttribute("email");
			String pass = (String) s.getAttribute("pass");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			response.setIntHeader("Refresh", 15);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail", "root", "sanjith");
			PreparedStatement st = con.prepareStatement("select*from send where ToUser=? order by DATE DESC");
			st.setString(1, Email);
			ResultSet rs = st.executeQuery();
			Cookie[] cookies = request.getCookies();

			boolean isMailAvailable = false;
			String cookieMail = "", cookiePwd = "";
			if (cookies == null) {
				System.out.println("Cookies not available");
				return;
			} else {
				for (Cookie c : cookies) {
					String tname = c.getName();
					if (tname.equals("em")) {
						if (c.getValue() != null || c.getValue().equals("")) {
							isMailAvailable = true;
							cookieMail = c.getValue();
						}
					} else if (tname.equals("pwd") || c.getValue().equals("")) {
						if (c.getValue() != null) {
							cookiePwd = c.getValue();
						}
					}
				}
			}
			if (isMailAvailable) {
				if (cookieMail.equals(Email) && cookiePwd.equals(pass)) {
					while (rs.next()) {
						out.println("<!DOCTYPE html>");
						out.println("<html>");
						out.println("<head>");
						out.println("<meta charset=\"utf-8\">"); // escape the quote marks
						out.println("<title>Messages</title>");
						out.println("<style>"); // start style
						// enclose style attributes withing the <style> </style> elements
						out.println("h2{"); // note leading brace
						out.println("color:#000000;");
						// out.println("background-color:White;");
						out.println("border: 1px solid black;");
						out.println("font-family:Verdana;");
						out.println("}");
						out.println("h4 {"); // note leading brace
						out.println("color:#000000;");
						// out.println("background-color:White;");
						// out.println("border: 1px solid black;");
						out.println("font-family:Verdana;");
						out.println("}");
						out.println("h5 {"); // note leading brace
						out.println("color:#000000;");
						// out.println("background-color:White;");
						// out.println("border: 1px solid black;");
						out.println("font-family:Verdana;");
						out.println("}");
						out.println(" #background {"); // note leading brace
						out.println(" width: 100%;");
						out.println(" height: 100%;;");
						out.println("position:fixed;");
						out.println("left:0px;");
						out.println("top:0px;");
						out.println("opacity: 0.5;");
						out.println(" z-index: -99999;");
						out.println("}");

						out.println(" #background img{"); // note leading brace
						out.println(" width: 100%;");
						out.println(" height: 100%;");
						out.println("opacity: 0.5;");
						// out.println(" background-color: rgba(255, 0, 0, 0.5);");
						out.println("}");

						out.println("</style>"); // terminate style
						out.println("</head>");
						out.println("<body>");
						out.println(
								"<div id=\"background\"><img src=\"img.png\" alt=\"msg\" width=\"170\" height=\"100\"></div>");
						out.println("<h2>Message:" + rs.getString(2) + "<br>" + "</h2>");
						out.println("<h4>From: " + rs.getString(4) + "</h4>");
						out.print("<h5>Time:  " + rs.getTimestamp(3) + "</h5>");
						out.println("</body>");
						out.println("</html>");
						// out.println("<body
						// style=\"background-color:#696969;\"><b>From:</b>"+rs.getString(4)+"<br>"+"<b>Message:</b>"+rs.getString(2)+"<br>"+"<b>Time:</b>"+rs.getTimestamp(3)+"<br>");
					}
				}
			} else {
				response.sendRedirect("loginforreg.jsp");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}