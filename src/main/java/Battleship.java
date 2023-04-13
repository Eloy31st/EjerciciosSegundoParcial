import java.awt.*;
import java.util.ArrayList;

public class Battleship extends Ship{
    private ArrayList<Point> puntosTocado;
    public Battleship(Point puntoInicio, Point puntoFinal) {
        super(5, puntoInicio, puntoFinal);
        puntosTocado = new ArrayList<Point>();
    }
    @Override
    public boolean get_Shot(Point shot){
        if(shot == null){
            throw new IllegalArgumentException("El punto no puede ser nulo");
        }
        if(!puntosTocado.contains(shot)){
            if(super.get_Shot(shot)){
                puntosTocado.add(shot);
                return true;
            } else{
                return false;
            }
        }else{
            throw new IllegalArgumentException("El punto ya ha sido tocado");
        }
    }

    @Override
    public boolean is_Sunk(){
        return puntosTocado.size() == this.getTamano();
    }
}
