package ar.edu.unlam.exception;

public class ChoferSinRegistroException extends Exception {
	private String message;

	public ChoferSinRegistroException(String message){
		this.message=message;
	}

}

