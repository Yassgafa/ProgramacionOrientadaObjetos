package logica.poo.miembros;
import logica.poo.centros.Centro;

import java.io.Serializable;
import java.time.LocalDate;

public class Miembro extends Membresia implements Serializable {
    private  int id;
    static int incremento;
    private int  numeroMiembro=0;
    private String nombres;
    private String apellido;
    private  String Correo;
    private  LocalDate fechaMiembro;
    private LocalDate fechaInicioMembresia;
    private int duracion;
    private double saldo;
    private LocalDate fechaFinMembresia;
    private String tipo;
    private static final long serialVersionUID = 8574171756805727186L;
    private static int getIncremento(){
        return Miembro.incremento++;
    }


    public Miembro(){

    }
    public Miembro(int id, String nombres, String apellido, String correo, LocalDate fechaMiembro, LocalDate fechaInicioMembresia, int duracion, double saldo2, boolean tipoClub) {
        super(fechaInicioMembresia, duracion);
        this.id = id;
        this.numeroMiembro=Miembro.getIncremento();
        this.nombres = nombres;
        this.apellido = apellido;
        this.Correo = correo;
        this.fechaMiembro = fechaMiembro;
        this.fechaInicioMembresia = fechaInicioMembresia;
        this.duracion = duracion;
        this.fechaFinMembresia= Membresia.getFechaVencimiento();
        this.saldo = saldo2;
        if (tipoClub){
            this.tipo="Multi-club";
        }
        else {
            this.tipo= "Solo uno";
        }


    }

    public final int getId() {
        return id;
    }

    public  int getNumeroMiembro() {
        return numeroMiembro;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTipo() {
        return tipo;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public LocalDate getFechaMiembro() {
        return fechaMiembro;
    }

    public LocalDate getFechaInicioMembresia() {
        return fechaInicioMembresia;
    }

    public int getDuracion() {
        return duracion;
    }

    public LocalDate getFechaFinMembresia() {
        return fechaFinMembresia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public void setFechaMiembro(LocalDate fechaMiembro) {
        this.fechaMiembro = fechaMiembro;
    }

    public void setFechaInicioMembresia(LocalDate fechaInicioMembresia) {
        this.fechaInicioMembresia = fechaInicioMembresia;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setFechaFinMembresia(LocalDate fechaFinMembresia) {
        this.fechaFinMembresia = fechaFinMembresia;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "ID " + this.id+ " número de miembro "+this.numeroMiembro+ " Nombres: " + this.nombres+ "  Apellidos: "+this.apellido+ " Correo: "+ this.Correo+" tiene una membresía de tipo "+this.tipo+
                " Fecha en la que se hizo miembro: " + this.fechaMiembro+" Fecha inicio Membresía "+this.fechaInicioMembresia+ " Duracion "+ this.duracion + " Fecha final de la membresía "+
                this.fechaFinMembresia+ " Saldo que debe "+ this.saldo ;

    }


}
