package br.unisinos.unitunes.service;

import br.unisinos.unitunes.model.Academic;

public class LoginService {

	public Academic login(String email, String password) {
		Academic academic = null;
		
		if(email == "teste" && password == "teste") {
			academic = new Academic(0, email,"nome", "sobrenome", password, 0, false, false);
		}
		
		return academic;
	}
	
}
