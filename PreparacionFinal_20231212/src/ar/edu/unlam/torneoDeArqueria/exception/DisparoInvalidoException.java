package ar.edu.unlam.torneoDeArqueria.exception;

public class DisparoInvalidoException extends Exception {
	private String message;

	public  DisparoInvalidoException(String message) {
		this.message=message;	}

}
