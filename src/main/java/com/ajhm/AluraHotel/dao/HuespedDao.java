package com.ajhm.AluraHotel.dao;

import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ajhm.AluraHotel.factory.ConnectionFactory;
import com.ajhm.AluraHotel.modelo.Huesped;

/**
 * La clase HuespedDao se encarga de gestionar las operaciones de acceso a la base de datos relacionadas con los huéspedes.
 * Esto incluye guardar, listar, modificar y eliminar huéspedes en la base de datos.
 * 
 * @since 2023-08-26
 */

public class HuespedDao {
	
	final private Connection con;
	
    /**
     * Constructor de la clase HuespedDao.
     * @param con La conexión a la base de datos.
     */

	public HuespedDao(Connection con) {
		this.con = con;
	}
	
	/**
     * Guarda un huésped en la base de datos.
     *
     * @param huesped El huésped a ser guardado.
     */
	
	public void guardar(Huesped huesped) {
		
		try {
			final PreparedStatement statement = con.prepareStatement("INSERT INTO huespedes(id_reserva, nombre, apellido, fecha_nacimiento, nacionalidad, telefono)"
					+ " VALUES(?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				
				ejecutarReserva(huesped, statement);
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
     * Ejecuta la inserción del huésped en la base de datos y obtiene su ID generado.
     *
     * @param huesped El huésped a ser insertado.
     * @param statement El PreparedStatement para la inserción.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
	
	private void ejecutarReserva(Huesped huesped, PreparedStatement statement) throws SQLException {
		
        // Configuración de los parámetros del PreparedStatement
		statement.setLong(1,  huesped.getIdReserva());
		statement.setString(2, huesped.getNombre());
		statement.setString(3, huesped.getApellido());
		statement.setString(4, huesped.getFechaNacimiento());
		statement.setString(5, huesped.getNacionalidad());
		statement.setString(6, huesped.getTelefono());
		
        // Ejecución de la inserción
		statement.execute();
		
        // Obtención del ID generado y actualización en el objeto huésped
		final ResultSet resultSet = statement.getGeneratedKeys();
		
		try(resultSet){
			while(resultSet.next()) {
				huesped.setId(resultSet.getLong(1));
				//System.out.println(String.format("Fue insertado el huesped %s", huesped));
			}
		}
		
	}
	
	/**
     * Lista huéspedes de la base de datos basados en un campo específico.
     *
     * @param campo El campo utilizado para realizar la lista.
     * @return Una lista de huéspedes que cumplen con el criterio de búsqueda.
     */
public List<Huesped> listarHuespedes(String campo){
    // ... Código para listar huéspedes ...
		List<Huesped> resultado = new ArrayList<>();
		
		ConnectionFactory factory = new ConnectionFactory();
		
		final Connection con = factory.recuperaConexion();
		
		try(con){
			
			var querySelect = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes ";
			
			if(!campo.isEmpty()) {
			    querySelect	+= "WHERE apellido LIKE ? ";
			}
			
				querySelect	+= "ORDER BY id DESC; ";
				
			//System.out.println(querySelect);
			
			final PreparedStatement statement = con.prepareStatement(querySelect);
			
			try(statement){
				
				if(!campo.isEmpty()) {
					statement.setString(1, "%" + campo + "%");
				}
				
				statement.execute();
				
				final ResultSet resultSet = statement.getResultSet();
				
				try(resultSet) {
					while(resultSet.next()) {
						Huesped fila = new Huesped(
								resultSet.getLong("id"), 
								resultSet.getString("nombre"), 
								resultSet.getString("apellido"), 
								resultSet.getString("fecha_nacimiento"), 
								resultSet.getString("nacionalidad"),
								resultSet.getString("telefono"),
								resultSet.getLong("id_reserva")
								);
						
						resultado.add(fila);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return resultado;
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
    // ... Código para modificar huésped ...
	try {			

		final PreparedStatement statement = con.prepareStatement("UPDATE huespedes SET "
				+ "nombre = ?, "
				+ "apellido = ?, "
				+ "fecha_nacimiento = ?, "
				+ "nacionalidad = ?, "
				+ "telefono = ? "
				+ "WHERE id = ?");
		
		try(statement) {
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setString(3, fecha_nacimiento);
			statement.setString(4, nacionalidad);
			statement.setString(5, telefono);
			statement.setLong(6, id);
			
			statement.execute();	
			
			int updateCount = statement.getUpdateCount();
						
			return updateCount;
		}
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
}

/**
 * Elimina un huésped de la base de datos por su ID.
 *
 * @param id El ID del huésped a ser eliminado.
 * @return El número de filas afectadas en la base de datos.
 */
public int eliminar(Integer id) {
    // ... Código para eliminar huésped ...
	try {
	
			final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE id = ?");
			
			try(statement){
				statement.setInt(1, id);					
				statement.execute();
				
				int updateCount = statement.getUpdateCount();
				
				return updateCount;
			
		}
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	
}

/**
 * Elimina huéspedes de la base de datos asociados a un ID de reserva.
 *
 * @param id_reserva El ID de la reserva para la cual se eliminarán los huéspedes.
 * @return El número de filas afectadas en la base de datos.
 */
public int eliminarPorIDReserva(Integer id_reserva) {
    // ... Código para eliminar huéspedes por ID de reserva ...
	try {
	
			final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE id_reserva = ?");
			
			try(statement){
				statement.setInt(1, id_reserva);					
				statement.execute();
				
				int updateCount = statement.getUpdateCount();
				
				return updateCount;
			
		}
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	
}
	
}
