package ar.edu.unlam.empresaDeTransporte.vehiculo;

import ar.edu.unlam.empresaDeTransporte.Registro;
import ar.edu.unlam.empresaDeTransporte.persona.Acompaniante;
import ar.edu.unlam.empresaDeTransporte.persona.Chofer;
import ar.edu.unlam.empresaDeTransporte.persona.Persona;
import ar.edu.unlam.exception.ChoferNoHabilitadoException;
import ar.edu.unlam.exception.VehiculoConPasajeroException;
import ar.edu.unlam.exception.VehiculoLlenoException;

public class Motocicleta extends Vehiculo {

	private final Integer CAPACIDAD_MAXIMA = 1;

	public Motocicleta(String patente, Integer kmRecorridos) {
		super(patente, kmRecorridos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean asignarChofer(Chofer chofer) throws ChoferNoHabilitadoException {
		Boolean choferAsignado = false;
		choferAsignado = chequearRegistro(chofer);
		return choferAsignado;

	}

	private Boolean chequearRegistro(Chofer chofer) throws ChoferNoHabilitadoException {
		Boolean registroOk = false;
		if (chofer.getRegistro() != null) {
			registroOk = true;
			return registroOk;
		}
		throw new ChoferNoHabilitadoException("El chofer no tiene registro");
	}

	@Override
	public void agregarAcompañanteOPasajero(Persona persona) throws VehiculoLlenoException {
		if (checkCapacidadMax() == true)
			super.getListadoPasajeros().add(persona);

	}

	private boolean checkCapacidadMax() throws VehiculoLlenoException {
		Boolean disponibilidadAsientos = false;
		if ((this.CAPACIDAD_MAXIMA - super.getListadoPasajeros().size()) > 0) {
			disponibilidadAsientos = true;
			return disponibilidadAsientos;
		}
		throw new VehiculoLlenoException("Sin asientos Disponibles");
	}

	@Override
	public void bajarAcompañanteOPasajero(Persona persona) {
		if (super.getListadoPasajeros().contains(persona))
			super.getListadoPasajeros().remove(persona);

	}

	@Override
	public void cambiarChofer(Persona chofer) throws ChoferNoHabilitadoException, VehiculoConPasajeroException {
		if (super.getListadoPasajeros().isEmpty())
			super.setChoferAsignado(chofer);
		else
			throw new VehiculoConPasajeroException("No se puede cambiar Chofer si el vehiculo no está vacío");

	}

}
