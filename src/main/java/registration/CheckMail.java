package registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

/**
 * Servlet implementation class CheckMail
 */
@WebServlet(name = "checkmail", urlPatterns = { "/CheckMail" })
public class CheckMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String host, storeType, user, password;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			HttpSession s = request.getSession();
			response.setContentType("text/html");
			host = "pop.gmail.com";
			storeType = "pop3";
			user = (String) s.getAttribute("email");
			password = (String) s.getAttribute("pass");
			response.setContentType("text/html");
			Properties properties = new Properties();
			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);
			Store store = emailSession.getStore("pop3s");
			store.connect(host, user, password);// connect it here ! establish connection
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			Message[] messages = emailFolder.getMessages();
			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
				int j = 0;
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset=\"utf-8\">"); // escape the quote marks
				out.println("<title>Messages</title>");
				out.println("<style>");
				out.println("h2{"); // note leading brace
				out.println("color:#000000;");
				// out.println("background-color:White;");
				// out.println("border: 1px solid black;");
				out.println("font-family:Verdana;");
				out.println("}");
				out.print("h3 {"); // note leading brace
				out.println("color:#000000;");
				// out.println("background-color:White;");
				// out.println("border: 1px solid black;");
				out.println("font-family:Verdana;");
				out.println("}");
				out.print("h1 {"); // note leading brace
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
				out.println("<h1>Email " + (i + 1) + "</h1>");
				out.println("<h2>Sub:" + message.getSubject() + "</h2>");
				out.print("<h3>From: </b>" + message.getFrom()[0] + "</h3>");
				out.println("</body>");
				out.println("</html>");
				Object content = message.getContent();
				if (content instanceof String) {
					out.println(content);
				} else if (content instanceof Multipart) {
					Multipart multiPart = (Multipart) content;
					int multiPartCount = multiPart.getCount();
					for (j = 0; j < multiPartCount; j++) {
						BodyPart bodyPart = multiPart.getBodyPart(j);
						Object o;
						o = bodyPart.getContent();
						if (o instanceof String) {
							out.print("<h3>Message:</h3>" + o);
						}

					}

				}
				// out.println("<b>Message:</b>" + messages[j].getContent());
			}

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
