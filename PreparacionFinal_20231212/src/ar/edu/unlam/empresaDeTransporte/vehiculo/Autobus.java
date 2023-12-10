package ar.edu.unlam.empresaDeTransporte.vehiculo;

import ar.edu.unlam.empresaDeTransporte.Registro;
import ar.edu.unlam.empresaDeTransporte.persona.Chofer;
import ar.edu.unlam.exception.ChoferNoHabilitadoException;

public class Autobus extends Vehiculo{

	public Autobus(String patente, Integer kmRecorridos) {
		super(patente, kmRecorridos);
		super.patente=patente;
		
	}
	@Override
	public Boolean asignarChofer(Chofer chofer) throws ChoferNoHabilitadoException {
		Boolean choferAsignado=false;
		choferAsignado=chequearRegistro(chofer);
		return choferAsignado;
		
		
	}

	private Boolean chequearRegistro(Chofer chofer) throws ChoferNoHabilitadoException {
		Boolean registroOk=false;
		if(chofer.getRegistro()==Registro.C) {
			 registroOk=true;
			 return registroOk;
		}
		else
		throw new ChoferNoHabilitadoException("El chofer no esta habilitado para este tipo dde vehiculo");
		
	}

}
