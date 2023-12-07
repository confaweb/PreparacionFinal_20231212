package ar.edu.unlam.empresaDeTransporte;

import java.util.Objects;

import ar.edu.unlam.empresaDeTransporte.persona.Chofer;

/*
 * Enunciado. 
Una Empresa de Transporte de personal nos plantea la siguiente situación problemática y 
desea un sistema que le permita manejar su flota. 
Según el Gerente existen dos tipos de VEHICULOS: las MOTOCICLETAS, que llevan un Chofer y un 
Acompañante, y los AUTOBUS, que llevan un Chofer y varios Pasajeros. 
Los VEHICULOS deben conocer la cantidad de KilómetrosRecorridos, Asignar y CambiarChofer. 
Cada VEHICULOS_PARTICULAR deberá poder agregarUnAcompañante o diversosPasajeros, 
respectivamente. 
En caso del Autobús, noPuedeCambiarDeChoferSiHubieraPasajeros. En el caso de la 
Motocicleta, noPuedeHacerloSiHubieraUnAcompañante. 
Luego de una primera entrega del producto, el Gerente le expresa que la empresa ha crecido y 
ahora también emplea AUTOMOVILES y que además del Conductor puedeLlevarHastaTresPasajeros. 
Como dato no menor, cada autobús cuenta con una Cantidad de veinte Asientos para pasajeros 
y sus pasajerosDebenSentarsePorOrdenDeLlegada. 
Se pide: 
• Implementar las clases necesarias que den solución al problema. 
• Generen al menos CINCO (5) casos de prueba que verifiquen la funcionalidad deseada
 */
public class Empresa {

	private String nombre;
	private Integer cuit;

	public Empresa(String nombre, Integer cuit) {
		this.nombre=nombre;
		this.cuit=cuit;
	}

	public Integer getCuit() {
		return cuit;
	}

	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cuit, other.cuit);
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", cuit=" + cuit + "]";
	}

	public Chofer asignarChoferMoto(Chofer chofer) {
		return chofer;
		// TODO Auto-generated method stub
		
	}

}
