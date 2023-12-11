package ar.edu.unlam.torneoDeArqueria;

import java.util.Objects;

public  class Participante  {

	protected Integer numeroParticipante;

	public Participante(Integer numeroParticipante) {
		this.numeroParticipante=numeroParticipante;
	}

	public Integer getNumeroParticipante() {
		return numeroParticipante;
	}

	public void setNumeroParticipante(Integer numeroParticipante) {
		this.numeroParticipante = numeroParticipante;
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

}
