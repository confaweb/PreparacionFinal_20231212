package ar.edu.unlam.empresaDeTransporte.vehiculo;

import ar.edu.unlam.empresaDeTransporte.Registro;
import ar.edu.unlam.empresaDeTransporte.persona.Chofer;

public class Automovil extends Vehiculo {

	public Automovil(String patente, Integer kmRecorridos) {
		super(patente, kmRecorridos);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Boolean asignarChofer(Chofer chofer) {
		Boolean choferAsignado=false;
		choferAsignado=chequearRegistro(chofer);
		return choferAsignado;
		
		
	}

	private Boolean chequearRegistro(Chofer chofer) {
		Boolean registroOk=false;
		if(chofer.getRegistro()!=null&& chofer.getRegistro()!=Registro.A)
			 registroOk=true;
		return registroOk;
	}

	
}
