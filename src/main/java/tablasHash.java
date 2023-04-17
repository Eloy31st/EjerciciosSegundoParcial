import java.util.HashMap;
import java.util.LinkedList;

public class tablasHash {
    HashMap<String, HashMap<Integer, HashMap<String, Barco>>> tablaTipo;

    public tablasHash() {
        tablaTipo = new HashMap<String, HashMap<Integer, HashMap<String, Barco>>>();
    }

    public void añadirBarco(Barco barco) {
        String tipo = barco.getTipo();

        HashMap<Integer, HashMap<String, Barco>> tablaNumero;
        HashMap<String, Barco> tablaNombre;

        if (tablaTipo.containsKey(tipo)) {
            tablaNumero = tablaTipo.get(tipo);
            if (tablaNumero.containsKey(barco.getNumero())) {
                tablaNombre = tablaNumero.get(barco.getNumero());
                if (tablaNombre.containsKey(barco.getNombre())) {
                    throw new IllegalArgumentException("Ya existe un barco con ese nombre");
                } else {
                    tablaNombre.put(barco.getNombre(), barco);
                }
            } else {
                tablaNombre = new HashMap<String, Barco>();
                tablaNombre.put(barco.getNombre(), barco);
                tablaNumero.put(barco.getNumero(), tablaNombre);
            }
        } else {
            tablaNumero = new HashMap<Integer, HashMap<String, Barco>>();
            tablaNombre = new HashMap<String, Barco>();
            tablaNombre.put(barco.getNombre(), barco);
            tablaNumero.put(barco.getNumero(), tablaNombre);
            tablaTipo.put(tipo, tablaNumero);
        }
    }
}
