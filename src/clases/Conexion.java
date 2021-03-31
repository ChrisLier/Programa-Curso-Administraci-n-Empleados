//Conectarnos a nuestra bases de datos
package clases;

import java.sql.*;  //Para la conexion

public class Conexion {

    //Conexion Local
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/baseproyectofinaljava", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en " + e);
        }
        return (null); //Evitar que mande algo
    }

}
