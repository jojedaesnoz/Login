package com.company;

import com.company.ui.Vista;

public class Programa {

    public static void main(String[] args) {
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(modelo, vista);

    }
}
