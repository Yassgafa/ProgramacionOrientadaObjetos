package logica.poo.ui;

import logica.poo.operaciones.OperacionesCentros;
import logica.poo.operaciones.OperacionesMiembros;
import logica.poo.ui.Menu.OpcionMenu;
import logica.poo.ui.PaqueteMenuConsola.MenuConsola;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GuardarObjetos extends OpcionMenu {
    private boolean regresar =false;
    private MenuConsola menuSerializable;

    private OpcionMenu opcionSerializar= new OpcionMenu() {
        @Override
        public void ejecutar() {

            Scanner sc = new Scanner(System.in);

            boolean respuestaValida = false;
            do {
                System.out.println("¿Desea guardar los objetos previamente ingresados? (s/n)");

                try {
                    String respuesta = sc.nextLine();
                    if (respuesta.equalsIgnoreCase("s")) {
                        regresar = true;
                        respuestaValida = true;


                        try {

                            ObjectOutputStream GuardarCentros = new ObjectOutputStream(new FileOutputStream("C:/yassir/Serializable/Centros.txt"));

                           ObjectOutputStream GuardarMiembros = new ObjectOutputStream(new FileOutputStream("C:/yassir/Serializable/Miembros.txt"));

                            GuardarCentros.writeObject(OperacionesCentros.getTodosCentros());
                            GuardarCentros.close();
                            GuardarMiembros.writeObject(OperacionesMiembros.getClientes());
                            GuardarMiembros.close();

                            System.out.println("Los objetos se han guardado exitosamente");


                        }catch (Exception e){
                            System.out.println("Error al guardar los datos");
                            e.printStackTrace();
                        }



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




        }

        @Override
        public String toString() {
            return "Guardar objetos";
        }
    };



    @Override
    public void ejecutar() {

        menuSerializable= new MenuConsola();
        menuSerializable.anadirOpcion(opcionSerializar);
        menuSerializable.lanzarMenu();

    }

    @Override
    public String toString() {
        return "Guardar Objetos";
    }

}




