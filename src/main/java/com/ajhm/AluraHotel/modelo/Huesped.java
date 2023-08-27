package com.ajhm.AluraHotel.modelo;

/**
 * Esta clase representa un huésped que puede realizar reservas en el hotel.
 * Contiene información personal y de reserva relacionada con el huésped.
 * 
 * @author AlexHolzM
 * @version 1.0
 * 
 */

public class Huesped {
	
	private Long id;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	private Long idReserva;
	
	/**
     * Constructor para crear un objeto Huesped con información básica.
     * 
     * @param nombre         El nombre del huésped.
     * @param apellido       El apellido del huésped.
     * @param fechaNacimiento La fecha de nacimiento del huésped.
     * @param nacionalidad   La nacionalidad del huésped.
     * @param telefono       El número de teléfono del huésped.
     * @param idReserva      El ID de la reserva asociada al huésped.
     */
	
	public Huesped(String nombre, String apellido, String fechaNacimiento, String nacionalidad,String telefono, Long idReserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}

	/**
     * Constructor para crear un objeto Huesped con información completa.
     * 
     * @param id             El ID del huésped.
     * @param nombre         El nombre del huésped.
     * @param apellido       El apellido del huésped.
     * @param fechaNacimiento La fecha de nacimiento del huésped.
     * @param nacionalidad   La nacionalidad del huésped.
     * @param telefono       El número de teléfono del huésped.
     * @param idReserva      El ID de la reserva asociada al huésped.
     */
	
	public Huesped(Long id, String nombre, String apellido, String fechaNacimiento, String nacionalidad,
			String telefono, Long idReserva) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}
	
	// Métodos getters y setters...

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}	
	
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	/**
     * Genera una representación en formato de cadena del objeto Huesped.
     * 
     * @return Una cadena que representa los atributos del huésped.
     */
	
	@Override
	public String toString() {
		return "Huesped [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", nacionalidad=" + nacionalidad + ", telefono=" + telefono + ", idReserva="
				+ idReserva + "]";
	}	
	
	
}
