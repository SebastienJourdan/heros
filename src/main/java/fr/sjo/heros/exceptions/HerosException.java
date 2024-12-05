package fr.sjo.heros.exceptions;

public class HerosException extends Exception{

	private static final long serialVersionUID = 4928355819774342732L;
	private String msg;
	
	public HerosException() {
		this.msg = "Pas de message";
	}
	
	public HerosException(String message) {
		this.msg = message;
	}
	
	public String getMsg() {
		return this.msg;
	}

}
