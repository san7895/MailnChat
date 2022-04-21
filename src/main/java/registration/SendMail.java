package registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Servlet implementation class SendMail
 */
@WebServlet(name = "mail", urlPatterns = { "/SendMail" })
public class SendMail extends HttpServlet {
	String name, subject, emailto, msg;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//response.setContentType("text/html");
		HttpSession s = request.getSession();
		response.setContentType("text/html");
		response.setIntHeader("Refresh", 5);	
		emailto = request.getParameter("toid");
		subject = request.getParameter("sub");
		msg = request.getParameter("mailarea");
		String em = (String) s.getAttribute("email");// login detail email
		String pm = (String) s.getAttribute("pass");// login detail password
		final String sendermail = em;
		final String password = pm;
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sendermail, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(em));// em is sender detail FROM
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailto));// to the receiver address
			String final_Text = "Message: " + msg;
			message.setText(final_Text);
			message.setSubject(subject);
			Transport.send(message);
			out.println("<center><h2 style='color:Blue;'>Email Sent Successfully.</h2>");
			out.println("<center><b><p style='font-family:Copperplate;'>Your Email Has been sent to" + emailto + "Successfully</b>");
		} catch (Exception e) {
			out.println(e);
		}
	}

}