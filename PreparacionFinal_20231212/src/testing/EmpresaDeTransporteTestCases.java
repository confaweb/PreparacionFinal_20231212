package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.empresaDeTransporte.Empresa;
import ar.edu.unlam.empresaDeTransporte.Registro;
import ar.edu.unlam.empresaDeTransporte.persona.Chofer;
import ar.edu.unlam.empresaDeTransporte.persona.Persona;
import ar.edu.unlam.empresaDeTransporte.vehiculo.Autobus;
import ar.edu.unlam.empresaDeTransporte.vehiculo.Automovil;
import ar.edu.unlam.empresaDeTransporte.vehiculo.Motocicleta;
import ar.edu.unlam.empresaDeTransporte.vehiculo.Vehiculo;
import ar.edu.unlam.exception.ChoferNoHabilitadoException;

/*
 * Enunciado. 
Una Empresa de Transporte de personal nos plantea la siguiente situación problemática y 
desea un sistema que le permita manejar su flota. 
Según el Gerente existen dos tipos de VEHICULOS: las MOTOCICLETAS, que llevan un Chofer y un 
Acompañante, y los AUTOBUS, que llevan un Chofer y varios Pasajeros. 
Los VEHICULOS deben conocer la cantidad de KilómetrosRecorridos, Asignar y CambiarChofer. 
Cada VEHICULO en particular deberá poder agregarUnAcompañante o diversosPasajeros, 
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
public class EmpresaDeTransporteTestCases {

	@Test // #1
	public void queSePuedaCrearempresaTransporte() {
//		PREPARACION

		String nombre = "Te Llevo";
		Integer cuit = 1111111;

//		EJECUCION

		Empresa teLlevo = new Empresa(nombre, cuit);

//		VALIDACION

		assertNotNull(teLlevo);
	}

	@Test // #2
	public void quelaEmpresaTransporteTenagFlotaDistintosTiposVehiculos() {// Vehiculo(patente,kmRecorridos)-->Autobus,Motocicleta,Automovil
//		PREPARACION

		String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123";
		Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999;

//		EJECUCION

		Empresa teLlevo = new Empresa(nombre, cuit);
		Vehiculo moto1 = new Motocicleta(patenteM, kmRecorridosM);
		Vehiculo auto1 = new Automovil(patenteA, kmRecorridosA);
		Vehiculo micro1 = new Autobus(patenteMic, kmRecorridosMic);

//		VALIDACION

		assertNotNull(moto1);
		assertNotNull(auto1);
		assertNotNull(micro1);
	}

	@Test // #3
	public void quelaEmpresaTransportepuedaAsignarChoferALosVehiculos() throws ChoferNoHabilitadoException {
//		PREPARACION
		
		String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123",
				nombreChofer = "Juan";
		Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999, dni = 303030;
		Registro registro = Registro.MOTO;

//		EJECUCION

		Empresa teLlevo = new Empresa(nombre, cuit);
		Vehiculo moto1 = new Motocicleta(patenteM, kmRecorridosM);
		Vehiculo auto1 = new Automovil(patenteA, kmRecorridosA);
		Vehiculo micro1 = new Autobus(patenteMic, kmRecorridosMic);
		Persona chofer = new Chofer(dni, nombreChofer, Registro.MOTO);

		teLlevo.asignarChoferMoto((Chofer) chofer);// Verificar Que sea choferHabilitado, que el registro sea adecuado
													// para el vehiculo y lo registra
		moto1.getChoferesHabilitados((Chofer) chofer);//si el dni del chofer de la firma existe en la lista de choferes registrados devuelve el chofer 

//		VALIDACION

		assertEquals(teLlevo.asignarChoferMoto((Chofer) chofer), moto1.getChoferesHabilitados((Chofer) chofer));
	}

}
