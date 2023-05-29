package logica.poo.ui;

import logica.poo.centros.Centro;
import logica.poo.operaciones.OperacionesCentros;
import logica.poo.ui.Menu.OpcionMenu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OpcionMenuMiembrosCentro extends OpcionMenu {

    private Centro centro;
    @Override
    public void ejecutar() {

        Scanner sc = new Scanner(System.in);

      //  System.out.println("Ingrese el Id del centro de acondicionamiento");
        //int idCentro = sc.nextInt();
        //a cual centro se va a agregar
        int idCentro= 0;
        boolean respuestaValida;
        do {
            System.out.println("ingrese el id del centro de acondicionamiento");

            try {
                idCentro= sc.nextInt();
                sc.nextLine(); // Limpiar el búfer después de leer el número
                respuestaValida = true; // Establecer la bandera de respuesta válida en verdadero
            } catch (InputMismatchException e) {
                System.out.println("Error: El id solo deben ser números.");
                sc.nextLine(); // Limpiar el búfer del scanner
                respuestaValida = false; // Establecer la bandera de respuesta válida en falso
            }

        } while (!respuestaValida);


        centro = OperacionesCentros.buscarCentro(idCentro);

        if (centro != null) {
            System.out.println("Estos son los mimebros disponibles actualmente en este centro ");
            if (centro.getMiembrosLista() != null){

                System.out.println(centro.getMiembros());

            }
            else {
                System.out.println("El centro no tiene miembros");}
        }
        else{
                System.out.println("No existe el Centro");
            }
        }


    @Override
    public String toString() {
        return "Listar miembros del centro de acondicionamiento.";
    }
}
