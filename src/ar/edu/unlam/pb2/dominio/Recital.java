package ar.edu.unlam.pb2.dominio;

import java.time.LocalDate;
import java.util.HashSet;

public class Recital extends Evento{

	private static final Integer CANTIDAD_PARTICIPANTES = 2000;
	private static final Double PRECIO_POR_PARTICIPANTE = 3000.0;
	private static final Integer EDAD_PERMITIDA = 18;
	
	
	public Recital(String nombre, LocalDate fecha, String lugar) {
		super(nombre, fecha, lugar);
		// TODO Auto-generated constructor stub
	}


	@Override
	public Boolean agregarParticipantes(Persona participante) {
		
		HashSet<Persona> personas = getParticipantes();
		Integer cantidadPersonas = personas.size();
				
		if(cantidadPersonas < Recital.CANTIDAD_PARTICIPANTES && participante.getEdad() >= Recital.EDAD_PERMITIDA) {
			return personas.add(participante);
		}
		
		return false;
	}


	@Override
	public Double calcularPrecioFinal() {
		HashSet<Persona> personas = getParticipantes();
		
		Integer cantidadPersonas = personas.size();
		
		Double precioFinal = cantidadPersonas * Recital.PRECIO_POR_PARTICIPANTE;
		
		return precioFinal;
	}

}
