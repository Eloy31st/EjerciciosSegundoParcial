package grafo;

import java.util.*;

public class grafoNoDirigido {
    Map<Puerto, List<Arista>> grafo;

    public grafoNoDirigido() {
        grafo = new HashMap<>();
    }

    public void agregarPuerto(Puerto puerto) {
        grafo.put(puerto,new ArrayList<>());
    }

    public void agregarArista(Puerto origen, Puerto destino, int distancia) {
        Arista arista = new Arista(origen, destino, distancia);
        grafo.get(origen).add(arista);
        grafo.get(destino).add(arista);
    }

    public void barridoEnProfundidad(Puerto puerto){
        Set<Puerto> visitados = new HashSet<>();
        barridoEnProfundidadAux(puerto, visitados);
    }
    public void barridoEnProfundidadAux(Puerto puerto, Set<Puerto> visitados){
        visitados.add(puerto);
        System.out.println(puerto.getNombre());
        for (Arista arista : grafo.get(puerto)) {
            Puerto adyacente = arista.getDestino();
            if(!visitados.contains(arista.getDestino())){
                barridoEnProfundidadAux(adyacente, visitados);
            }
        }
    }
    public ArrayList<Puerto> caminoMasCorto(Puerto origen, Puerto destino){
        HashMap<Puerto, Integer> distancia = new HashMap<>();
        HashMap<Puerto, Puerto> previo = new HashMap<>();
        PriorityQueue<Puerto> cola = new PriorityQueue<>(Comparator.comparingInt(distancia::get));
        Set<Puerto> visitados = new HashSet<>();

        for(Puerto puerto : grafo.keySet()){
            distancia.put(puerto, Integer.MAX_VALUE);
            previo.put(puerto, null);
        }
        distancia.put(origen, 0);
        cola.add(origen);

        while(!cola.isEmpty()){
            Puerto actual = cola.poll();
            if(!visitados.contains(actual)){
                visitados.add(actual);
            }
            for(Arista arista : grafo.get(actual)){
                Puerto adyacente = arista.getOrigen() == actual ? arista.getDestino() : arista.getOrigen();
                if(!visitados.contains(adyacente)){
                    int nuevaDistancia = distancia.get(actual) + arista.getDistancia();
                    if(nuevaDistancia < distancia.get(adyacente)){
                        distancia.put(adyacente, nuevaDistancia);
                        previo.put(adyacente, actual);
                        cola.add(adyacente);
                    }
                }
            }
        }
        ArrayList<Puerto> camino = new ArrayList<>();
        Puerto actual = destino;
        while(actual != null){
            camino.add(actual);
            actual = previo.get(actual);
        }
        Collections.reverse(camino);
        return camino;
    }



    public String eliminarPuertoMasAristas(){
        Puerto puerto = null;
        int max = 0;
        for(Puerto p : grafo.keySet()){
            if(grafo.get(p).size() > max){
                max = grafo.get(p).size();
                puerto = p;
            }
        }
        grafo.remove(puerto);
        for(List<Arista> aristas : grafo.values()){
            Iterator<Arista> iterator = aristas.iterator();
            while(iterator.hasNext()){
                Arista arista = iterator.next();
                if(arista.getOrigen() == puerto || arista.getDestino() == puerto){
                    iterator.remove();
                }
            }
        }
        return "Se elimino el puerto " + puerto.getNombre() + " y sus aristas.";

    }

    public static void main(String[] args) {
        grafoNoDirigido grafo = new grafoNoDirigido();

        Puerto puerto1 = new Puerto("A");
        Puerto puerto2 = new Puerto("B");
        Puerto puerto3 = new Puerto("C");
        Puerto puerto4 = new Puerto("D");
        Puerto puerto5 = new Puerto("E");
        grafo.agregarPuerto(puerto1);
        grafo.agregarPuerto(puerto2);
        grafo.agregarPuerto(puerto3);
        grafo.agregarPuerto(puerto4);
        grafo.agregarPuerto(puerto5);

        grafo.agregarArista(puerto1, puerto2, 5);
        grafo.agregarArista(puerto2, puerto3, 10);
        grafo.agregarArista(puerto1, puerto3, 8);
        grafo.agregarArista(puerto5, puerto4, 7);
        grafo.agregarArista(puerto2, puerto5, 3);
        grafo.agregarArista(puerto3, puerto2, 2);

        System.out.println("Barrido en profundidad:");
        grafo.barridoEnProfundidad(puerto1);

        System.out.println("\nCamino más corto desde A a C:");
        ArrayList<Puerto> camino = grafo.caminoMasCorto(puerto1, puerto3);
        for(Puerto puerto : camino){
            System.out.print(puerto.getNombre() + " ");
        }
        System.out.println();

        System.out.println("\nEliminando puerto con más aristas:");
        System.out.println(grafo.eliminarPuertoMasAristas());

        System.out.println("\nBarrido en profundidad:");
        grafo.barridoEnProfundidad(puerto1);
    }

}
