package logica.poo.operaciones;

import logica.poo.miembros.Miembro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OperacionesMiembros implements Serializable {

    private static ArrayList<Miembro> clientes= new ArrayList<>();

    public static void agregarMiembro(Miembro m){
        clientes.add(m);
    }

    public static void listarMiembro(){
        for (int i=0; i< clientes.size();i++){
            System.out.println(clientes.get(i).toString());
        }
    }

    public static Miembro buscarMiembro(int numMiembro) {
        for (int i = 0; i < clientes.size(); i++) {
            if (numMiembro == clientes.get(i).getNumeroMiembro()) {
                return clientes.get(i);
            }
        }
        System.out.println("No existe el miembro");
        return null;
    }


    public static ArrayList<Miembro> getClientes() {
        return clientes;
    }

    public static void agregarTodosMiembros(List<Miembro> miembrosNuevos) {
        for (Miembro miembro : miembrosNuevos) {
            agregarMiembro(miembro);
        }
    }


    public static void eliminarMiembro(int id){
        Miembro m= buscarMiembro(id);
        OperacionesMiembros.getClientes().remove(m);
    }


    public static void EditarMiembro(int id, Miembro miembro) {
        Miembro miembroEncontrado = buscarMiembro(id);
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
