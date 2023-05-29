package logica.poo.ui;

import logica.poo.Excepciones.Excepciones;
import logica.poo.centros.Centro;
import logica.poo.centros.TipoCentro;
import logica.poo.miembros.Miembro;
import logica.poo.miembros.MiembroMultiClub;
import logica.poo.miembros.MiembroSoloUno;
import logica.poo.operaciones.OperacionesCentros;
import logica.poo.operaciones.OperacionesMiembros;
import logica.poo.ui.Menu.OpcionMenu;
import logica.poo.ui.PaqueteMenuConsola.MenuConsola;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditarMiembros extends OpcionMenu {

    private  MenuConsola editarMiembro;
    private MiembroSoloUno miembroSoloUno;
    private MiembroMultiClub miembroMultiClub;
    int numero= 0;
    @Override
    public void ejecutar() {
        Scanner sc = new Scanner(System.in);

        boolean respuesta;
        do {
            System.out.println("Ingrese el número de miembro que desea editar");
            try {
                numero = sc.nextInt();
                sc.nextLine();
                respuesta = true;

                Miembro miembroEncontrado = OperacionesMiembros.buscarMiembro(numero);
                if (miembroEncontrado != null) {

                    editarMiembro = new MenuConsola();
                    editarMiembro.anadirOpcion(opcion1);
                    editarMiembro.anadirOpcion(opcion2);

                    editarMiembro.lanzarMenu();
                } else {
                    System.out.println("El miembro no existe.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                sc.nextLine(); // Limpiar el buffer de entrada
                respuesta = false;
            }
        } while (!respuesta);

    }

    @Override
    public String toString() {
        return "Editar Miembros";
    }

    
    private OpcionMenu opcion1 = new OpcionMenu() {
        @Override
        public void ejecutar() {


            Scanner sc = new Scanner(System.in);
            //leer los valores de los parámetros desde la consola


            //ingrese el id del miembro
            int id= 0;
            // boolean respuestaValida = false;
            boolean respuestaValida;
            do {
                System.out.println("Ingrese el id del meimbro");

                try {
                    id = sc.nextInt();
                    sc.nextLine(); // Limpiar el búfer después de leer el número
                    respuestaValida = true; // Establecer la bandera de respuesta válida en verdadero
                } catch (InputMismatchException e) {
                    System.out.println("Error: El id solo deben ser números.");
                    sc.nextLine(); // Limpiar el búfer del scanner
                    respuestaValida = false; // Establecer la bandera de respuesta válida en falso
                }

            } while (!respuestaValida);


            //ingresar nombre y  apellidos
            String NombreMimebro;
            String apellidosMiembro;
            boolean respuesta= false;
            do {
                System.out.println("Ingrese los nombres del miembro");
                NombreMimebro = sc.nextLine();

                System.out.println("Ingrese los apellidos del miembro");
                apellidosMiembro = sc.nextLine();

                Pattern patron = Pattern.compile("^[a-zA-Z]+$");
                Matcher matcherNombre = patron.matcher(NombreMimebro);
                Matcher matcherApellidos = patron.matcher(apellidosMiembro);

                try {
                    if (matcherNombre.matches() && matcherApellidos.matches()) {
                        respuesta = true;
                    } else {

                        //Thrown to indicate that a method has been passed an illegal or inappropriate argument.
                        throw new IllegalArgumentException("Error: Debe ingresar valores válidos (solo letras).");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!respuesta);


            //ingresar correo
            String correoMiembro;
            boolean boolCorreo= false;

            do {
                System.out.println("Ingrese el correo del miembro");

                correoMiembro = sc.nextLine();
                Pattern pattern = Pattern
                        .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

                Matcher mather = pattern.matcher(correoMiembro);
                try {
                    if (mather.matches()){
                        boolCorreo=true;
                    }
                    else {
                        throw new IllegalArgumentException("Formato de correo inválido");
                    }


                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());

                }
            }while (!boolCorreo);



            //recibir la fecha en la que se hace miembro
            String fecha1 = "";
            LocalDate fechaMiembro = null;
            boolean fechaBool = false;
            do {
                System.out.println("Ingrese la fecha en la que se hace miembro yyyy-MM-dd");
                try {
                    fecha1 = sc.nextLine();
                    // FormatoFecha(fecha1);

                    fechaMiembro = LocalDate.parse(fecha1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    fechaBool = true;
                } catch (DateTimeParseException e) {
                    System.out.println(e.getMessage());
                    fechaBool = false;
                }
            } while (!fechaBool);



            //recibir la fecha en la que inicia la membresia
            String fecha2 ="";
            LocalDate fechaInicioMiembro = null;
            boolean fechaInicioBool= false;
            do {
                System.out.println("Ingrese la fecha en la que inicia la membresia miembro yyyy-MM-dd");
                try {
                    fecha2 = sc.nextLine();


                    fechaInicioMiembro = LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    fechaInicioBool= true;
                }catch (DateTimeParseException ex){
                    System.out.println(ex.getMessage());
                    fechaInicioBool= false;
                }

            }while (!fechaInicioBool);





            //recibo la duración de la membresía
            int duracion = 0;
            do {
                System.out.println("Ingrese la duracion de la membrsía");

                try {
                    duracion = sc.nextInt();
                    sc.nextLine(); // Limpiar el búfer después de leer el número
                    respuestaValida = true; // Establecer la bandera de respuesta válida en verdadero
                } catch (InputMismatchException e) {
                    System.out.println("Error: La duración solo deben ser números.");
                    sc.nextLine(); // Limpiar el búfer del scanner
                    respuestaValida = false; // Establecer la bandera de respuesta válida en falso
                }

            } while (!respuestaValida);




            //recibo el saldo del cliente
            double saldo=0;
            do {
                System.out.println("Ingrese el saldo del miembro");
                try {
                    saldo = sc.nextDouble();
                    sc.nextLine(); // Limpiar el búfer después de leer el número
                    respuestaValida = true; // Establecer la bandera de respuesta válida en verdadero
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un saldo válido.");
                    sc.nextLine(); // Limpiar el búfer del scanner
                    respuestaValida = false; // Establecer la bandera de respuesta válida en falso
                }

            } while (!respuestaValida);


            //a cual centro se va a agregar
            int idCentro= 0;
            do {
                System.out.println("ingrese el id del centro al cual quiere inscribirse");

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




            if (OperacionesCentros.buscarCentro(idCentro)==null){
                System.out.println("No existe el centro al cual añadir el cliente");
                return;
            }


            Centro centro= OperacionesCentros.buscarCentro(idCentro);
            miembroSoloUno= new MiembroSoloUno(id, NombreMimebro, apellidosMiembro, correoMiembro, fechaMiembro,fechaInicioMiembro,duracion,saldo);
            OperacionesCentros.actualizarMiembroEnCentros(numero, miembroSoloUno);
            OperacionesMiembros.EditarMiembro(numero, miembroSoloUno);
            OperacionesCentros.eliminarMiembroDeCentros(numero, centro);




            System.out.println("Se ha editado el miembro");

        }

        @Override
        public String toString() {
            return "Miembro para un solo Centro de acondicionamiento";
        }
    };
    private OpcionMenu opcion2= new OpcionMenu() {
        @Override
        public void ejecutar() {


            Scanner sc = new Scanner(System.in);
            //leer los valores de los parámetros desde la consola

            //ingrese el id del miembro
            int id= 0;
            boolean respuestaValida;
            do {
                System.out.println("Ingrese el id del meimbro");

                try {
                    id = sc.nextInt();
                    sc.nextLine(); // Limpiar el búfer después de leer el número
                    respuestaValida = true; // Establecer la bandera de respuesta válida en verdadero
                } catch (InputMismatchException e) {
                    System.out.println("Error: El id solo deben ser números.");
                    sc.nextLine(); // Limpiar el búfer del scanner
                    respuestaValida = false; // Establecer la bandera de respuesta válida en falso
                }

            } while (!respuestaValida);




            //ingresar nombre y  apellidos
            String NombreMimebro;
            String apellidosMiembro;
            boolean respuesta= false;
            do {
                System.out.println("Ingrese los nombres del miembro");
                NombreMimebro = sc.nextLine();

                System.out.println("Ingrese los apellidos del miembro");
                apellidosMiembro = sc.nextLine();

                Pattern patron = Pattern.compile("^[a-zA-Z]+$");
                Matcher matcherNombre = patron.matcher(NombreMimebro);
                Matcher matcherApellidos = patron.matcher(apellidosMiembro);

                try {
                    if (matcherNombre.matches() && matcherApellidos.matches()) {
                        respuesta = true;
                    } else {

                        //Thrown to indicate that a method has been passed an illegal or inappropriate argument.
                        throw new IllegalArgumentException("Error: Debe ingresar valores válidos (solo letras).");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!respuesta);




            //ingresar correo
            String correoMiembro;
            boolean boolCorreo= false;

            do {
                System.out.println("Ingrese el correo del miembro");

                correoMiembro = sc.nextLine();
                Pattern pattern = Pattern
                        .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

                Matcher mather = pattern.matcher(correoMiembro);
                try {
                    if (mather.matches()){
                        boolCorreo=true;
                    }
                    else {
                        throw new IllegalArgumentException("Formato de correo inválido");
                    }


                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());

                }
            }while (!boolCorreo);




            //recibir la fecha en la que se hace miembro
            String fecha1 = "";
            LocalDate fechaMiembro = null;
            boolean fechaBool = false;

            do {
                System.out.println("Ingrese la fecha en la que se hace miembro yyyy-MM-dd");
                try {
                    fecha1 = sc.nextLine();
                    // FormatoFecha(fecha1);

                    fechaMiembro = LocalDate.parse(fecha1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    fechaBool = true;
                } catch (DateTimeParseException e) {
                    System.out.println(e.getMessage());
                    fechaBool = false;
                }
            } while (!fechaBool);






            //recibir la fecha en la que inicia la membresia
            String fecha2 ="";
            LocalDate fechaInicioMiembro = null;
            boolean fechaInicioBool= false;
            do {
                System.out.println("Ingrese la fecha en la que inicia la membresia miembro yyyy-MM-dd");
                try {
                    fecha2 = sc.nextLine();


                    fechaInicioMiembro = LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    fechaInicioBool= true;
                }catch (DateTimeParseException ex){
                    System.out.println(ex.getMessage());
                    fechaInicioBool= false;
                }

            }while (!fechaInicioBool);






            //recibo la duración de la membresía
            int duracion = 0;
            do {
                System.out.println("Ingrese la duracion de la membrsía");

                try {
                    duracion = sc.nextInt();
                    sc.nextLine(); // Limpiar el búfer después de leer el número
                    respuestaValida = true; // Establecer la bandera de respuesta válida en verdadero
                } catch (InputMismatchException e) {
                    System.out.println("Error: La duración solo deben ser números.");
                    sc.nextLine(); // Limpiar el búfer del scanner
                    respuestaValida = false; // Establecer la bandera de respuesta válida en falso
                }

            } while (!respuestaValida);




            //recibo el saldo del cliente
            double saldo=0;
            do {
                System.out.println("Ingrese el saldo del miembro");
                try {
                    saldo = sc.nextDouble();
                    sc.nextLine(); // Limpiar el búfer después de leer el número
                    respuestaValida = true; // Establecer la bandera de respuesta válida en verdadero
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debe ingresar un saldo válido.");
                    sc.nextLine(); // Limpiar el búfer del scanner
                    respuestaValida = false; // Establecer la bandera de respuesta válida en falso
                }

            } while (!respuestaValida);





            miembroMultiClub = new MiembroMultiClub(id, NombreMimebro, apellidosMiembro, correoMiembro, fechaMiembro, fechaInicioMiembro, duracion, saldo);
            OperacionesMiembros.EditarMiembro(numero, miembroMultiClub);
            OperacionesCentros.actualizarMiembroEnCentros(numero, miembroMultiClub);
            OperacionesCentros.agregarMiembroEnCentros(OperacionesMiembros.buscarMiembro(numero));
            OperacionesCentros.eliminarMiembroDeTodosCentros(miembroMultiClub.getNumeroMiembro());


            System.out.println("Se ha editado el miembro");



        }

        @Override
        public String toString() {
            return "Miembro Multiclub";
        }
    };



























}
