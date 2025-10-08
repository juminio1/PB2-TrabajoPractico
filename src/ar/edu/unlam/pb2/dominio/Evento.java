package ar.edu.unlam.pb2.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public abstract class Evento {

	private static Integer idIncremento = 0;
	private Integer id;
	private String nombre;
	private LocalDate fecha;
	private String lugar;
	private HashSet<Persona> participantes;
	// private Double precio;

	public Evento(String nombre, LocalDate fecha, String lugar) {
		this.id = ++idIncremento;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		// this.precio = precio;
		this.participantes = new HashSet<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public HashSet<Persona> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(HashSet<Persona> participantes) {
		this.participantes = participantes;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(fecha);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Evento other = (Evento) obj;
//		return Objects.equals(fecha, other.fecha);
//	}

	public abstract Boolean agregarParticipantes(Persona participante);

	public abstract Double calcularPrecioFinal();

}
