package logica.poo.miembros;
import logica.poo.centros.Centro;
import logica.poo.centros.TipoCentro;
import logica.poo.operaciones.OperacionesCentros;
import logica.poo.operaciones.OperacionesMiembros;
import logica.poo.ui.Menu.OpcionMenu;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class MiembroMultiClub extends Miembro implements Serializable {

    private int puntos;

    private static final long serialVersionUID = -2218828852480603366L;

    public MiembroMultiClub(){

    }
    public MiembroMultiClub(int id, String nombres, String apellido, String correo, LocalDate fechaMiembro, LocalDate fechaInicioMembresia, int duracion, double saldo) {
        super(id, nombres, apellido, correo, fechaMiembro, fechaInicioMembresia, duracion,  saldo, true );
       sumarPuntos();
       setCentrosAcondicionamiento();

    }

    public int getPuntos() {
        return puntos;
    }

   public void sumarPuntos(){
       this.puntos+=100;
    }

    public void setCentrosAcondicionamiento() {
        int numeroMiembro = this.getNumeroMiembro();
        for (Centro centro : OperacionesCentros.getTodosCentros()) {
            boolean miembroExiste = false;
            for (Miembro miembro : centro.getMiembrosLista()) {
                if (miembro.getNumeroMiembro() == numeroMiembro) {
                    miembroExiste = true;
                    break;
                }
            }
            if (!miembroExiste) {
                centro.agregarMiembro(this);
            }
        }
    }


}
