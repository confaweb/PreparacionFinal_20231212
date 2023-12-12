package testing;

import static org.junit.Assert.*;
/*
 * Enunciado:
Torneo de Arquería
Como todos sabemos, en los torneos de arquería se disparan flechas hacia un blanco que
consiste en varios círculos concéntricos y cada disparo es puntuado de acuerdo con su
distancia al centro.
Se sabe que todos los blancos utilizados en la competencia tienen 1 metro de diámetro. Se
considera que el centro tiene coordenadas (0,0).
Durante el torneo se van registrando los tiros realizados por todos los arqueros. Cada arquero
deberá llevar un registro de todos sus tiros (puntaje obtenido).
A cada arquero se le asigna un número de participante y por cada disparo se conoce
coordenada “x” e “y”. Para que un disparo se considere válido, debe haber sido registrado a
menor distancia del centro que el radio del blanco:
• Si la distancia al centro es <= 10 cm vale 1000 puntos.
• Si la distancia al centro es mayor que 10 cm y <= 20 cm vale 500 puntos.
• Si la distancia al centro es mayor que 20 cm y <= 30 cm vale 200 puntos.
• Si la distancia al centro es mayor que 30 cm y <= 40 cm vale 100 puntos.
• Si la distancia al centro es mayor que 40 cm y <= 50 cm vale 50 puntos.
• Más de 50 cm del centro es tiro inválido y no obtiene puntaje.
De todos los disparos registrados por participante, se deben considerar los 5 mejores. Si algún
participante no alcanza los 5 tiros válidos, es descalificado. Si un participante está descalificado
no podrá responder al puntaje obtenido en el torneo y se deberá lanzar una excepción.
No existe orden durante la competencia y no se conoce tampoco cuántos disparos se
registraron para cada participante, ni la cantidad de participantes.
Se te pide que ayudes a los organizadores a clasificar a los participantes e informar el podio
(1°, 2° y 3° puesto).
Generar al menos CINCO (5) casos de prueba significativos y al menos UNO (1) de ellos que
pruebe el escenario que lance la excepción. 

 */

import org.junit.Test;

import ar.edu.unlam.torneoDeArqueria.Disparo;
import ar.edu.unlam.torneoDeArqueria.NumeroOrdinalDisparo;
import ar.edu.unlam.torneoDeArqueria.Participante;
import ar.edu.unlam.torneoDeArqueria.Torneo;
import ar.edu.unlam.torneoDeArqueria.exception.DisparoInvalidoException;

public class TorneodeAruqeriaTestCases {

