package registration;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import com.mysql.cj.jdbc.Driver;

/**
 * Servlet implementation class CheckdbServlet
 */

@WebServlet(name = "checkdb", urlPatterns = { "/CheckdbServlet" })
public class CheckdbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int flag = 0;
			PrintWriter out = response.getWriter();
			String email = request.getParameter("email");
			String pwd = request.getParameter("password");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mail", "root", "sanjith");
			PreparedStatement st = con.prepareStatement("select*from register where emailid=? and password=?");
			
			
			Cookie[] cookies = request.getCookies();
            boolean isMailAvailable = false;
            String cookieMail = "", cookiePwd = "";
            if (cookies == null) {
                System.out.println("Cookies not available");
                return;
            }
            else {
                for (Cookie c1 : cookies) {
                    String tname = c1.getName();
                    if(tname.equals("em")) {
                    	if(c1.getValue() != null || c1.getValue().equals("")) {
                    		isMailAvailable = true;
                    		cookieMail = c1.getValue();
                    	}
                    } else if(tname.equals("pwd") || c1.getValue().equals("")) {
                    	if(c1.getValue() != null) {
                    		cookiePwd= c1.getValue();
                    	}
                    }
                }
            }
            
            if(isMailAvailable) {
            	st.setString(1, cookieMail);
    			st.setString(2, cookiePwd);
    			ResultSet rs1 = st.executeQuery();
    			while (rs1.next()) {
    				String u = rs1.getString(3);
    				String p = rs1.getString(2);
    				if (cookieMail.equals(u) && cookiePwd.equals(p)) {

    					request.getRequestDispatcher("menu1.html").forward(request, response);
    				}
    			}
    			
            } else {
            	HttpSession session = request.getSession();
    			session.setAttribute("email", email);
    			session.setAttribute("pass", pwd);
    			Cookie c=new Cookie("em",email);
    			Cookie p1 = new Cookie("pwd", pwd);
    			response.addCookie(c);
    			response.addCookie(p1);
            	st.setString(1, email);
    			st.setString(2, pwd);
    			ResultSet rs = st.executeQuery();
    			while (rs.next()) {
    				String u = rs.getString(3);
    				String p = rs.getString(2);
    				if (email.equals(u) && pwd.equals(p)) {
    					request.getRequestDispatcher("menu1.html").forward(request, response);
    				}
    			}
            
            if(flag==0) {
            	request.getRequestDispatcher("loginforreg.jsp").include(request, response);
            }
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
