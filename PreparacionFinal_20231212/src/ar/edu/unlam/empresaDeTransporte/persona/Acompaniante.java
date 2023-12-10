package ar.edu.unlam.empresaDeTransporte.persona;

public class Acompaniante extends Persona {

	private String codPasajero;

	public Acompaniante(String nombre, Integer dni,String codPasajeroA) {
		super(nombre, dni);
		super.nombre=nombre;
		super.dni=dni;
		this.setCodPasajero(codPasajeroA);
	}

	/**
	 * @return the codPasajero
	 */
	public String getCodPasajero() {
		return codPasajero;
	}

	/**
	 * @param codPasajero the codPasajero to set
	 */
	public void setCodPasajero(String codPasajero) {
		this.codPasajero = codPasajero;
	}

	

}