	@Test         //#1
	public void QueSePuedaCrearPersonasParticipantesQueRealizanDisparosSobreUnBlanco() {
//		PREPARACION
		
		Integer numeroParticipante=1,coordX=5,coordY=5;
		NumeroOrdinalDisparo orden = NumeroOrdinalDisparo.PRIMERO;
		
//		EJECUCION
		
		Participante participante1=new Participante(numeroParticipante);
		Disparo disparo = new Disparo(coordX,coordY,numeroParticipante,orden);
		
//		VALIDACION
		
		assertNotNull(participante1);
		assertNotNull(disparo);
	}
	@Test         //#2
	public void QueSePuedaCalcularPuntajePorDisparo() throws DisparoInvalidoException {
//		PREPARACION
		
		Integer numeroParticipante=1,coordX=3,coordY=42;
		NumeroOrdinalDisparo orden = NumeroOrdinalDisparo.PRIMERO;
		
//		EJECUCION
		
		Participante participante1=new Participante(numeroParticipante);
		Disparo disparo = new Disparo(coordX,coordY,numeroParticipante,orden);
		disparo.calcularPuntaje(coordX, coordY);
		
//		VALIDACION
		Integer ve=50;
		Integer vo=disparo.calcularPuntaje(coordX, coordY);
		
		
		assertEquals(ve,vo);
	}
	@Test         //#3
	(expected=DisparoInvalidoException.class)
	public void QueLanceExcepcionSiElTiroSeAlejaMasDe_50_CMdelCentro() throws DisparoInvalidoException {
//		PREPARACION
		
		Integer numeroParticipante=1,coordX=65,coordY=51;
		NumeroOrdinalDisparo orden = NumeroOrdinalDisparo.PRIMERO;
		
//		EJECUCION
		
		Participante participante1=new Participante(numeroParticipante);
		Disparo disparo = new Disparo(coordX,coordY,numeroParticipante,orden);
		disparo.calcularPuntaje(coordX, coordY);
		
//		VALIDACION
		Integer ve=50;
		Integer vo=disparo.calcularPuntaje(coordX, coordY);
		
		
		assertEquals(ve,vo);
	}
	@Test         //#4
	public void QueSePuedaREgistrarPuntajeDelDisparo() throws DisparoInvalidoException {
//		PREPARACION
		
		Integer numeroParticipante=1,coordX=3,coordY=42;
		NumeroOrdinalDisparo orden = NumeroOrdinalDisparo.PRIMERO;
		
//		EJECUCION
		
		Participante participante1=new Participante(numeroParticipante);
		Disparo disparo = new Disparo(coordX,coordY,numeroParticipante,orden);
		disparo.calcularPuntaje(coordX, coordY);
		participante1.registrarPuntajeDisparo( disparo);
		
//		VALIDACION
		
		assertTrue(participante1.registrarPuntajeDisparo( disparo));
		
		
	}
	@Test         //#5
	public void QueSePuedaSumaryMostrarPuntajeDelDisparo() throws DisparoInvalidoException {
//		PREPARACION
		
		Integer numeroParticipante=1,coordX=3,coordY=42,coordX1=5,coordY1=25,coordX2=8,coordY2=1;
		NumeroOrdinalDisparo orden = NumeroOrdinalDisparo.PRIMERO,orden1 = NumeroOrdinalDisparo.SEGUNDO,
				orden2 = NumeroOrdinalDisparo.TERCERO;
		
//		EJECUCION
		
		Participante participante1=new Participante(numeroParticipante);
		Disparo disparo = new Disparo(coordX,coordY,numeroParticipante,orden);
		Disparo disparo1 = new Disparo(coordX1,coordY1,numeroParticipante,orden1);
		Disparo disparo2 = new Disparo(coordX2,coordY2,numeroParticipante,orden2);
		disparo.calcularPuntaje(coordX, coordY);
		
		participante1.registrarPuntajeDisparo( disparo);
		participante1.registrarPuntajeDisparo( disparo1);
		participante1.registrarPuntajeDisparo( disparo2);
		participante1.sumarYMostrarTotal();
		
		
//		VALIDACION
		
		Integer ve=1250;
		Integer vo=participante1.sumarYMostrarTotal();
		
		
		assertEquals(ve,vo);
		
		
	}
	@Test         //#6
	public void QueSePuedaCrearRegistroDeParticipantes() throws DisparoInvalidoException {
//		PREPARACION
		
		Integer numeroParticipante=1,coordX=3,coordY=42,coordX1=5,coordY1=25,coordX2=8,coordY2=1,//puntaje participante1=1250
				numeroParticipante2=2,coordX00=3,coordY00=5,coordX11=5,coordY11=6,coordX22=8,coordY22=1,//puntaje participante2=3000
				numeroParticipante3=2,coordX000=25,coordY000=25,coordX111=25,coordY111=26,coordX222=28,coordY222=21,//puntaje participante2=1500
				codigoTorneo=123123123;
		NumeroOrdinalDisparo orden = NumeroOrdinalDisparo.PRIMERO,orden1 = NumeroOrdinalDisparo.SEGUNDO,
				orden2 = NumeroOrdinalDisparo.TERCERO;
		String nombreTorneo="Olympic";
		
//		EJECUCION
		Torneo torneo=new Torneo(nombreTorneo,codigoTorneo);
		
		Participante participante1=new Participante(numeroParticipante);
		Disparo disparo = new Disparo(coordX,coordY,numeroParticipante,orden);
		Disparo disparo1 = new Disparo(coordX1,coordY1,numeroParticipante,orden1);
		Disparo disparo2 = new Disparo(coordX2,coordY2,numeroParticipante,orden2);
		disparo.calcularPuntaje(coordX, coordY);
		
		Participante participante2=new Participante(numeroParticipante);
		Disparo disparo00 = new Disparo(coordX00,coordY00,numeroParticipante2,orden);
		Disparo disparo11 = new Disparo(coordX11,coordY11,numeroParticipante2,orden1);
		Disparo disparo22 = new Disparo(coordX22,coordY22,numeroParticipante2,orden2);
		disparo.calcularPuntaje(coordX00, coordY00);
		
		Participante participante3=new Participante(numeroParticipante);
		Disparo disparo000 = new Disparo(coordX000,coordY000,numeroParticipante3,orden);
		Disparo disparo111 = new Disparo(coordX111,coordY111,numeroParticipante3,orden1);
		Disparo disparo222 = new Disparo(coordX222,coordY222,numeroParticipante3,orden2);
		disparo.calcularPuntaje(coordX000, coordY000);
		
		participante1.registrarPuntajeDisparo( disparo);
		participante1.registrarPuntajeDisparo( disparo1);
		participante1.registrarPuntajeDisparo( disparo2);
		participante1.sumarYMostrarTotal();
		
		participante2.registrarPuntajeDisparo( disparo00);
		participante2.registrarPuntajeDisparo( disparo11);
		participante2.registrarPuntajeDisparo( disparo22);
		participante2.sumarYMostrarTotal();
		
		participante3.registrarPuntajeDisparo( disparo000);
		participante3.registrarPuntajeDisparo( disparo111);
		participante3.registrarPuntajeDisparo( disparo222);
		participante3.sumarYMostrarTotal();
		
		torneo.registraParticipantePorTotal(participante1);
		torneo.registraParticipantePorTotal(participante2);
		torneo.registraParticipantePorTotal(participante3);
		
		
		
		
//		VALIDACION
		
		
		assertFalse(torneo.getRanking().isEmpty());
		assertTrue(torneo.getRanking().contains(participante1));
		assertTrue(torneo.getRanking().contains(participante2));
		assertTrue(torneo.getRanking().contains(participante3));
		
		
		
		
		
	}
	



}
