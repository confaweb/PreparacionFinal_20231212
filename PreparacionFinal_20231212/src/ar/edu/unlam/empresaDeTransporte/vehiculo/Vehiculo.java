package ar.edu.unlam.empresaDeTransporte.vehiculo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.empresaDeTransporte.persona.Acompaniante;
import ar.edu.unlam.empresaDeTransporte.persona.Chofer;
import ar.edu.unlam.empresaDeTransporte.persona.Persona;
import ar.edu.unlam.exception.ChoferNoHabilitadoException;
import ar.edu.unlam.exception.VehiculoConPasajeroException;
import ar.edu.unlam.exception.VehiculoLlenoException;
import ar.edu.unlam.exception.ChoferNoHabilitadoException;

public abstract class Vehiculo {

	protected String patente;
	protected Integer kmRecorridos;
	protected Persona choferAsignado;
	private Set<Chofer> choferesHabilitados;
	private List<Persona> listadoPasajeros;

	public Vehiculo(String patente, Integer kmRecorridos) {
		this.patente = patente;
		this.kmRecorridos = kmRecorridos;
		this.choferesHabilitados = new HashSet<Chofer>();
		this.listadoPasajeros = new ArrayList<Persona>();
		this.choferAsignado=choferAsignado;

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

	public List<Persona> getListadoPasajeros() {
		return listadoPasajeros;
	}

	public void setListadoPasajeros(ArrayList<Persona> listadoPasajeros) {
		this.listadoPasajeros = listadoPasajeros;
	}
	public void setChoferAsignado(Persona chofer) throws ChoferNoHabilitadoException {
		if(asignarChofer( (Chofer) chofer))
		this.choferAsignado = chofer;
	}
	public Persona getChoferAsignado() {
		return this.choferAsignado;
	}

	public abstract Boolean asignarChofer(Chofer choferAsignado) throws ChoferNoHabilitadoException;

	public abstract void agregarAcompañanteOPasajero(Persona persona) throws VehiculoLlenoException;

	public abstract void bajarAcompañanteOPasajero(Persona persona);

	public abstract void cambiarChofer(Persona chofer) throws ChoferNoHabilitadoException, VehiculoConPasajeroException;

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
