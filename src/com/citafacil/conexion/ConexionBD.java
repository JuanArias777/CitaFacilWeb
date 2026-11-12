package com.citafacil.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/citafacil_db?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "juan777sql@juanchopolo#27";
    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✅ Conexión exitosa a la base de datos citafacil_db vía JDBC.");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: No se encontró el Driver JDBC de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Error de SQL al conectar con la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }
}