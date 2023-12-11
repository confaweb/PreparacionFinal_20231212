package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.empresaDeTransporte.Empresa;
import ar.edu.unlam.empresaDeTransporte.Registro;
import ar.edu.unlam.empresaDeTransporte.Tipo;
import ar.edu.unlam.empresaDeTransporte.ClasePasajero;
import ar.edu.unlam.empresaDeTransporte.persona.Acompaniante;
import ar.edu.unlam.empresaDeTransporte.persona.Chofer;
import ar.edu.unlam.empresaDeTransporte.persona.Pasajero;
import ar.edu.unlam.empresaDeTransporte.persona.Persona;
import ar.edu.unlam.empresaDeTransporte.vehiculo.Autobus;
import ar.edu.unlam.empresaDeTransporte.vehiculo.Automovil;
import ar.edu.unlam.empresaDeTransporte.vehiculo.Motocicleta;
import ar.edu.unlam.empresaDeTransporte.vehiculo.Vehiculo;
import ar.edu.unlam.exception.ChoferNoHabilitadoException;
import ar.edu.unlam.exception.ChoferSinRegistroException;
import ar.edu.unlam.exception.VehiculoConPasajeroException;
import ar.edu.unlam.exception.VehiculoLlenoException;

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
	public void quelaEmpresaTransporteTengaChoferesAcompañanteYPasajeros() {// Vehiculo(patente,kmRecorridos)-->Autobus,Motocicleta,Automovil
//		PREPARACION

		String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123", nombreP = "Juan",
				nombreCh = "Jose", codPasajeroA = "AA11", codPasajeroPs = "PS22", nombreA = "Pedro",
				nombrePs = "Marcelo";
		Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999, dniP = 111111,
				dniCh = 222222, dniA = 333333, dniPs = 555555;
		Registro registro = null;
		ClasePasajero clase = null;

//		EJECUCION

		Empresa teLlevo = new Empresa(nombre, cuit);
		Vehiculo moto1 = new Motocicleta(patenteM, kmRecorridosM);
		Vehiculo auto1 = new Automovil(patenteA, kmRecorridosA);
		Vehiculo micro1 = new Autobus(patenteMic, kmRecorridosMic);
		Persona persona = new Persona(nombreP, dniP);
		Persona chofer = new Chofer(nombreP, dniP, registro);
		Persona acompaniante = new Acompaniante(nombreA, dniA, codPasajeroA);
		Persona pasajero = new Pasajero(nombrePs, dniPs, codPasajeroPs, clase);

//		VALIDACION

		assertNotNull(moto1);
		assertNotNull(auto1);
		assertNotNull(micro1);
		assertNotNull(persona);
		assertNotNull(chofer);
		assertNotNull(acompaniante);
		assertNotNull(pasajero);

	}

	@Test(expected = ChoferSinRegistroException.class) // #4
	public void siElChoferNoTieneRegistro() throws ChoferSinRegistroException {// Vehiculo(patente,kmRecorridos)-->Autobus,Motocicleta,Automovil
//	PREPARACION

		String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123", nombreP = "Juan",
				nombreCh = "Jose", codPasajeroA = "AA11", codPasajeroPs = "PS22", nombreA = "Pedro",
				nombrePs = "Marcelo";
		Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999, dniP = 111111,
				dniCh = 222222, dniA = 333333, dniPs = 555555;
		Registro registro = null;
		ClasePasajero clase = null;
		Tipo tipoDeVehiculo = null;

//	EJECUCION

		Persona persona = new Persona(nombreP, dniP);
		Persona chofer = new Chofer(nombreP, dniP, registro);

		((Chofer) chofer).sacarRegistro(tipoDeVehiculo);

//	VALIDACION

		assertTrue(((Chofer) chofer).tieneRegistro());

	}

	@Test // #5
	public void queElChoferTengaRegistro() throws ChoferSinRegistroException {// Vehiculo(patente,kmRecorridos)-->Autobus,Motocicleta,Automovil
//	PREPARACION

		String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123", nombreP = "Juan",
				nombreCh = "Jose", codPasajeroA = "AA11", codPasajeroPs = "PS22", nombreA = "Pedro",
				nombrePs = "Marcelo";
		Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999, dniP = 111111,
				dniCh = 222222, dniA = 333333, dniPs = 555555;
		Registro registro = null;
		ClasePasajero clase = null;
		Tipo tipoDeVehiculo = Tipo.AUTOBUS;

//	EJECUCION

		Persona persona = new Persona(nombreP, dniP);
		Persona chofer = new Chofer(nombreP, dniP, registro);

		((Chofer) chofer).sacarRegistro(tipoDeVehiculo);

//	VALIDACION

		assertTrue(((Chofer) chofer).tieneRegistro());

	}

	@Test// #6
	(expected = ChoferNoHabilitadoException.class)

	public void vehiculoAasignaChoferSinRegistroCompetente() throws ChoferNoHabilitadoException {// Vehiculo(patente,kmRecorridos)-->Autobus,Motocicleta,Automovil
//	PREPARACION

		String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123", nombreP = "Juan",
				nombreCh = "Jose", codPasajeroA = "AA11", codPasajeroPs = "PS22", nombreA = "Pedro",
				nombrePs = "Marcelo";
		Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999, dniP = 111111,
				dniCh = 222222, dniA = 333333, dniPs = 555555;
		Registro registro = Registro.A;
		ClasePasajero clase = null;
		Tipo tipoDeVehiculo = Tipo.AUTOBUS;

//	EJECUCION

		Persona persona = new Persona(nombreP, dniP);
		Persona chofer = new Chofer(nombreP, dniP, registro);
		Vehiculo moto1 = new Motocicleta(patenteM, kmRecorridosM);
		Vehiculo auto1 = new Automovil(patenteA, kmRecorridosA);
		Vehiculo micro1 = new Autobus(patenteMic, kmRecorridosMic);

		micro1.asignarChofer((Chofer) chofer);

//	VALIDACION

		assertTrue(moto1.asignarChofer((Chofer) chofer));

	}

	@Test // #7
	public void vehiculoAasignaChofer() throws ChoferNoHabilitadoException {// Vehiculo(patente,kmRecorridos)-->Autobus,Motocicleta,Automovil
//	PREPARACION

		String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123", nombreP = "Juan",
				nombreCh = "Jose", codPasajeroA = "AA11", codPasajeroPs = "PS22", nombreA = "Pedro",
				nombrePs = "Marcelo";
		Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999, dniP = 111111,
				dniCh = 222222, dniA = 333333, dniPs = 555555;
		Registro registro = null;
		ClasePasajero clase = null;
		Tipo tipoDeVehiculo = Tipo.AUTOBUS;

//	EJECUCION

		Persona persona = new Persona(nombreP, dniP);
		Persona chofer = new Chofer(nombreP, dniP, registro);
		Vehiculo moto1 = new Motocicleta(patenteM, kmRecorridosM);
		Vehiculo auto1 = new Automovil(patenteA, kmRecorridosA);
		Vehiculo micro1 = new Autobus(patenteMic, kmRecorridosMic);

		((Chofer) chofer).sacarRegistro(tipoDeVehiculo);

		moto1.asignarChofer((Chofer) chofer);

//	VALIDACION

		assertTrue(moto1.asignarChofer((Chofer) chofer));

	}

	@Test // #8
	public void vehiculoAgregarAcompañanteOPasajero() throws VehiculoLlenoException {// Vehiculo(patente,kmRecorridos)-->Autobus,Motocicleta,Automovil
//	PREPARACION

		String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123", nombreP = "Juan",
				nombreCh = "Jose", codPasajeroA = "AA11", codPasajeroPs = "PS22", nombreA = "Pedro",
				nombrePs = "Marcelo";
		Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999, dniP = 111111,
				dniCh = 222222, dniA = 333333, dniPs = 555555,cantidadPasajerosAgregados=0;
		Registro registro = null;
		ClasePasajero clase = null;
		Tipo tipoDeVehiculo = Tipo.AUTOBUS;
		

//	EJECUCION

		Persona persona = new Persona(nombreP, dniP);
		Persona chofer = new Chofer(nombreP, dniP, registro);
		Vehiculo moto1 = new Motocicleta(patenteM, kmRecorridosM);
		Vehiculo auto1 = new Automovil(patenteA, kmRecorridosA);
		Vehiculo micro1 = new Autobus(patenteMic, kmRecorridosMic);
		Persona acompaniante = new Acompaniante(nombreA, dniA, codPasajeroA);
		Persona acompaniante1 = new Acompaniante(nombreCh, dniCh, codPasajeroPs);

		((Chofer) chofer).sacarRegistro(tipoDeVehiculo);

		moto1.agregarAcompañanteOPasajero((Acompaniante) acompaniante);
		cantidadPasajerosAgregados ++;
		

//	VALIDACION
		Integer ve= cantidadPasajerosAgregados;
		Integer vo=moto1.getListadoPasajeros().size();

		assertEquals(ve,vo);

	}
	@Test // #9
	(expected = VehiculoLlenoException.class)
	public void vehiculoNoPuedeAgregarAcompañanteOPasajero() throws VehiculoLlenoException {// Vehiculo(patente,kmRecorridos)-->Autobus,Motocicleta,Automovil
//	PREPARACION

		String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123", nombreP = "Juan",
				nombreCh = "Jose", codPasajeroA = "AA11", codPasajeroPs = "PS22", nombreA = "Pedro",
				nombrePs = "Marcelo";
		Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999, dniP = 111111,
				dniCh = 222222, dniA = 333333, dniPs = 555555, cantidadPasajerosAgregados=0;
		Registro registro = null;
		ClasePasajero clase = null;
		Tipo tipoDeVehiculo = Tipo.AUTOBUS;

//	EJECUCION

		Persona persona = new Persona(nombreP, dniP);
		Persona chofer = new Chofer(nombreP, dniP, registro);
		Vehiculo moto1 = new Motocicleta(patenteM, kmRecorridosM);
		Vehiculo auto1 = new Automovil(patenteA, kmRecorridosA);
		Vehiculo micro1 = new Autobus(patenteMic, kmRecorridosMic);
		Persona acompaniante = new Acompaniante(nombreA, dniA, codPasajeroA);
		Persona acompaniante1 = new Acompaniante(nombreCh, dniCh, codPasajeroPs);

		((Chofer) chofer).sacarRegistro(tipoDeVehiculo);

		moto1.agregarAcompañanteOPasajero((Acompaniante) acompaniante);
		cantidadPasajerosAgregados ++;
		moto1.agregarAcompañanteOPasajero((Acompaniante) acompaniante1);
		cantidadPasajerosAgregados ++;


//	VALIDACION
		Integer ve= cantidadPasajerosAgregados;
		Integer vo=moto1.getListadoPasajeros().size();

		assertEquals(ve,vo);

	}
	@Test // #10
	public void vehiculoAgregarAcompañanteOPasajeroAuto() throws VehiculoLlenoException {// Vehiculo(patente,kmRecorridos)-->Autobus,Motocicleta,Automovil
//	PREPARACION

		String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123", nombreP = "Juan",
				nombreCh = "Jose", codPasajeroA = "AA11", codPasajeroPs = "PS00",codPasajeroPs1 = "PS11",codPasajeroPs2 = "PS22",
				codPasajeroPs3 = "PS33", codPasajeroPs4 = "PS44",codPasajeroPs5 = "PS55",nombreA = "Pedro",
				nombrePs = "Marcelo";
		Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999, dniP = 111111,
				dniCh = 222222, dniA = 333333, dniPs = 555555,dniPs1 = 666666,dniPs2 = 777777,dniPs3 = 888888,dniPs4 = 999999,cantidadPasajerosAgregados=0;
		Registro registro = null;
		ClasePasajero clase = null;
		Tipo tipoDeVehiculo = Tipo.AUTOBUS;
		

//	EJECUCION

		Persona persona = new Persona(nombreP, dniP);
		Persona chofer = new Chofer(nombreP, dniP, registro);
		Vehiculo moto1 = new Motocicleta(patenteM, kmRecorridosM);
		Vehiculo auto1 = new Automovil(patenteA, kmRecorridosA);
		Vehiculo micro1 = new Autobus(patenteMic, kmRecorridosMic);
		Persona acompaniante = new Acompaniante(nombreA, dniA, codPasajeroA);
		Persona pasajero = new Pasajero(nombrePs, dniPs, codPasajeroPs,clase);
		Persona pasajero1 = new Pasajero(nombrePs, dniPs1, codPasajeroPs1,clase);
		Persona pasajero2 = new Pasajero(nombrePs, dniPs2, codPasajeroPs2,clase);
		Persona pasajero3 = new Pasajero(nombrePs, dniPs3, codPasajeroPs3,clase);
		

		((Chofer) chofer).sacarRegistro(tipoDeVehiculo);

		((Vehiculo)auto1).agregarAcompañanteOPasajero(pasajero);
		cantidadPasajerosAgregados ++;
		((Vehiculo)auto1).agregarAcompañanteOPasajero(pasajero1);
		cantidadPasajerosAgregados ++;
		((Vehiculo)auto1).agregarAcompañanteOPasajero(pasajero2);
		cantidadPasajerosAgregados ++;
		((Vehiculo)auto1).agregarAcompañanteOPasajero(pasajero3);
		cantidadPasajerosAgregados ++;
		
		

//	VALIDACION
		Integer ve= cantidadPasajerosAgregados;
		Integer vo=((Vehiculo)auto1).getListadoPasajeros().size();

		assertEquals(ve,vo);

	}
	@Test // #11
	(expected = VehiculoLlenoException.class)
	public void vehiculoNoPuedeAgregarAcompañanteOPasajeroAutomovil() throws VehiculoLlenoException {// Vehiculo(patente,kmRecorridos)-->Autobus,Motocicleta,Automovil
//		PREPARACION

			String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123", nombreP = "Juan",
					nombreCh = "Jose", codPasajeroA = "AA11", codPasajeroPs = "PS00",codPasajeroPs1 = "PS11",codPasajeroPs2 = "PS22",
					codPasajeroPs3 = "PS33", codPasajeroPs4 = "PS44",codPasajeroPs5 = "PS55",nombreA = "Pedro",
					nombrePs = "Marcelo";
			Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999, dniP = 111111,
					dniCh = 222222, dniA = 333333, dniPs = 555555,dniPs1 = 666666,dniPs2 = 777777,dniPs3 = 888888,dniPs4 = 999999,cantidadPasajerosAgregados=0;
			Registro registro = null;
			ClasePasajero clase = null;
			Tipo tipoDeVehiculo = Tipo.AUTOBUS;
			

//		EJECUCION

			Persona persona = new Persona(nombreP, dniP);
			Persona chofer = new Chofer(nombreP, dniP, registro);
			Vehiculo moto1 = new Motocicleta(patenteM, kmRecorridosM);
			Vehiculo auto1 = new Automovil(patenteA, kmRecorridosA);
			Vehiculo micro1 = new Autobus(patenteMic, kmRecorridosMic);
			Persona acompaniante = new Acompaniante(nombreA, dniA, codPasajeroA);
			Persona pasajero = new Pasajero(nombrePs, dniPs, codPasajeroPs,clase);
			Persona pasajero1 = new Pasajero(nombrePs, dniPs1, codPasajeroPs1,clase);
			Persona pasajero2 = new Pasajero(nombrePs, dniPs2, codPasajeroPs2,clase);
			Persona pasajero3 = new Pasajero(nombrePs, dniPs3, codPasajeroPs3,clase);
			Persona pasajero4 = new Pasajero(nombrePs, dniPs4, codPasajeroPs4,clase);
			

			((Chofer) chofer).sacarRegistro(tipoDeVehiculo);

			auto1.agregarAcompañanteOPasajero((Persona)pasajero);
			cantidadPasajerosAgregados ++;
			auto1.agregarAcompañanteOPasajero((Persona)pasajero1);
			cantidadPasajerosAgregados ++;
			auto1.agregarAcompañanteOPasajero((Persona)pasajero2);
			cantidadPasajerosAgregados ++;
			auto1.agregarAcompañanteOPasajero((Persona)pasajero3);
			cantidadPasajerosAgregados ++;
			auto1.agregarAcompañanteOPasajero((Persona)pasajero4);
			cantidadPasajerosAgregados ++;
			
			

//		VALIDACION
			Integer ve= cantidadPasajerosAgregados;
			Integer vo=auto1.getListadoPasajeros().size();

			assertEquals(ve,vo);


	}
	@Test // #12
	public void vehiculoCambiarChofer() throws VehiculoLlenoException, VehiculoConPasajeroException, ChoferNoHabilitadoException  {

		String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123", nombreP = "Juan",
				nombreCh = "Jose", codPasajeroA = "AA11", codPasajeroPs = "PS00",codPasajeroPs1 = "PS11",codPasajeroPs2 = "PS22",
				codPasajeroPs3 = "PS33", codPasajeroPs4 = "PS44",codPasajeroPs5 = "PS55",nombreA = "Pedro",
				nombrePs = "Marcelo";
		Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999, dniP = 111111,
				dniCh = 222222, dniA = 333333, dniPs = 555555,dniPs1 = 666666,dniPs2 = 777777,dniPs3 = 888888,dniPs4 = 999999,cantidadPasajerosAgregados=0;
		Registro registro = null;
		ClasePasajero clase = null;
		Tipo tipoDeVehiculo = Tipo.AUTOBUS;
		

//	EJECUCION

		Persona persona = new Persona(nombreP, dniP);
		Persona chofer = new Chofer(nombreP, dniP, registro);
		Persona chofer2 = new Chofer(nombreCh, dniCh, registro);
		Vehiculo moto1 = new Motocicleta(patenteM, kmRecorridosM);
		Vehiculo auto1 = new Automovil(patenteA, kmRecorridosA);
		Vehiculo micro1 = new Autobus(patenteMic, kmRecorridosMic);
		Persona acompaniante = new Acompaniante(nombreA, dniA, codPasajeroA);
		Persona pasajero = new Pasajero(nombrePs, dniPs, codPasajeroPs,clase);
		

		((Chofer) chofer).sacarRegistro(tipoDeVehiculo);
		((Vehiculo)auto1).setChoferAsignado((Persona)chofer2);

//		((Vehiculo)auto1).agregarAcompañanteOPasajero(pasajero);
//		cantidadPasajerosAgregados ++;
		
		((Vehiculo)auto1).cambiarChofer((Persona)chofer);
		

//	VALIDACION
		Persona ve= chofer;
		Persona vo=((Vehiculo)auto1).getChoferAsignado();

		assertEquals(ve,vo);

	}
	@Test // #13
	(expected=VehiculoConPasajeroException.class)
	public void vehiculoNoPermiteCambiarChofer() throws VehiculoLlenoException, VehiculoConPasajeroException, ChoferNoHabilitadoException  {

		String nombre = "Te Llevo", patenteM = "MMM123", patenteA = "AAA123", patenteMic = "MIC123", nombreP = "Juan",
				nombreCh = "Jose", codPasajeroA = "AA11", codPasajeroPs = "PS00",codPasajeroPs1 = "PS11",codPasajeroPs2 = "PS22",
				codPasajeroPs3 = "PS33", codPasajeroPs4 = "PS44",codPasajeroPs5 = "PS55",nombreA = "Pedro",
				nombrePs = "Marcelo";
		Integer cuit = 1111111, kmRecorridosM = 777777, kmRecorridosA = 888888, kmRecorridosMic = 999999, dniP = 111111,
				dniCh = 222222, dniA = 333333, dniPs = 555555,dniPs1 = 666666,dniPs2 = 777777,dniPs3 = 888888,dniPs4 = 999999,cantidadPasajerosAgregados=0;
		Registro registro = null;
		ClasePasajero clase = null;
		Tipo tipoDeVehiculo = Tipo.AUTOBUS;
		

//	EJECUCION

		Persona persona = new Persona(nombreP, dniP);
		Persona chofer = new Chofer(nombreP, dniP, registro);
		Persona chofer2 = new Chofer(nombreCh, dniCh, registro);
		Vehiculo moto1 = new Motocicleta(patenteM, kmRecorridosM);
		Vehiculo auto1 = new Automovil(patenteA, kmRecorridosA);
		Vehiculo micro1 = new Autobus(patenteMic, kmRecorridosMic);
		Persona acompaniante = new Acompaniante(nombreA, dniA, codPasajeroA);
		Persona pasajero = new Pasajero(nombrePs, dniPs, codPasajeroPs,clase);
		

		((Chofer) chofer).sacarRegistro(tipoDeVehiculo);
		((Vehiculo)auto1).setChoferAsignado((Persona)chofer2);

		((Vehiculo)auto1).agregarAcompañanteOPasajero(pasajero);
		cantidadPasajerosAgregados ++;
		
		((Vehiculo)auto1).cambiarChofer((Persona)chofer);
		

//	VALIDACION
		Persona ve= chofer;
		Persona vo=((Vehiculo)auto1).getChoferAsignado();

		assertEquals(ve,vo);

	}

}
