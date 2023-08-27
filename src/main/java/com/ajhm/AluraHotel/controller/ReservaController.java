package com.ajhm.AluraHotel.controller;

import java.util.List;
import com.ajhm.AluraHotel.dao.ReservaDao;
import com.ajhm.AluraHotel.factory.ConnectionFactory;
import com.ajhm.AluraHotel.modelo.Reserva;

/**
 * La clase ReservaController es responsable de gestionar las operaciones relacionadas con las reservas.
 * Esto incluye guardar, listar, modificar y eliminar reservas en la base de datos.
 * Utiliza la clase ReservaDao para interactuar con la base de datos.
 * 
 * @since 2023-08-26
 */
public class ReservaController {

    private ReservaDao reservaDao;

    /**
     * Constructor de la clase ReservaController.
     * Inicializa el ReservaDao utilizando una instancia de ConnectionFactory.
     */
    public ReservaController() {
        this.reservaDao = new ReservaDao(new ConnectionFactory().recuperaConexion());
    }

    /**
     * Guarda una reserva en la base de datos.
     *
     * @param reserva La reserva a ser guardada.
     */
    public void guardar(Reserva reserva) {
        reservaDao.guardar(reserva);
    }

    /**
     * Lista reservas de la base de datos basadas en un campo específico.
     *
     * @param campo El campo utilizado para realizar la lista.
     * @return Una lista de reservas que cumplen con el criterio de búsqueda.
     */
    public List<Reserva> listar(String campo) {
        return reservaDao.listarReservas(campo);
    }

    /**
     * Modifica los detalles de una reserva en la base de datos.
     *
     * @param fecha_entrada La nueva fecha de entrada de la reserva.
     * @param fecha_salida La nueva fecha de salida de la reserva.
     * @param valor El nuevo valor de la reserva.
     * @param forma_pago La nueva forma de pago de la reserva.
     * @param id El ID de la reserva a ser modificada.
     * @return El número de filas afectadas en la base de datos.
     */
    public int modificar(String fecha_entrada, String fecha_salida, Double valor, String forma_pago, Long id) {
        return reservaDao.modificar(fecha_entrada, fecha_salida, valor, forma_pago, id);
    }

    /**
     * Elimina una reserva de la base de datos por su ID.
     *
     * @param id El ID de la reserva a ser eliminada.
     * @return El número de filas afectadas en la base de datos.
     */
    public int eliminar(Integer id) {
        return reservaDao.eliminar(id);
    }
}
