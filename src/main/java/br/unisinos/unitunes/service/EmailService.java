package br.unisinos.unitunes.service;

import java.sql.SQLException;

import br.unisinos.unitunes.model.Academic;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGrid.Email;
import com.sendgrid.SendGridException;

public class EmailService {
	
	private static String htmlText = "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">" 
			+ "Sua senha é: <password> <br><br> "
			+ " <a href=\"https://whispering-everglades-2818.herokuapp.com\">Clique para voltar ao uniTunes</a>";
	
	public static void sendPasswordRecoveryMail(Academic a) throws SQLException {
		sendPasswordRecoveryMail(a.getEmail());
	}

	public static void sendPasswordRecoveryMail(String address) throws SQLException {
		String username  = System.getenv("SENDGRID_USERNAME");
		String password  = System.getenv("SENDGRID_PASSWORD");
		
		SendGrid sendGrid = new SendGrid(username, password);
		Email email = new Email();
		
		email.addTo(address);
		email.addCc("plgrabin@gmail.com");
		email.setFrom("plgrabin@gmail.com");
		email.setSubject("uniTunes - Recuperação de senha");

		AcademicService as = AcademicService.getInstance();
		Academic a = as.getByEmail(address);
		
		String mailText = htmlText.replace("<password>", a.getPassword());
		email.setHtml(mailText);
		
		try {
			SendGrid.Response response = sendGrid.send(email);
			System.out.println(response.getMessage());
		}
		catch (SendGridException e) {
			System.err.println(e);
		}
	}
}
