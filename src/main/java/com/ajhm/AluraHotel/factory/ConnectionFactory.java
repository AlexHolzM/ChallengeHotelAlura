package com.ajhm.AluraHotel.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Esta clase proporciona una fábrica de conexiones a la base de datos utilizando
 * C3P0 para la gestión del pool de conexiones.
 * 
 * @author AlexHolzM
 * @since 2023-08-26
 * @version 1.0
 * 
 */
public class ConnectionFactory {
    private DataSource dataSource;

    /**
     * Constructor de la fábrica de conexiones.
     * Configura el pool de conexiones C3P0 con los parámetros necesarios.
     */
    public ConnectionFactory() {
        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
        pooledDataSource.setUser("root");
        pooledDataSource.setPassword("ah1835");
        pooledDataSource.setMaxPoolSize(10);

        this.dataSource = pooledDataSource;
    }

    /**
     * Recupera una conexión de la base de datos.
     * 
     * @return Objeto Connection que representa la conexión a la base de datos.
     * @throws RuntimeException Si ocurre un error al obtener la conexión.
     */
    public Connection recuperaConexion() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar la conexión", e);
        }
    }
}
