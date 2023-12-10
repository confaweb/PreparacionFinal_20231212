package ar.edu.unlam.empresaDeTransporte.persona;

import ar.edu.unlam.empresaDeTransporte.Registro;
import ar.edu.unlam.empresaDeTransporte.Tipo;
import ar.edu.unlam.exception.ChoferSinRegistroException;

public class Chofer extends Persona {
	private Registro registro;
	private Tipo tipoDeVehiculo; 

	public Chofer(String nombre,Integer dni,  Registro registro) {
		super(nombre,dni);
		super.nombre=nombre;
		super.dni=dni;
		this.registro=registro;
		
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}
	public boolean tieneRegistro() throws ChoferSinRegistroException {
		if (this.getRegistro()!=null)
		return true;
		throw new ChoferSinRegistroException("Chofer no posee registro");
	}
	public void sacarRegistro(Tipo tipoDeVehiculo) {
		if(tipoDeVehiculo==Tipo.MOTO)
		this.registro=Registro.A;
		if(tipoDeVehiculo==Tipo.AUTOMOVIL)
			this.registro=Registro.B;
		if(tipoDeVehiculo==Tipo.AUTOBUS)
			this.registro=Registro.C;		
		
	}

}
