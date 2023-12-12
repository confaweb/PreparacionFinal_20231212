package ar.edu.unlam.torneoDeArqueria;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import ar.edu.unlam.torneoDeArqueria.exception.DisparoInvalidoException;

public class Participante implements Comparable<Participante>{

	protected Integer numeroParticipante;
	private List<Integer> registroPuntaje;

	public Participante(Integer numeroParticipante) {
		this.numeroParticipante = numeroParticipante;
		this.registroPuntaje = new ArrayList<Integer>();
	}

	public Integer getNumeroParticipante() {
		return numeroParticipante;
	}

	public void setNumeroParticipante(Integer numeroParticipante) {
		this.numeroParticipante = numeroParticipante;
	}

	public Boolean registrarPuntajeDisparo(Disparo disparo) throws DisparoInvalidoException {
		Boolean disparoRegistrado = false;
		Integer puntaje = disparo.calcularPuntaje(disparo.getCoordX(), disparo.getCoordY());
		disparoRegistrado = registroPuntaje.add(puntaje);
		return disparoRegistrado;
	}

	public Integer sumarYMostrarTotal() {
		Integer total = 0;
		for (Integer puntajes : registroPuntaje) {
			total += puntajes;
		}
		return total;

	}

	public void sort(Comparator<? super Integer> c) {
		registroPuntaje.sort(c);
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
		Participante other = (Participante) obj;
		return Objects.equals(numeroParticipante, other.numeroParticipante);
	}

	@Override
	public int compareTo(Participante o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
