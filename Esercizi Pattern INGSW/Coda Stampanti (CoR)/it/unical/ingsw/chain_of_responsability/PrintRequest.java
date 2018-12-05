package it.unical.ingsw.chain_of_responsability;

public class PrintRequest {
	private String message;
	
	public int getMemory() {
		return message.length();
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
