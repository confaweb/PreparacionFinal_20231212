package ar.edu.unlam.empresaDeTransporte.vehiculo;

import ar.edu.unlam.empresaDeTransporte.Registro;
import ar.edu.unlam.empresaDeTransporte.persona.Acompaniante;
import ar.edu.unlam.empresaDeTransporte.persona.Chofer;
import ar.edu.unlam.empresaDeTransporte.persona.Pasajero;
import ar.edu.unlam.empresaDeTransporte.persona.Persona;
import ar.edu.unlam.exception.ChoferNoHabilitadoException;
import ar.edu.unlam.exception.VehiculoConPasajeroException;
import ar.edu.unlam.exception.VehiculoLlenoException;

public class Automovil extends Vehiculo {
	private final Integer CAPACIDAD_MAXIMA = 4;

	public Automovil(String patente, Integer kmRecorridos) {
		super(patente, kmRecorridos);

	}

	public Integer getCAPACIDAD_MAXIMA() {
		return CAPACIDAD_MAXIMA;
	}

	@Override
	public Boolean asignarChofer(Chofer chofer) {
		Boolean choferAsignado = false;
		choferAsignado = chequearRegistro(chofer);
		return choferAsignado;

	}

	private Boolean chequearRegistro(Chofer chofer) {
		Boolean registroOk = false;
		if (chofer.getRegistro() != null && chofer.getRegistro() != Registro.A)
			registroOk = true;
		return registroOk;
	}

	@Override
	public void agregarAcompañanteOPasajero(Persona persona) throws VehiculoLlenoException {
		if (checkCapacidadMax())
			super.getListadoPasajeros().add(persona);

	}

	private boolean checkCapacidadMax() throws VehiculoLlenoException {
		Boolean disponibilidadAsientos = false;
		if ((this.CAPACIDAD_MAXIMA - super.getListadoPasajeros().size() > 0)) {
			disponibilidadAsientos = true;
			return disponibilidadAsientos;
		}
		throw new VehiculoLlenoException("Sin asientos Disponibles");

	}

	@Override
	public void bajarAcompañanteOPasajero(Persona persona) {
		// TODO Auto-generated method
		// stubif(super.getListadoPasajeros().contains(persona))
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
