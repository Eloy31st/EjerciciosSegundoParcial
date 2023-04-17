import java.awt.*;

public class Ship {
    protected CardinalPoints direccion;
    protected int tamano;
    protected int numTocado;
    protected Point puntoInicio;
    protected Point puntoFinal;

    public Ship(int tamano, Point puntoInicio, Point puntoFinal) {
        this.puntoInicio = puntoInicio;
        this.puntoFinal = puntoFinal;
        this.numTocado = 0;
        if (puntoInicio.getX() == puntoFinal.getX()) {
            if (puntoInicio.getY() < puntoFinal.getY()) {
                this.direccion = CardinalPoints.SOUTH;
            } else {
                this.direccion = CardinalPoints.NORTH;
            }
        } else if (puntoInicio.getY() == puntoFinal.getY()) {
            if (puntoInicio.getX() < puntoFinal.getX()) {
                this.direccion = CardinalPoints.EAST;
            } else {
                this.direccion = CardinalPoints.WEST;
            }
        } else {
            throw new IllegalArgumentException("Los puntos no forman una linea recta");
        }
        if (comprobarTamaño()==tamano){
            this.tamano = tamano;
        } else{
            throw new IllegalArgumentException("El tamaño no es correcto");
        }

    }

    public CardinalPoints getDireccion() {
        return direccion;
    }

    public int getTamano() {
        return tamano;
    }

    public int getNumTocado() {
        return numTocado;
    }

    public Point getPuntoInicio() {
        return puntoInicio;
    }

    public Point getPuntoFinal() {
        return puntoFinal;
    }

    public void setPuntoInicio(Point puntoInicio) {
        this.puntoInicio = puntoInicio;
    }

    public void setPuntoFinal(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
    }

    public boolean is_Sunk() {
        return this.numTocado == this.tamano;
    }

    public boolean get_Shot(Point shot) {
        if (direccion == CardinalPoints.NORTH) {
            if (shot.getX() != this.puntoInicio.getX()) {
                return false;
            } else if (shot.getY() <= this.puntoInicio.getY() && shot.getY() >= this.puntoFinal.getY()) {
                numTocado++;
                return true;
            }
        } else if (direccion == CardinalPoints.SOUTH) {
            if (shot.getX() != this.puntoInicio.getX()) {
                return false;
            } else if (shot.getY() >= this.puntoInicio.getY() && shot.getY() <= this.puntoFinal.getY()) {
                numTocado++;
                return true;

            }
        } else if (direccion == CardinalPoints.EAST) {
            if (shot.getY() != this.puntoInicio.getY()) {
                return false;
            } else if (shot.getX() >= this.puntoInicio.getX() && shot.getX() <= this.puntoFinal.getX()) {
                numTocado++;
                return true;
            }
        } else if (direccion == CardinalPoints.WEST) {
            if (shot.getY() != this.puntoInicio.getY()) {
                return false;
            } else if (shot.getX() <= this.puntoInicio.getX() && shot.getX() >= this.puntoFinal.getX()) {
                numTocado++;
                return true;
            }
        }
        return false;
    }
    public boolean ship_Straight(){
        return this.puntoInicio.getX() == this.puntoFinal.getX() || this.puntoInicio.getY() == this.puntoFinal.getY();
    }

    public int comprobarTamaño(){
        if(this.puntoInicio.getX() == this.puntoFinal.getX()){
            return (int) Math.abs(this.puntoInicio.getY() - this.puntoFinal.getY()) + 1;
        }else{
            return (int) Math.abs(this.puntoInicio.getX() - this.puntoFinal.getX()) + 1;
        }
    }

}
