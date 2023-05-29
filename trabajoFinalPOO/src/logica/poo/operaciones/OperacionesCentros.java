package logica.poo.operaciones;

import logica.poo.centros.Centro;
import logica.poo.miembros.Miembro;
import logica.poo.miembros.MiembroMultiClub;
import logica.poo.miembros.MiembroSoloUno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OperacionesCentros extends ArrayList<Centro>  implements Serializable {

    private static ArrayList<Centro> todosCentros = new ArrayList<>();

    public static void agregar(Centro centro) {
        todosCentros.add(centro);
    }

    public static void listarCentros() {
        for (int i = 0; i < todosCentros.size(); i++) {
            System.out.println(todosCentros.get(i).toString());
        }
    }

    public static ArrayList<Centro> getTodosCentros() {
        return todosCentros;
    }

    public static Centro buscarCentro(int idCentro) {
        for (int i = 0; i < todosCentros.size(); i++) {
            if (idCentro == todosCentros.get(i).getIDcentro()) {
                return todosCentros.get(i);
            }
        }

        return null;

    }

    public static void agregarTodosCentros(List<Centro> centrosNuevos) {
        for (Centro centro : centrosNuevos) {
            agregar(centro);
        }
    }

    public static void EditarCentro(int id, Centro c) {
        buscarCentro(id).setNombreCentro(c.getNombreCentro());
        buscarCentro(id).setDireccion(c.getDireccion());
        buscarCentro(id).setTarifa(c.getTarifa());
        buscarCentro(id).setTipo(c.getTipo());

    }

    public static void eliminarMiembroDeCentros(int id, Centro centroExcluir) {
        for (Centro centro : todosCentros) {
            if (centro != centroExcluir) {
                centro.eliminarMiembro(id);
            }
            else if (!centroExcluir.eliminarMiembro(id)){
                centroExcluir.agregarMiembro(OperacionesMiembros.buscarMiembro(id));
            }
        }

    }
    public static void eliminarMiembroDeTodosCentros(int id) {
        for (Centro centro : todosCentros) {
           centro.eliminarMiembro(id);
        }
    }



    public static void agregarMiembroEnCentros(Miembro miembro) {
        for (Centro centro : todosCentros) {
                centro.agregarMiembro(miembro);
        }
    }

    public static void actualizarMiembroEnCentros(int id, Miembro miembro) {
        for (Centro centro : todosCentros) {
            Miembro miembroEncontrado = OperacionesMiembros.buscarMiembro(id);
            if (miembroEncontrado != null) {
                miembroEncontrado.setNombres(miembro.getNombres());
                miembroEncontrado.setApellido(miembro.getApellido());
                miembroEncontrado.setCorreo(miembro.getCorreo());
                miembroEncontrado.setFechaMiembro(miembro.getFechaMiembro());
                miembroEncontrado.setFechaInicioMembresia(miembro.getFechaInicioMembresia());
                miembroEncontrado.setDuracion(miembro.getDuracion());
                miembroEncontrado.setSaldo(miembro.getSaldo());
                miembroEncontrado.setTipo(miembro.getTipo());
            }
        }
    }






}
