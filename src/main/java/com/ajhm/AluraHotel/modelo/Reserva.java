package com.ajhm.AluraHotel.modelo;

/**
 * Esta clase representa una reserva realizada en el hotel.
 * Contiene información sobre las fechas de entrada y salida, el valor de la reserva
 * y la forma de pago utilizada.
 * 
 * @author AlexHolzM
 * @version 1.0
 * @since 2023-08-26
 * 
 */

/**
 * Constructor para crear una reserva con información básica.
 * 
 * @param fechaEntrada La fecha de entrada para la reserva.
 * @param fechaSalida  La fecha de salida para la reserva.
 * @param valor        El valor monetario de la reserva.
 * @param formaPago    La forma de pago utilizada para la reserva.
 */
public class Reserva {

	private Long id;
	private String fechaEntrada;
	private String fechaSalida;
	private Long valor;
	private String formaPago;

	/**
	 * Constructor para crear una reserva con información completa.
	 * 
	 * @param id           El ID de la reserva.
	 * @param fechaEntrada La fecha de entrada para la reserva.
	 * @param fechaSalida  La fecha de salida para la reserva.
	 * @param valor        El valor monetario de la reserva.
	 * @param formaPago    La forma de pago utilizada para la reserva.
	 */
	public Reserva(String fechaEntrada, String fechaSalida, Long valor, String formaPago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	/**
	 * Constructor para crear una reserva con información completa.
	 * 
	 * @param id           El ID de la reserva.
	 * @param fechaEntrada La fecha de entrada para la reserva.
	 * @param fechaSalida  La fecha de salida para la reserva.
	 * @param valor        El valor monetario de la reserva.
	 * @param formaPago    La forma de pago utilizada para la reserva.
	 */
	public Reserva(Long id, String fechaEntrada, String fechaSalida, Long valor, String formaPago) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	// Métodos getters y setters...
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	 /**
     * Genera una representación en formato de cadena del objeto Reserva.
     * 
     * @return Una cadena que representa los atributos de la reserva.
     */
	@Override
	public String toString() {
		return "Reserva [fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", valor=" + valor
				+ ", formaPago=" + formaPago + "]";
	}

}
