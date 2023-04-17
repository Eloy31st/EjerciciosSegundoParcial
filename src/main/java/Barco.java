public class Barco {

    private String tipo;
    private String nombre;
    private int numero;
    private int nivel;

    public Barco(String tipo, String nombre, int numero, int nivel) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.numero = numero;
        this.nivel = nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public int getNivel() {
        return nivel;
    }
}
