package logica.poo.ui;

import logica.poo.centros.Centro;
import logica.poo.miembros.Miembro;
import logica.poo.operaciones.OperacionesMiembros;
import logica.poo.ui.Menu.OpcionMenu;

import java.util.ArrayList;

public class OpcionMenuListarMiembros extends OpcionMenu {

    @Override
    public void ejecutar() {
        System.out.println("Estos son los mimebros disponibles actualmente");

        OperacionesMiembros.listarMiembro();

    }

    @Override
    public String toString() {
        return "Listar miembros/Clientes";
    }

}
