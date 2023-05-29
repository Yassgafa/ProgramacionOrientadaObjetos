package logica.poo.miembros;

import java.io.Serializable;
import java.time.LocalDate;


public class Membresia implements Serializable {
    private static LocalDate fechaInicioMembresia;
    private  static int duracion;

    public Membresia(){

    }

    public Membresia(LocalDate fechaInicioMembresia, int duracion) {
        this.fechaInicioMembresia = fechaInicioMembresia;
        this.duracion = duracion;
    }

    public LocalDate getFechaInicioMembresia() {
        return fechaInicioMembresia;
    }

    public void setFechaInicioMembresia(LocalDate fechaInicioMembresia) {
        this.fechaInicioMembresia = fechaInicioMembresia;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }


    public static LocalDate getFechaVencimiento(){
        return fechaInicioMembresia.plusDays(duracion);
    }
}
