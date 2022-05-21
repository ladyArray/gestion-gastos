/**
 * @autor Rodriguez Cardenas, Regina
 * @version 1.0
 *
 * Clase Principal de la PAC de desarrollo UF5
 * 
 * */

import java.util.Iterator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class main {

    public static void main(String[] args) {

        System.out.println("\t**SISTEMA DE GASTO**");
        System.out.println("\t--------------------\n");

        //-Creando usuario-
        Usuario usuario = new Usuario();
        System.out.println("Ingrese los datos de su usuario");
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: "); usuario.setNombre(sc.nextLine());
        do {
            try { //Control e errores si la edad no es un numero.
                System.out.print("Edad: ");
                usuario.setEdad(sc.nextInt());

            } catch (InputMismatchException e) {
                System.out.println("La edad debe ser un numero");
            }
            sc.nextLine(); //para finalizar la lectura del int.
        }while(usuario.getEdad() <= 0);

        boolean userCreated = false; //Variable de control para el setDNI.
        do{
            System.out.print("DNI: ");
            String dni = sc.nextLine();
            userCreated = usuario.setDNI(dni);
        }while (!userCreated);

        System.out.println("Usuario creado correctamente \nDatos de Usuario");
        System.out.println(usuario.toString()); //Imprimo los datos para que se vea que salen correctamente

        Cuenta cuenta = new Cuenta(usuario);

        //Creo variables auxilares para no definirlas en el bucle
        int option;  //opcion del menu (0 to 5)
        String auxDesc; // Auxiliar para pedir la descripcion del ingreso o gasto
        double auxImp; // auxiliar para pedir el importe del ingreso o gasto
        double saldo; //

        Iterator<Gasto> iteratorG;
        Iterator<Ingreso> iteratorI;
        Gasto gasto;
        Ingreso ingreso;

        // - creo el menu de opciones

        do {
            menu(); //Imprimo el menu
            option = sc.nextInt(); // Pido la opcion a ejecutar
            sc.nextLine(); //leo el el caracter enter que queda despues del nextInt()

            if (option > 5 || option < 0) {
                System.out.println("Opcion no valida");
            }else{
                switch (option) {
                    case 1:
                    case 2: // Ingreso o gasto
                        if (option == 1) {
                            System.out.print("Introduce la descripcion del gasto: ");
                        } else {
                            System.out.print("Introduce la descripcion del ingreso: ");
                        }

                        auxDesc = sc.nextLine();
                        auxImp = 0; //Dejo el auxiliar siempre a cero, antes de pedirlo

                        do { //Solicitud y control e errores si el importe no es un número
                            try {
                                System.out.print("Introduce el importe: ");
                                auxImp = sc.nextDouble();
                            } catch (InputMismatchException e) {
                                System.out.println("Valor numerico incorrecto");
                            }
                            sc.nextLine(); //para finalizar la lectura del Double.
                        } while (auxImp <= 0);

                        if (option == 1) { //Agrego el gasto o el ingreso a la cuenta.
                            saldo = cuenta.addGastos(auxDesc, auxImp);
                        } else {
                            saldo = cuenta.addIngresos(auxDesc, auxImp);
                        }

                        System.out.println("Saldo restante: " + saldo);
                        break;
                    case 3: //mostrar los gastos
                        System.out.println("Gastos registrados:");
                        iteratorG = cuenta.getGastos().iterator();
                        while (iteratorG.hasNext()) {
                            System.out.println(iteratorG.next().toString());

                        }
                        break;
                    case 4: //mostrar los Ingresos
                        System.out.println("Ingresos registrados:");
                        iteratorI = cuenta.getIngresos().iterator();
                        while (iteratorI.hasNext()) {
                            System.out.println(iteratorI.next().toString());
                        }
                        break;
                    case 5:
                        System.out.println("\nEl saldo de la cuenta es de: " + cuenta.getSaldo());
                        break;
                }
            }
            }while(option != 0);


        sc.close(); //Cerramos el Scanner
        System.out.println("Fin del programa.");
        System.out.println("Gracias por utilizar la aplicacion.");
    }

    private static void menu(){  // Como en la clase main no especifica metodos creo uno para el menú y tener el código más limpio
        System.out.println("----------------------------------------");
        System.out.println("\n\t**SISTEMA DE GASTO**");
        System.out.println("\t--------------------\n");
        System.out.println("- Realizar una accion -");
        System.out.println("1 - Introduce un nuevo gasto");
        System.out.println("2 - Introduce un nuevo ingreso");
        System.out.println("3 - Mostrar gastos");
        System.out.println("4 - Mostrar ingresos");
        System.out.println("5 - Mostrar saldo");
        System.out.println("0 - Salir");
        System.out.print("\nOpcion ");
    }
}
