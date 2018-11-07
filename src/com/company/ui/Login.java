package com.company.ui;

import javax.swing.*;
import java.awt.*;

public class Login extends JDialog {
    public JLabel lUser, lPass;
    public JTextField tfUsuario, tfContrasena;
    public JButton btEntrar, btSalir;

    public Login() {
        prepararComponentes();
        mostrarVentana();
    }

    private void prepararComponentes() {
        lUser = new JLabel("Usuario:", SwingConstants.CENTER);
        lPass = new JLabel("Contraseña:", SwingConstants.CENTER);
        tfUsuario = new JTextField();
        tfContrasena = new JTextField();
        btEntrar = new JButton("Entrar");
        btSalir = new JButton("Salir");

        setLayout(new GridLayout(3, 2));
        for (JComponent component: new JComponent[]{lUser, tfUsuario, lPass, tfContrasena, btEntrar, btSalir}){
            add(component);
            component.setPreferredSize(new Dimension(160, 35));
        }
    }

    private void mostrarVentana() {
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        //setModal(true);
        setTitle("Mi aplicación");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
