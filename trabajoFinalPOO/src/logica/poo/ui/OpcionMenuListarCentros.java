package logica.poo.ui;

import logica.poo.centros.Centro;
import logica.poo.operaciones.OperacionesCentros;
import logica.poo.ui.Menu.OpcionMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class OpcionMenuListarCentros extends OpcionMenu {

    @Override
    public void ejecutar() {

        System.out.println("Estos son los centros disponibles actualmente ");

        OperacionesCentros.listarCentros();
        }


    @Override
    public String toString() {
        return "Listar Centros";
    }

}

