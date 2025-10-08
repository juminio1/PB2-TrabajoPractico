package ar.edu.unlam.pb2.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class TestSistemaDeEventos {

	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnRecitalExitosamente(){
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";
		
		//Evento evento = new Evento(nombre, fecha, lugar);
		Recital recitalNuevo = new Recital(nombre, fecha, lugar);
		
		Boolean seAgrego = sistema.agregarEvento(recitalNuevo);
		
		assertTrue(seAgrego);
	}
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnaConferenciaExitosamente(){
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";
		
		Conferencia conferenciaNueva = new Conferencia(nombre, fecha, lugar);
		
		Boolean seAgrego = sistema.agregarEvento(conferenciaNueva);
		
		assertTrue(seAgrego);
	}
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnCasamientoExitosamente(){
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";
		
		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		
		assertTrue(seAgrego);
	}
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroCrearUnCasamientoQueSupereLaCantidadDeParticipantesProvistas(){
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";
		
		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);

		Integer casamientoId = casamientoNueva.getId();
		
		Persona persona1 = new Persona(912, "Jose", 20);
		Persona persona2 = new Persona(31, "Julieta", 74);
		
		Boolean seAgregoParticipante = sistema.agregarParticipante(casamientoId, persona1);
		Boolean seAgregoParticipante2 = sistema.agregarParticipante(casamientoId, persona2);

		assertTrue(seAgrego);
		assertTrue(seAgregoParticipante);
		assertFalse(seAgregoParticipante2);

	}
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroAgregarDosPersonasAlEventoConElMismoDNIyObtenerError(){
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";
		
		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		Integer casamientoId = casamientoNueva.getId();

		
		Persona persona1 = new Persona(912, "Jose", 20);
		Persona persona2 = new Persona(912, "Julieta", 74);
		
		Boolean seAgregoParticipante = sistema.agregarParticipante(casamientoId, persona1);
		Boolean seAgregoParticipante2 = sistema.agregarParticipante(casamientoId, persona2);

		assertTrue(seAgrego);
		assertTrue(seAgregoParticipante);
		assertFalse(seAgregoParticipante2);

	}
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroAgregarParticipantesEnUnEventoConIdInventado(){

		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lol";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Movistar Arena";
		
		Casamiento casamientoNueva = new Casamiento(nombre, fecha, lugar, false);
		Boolean seAgrego = sistema.agregarEvento(casamientoNueva);
		Integer idInventado = 5;

		
		Persona persona1 = new Persona(912, "Jose", 20);
		Persona persona2 = new Persona(1, "Julieta", 74);
		
		Boolean seAgregoParticipante = sistema.agregarParticipante(idInventado, persona1);
		Boolean seAgregoParticipante2 = sistema.agregarParticipante(idInventado, persona2);

		assertTrue(seAgrego);
		assertFalse(seAgregoParticipante);
		assertFalse(seAgregoParticipante2);
	}
	
	// Calcular costoTotal dependiendo el tipo de evento (cada evento tiene una entrada con costo distinto) 1 EMIR
	
	// No se puede agregar un participante que no cumpla con la edad requerida por cada tipo de evento  2 VERO
	
	// No se puede crear dos eventos con misma fecha 3 LUCAS
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosNoPuedoAgregarDosEventosConLaMismaFecha() {
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lollapalooza";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Hipodromo";
		
		Recital recital = new Recital(nombre, fecha, lugar);
		
		String nombre2 = "Conferencia";
		String lugar2 = "Auditorio";

		Conferencia conferencia = new Conferencia(nombre2, fecha, lugar2);
		
		Boolean seAgregoRecital = sistema.agregarEvento(recital);
		Boolean seAgregoConferencia = sistema.agregarEvento(conferencia);

		assertTrue(seAgregoRecital);
		assertFalse(seAgregoConferencia);
		
	}
	
	// buscar evento por fecha EMIR
	
	// devolver lista cantidad de participantes DORIAN
	
	// devolver lista cantidad de eventos LUCAS
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroSaberCuantosEventosEstanRegistradosDeCadaTipo() {
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lollapalooza";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Hipodromo";
		
		Recital recital = new Recital(nombre, fecha, lugar);
		
		String nombre2 = "Conferencia";
		LocalDate fecha2 = LocalDate.of(2025, 10, 7);
		String lugar2 = "Auditorio";

		Conferencia conferencia = new Conferencia(nombre2, fecha2, lugar2);
		
		String nombre3 = "Casamiento";
		LocalDate fecha3 = LocalDate.of(2025, 10, 8);
		String lugar3 = "Salon";
		
		Casamiento casamiento = new Casamiento(nombre3, fecha3, lugar3, true);
		
		sistema.agregarEvento(recital);
		sistema.agregarEvento(conferencia);
		sistema.agregarEvento(casamiento);

		Integer cantCasamientos = sistema.getCantCasamientos();
		Integer cantRecital = sistema.getCantRecital();
		Integer cantConferencia = sistema.getCantConferencias();
		
		Integer cantEsperada = 1;
		
		assertEquals(cantEsperada, cantCasamientos);
		assertEquals(cantEsperada, cantRecital);
		assertEquals(cantEsperada, cantConferencia);

	}
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroSaberCuantosEventosEstanRegistrados() {
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lollapalooza";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Hipodromo";
		
		Recital recital = new Recital(nombre, fecha, lugar);
		
		String nombre2 = "Conferencia";
		LocalDate fecha2 = LocalDate.of(2025, 10, 7);
		String lugar2 = "Auditorio";

		Conferencia conferencia = new Conferencia(nombre2, fecha2, lugar2);
		
		String nombre3 = "Casamiento";
		LocalDate fecha3 = LocalDate.of(2025, 10, 8);
		String lugar3 = "Salon";
		
		Casamiento casamiento = new Casamiento(nombre3, fecha3, lugar3, true);
		
		sistema.agregarEvento(recital);
		sistema.agregarEvento(conferencia);
		sistema.agregarEvento(casamiento);

		ArrayList<Evento> eventos = sistema.getEventos();
		Integer cantEventos = eventos.size();
		Integer cantEsperada = 3;
		assertEquals(cantEsperada, cantEventos);

	}
	
	// devolver el evento con mayor cantidad de participantes JULI
	
	// devolver evento con mayor promedio de edad de participantes LUCAS
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroSaberElPromedioDeEdadDeUnEvento() {
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lollapalooza";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Hipodromo";
		
		Recital recital = new Recital(nombre, fecha, lugar);
		Integer idR = recital.getId();
	
		sistema.agregarEvento(recital);
		
		Persona persona1 = new Persona(912, "Adrian", 20); 
		Persona persona2 = new Persona(31, "Emilia", 30);
		
		sistema.agregarParticipante(idR, persona1);
		sistema.agregarParticipante(idR, persona2);

		double promedioEdad = sistema.obtenerPromedioDeEdadDeEvento(idR);
		double esperado = 25.0;
		
		assertEquals((int)esperado, (int)promedioEdad);
		
	}
	
	@Test
	public void dadoQueExisteUnSistemaDeEventosQuieroSaberCualEsElEventoConMasPromedioDeEdad() {
		
		SistemaDeEventos sistema = new SistemaDeEventos();
		
		String nombre = "Lollapalooza";
		LocalDate fecha = LocalDate.of(2025, 10, 6);
		String lugar = "Hipodromo";
		
		Recital recital = new Recital(nombre, fecha, lugar);
		Integer idR = recital.getId();
		
		String nombre2 = "Conferencia";
		LocalDate fecha2 = LocalDate.of(2025, 10, 7);
		String lugar2 = "Auditorio";

		Conferencia conferencia = new Conferencia(nombre2, fecha2, lugar2);
		Integer idC = conferencia.getId();

		sistema.agregarEvento(recital);
		sistema.agregarEvento(conferencia);
			
		Persona persona1 = new Persona(912, "Adrian", 20); 
		Persona persona2 = new Persona(31, "Emilia", 30);
		Persona persona5 = new Persona(999, "Emilia", 30);
		sistema.agregarParticipante(idR, persona1);
		sistema.agregarParticipante(idR, persona2);
		sistema.agregarParticipante(idR, persona5);

		
		Persona persona3 = new Persona(91218, "Adrian", 45); 
		Persona persona4 = new Persona(18, "Emilia", 25);
		sistema.agregarParticipante(idC, persona3);
		sistema.agregarParticipante(idC, persona4);

		Evento eventoConMasPromedio = sistema.obtenerElEventoConMayorPromedioDeEdad();
		
		assertEquals(eventoConMasPromedio, conferencia);
		
	}
	
	
	
	// buscar cuantos eventos se encuentran disponibles en un lapso de dos fechas VERO
	
	// eliminar evento con exito por ID DORIAN
	
	// eliminar participante por DNI JULI
		
	// BUSCAR PERSONA EN EVENTO POR ID
	
	
	
	

	
	
}
