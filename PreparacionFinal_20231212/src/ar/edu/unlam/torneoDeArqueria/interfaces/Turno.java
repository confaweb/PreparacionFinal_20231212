package ar.edu.unlam.torneoDeArqueria.interfaces;

import ar.edu.unlam.torneoDeArqueria.NumeroOrdinalDisparo;
import ar.edu.unlam.torneoDeArqueria.exception.DisparoInvalidoException;

public interface Turno {
	public void disparar();

	public Integer calcularPuntaje(Integer coordX, Integer coordY) throws DisparoInvalidoException;

	public void registrarPuntaje() throws DisparoInvalidoException;
}
