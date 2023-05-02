package grafo;

import java.util.ArrayList;

public class Puerto {
    private String nombre;
    private ArrayList<Arista> aristas;

    public Puerto(String nombre) {
        this.nombre = nombre;
        this.aristas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

}
