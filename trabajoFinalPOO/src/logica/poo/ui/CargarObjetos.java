package logica.poo.ui;

import logica.poo.centros.Centro;
import logica.poo.miembros.Miembro;
import logica.poo.operaciones.OperacionesCentros;
import logica.poo.operaciones.OperacionesMiembros;
import logica.poo.ui.Menu.OpcionMenu;
import logica.poo.ui.PaqueteMenuConsola.MenuConsola;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CargarObjetos extends OpcionMenu {

    private boolean regresar =false;
    private MenuConsola menuSerializable;

    private OpcionMenu opcionDeserializar= new OpcionMenu() {
        @Override
        public void ejecutar() {



            Scanner sc = new Scanner(System.in);

            boolean respuestaValida = false;
            do {
                System.out.println("¿Desea cargar los objetos previamente ingresados? (s/n)");

                try {
                    String respuesta = sc.nextLine();
                    if (respuesta.equalsIgnoreCase("s")) {
                        regresar = true;
                        respuestaValida = true;


                        try {
                            ObjectInputStream CargarCentros = new ObjectInputStream(new FileInputStream("C:/yassir/Serializable/Centros.txt"));

                            ObjectInputStream CargarMiembros = new ObjectInputStream(new FileInputStream("C:/yassir/Serializable/Miembros.txt"));

                            List <Centro> centrosRecuperados = (List<Centro>) CargarCentros.readObject();
                            CargarCentros.close();

                            OperacionesCentros.agregarTodosCentros(centrosRecuperados);


                            List <Miembro> miembrosRecuperados = (List<Miembro>) CargarMiembros.readObject();
                            CargarMiembros.close();

                            OperacionesMiembros.agregarTodosMiembros(miembrosRecuperados);


                            System.out.println("Datos recuperados");
                        }catch (Exception e){
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
                    sc.nextLine();
                    respuestaValida = false; // Indicar que la respuesta no es válida
                }
            } while (!respuestaValida);







        }

        @Override
        public String toString() {
            return "Cargar objetos";
        }
    };



    @Override
    public void ejecutar() {

        menuSerializable= new MenuConsola();
        menuSerializable.anadirOpcion(opcionDeserializar);
        menuSerializable.lanzarMenu();

    }

    @Override
    public String toString() {
        return "Cargar objetos";
    }

}
