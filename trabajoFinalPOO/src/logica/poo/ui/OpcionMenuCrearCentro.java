package logica.poo.ui;

import logica.poo.centros.Centro;
import logica.poo.centros.TipoCentro;
import logica.poo.operaciones.OperacionesCentros;
import logica.poo.ui.Menu.OpcionMenu;
import logica.poo.ui.PaqueteMenuConsola.MenuConsola;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OpcionMenuCrearCentro extends OpcionMenu {

private Centro centro;

    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        //leer los valores de los parámetros desde la consola
        System.out.println("Ingrese el nombre del centro de acondicionamiento");
        String NombreCentro = sc.nextLine();

        System.out.println("Ingrese la direccion del centro de acondicionamiento");
        String direccionCentro = sc.nextLine();

       // System.out.println("Ingrese la tarifa del centro de acondicionamiento");
        double tarifaCentro= 0;
        boolean respuestaValida = false;
        do {
            System.out.println("Ingrese la tarifa del centro de acondicionamiento");

            try {
               tarifaCentro = sc.nextDouble();
                sc.nextLine(); // Limpiar el búfer después de leer el número
                respuestaValida = true; // Establecer la bandera de respuesta válida en verdadero
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar una tarifa válida.");
                sc.nextLine(); // Limpiar el búfer del scanner
                respuestaValida = false; // Establecer la bandera de respuesta válida en falso
            }

        } while (!respuestaValida);




        int tipoint;
        TipoCentro tipito = null;

        while (tipito == null) {
            try {
                System.out.println("Ingrese el tipo de centro de acondicionamiento (1=JUPITER, 2=NEPTUNO, 3=MERCURIO)");
                tipoint = sc.nextInt();
                sc.nextLine();

                switch (tipoint) {
                    case 1:
                        tipito = TipoCentro.JUPITER;
                        break;
                    case 2:
                        tipito = TipoCentro.NEPTUNO;
                        break;
                    case 3:
                        tipito = TipoCentro.MERCURIO;
                        break;
                    default:
                        System.out.println("El tipo de centro ingresado no es válido. Por favor ingrese un valor válido.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                sc.nextLine(); // Limpiar el búfer del scanner
            }
        }


        centro = new Centro(NombreCentro,direccionCentro,tarifaCentro,tipito);
       System.out.println(centro.toString());
       OperacionesCentros.agregar(centro);

    }

    @Override
    public String toString() {
        return "Crear Centro de acondicionamiento.";
    }






}
