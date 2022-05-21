/**
 * @autor Rodriguez Cardenas, Regina
 * @version 1.0
 *
 * Clase GastoException de la PAC de desarrollo UF5
 * 
 * devuelve saldo insuficiente a partir de la excepcion de 
 * */

public class GastoException extends  Exception{

    GastoException(){
        System.out.println("Saldo insuficiente");
    }
}
