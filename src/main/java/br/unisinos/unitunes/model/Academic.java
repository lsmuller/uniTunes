package br.unisinos.unitunes.model;

public class Academic {

	private long id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private double balance;
	private boolean admin;
	private boolean excluded;
	
	public Academic(long id, String email, String firstName, String lastName,
			String password, double balance, boolean admin, boolean excluded) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.balance = balance;
		this.admin = admin;
		this.excluded = excluded;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isExcluded() {
		return excluded;
	}

	public void setExcluded(boolean excluded) {
		this.excluded = excluded;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "ID: " + id + " / login " + email + " / senha " + password + " / saldo " + balance + " / admin " + admin + " / excluido " + excluded + "\n";
	}
}
