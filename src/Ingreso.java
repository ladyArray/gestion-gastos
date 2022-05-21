/**
 * @autor Rodriguez Cardenas, Regina
 * @version 1.0
 *
 * Clase Ingreso de la PAC de desarrollo UF5
 * 
 * */

public class Ingreso extends Dinero {

    Ingreso (double ingreso, String description){ //constructor de ingreso con importe y descripcion
        this.dinero = ingreso;
        this.description = description;
    }

    public double getDinero() {
        return this.dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return this.description + " " + dinero;
    }
}

