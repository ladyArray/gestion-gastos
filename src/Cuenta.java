/**
 * @autor Rodriguez Cardenas, Regina
 * @version 1.0
 *
 * Clase Gasto de la PAC de desarrollo UF5
 * 
 * Maneja los ingresos y gastos de un usuario.
 * */
 

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;

   Cuenta(Usuario usuario){ //Constructor
        this.usuario = usuario;
        this.saldo = 0;
        gastos = new ArrayList<>();
        ingresos = new ArrayList<>();
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public double addIngresos(String description, double cantidad){
        this.ingresos.add(new Ingreso(cantidad, description));
        this.saldo += cantidad;
        return this.saldo;
    }

    public double addGastos(String description, double cantidad) {
       try{
           if (this.saldo < cantidad) {
               throw new GastoException();
           }else{
               this.gastos.add(new Gasto(cantidad, description));
               this.saldo -= cantidad;
           }
       }catch (GastoException e){
            // La excepcion enviara un mensaje de 'saldo insuficiente'.
           // Tambien se podra agregar aqui mas acciones para este caso puntual.
       }finally {
           return this.saldo;
       }
    }

    @Override
    public String toString(){
        return "Usuario: " + this.usuario.getNombre() +
                "\nSaldo: " + this.saldo;
    }

}
