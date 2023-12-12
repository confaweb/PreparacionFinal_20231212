package ar.edu.unlam.torneoDeArqueria;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Torneo implements Comparable<Participante> {

	private String nombreTorneo;
	private Integer codigoTorneo;
	private List<Participante> ranking;

	public Torneo(String nombreTorneo, Integer codigoTorneo) {
		this.nombreTorneo = nombreTorneo;
		this.codigoTorneo = codigoTorneo;
		this.ranking = new ArrayList<Participante>();
	}

	public String getNombreTorneo() {
		return nombreTorneo;
	}

	public void setNombreTorneo(String nombreTorneo) {
		this.nombreTorneo = nombreTorneo;
	}

	public Integer getCodigoTorneo() {
		return codigoTorneo;
	}

	public void setCodigoTorneo(Integer codigoTorneo) {
		this.codigoTorneo = codigoTorneo;
	}

	public List<Participante> getRanking() {
		return ranking;
	}

	public void setRanking(List<Participante> ranking) {
		this.ranking = ranking;
	}

	public void registraParticipantePorTotal(Participante participante) {
		this.ranking.add(participante);

	}

	public void sort(Comparator<? super Participante> c) {
		ranking.sort(c);
	}
	public void printRanking(List <Participante>ranking) {
		for (Participante participante : ranking) {
			System.out.println("Participante N"+participante.getNumeroParticipante());
		}
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(codigoTorneo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torneo other = (Torneo) obj;
		return Objects.equals(codigoTorneo, other.codigoTorneo);
	}

	@Override
	public String toString() {
		return "Torneo [nombreTorneo=" + nombreTorneo + ", codigoTorneo=" + codigoTorneo + "]";
	}

	@Override
	public int compareTo(Participante o) {
		// TODO Auto-generated method stub
		return 0;
	}
	/*
	 * Collections.sort(personas, new Comparator<Persona>() {
	@Override
	public int compare(Persona p1, Persona p2) {
		return new Integer(p1.getEdad()).compareTo(new Integer(p2.getEdad()));
	}
});
	 */

}
