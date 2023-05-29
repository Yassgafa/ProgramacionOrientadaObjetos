package logica.poo.inicio;

import logica.poo.ui.*;
import logica.poo.ui.Menu.OpcionMenu;
import logica.poo.ui.PaqueteMenuConsola.MenuConsola;

public class GestionGimnasio {
    public static void main (String[] args){


        OpcionMenu opcion1 = new OpcionMenuCrearCentro();

        OpcionMenu opcion2 = new OpcionMenuListarCentros();

        OpcionMenu opcion3 = new OpcionMenuCrearMiembro() ;

        OpcionMenu opcion4 = new OpcionMenuListarMiembros();

        OpcionMenu opcion5 = new OpcionMenuMiembrosCentro();

        OpcionMenu opcion6 = new EditarCentros();

        OpcionMenu opcion7 = new EditarMiembros();

        OpcionMenu opcion8 = new GuardarObjetos();

        OpcionMenu opcion9 = new CargarObjetos();
          
        MenuConsola menu = new MenuConsola();
        menu.anadirOpcion(opcion1);
        menu.anadirOpcion(opcion2);
        menu.anadirOpcion(opcion3);
        menu.anadirOpcion(opcion4);
        menu.anadirOpcion(opcion5);
        menu.anadirOpcion(opcion6);
        menu.anadirOpcion(opcion7);
        menu.anadirOpcion(opcion8);
        menu.anadirOpcion(opcion9);

        menu.lanzarMenu();

    }


}