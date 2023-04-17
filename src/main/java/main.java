import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void jugar(){
        Scanner sc = new Scanner(System.in);
        int MaxBarcos = 3;
        int numBarcos = 0;
        int x1;
        int y1;
        int x2;
        int y2;
        Point start;
        Point end;
        Point attack;
        Frigate frigate;
        Battleship battleship;
        Canoe canoe;
        int tipoBarco;
        ArrayList<Ship> ships1 = new ArrayList<Ship>();
        ArrayList<Ship> ships2 = new ArrayList<Ship>();
        User user1;
        User user2;

        System.out.println("Bienvenido al juego de batalla naval");

        System.out.println("Configuracion de los barcos del jugador 1");
        System.out.println("El número máximo de barcos es 3, el mínimo es 1 y tiene que haber 1 de cada tipo");
        System.out.println("Las coordenadas van de 0 a 9");
        System.out.println("La coordenada x son columnas y la y son filas");

        while(numBarcos < MaxBarcos) {
            System.out.println("Introduzca tipo de barco: \n 1. Battleship \n 2. Frigate \n 3. Canoe");
            tipoBarco = sc.nextInt();
            switch (tipoBarco) {
                case 1:
                    System.out.println("El barco tiene que ser recto y tener un tamaño de 5 casillas");
                    System.out.println("Introduzca coordenada X de inicio");
                    x1 = sc.nextInt();
                    System.out.println("Introduzca coordenada Y de inicio");
                    y1 = sc.nextInt();
                    start = new Point(x1, y1);
                    System.out.println("Introduzca coordenada X de final");
                    x2 = sc.nextInt();
                    System.out.println("Introduzca coordenada Y de final");
                    y2 = sc.nextInt();
                    end = new Point(x2, y2);
                    battleship = new Battleship(start, end);
                    if (battleship.ship_Straight()) {
                        ships1.add(battleship);
                        numBarcos++;
                    } else {
                        System.out.println("El barco no es recto");
                    }
                    break;
                case 2:
                    System.out.println("El barco tiene que ser recto y tener un tamaño de 3 casillas");
                    System.out.println("Introduzca coordenada X de inicio");
                    x1 = sc.nextInt();
                    System.out.println("Introduzca coordenada Y de inicio");
                    y1 = sc.nextInt();
                    start = new Point(x1, y1);
                    System.out.println("Introduzca coordenada X de final");
                    x2 = sc.nextInt();
                    System.out.println("Introduzca coordenada Y de final");
                    y2 = sc.nextInt();
                    end = new Point(x2, y2);
                    frigate = new Frigate(start, end);
                    if (frigate.ship_Straight()) {
                        ships1.add(frigate);
                        numBarcos++;
                    } else {
                        System.out.println("El barco no es recto");
                    }
                    break;
                case 3:
                    System.out.println("El barco tiene que ser recto y tener un tamaño de 1 casilla");
                    System.out.println("Introduzca coordenada X de inicio");
                    x1 = sc.nextInt();
                    System.out.println("Introduzca coordenada Y de inicio");
                    y1 = sc.nextInt();
                    start = new Point(x1, y1);
                    end = new Point(x1, y1);
                    canoe = new Canoe(start, end);
                    ships1.add(canoe);
                    numBarcos++;
                    break;
                default:
                    System.out.println("Introduzca un tipo de barco válido");
                    break;
            }
        }
        numBarcos = 0;
        user1 = new User(ships1);

        System.out.println("Configuracion de los barcos del jugador 2");
        System.out.println("El número máximo de barcos es 3, el mínimo es 1 y tiene que haber 1 de cada tipo");

        while(numBarcos < MaxBarcos) {
            System.out.println("Introduzca tipo de barco: \n 1. Battleship \n 2. Frigate \n 3. Canoe");
            tipoBarco = sc.nextInt();
            switch (tipoBarco) {
                case 1:
                    System.out.println("El barco tiene que ser recto y tener un tamaño de 5 casillas");
                    System.out.println("Introduzca coordenada X de inicio");
                    x1 = sc.nextInt();
                    System.out.println("Introduzca coordenada Y de inicio");
                    y1 = sc.nextInt();
                    start = new Point(x1, y1);
                    System.out.println("Introduzca coordenada X de final");
                    x2 = sc.nextInt();
                    System.out.println("Introduzca coordenada Y de final");
                    y2 = sc.nextInt();
                    end = new Point(x2, y2);
                    battleship = new Battleship(start, end);
                    if (battleship.ship_Straight()) {
                        ships2.add(battleship);
                        numBarcos++;
                    } else {
                        System.out.println("El barco no es recto");
                    }
                        break;
                case 2:
                    System.out.println("El barco tiene que ser recto y tener un tamaño de 3 casillas");
                    System.out.println("Introduzca coordenada X de inicio");
                    x1 = sc.nextInt();
                    System.out.println("Introduzca coordenada Y de inicio");
                    y1 = sc.nextInt();
                    start = new Point(x1, y1);
                    System.out.println("Introduzca coordenada X de final");
                    x2 = sc.nextInt();
                    System.out.println("Introduzca coordenada Y de final");
                    y2 = sc.nextInt();
                    end = new Point(x2, y2);
                    frigate = new Frigate(start, end);
                    if (frigate.ship_Straight()) {
                        ships2.add(frigate);
                        numBarcos++;
                    } else {
                        System.out.println("El barco no es recto");
                    }
                    break;
                case 3:
                    System.out.println("El barco tiene que ser recto y tener un tamaño de 1 casilla");
                    System.out.println("Introduzca coordenada X de inicio");
                    x1 = sc.nextInt();
                    System.out.println("Introduzca coordenada Y de inicio");
                    y1 = sc.nextInt();
                    start = new Point(x1, y1);
                    end = new Point(x1, y1);
                    canoe = new Canoe(start, end);
                    ships2.add(canoe);
                    numBarcos++;
                    break;
                default:
                    System.out.println("Introduzca un tipo de barco válido");
                    break;
            }
        }
        user2 = new User(ships2);

        while(user1.getIs_Alive() && user2.getIs_Alive()){
            System.out.println("Turno del jugador 1");
            System.out.println("Introduzca coordenadas de disparo");
            System.out.println("Introduzca coordenada X");
            x1 = sc.nextInt();
            System.out.println("Introduzca coordenada Y");
            y1 = sc.nextInt();
            attack = new Point(x1, y1);
            user1.attack(attack, user2);

            System.out.println("Turno del jugador 2");
            System.out.println("Introduzca coordenadas de disparo");
            System.out.println("Introduzca coordenada X");
            x2 = sc.nextInt();
            System.out.println("Introduzca coordenada Y");
            y2 = sc.nextInt();
            attack = new Point(x2, y2);
            user2.attack(attack, user1);
        }
        if(user1.getIs_Alive() && !user2.getIs_Alive()){
            System.out.println("El jugador 1 ha ganado");
        }else if(!user1.getIs_Alive() && user2.getIs_Alive()){
            System.out.println("El jugador 2 ha ganado");
        }else{
            System.out.println("Empate");
        }

    }
    public static void main(String[] args) {
        jugar();
    }
}
