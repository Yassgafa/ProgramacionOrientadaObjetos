package logica.poo.ui.PaqueteMenuConsola;
import logica.poo.ui.Menu.OpcionMenu;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class MenuConsola extends OpcionMenu {
   private ArrayList<OpcionMenu> opciones;
   private int opcionSeleccionada;

   private boolean regresar =false;

    public MenuConsola() {
        opciones = new ArrayList<OpcionMenu>(); // Inicializar el ArrayList en el constructor
    }

    public void anadirOpcion( OpcionMenu op){
        this.opciones.add(op);
    }


    //Thrown by a Scanner to indicate that the token retrieved does not match the pattern for the expected type, or that the token is out of range for the expected type.
    public void lanzarMenu() {
        Scanner sc = new Scanner(System.in);

        boolean error;
        do {
            error = false; // Reiniciamos la bandera de error en cada iteración

            System.out.println("----- Menú -----");
            for (int i = 0; i < opciones.size(); i++) {
                System.out.println((i + 1) + ". " + opciones.get(i).toString());
            }
            System.out.println((opciones.size() + 1) + ". Salir");

            System.out.println("Seleccione una opción: ");

            try {
                opcionSeleccionada = sc.nextInt();
                sc.nextLine(); // Limpiar el búfer después de leer el número
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                sc.nextLine(); // Limpiar el búfer del scanner
                error = true; // Establecer la bandera de error en verdadero
            }

            if (!error) {
                if (opcionSeleccionada > 0 && opcionSeleccionada <= opciones.size()) {
                    opciones.get(opcionSeleccionada - 1).ejecutar();

                    boolean respuestaValida = false;
                    do {
                        System.out.println("¿Desea regresar al menú? (s/n)");

                        try {
                            String respuesta = sc.nextLine();
                            if (respuesta.equalsIgnoreCase("s")) {
                                regresar = true;
                                respuestaValida = true;
                            } else if (respuesta.equalsIgnoreCase("n")) {
                                regresar = false;
                                respuestaValida = true;
                            } else {
                                throw new InputMismatchException("Respuesta inválida");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: " + e.getMessage());
                            respuestaValida = false; // Indicar que la respuesta no es válida
                        }
                    } while (!respuestaValida);
                } else if (opcionSeleccionada == opciones.size() + 1) {
                    return;
                } else {
                    System.out.println("Opción inválida");
                }

            }
        } while (regresar || error);
    }




    public int getOpcionSeleccionada() {
        return opcionSeleccionada;
    }
    @Override
    public void ejecutar() {

    }

    @Override
    public String toString() {
        return null;
    }




}