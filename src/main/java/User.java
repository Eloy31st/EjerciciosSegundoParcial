import java.awt.*;
import java.util.ArrayList;

public class User {
    private boolean is_Alive;
    private ArrayList<Ship> ships;

    public User(ArrayList<Ship> ships) {
        this.is_Alive = true;
        if(ships.size() == 0||ships == null){
            throw new IllegalArgumentException("No hay barcos, debe haber al menos uno");
        } else{
            for(int i = 0; i < ships.size(); i++){
                if(ships.get(i)==null){
                    throw new IllegalArgumentException("El barco no puede ser nulo");
                }
            }
        }
        this.ships = ships;
    }

    public boolean getIs_Alive() {
        return is_Alive;
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
    }

    public void die(){
        this.is_Alive = false;
    }

    public boolean attack(Point shot, User user){
        if(shot == null || user == null){
            throw new IllegalArgumentException("Los datos no pueden ser nulos");
        }
        if(user.get_Shot(shot)){
            System.out.println("Un barco ha sido tocado");
            return true;
        } else{
            System.out.println("Agua");
            return false;
        }
    }
    public boolean get_Shot(Point shot){
        boolean Touched = false;
        for(int i = 0; i < ships.size(); i++){
            if(ships.get(i).get_Shot(shot)){
                Touched = true;
                if(ships.get(i).is_Sunk()){
                    System.out.println("Un barco ha sido hundido");
                    ships.remove(i);
                }
            }
        }
        return Touched;
    }
}
