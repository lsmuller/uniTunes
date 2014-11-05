package br.unisinos.unitunes.model;

public class ViewMessage {
	
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	public static final String WARNING = "warning";
	
	private String type;
	private String field;
	private String message;
	
	public ViewMessage(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}
	
	public ViewMessage(String type, String field, String message) {
		super();
		this.type = type;
		this.field = field;
		this.message = message;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
