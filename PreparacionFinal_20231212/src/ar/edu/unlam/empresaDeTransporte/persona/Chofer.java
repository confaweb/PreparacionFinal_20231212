package ar.edu.unlam.empresaDeTransporte.persona;

import ar.edu.unlam.empresaDeTransporte.Registro;

public class Chofer extends Persona {
	private Registro registro;

	public Chofer(Integer dni, String nombre, Registro registro) {
		super(nombre,dni);
		super.nombre=nombre;
		super.dni=dni;
		this.setRegistro(Registro.MOTO);
		
	}

	public Registro getMoto() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

}
