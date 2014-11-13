package br.unisinos.unitunes.service;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGrid.Email;
import com.sendgrid.SendGridException;

public class EmailService {

	public static void sendMail() {
		String username  = System.getenv("SENDGRID_USERNAME");
		String password  = System.getenv("SENDGRID_PASSWORD");
		
		SendGrid sendGrid = new SendGrid(username, password);
		Email email = new Email();
		
		email.addTo("plgrabin@gmail.com");
		email.addTo("henriquebraum@gmail.com");
		email.addTo("matheus.bloebaum@gmail.com");
		email.addTo("lety182@gmail.com");
		email.setFrom("plgrabin@gmail.com");
		email.setSubject("Teste envio de email do Heroku");
		email.setText("Jesus breve voltará.");
		
		try {
			SendGrid.Response response = sendGrid.send(email);
			System.out.println(response.getMessage());
		}
		catch (SendGridException e) {
			System.err.println(e);
		}
	}
}
