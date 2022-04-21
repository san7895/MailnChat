package registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class RegcheckServlet
 */
@WebServlet(name = "check", urlPatterns = { "/RegcheckServlet" })
public class RegcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail", "root", "sanjith");
			PreparedStatement st = con.prepareStatement(
					"insert into register" + "(name,password,emailid,phone,Time)" + "values" + "(?,?,?,?,?)");
			// st.setString(1,null);
			st.setString(1, username);
			st.setString(2, password);
			st.setString(3, email);
			st.setString(4, phone);
			st.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));

			if (st.executeUpdate() > 0) {

				response.setContentType("text/html;charset=UTF-8");

				request.getRequestDispatcher("loginforreg.jsp").forward(request, response);
			} else {
				out.println("enter valid details ");
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
