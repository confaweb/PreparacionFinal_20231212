package ar.edu.unlam.empresaDeTransporte.vehiculo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import ar.edu.unlam.empresaDeTransporte.persona.Chofer;
import ar.edu.unlam.empresaDeTransporte.persona.Persona;
import ar.edu.unlam.exception.ChoferNoHabilitadoException;
import ar.edu.unlam.exception.ChoferNoHabilitadoException;

public abstract class Vehiculo{
	
	protected String patente;
	protected Integer kmRecorridos;
	private Set <Chofer>  choferesHabilitados;
	private Chofer choferAsignado;

	public  Vehiculo(String patente, Integer kmRecorridos) {
		this.patente=patente;
		this.kmRecorridos=kmRecorridos;
		this.choferesHabilitados=new HashSet<Chofer>();
		
		
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Integer getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(Integer kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}
	public abstract Boolean asignarChofer(Chofer choferAsignado) throws ChoferNoHabilitadoException;

	

	@Override
	public int hashCode() {
		return Objects.hash(patente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(patente, other.patente);
	}

	@Override
	public String toString() {
		return "Vehiculo [patente=" + patente + ", kmRecorridos=" + kmRecorridos + "]";
	}



}
