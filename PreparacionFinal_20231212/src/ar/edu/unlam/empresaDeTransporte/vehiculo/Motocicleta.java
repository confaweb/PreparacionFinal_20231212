package ar.edu.unlam.empresaDeTransporte.vehiculo;

import ar.edu.unlam.empresaDeTransporte.Registro;
import ar.edu.unlam.empresaDeTransporte.persona.Chofer;
import ar.edu.unlam.exception.ChoferNoHabilitadoException;

public class Motocicleta extends Vehiculo {

	public Motocicleta(String patente, Integer kmRecorridos) {
		super(patente, kmRecorridos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean asignarChofer(Chofer chofer) throws ChoferNoHabilitadoException {
		Boolean choferAsignado=false;
		choferAsignado=chequearRegistro(chofer);
		return choferAsignado;
		
		
	}

	private Boolean chequearRegistro(Chofer chofer) throws ChoferNoHabilitadoException {
		Boolean registroOk=false;
		if(chofer.getRegistro()!=null) {
			 registroOk=true;
		return registroOk;
		}
		throw new ChoferNoHabilitadoException("El chofer no tiene registro");
	}

	
}
