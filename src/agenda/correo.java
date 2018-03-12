/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Desarrollo
 */
public class correo {
     public void enviar(String correo,String asunto,String descripcion){
    Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("falberto.ayala@gmail.com","Falberto1977");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(correo));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(correo));
			message.setSubject(asunto);
			message.setText(descripcion);

			Transport.send(message);

			System.out.println("El mensaje fue enviado con exito");

		} catch (MessagingException e) {
			System.out.println("El mensaje no fue enviado");
		}
    
    }
    
}
