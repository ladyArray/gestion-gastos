/**
 * @autor Rodriguez Cardenas, Regina
 * @version 1.0
 *
 * Clase Gasto de la PAC de desarrollo UF5
 * 
 * Clase abstracta dinero
 * */

public abstract class Dinero {
    protected double dinero;
    protected String description;

    public abstract double getDinero();
    public abstract void setDinero(double dinero);
    public abstract String getDescription();
    public abstract void setDescription(String description);

}
