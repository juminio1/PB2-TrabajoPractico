package ar.edu.unlam.pb2.dominio;

import java.time.LocalDate;
import java.util.HashSet;

public class Conferencia extends Evento{

	private static final Integer CANTIDAD_PARTICIPANTES = 500;
	private static final Double PRECIO_POR_PARTICIPANTE = 1000.0;
	private static final Integer EDAD_PERMITIDA = 13;
	
	
	public Conferencia(String nombre, LocalDate fecha, String lugar) {
		super(nombre, fecha, lugar);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Boolean agregarParticipantes(Persona participante) {
		
		HashSet<Persona> personas = getParticipantes();
		Integer cantidadPersonas = personas.size();
		
		if(cantidadPersonas < Conferencia.CANTIDAD_PARTICIPANTES && participante.getEdad() >= Conferencia.EDAD_PERMITIDA) {
			return personas.add(participante);
		}
		
		return false;
	}


	@Override
	public Double calcularPrecioFinal() {
		HashSet<Persona> personas = getParticipantes();
		
		Integer cantidadPersonas = personas.size();
		
		Double precioFinal = cantidadPersonas * Conferencia.PRECIO_POR_PARTICIPANTE;
		
		return precioFinal;
	}

}
