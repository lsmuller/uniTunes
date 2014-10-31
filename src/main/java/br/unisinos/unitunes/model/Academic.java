package br.unisinos.unitunes.model;

import lombok.Getter;
import lombok.Setter;

public class Academic {

	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String password;
	
	@Getter
	@Setter
	private String firstName;
	
	@Getter
	@Setter
	private String lastName;
	
	@Getter
	@Setter
	private double balance;
	
}
