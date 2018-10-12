package com.gogo.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	
	
	
	@PostMapping("/email")
	public String email(String id) {
		
		  String to = id;

	      // Sender's email ID needs to be mentioned
	      String from = "dchengalvarayan@gogoair.com";
	      final String username = "dchengalvarayan@gogoair.com";//change accordingly
	      final String password = "Pranesh-15";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "imap-mail.outlook.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
	            }
		});

	      try {
	            // Create a default MimeMessage object.
	            Message message = new MimeMessage(session);

	   	   // Set From: header field of the header.
		   message.setFrom(new InternetAddress(from));

		   // Set To: header field of the header.
		   message.setRecipients(Message.RecipientType.TO,
	              InternetAddress.parse(to));

		   // Set Subject: header field
		   message.setSubject("Testing Subject");

		   // Send the actual HTML message, as big as you like
		   message.setContent(
	              "<!DOCTYPE html>\n" + 
	              "<html lang=\"en\">\n" + 
	              "<head>\n" + 
	              "<meta charset=\"utf-8\">\n" + 
	              "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" + 
	              "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
	              "<title>Example of Bootstrap 3 Simple Tables</title>\n" + 
	              "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" + 
	              "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" + 
	              "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" + 
	              "<style type=\"text/css\">\n" + 
	              "   .bs-example{\n" + 
	              "       margin: 20px;\n" + 
	              "   }\n" + 
	              "a.tooltip {outline:none; }\n" + 
	              "a.tooltip strong {line-height:30px;}\n" + 
	              "a.tooltip:hover {text-decoration:none;} \n" + 
	              "a.tooltip span {\n" + 
	              "    z-index:10;display:none; padding:14px 20px;\n" + 
	              "    margin-top:-30px; margin-left:28px;\n" + 
	              "    width:300px; line-height:16px;\n" + 
	              "}\n" + 
	              "a.tooltip:hover span{\n" + 
	              "    display:inline; position:absolute; color:#111;\n" + 
	              "    border:1px solid #DCA; background:#fffAF0;}\n" + 
	              ".callout {z-index:20;position:absolute;top:30px;border:0;left:-12px;}\n" + 
	              "    \n" + 
	              "/*CSS3 extras*/\n" + 
	              "a.tooltip span\n" + 
	              "{\n" + 
	              "    border-radius:4px;\n" + 
	              "    box-shadow: 5px 5px 8px #CCC;\n" + 
	              "}\n" + 
	              "tr .spnTooltip {\n" + 
	              "    z-index:10;display:none; padding:14px 20px;\n" + 
	              "    margin-top:-30px; margin-left:28px;\n" + 
	              "    width:300px; line-height:16px;\n" + 
	              "}\n" + 
	              "tr:hover .spnTooltip{\n" + 
	              "    display:inline; position:absolute; color:#111;\n" + 
	              "    border:1px solid #DCA; background:#fffAF0;}\n" + 
	              ".callout {z-index:20;position:absolute;top:30px;border:0;left:-12px;}\n" + 
	              "</style>\n" + 
	              "</head>\n" + 
	              "<body>\n" + 
	              "<div class=\"bs-example\">\n" + 
	              "   <table class=\"table\">\n" + 
	              "       <thead>\n" + 
	              "           <tr>\n" + 
	              "               <th>Total Ratio</th>\n" + 
	              "               <th>Airlines</th>\n" + 
	              "               <th>Monday</th>\n" + 
	              "               <th>Tuesday</th>\n" + 
	              "               <th>Wednesday</th>\n" + 
	              "               <th>Thursady</th>\n" + 
	              "               <th>Friday</th>\n" + 
	              "           </tr>\n" + 
	              "       </thead>\n" + 
	              "       <tbody>\n" + 
	              "           <tr>\n" + 
	              "               <td><span class=\"spnDetails\">0.3</span><span class=\"spnTooltip\">\n" + 
	              "<strong>Current reset - 100</strong><br/>\n" + 
	              "        Previous week reset -90\n" + 
	              "        <br/> Flight Hours - 14 </br> Re-set Flight hours - 2\n" + 
	              "    </span>\n" + 
	              "</td>\n" + 
	              "               <td >DAL</td>\n" + 
	              "               <td>0.1</td>\n" + 
	              "                <td>0.4</td>\n" + 
	              "               <td>0.3</td>\n" + 
	              "               <td>0.3</td>\n" + 
	              "               <td>0.3</td>\n" + 
	              "           </tr>\n" + 
	              "           <tr>\n" + 
	              "               <td><span class=\"spnDetails\">0.2</span><span class=\"spnTooltip\">\n" + 
	              "<strong>Current reset - 105</strong><br/>\n" + 
	              "        Previous week reset -95\n" + 
	              "        <br/> Flight Hours - 14 </br> Re-set Flight hours - 2\n" + 
	              "    </span>\n" + 
	              "               <td>ASA</td>\n" + 
	              "               <td>0.4</td>\n" + 
	              "               <td>0.3</td>\n" + 
	              "               <td>0.3</td>\n" + 
	              "               <td>0.3</td>\n" + 
	              "               <td>0.3</td>\n" + 
	              "           </tr>\n" + 
	              "           <tr>\n" + 
	              "               <td><span class=\"spnDetails\">0.1</span><span class=\"spnTooltip\">\n" + 
	              "<strong>Current reset - 40</strong><br/>\n" + 
	              "        Previous week reset -20\n" + 
	              "        <br/> Flight Hours - 14 </br> Re-set Flight hours - 2\n" + 
	              "    </span>\n" + 
	              "               <td>AAL</td>\n" + 
	              "                <td>0.4</td>\n" + 
	              "               <td>0.3</td>\n" + 
	              "               <td>0.3</td>\n" + 
	              "               <td>0.3</td>\n" + 
	              "               <td>0.3</td>\n" + 
	              "           </tr>\n" + 
	              "       </tbody>\n" + 
	              "   </table>\n" + 
	              "</div>\n" + 
	              "</body>\n" + 
	              "</html>",
	             "text/html");

		   // Send message
		   Transport.send(message);

		   System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
		   e.printStackTrace();
		   throw new RuntimeException(e);
	      }
		
		return "email sent successful";
	}

}
