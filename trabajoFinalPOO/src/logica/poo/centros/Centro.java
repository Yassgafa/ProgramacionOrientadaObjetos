package logica.poo.centros;

import logica.poo.miembros.Miembro;

import java.io.Serializable;
import java.util.ArrayList;

public class Centro implements Serializable {
    private TipoCentro tipo;
    static int incremento;
    private int IDcentro=0;
    private String direccion;
    private String nombreCentro;
    private Double tarifa;
    private ArrayList<Miembro> miembrosLista;
    private static final long serialVersionUID = -441277075349832552L;


    private static int getIncremento(){
        return Centro.incremento++;
    }

    //public Centro(){

   // }


    public Centro(String nombreCentro, String direccion, Double tarifa, TipoCentro tipo) {

           this.tipo= tipo;
           this.direccion = direccion;
           this.nombreCentro = nombreCentro;
           this.tarifa = tarifa;
           this.IDcentro=Centro.getIncremento();
           this.miembrosLista = new ArrayList<>();

    }
    public Centro(TipoCentro centro){
        this.tipo= centro;
    }


    public  int getIDcentro() {
        return IDcentro;
    }

    public  void setIDcentro(int IDcentro) {
        this.IDcentro = IDcentro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

    public TipoCentro getTipo() {
        return tipo;
    }

    public void setTipo(TipoCentro tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Miembro> getMiembrosLista() {
        return miembrosLista;
    }

    public boolean agregarMiembro(Miembro m) {
        for (Miembro miembro : miembrosLista) {
            if (miembro.getNumeroMiembro() == m.getNumeroMiembro()) {
                return true; // El miembro ya existe en el centro, devuelve true
            }
        }
        miembrosLista.add(m);
        return false; // El miembro no existe en el centro, se agrega y devuelve false
    }

    public boolean eliminarMiembro(int idMiembro) {
        Miembro miembroEncontrado = null;
        for (Miembro miembro : miembrosLista) {
            if (miembro.getNumeroMiembro() == idMiembro) {
                miembroEncontrado = miembro;
                break;
            }
        }
        if (miembroEncontrado != null) {
            miembrosLista.remove(miembroEncontrado);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean contieneMiembro(int idMiembro) {
        for (Miembro miembro : miembrosLista) {
            if (miembro.getNumeroMiembro() == idMiembro) {
                return true;
            }
        }
        return false;
    }





    public String getMiembros(){
        String listado=" ";
        for (int i = 0; i< miembrosLista.size();i++){
            listado+="El identificador de este centro es: "+ this.IDcentro+ " \r\nel nombre del centro de acondicionamiento es:  "+this.nombreCentro+
                    "\r\nel número de miembro es: "+ miembrosLista.get(i).getNumeroMiembro()+ "\r\nel nombre del miembro es: "+ miembrosLista.get(i).getNombres()+
                    "\r\nel miembro es "+ miembrosLista.get(i).getTipo() +"\n";
        }
        return listado;
    }


    @Override
    public String toString(){
        return "Este centro se llama: "+ this.nombreCentro+ " es de tipo: "+this.tipo+ "\r\ntiene ID: "+this.IDcentro+ "\r\nsu dirección es: "+this.direccion+ "\r\n y tiene un precio de: "+ this.tarifa;
    }

}
