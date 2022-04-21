package registration;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name="sendmsg",urlPatterns= {"/SendServlet"})
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				response.setIntHeader("refresh", 5);
				HttpSession s = request.getSession();
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				String email= request.getParameter("mail");
				String msg= request.getParameter("msgarea");
				String from=(String) s.getAttribute("email");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail", "root", "sanjith");
				PreparedStatement st = con.prepareStatement("insert into send values(?,?,?,?)");
				st.setString(1, email);
				st.setString(2, msg);
				st.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
				st.setString(4,from);
				if(st.executeUpdate()>0) {
					response.sendRedirect("sendmessage.jsp");
				}
				else {
					out.print("<center><h2 style='color:red;'>EMAIL ID DOES NOT EXIST . Please SIGN-UP.</h2>");
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
