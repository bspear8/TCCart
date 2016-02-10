package edu.gatech.seclass.project1;

public class InvalidMinimumLengthException extends RuntimeException {
	
	private String _badValue = "";
	public InvalidMinimumLengthException() {
		// TODO Auto-generated constructor stub
	}
	
	public InvalidMinimumLengthException(String message, String badValue) {
		super(message);
		this._badValue = badValue;
	}

	public String getBadValue() {
		return _badValue;
	}

}
