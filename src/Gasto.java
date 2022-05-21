/**
 * @autor Rodriguez Cardenas, Regina
 * @version 1.0
 *
 * Clase Gasto de la PAC de desarrollo UF5
 * 
 * */

public class Gasto extends Dinero{

    Gasto (double gasto, String description){ //constructor de gasto con importe y descripcion
        this.dinero = gasto;
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
        return this.description + " - " + dinero;
    }
}

