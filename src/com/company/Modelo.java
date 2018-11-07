package com.company;


import java.sql.*;

public class Modelo {

    // Todo: ponerlo en un fichero properties
    private final String IP = "192.168.34.5";
    private final String BASE_DATOS = "damt";
    private final String USUARIO = "damt";
    private final String CONTRASENA = "damt";
    private Connection conexion;


    public void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(
                "jdbc:mysql://" + IP + ":3306/" + BASE_DATOS, USUARIO, CONTRASENA);
    }

    /*
    Los permisos de usuario y demás se verifican en la aplicación, NO EN LA BASE DE DATOS
     */

    private void cargarConfiguracion() {

    }

    public void desconectar() throws SQLException {
        conexion.close();
        conexion = null;
    }


    public boolean iniciarSesion(String usuario, String contrasena) throws SQLException {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE usuario = ? " +
                "AND CONTRASENA = ?";

        // Parametrizar la consulta para evitar inyeccion de codigo
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, usuario);
        sentencia.setString(2, contrasena);

        ResultSet resultado = sentencia.executeQuery();
        return resultado.next();
    }
}
