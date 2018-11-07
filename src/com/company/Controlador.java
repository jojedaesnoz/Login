package com.company;

import com.company.ui.Login;
import com.company.ui.Vista;

import java.sql.SQLException;

public class Controlador {
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;

    /*
    TODO: poner que cuando falle el login te informe del error, borre la contraseña y
    seleccione el texto + request focus.
     */
        try {
            modelo.conectar();
            iniciarSesion();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void iniciarSesion() {
        Login login = new Login();

        login.btEntrar.addActionListener(e -> {
            System.out.println("ESAd");
            try {
                String usuario = login.tfUsuario.getText();
                String contrasena = login.tfContrasena.getText();
                if (modelo.iniciarSesion(usuario, contrasena)){
                    login.dispose();
                }
                else {
                    System.out.println("ERROR");
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });



        login.btSalir.addActionListener(e -> {

        });

    }

    private void ponerListeners() {

    }
}
