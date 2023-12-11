package ar.edu.unlam.empresaDeTransporte.persona;

import java.util.Objects;

import ar.edu.unlam.empresaDeTransporte.ClasePasajero;

public class Pasajero extends Persona {

	private String codPasajero;
	ClasePasajero clase;

	public Pasajero(String nombre, Integer dni, String codPasajero, ClasePasajero clase) {
		super(nombre, dni);
		this.setCodPasajero(codPasajero);
		this.clase=clase;
		
	}

	/**
	 * @return the codPasajero
	 */
	public String getCodPasajero() {
		return codPasajero;
	}

	public ClasePasajero getClase() {
		return clase;
	}

	public void setClase(ClasePasajero clase) {
		this.clase = clase;
	}

	/**
	 * @param codPasajero the codPasajero to set
	 */
	public void setCodPasajero(String codPasajero) {
		this.codPasajero = codPasajero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(codPasajero);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		return Objects.equals(codPasajero, other.codPasajero);
	}

}
