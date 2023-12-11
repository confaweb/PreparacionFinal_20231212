package ar.edu.unlam.torneoDeArqueria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ar.edu.unlam.torneoDeArqueria.exception.DisparoInvalidoException;
import ar.edu.unlam.torneoDeArqueria.interfaces.Turno;

public class Disparo implements Turno {

	private Integer coordX;
	private Integer coordY;
	private Integer numeroParticipante;
	private NumeroOrdinalDisparo orden;
	private List<Integer> registroDePuntos;
	

	public Disparo(Integer coordX, Integer coordY, Integer numeroParticipante, NumeroOrdinalDisparo orden) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.numeroParticipante = numeroParticipante;
		this.orden = orden;
		this.registroDePuntos=new ArrayList<Integer>();
	}

	public Integer getCoordX() {
		return coordX;
	}

	public void setCoordX(Integer coordX) {
		this.coordX = coordX;
	}

	public Integer getCoordY() {
		return coordY;
	}

	public void setCoordY(Integer coordY) {
		this.coordY = coordY;
	}

	public Integer getNumeroParticipante() {
		return numeroParticipante;
	}

	public void setNumeroParticipante(Integer numeroParticipante) {
		this.numeroParticipante = numeroParticipante;
	}

	public NumeroOrdinalDisparo getOrden() {
		return orden;
	}

	public void setOrden(NumeroOrdinalDisparo orden) {
		this.orden = orden;
	}

	@Override
	public void disparar() {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer calcularPuntaje(Integer coordX, Integer coordY) throws DisparoInvalidoException {
		Integer puntaje = 0;
		if (!disparoValidado(coordX, coordY))
			throw new DisparoInvalidoException("Disparo fuera de rango");
		else if (Integer.sum(coordX, coordY) <= 20)
			puntaje = 1000;
		else if (Integer.sum(coordX, coordY) > 20&& Integer.sum(coordX, coordY) <= 40)
			puntaje = 500;
		else if (Integer.sum(coordX, coordY) >40&& Integer.sum(coordX, coordY) <= 60)
			puntaje = 200;
		else if (Integer.sum(coordX, coordY) > 60&&Integer.sum(coordX, coordY) <= 80)
			puntaje = 100;
		else
			puntaje=50;

		return puntaje;
	}

	private boolean disparoValidado(Integer coordX2, Integer coordY2) {
		Boolean valido = false;
		if (coordX2 < 50 && coordY2 < 50)
			valido = true;
		return valido;
	}

	@Override
	public void registrarPuntaje() throws DisparoInvalidoException {
		Integer puntajeObtenido=calcularPuntaje(this.getCoordX(), this.getCoordY());
		this.registroDePuntos.add(puntajeObtenido);

	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroParticipante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disparo other = (Disparo) obj;
		return Objects.equals(numeroParticipante, other.numeroParticipante);
	}

}
