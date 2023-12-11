package ar.edu.unlam.exception;

public class VehiculoConPasajeroException extends Exception {
	private String message;

	public VehiculoConPasajeroException(String message) {
		this.message = message;
	}
}
