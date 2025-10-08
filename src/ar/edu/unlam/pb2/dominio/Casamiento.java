package ar.edu.unlam.pb2.dominio;

import java.time.LocalDate;
import java.util.HashSet;

public class Casamiento extends Evento{

	private static final Integer CANTIDAD_PARTICIPANTES = 1;
	private static final Double PRECIO_POR_PARTICIPANTE = 500.0;
	private static final Integer EDAD_PERMITIDA = 3;

	private Boolean tieneCatering;
	
	
	public Casamiento(String nombre, LocalDate fecha, String lugar, Boolean tieneCatering) {
		super(nombre, fecha, lugar);
		this.tieneCatering = tieneCatering;
		// TODO Auto-generated constructor stub
	}

	
	
	public Boolean getTieneCatering() {
		return tieneCatering;
	}



	@Override
	public Boolean agregarParticipantes(Persona participante) {

		HashSet<Persona> personas = getParticipantes();
		Integer cantidadPersonas = personas.size();
		
		
		if(cantidadPersonas < Casamiento.CANTIDAD_PARTICIPANTES && participante.getEdad() >= Casamiento.EDAD_PERMITIDA) {
			return personas.add(participante);
		}
		
		return false;
	}

	@Override
	public Double calcularPrecioFinal() {
		
		HashSet<Persona> personas = getParticipantes();
		Integer cantidadPersonas = personas.size();
		
		Double precioFinal = cantidadPersonas * Casamiento.PRECIO_POR_PARTICIPANTE;
		
		if(getTieneCatering() == true) {
			return precioFinal += precioFinal * 0.1;
		}
		
		return precioFinal;
	}

}
