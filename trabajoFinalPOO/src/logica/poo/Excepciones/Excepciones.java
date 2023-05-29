package logica.poo.Excepciones;

public class Excepciones extends Exception{
    private  String Strings;
    private Double precios;
    private String Expresion;

    public Excepciones (String s, String express){
        super(s);
        this.Expresion= express;

    }

    public String getExpresion() {
        return Expresion;
    }

    public String getStrings() {
        return Strings;
    }

    public void setStrings(String strings) {
        Strings = strings;
    }

    public Double getPrecios() {
        return precios;
    }

    public void setPrecios(Double precios) {
        this.precios = precios;
    }
}
