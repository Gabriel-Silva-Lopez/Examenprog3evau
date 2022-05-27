package Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	/*
	 * Clase encargada de llevar la conexion con mysql en el ejercicio1
	 * del examen de programacion 3 evaluacion
	 */
		private Connection connect = null;
		private Statement statement = null;
		private PreparedStatement preparedStatement = null;
		private ResultSet resultSet = null;
		final private String host = "localhost:3306/prog1";
		final private String user = "root";
		final private String passwd = "root";
		
		
		/**
		 * Pre:-----------
		 * Post: Metodo que añade una palabra a la base de datos con su palabra y
		 * la linea en la que se situa
		 */
		public void setDataBase(Palabra palabra) throws Exception {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connect = DriverManager
						.getConnection("jdbc:mysql://" + host + "?"
								+ "user=" + user + "&password=" + passwd );
				   //statement = connect.createStatement();
				   preparedStatement = connect
					       .prepareStatement("insert into palabras(palabra,linea)"
					       					+ " values (?,?)");
				   preparedStatement.setString(1, palabra.getStr());
				   preparedStatement.setInt(2, palabra.getLinea());
				   preparedStatement.executeUpdate();
				   //connect.commit();
			} catch (Exception e) {
				throw e;
			} finally {
			    close();
			}
		}
		
		/**
		 * Pre:-----------
		 * Post: Metodo que prepara una query para leer los datos de la base
		 * y ser escritos por writeResultSet
		 */
		public void readDataBase() throws Exception {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connect = DriverManager
						.getConnection("jdbc:mysql://" + host + "?"
								+ "user=" + user + "&password=" + passwd );
			   statement = connect.createStatement();
			
			   resultSet = statement
			       .executeQuery("select * from palabras");
			   System.out.println("QUERY ---> select * from palabras");

			   writeResultSet(resultSet);
			} catch (Exception e) {
				throw e;
			}  finally {
		    close();
			}
		}
		
		
		/**
		 * Pre:-----------
		 * Post: Metodo que muestra por pantalla el resultado de la query enviada
		 */	
			private void writeResultSet(ResultSet resultSet) throws SQLException {
				while (resultSet.next()) {
					String palabra = resultSet.getString(2);
				   int linea = resultSet.getInt(3);
				   System.out.println("\tpalabra: " + palabra);
				   System.out.println("\tLinea: " + linea);
				}
			}
			
		/**
		* Pre:-----------
		* Post: Metodo que cierra toda la conexion
		 */
		private void close() {
			try {
				if (resultSet != null) {
					resultSet.close();
				} if (statement != null) {
					statement.close();
				} if (connect != null) {
					connect.close();
				}
			} catch (Exception e) {
				
			}
		}
}