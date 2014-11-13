package br.unisinos.unitunes.service;

import java.sql.SQLException;

import br.unisinos.unitunes.model.Academic;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGrid.Email;
import com.sendgrid.SendGridException;

public class EmailService {
	
	public static void sendPasswordRecoveryMail(Academic a) throws SQLException {
		sendPasswordRecoveryMail(a.getEmail());
	}

	public static void sendPasswordRecoveryMail(String address) throws SQLException {
		String username  = System.getenv("SENDGRID_USERNAME");
		String password  = System.getenv("SENDGRID_PASSWORD");
		
		SendGrid sendGrid = new SendGrid(username, password);
		Email email = new Email();
		
		email.addTo(address);
		email.addCc("paulograbin@gmail.com");
		email.addCc("henriquebraum@gmail.com");
		email.addCc("matheus.bloebaum@gmail.com");
		email.addCc("lety182@gmail.com");
		email.setFrom("plgrabin@gmail.com");
		email.setSubject("Teste envio de email do Heroku");

		AcademicService as = AcademicService.getInstance();
		Academic a = as.getByEmail(address);
		
		
		email.setText("Sua senha é: " + a.getPassword());
		
		try {
			SendGrid.Response response = sendGrid.send(email);
			System.out.println(response.getMessage());
		}
		catch (SendGridException e) {
			System.err.println(e);
		}
	}
}
