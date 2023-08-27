package com.ajhm.AluraHotel.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import com.ajhm.AluraHotel.factory.ConnectionFactory;

/**
 * Esta clase contiene un programa de prueba para establecer y cerrar una conexión a la base de datos.
 * Utiliza la clase ConnectionFactory para obtener la conexión.
 * 
 * @author AlexHolzM
 * @version 1.0
 * @since 2023-08-26
 * 
 */
public class PruebaConexion {

    /**
     * Punto de entrada del programa de prueba.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     * @throws SQLException Si ocurre un error al manejar la conexión.
     */
    public static void main(String[] args) throws SQLException {
        // Obtener una conexión a la base de datos utilizando la fábrica de conexiones
        Connection con = new ConnectionFactory().recuperaConexion();

        System.out.println("Conexión establecida");

        // Cerrar la conexión
        con.close();

        System.out.println("Conexión cerrada");
    }
}
