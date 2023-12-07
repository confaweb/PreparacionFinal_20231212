package ar.edu.unlam.exception;

public class ChoferNoHabilitadoException extends Throwable {
	
private String message;

public ChoferNoHabilitadoException(String message) {
	this.message=message;
}
}
