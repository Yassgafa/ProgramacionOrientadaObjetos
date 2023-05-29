package logica.poo.miembros;

import logica.poo.centros.Centro;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class MiembroSoloUno extends Miembro implements Serializable {
    private Centro centro;

    public MiembroSoloUno(){

    }

    public MiembroSoloUno(int id, String nombres, String apellido, String correo, LocalDate fechaMiembro, LocalDate fechaInicioMembresia, int duracion, double saldo, Centro centro){
        this(id,nombres,apellido,correo,fechaMiembro,fechaInicioMembresia,duracion,saldo);
        this.centro=centro;
    }
    public MiembroSoloUno(int id, String nombres, String apellido, String correo, LocalDate fechaMiembro, LocalDate fechaInicioMembresia, int duracion, double saldo) {
        super(id, nombres, apellido, correo, fechaMiembro, fechaInicioMembresia, duracion, saldo, false);

    }

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro c) {
        this.centro = c;
    }

    @Override
    public String toString() {
        return super.toString()+ " pertenece al centro: "+ this.centro.getNombreCentro() + " el ID del centro es: "+ this.centro.getIDcentro();
    }
}
