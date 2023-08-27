package com.ajhm.AluraHotel.controller;

import java.util.List;
import com.ajhm.AluraHotel.dao.HuespedDao;
import com.ajhm.AluraHotel.factory.ConnectionFactory;
import com.ajhm.AluraHotel.modelo.Huesped;

/**
 * La clase HuespedController es responsable de gestionar las operaciones relacionadas con los huéspedes.
 * Esto incluye guardar, listar, modificar y eliminar huéspedes en la base de datos.
 * Utiliza la clase HuespedDao para interactuar con la base de datos.
 * 
 * @since 2023-08-26
 */
public class HuespedController {

    private HuespedDao huespedDao;

    /**
     * Constructor de la clase HuespedController.
     * Inicializa el HuespedDao utilizando una instancia de ConnectionFactory.
     */
    public HuespedController() {
        this.huespedDao = new HuespedDao(new ConnectionFactory().recuperaConexion());
    }

    /**
     * Guarda un huésped en la base de datos.
     *
     * @param huesped El huésped a ser guardado.
     */
    public void guardar(Huesped huesped) {
        huespedDao.guardar(huesped);
    }

    /**
     * Lista huéspedes de la base de datos basados en un campo específico.
     *
     * @param campo El campo utilizado para realizar la lista.
     * @return Una lista de huéspedes que cumplen con el criterio de búsqueda.
     */
    public List<Huesped> listar(String campo) {
        return huespedDao.listarHuespedes(campo);
    }

    /**
     * Modifica los detalles de un huésped en la base de datos.
     *
     * @param nombre El nuevo nombre del huésped.
     * @param apellido El nuevo apellido del huésped.
     * @param fecha_nacimiento La nueva fecha de nacimiento del huésped.
     * @param nacionalidad La nueva nacionalidad del huésped.
     * @param telefono El nuevo número de teléfono del huésped.
     * @param id El ID del huésped a ser modificado.
     * @return El número de filas afectadas en la base de datos.
     */
    public int modificar(String nombre, String apellido, String fecha_nacimiento, String nacionalidad, String telefono, Long id) {
        return huespedDao.modificar(nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id);
    }

    /**
     * Elimina un huésped de la base de datos por su ID.
     *
     * @param id El ID del huésped a ser eliminado.
     * @return El número de filas afectadas en la base de datos.
     */
    public int eliminar(Integer id) {
        return huespedDao.eliminar(id);
    }

    /**
     * Elimina huéspedes de la base de datos asociados a un ID de reserva.
     *
     * @param id_reserva El ID de la reserva para la cual se eliminarán los huéspedes.
     * @return El número de filas afectadas en la base de datos.
     */
    public int eliminarPorIDReserva(Integer id_reserva) {
        return huespedDao.eliminarPorIDReserva(id_reserva);
    }
}

