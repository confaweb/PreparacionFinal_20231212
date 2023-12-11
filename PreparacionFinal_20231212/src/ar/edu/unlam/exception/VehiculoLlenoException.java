package ar.edu.unlam.exception;

public class VehiculoLlenoException extends Exception {
	private String message;

	public VehiculoLlenoException(String message) {
this.message=message;
	}
}
