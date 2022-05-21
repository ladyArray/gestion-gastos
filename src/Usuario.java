/**
 * @autor Rodriguez Cardenas, Regina
 * @version 1.0
 *
 * Clase Usuario de la PAC de desarrollo UF5
 * 
 * */


import java.util.regex.*;  //Anadimos la libreria

public class Usuario {
    private String nombre;
    private int edad;
    private String DNI;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public boolean setDNI(String DNI) {
        String auxDNI = DNI.replace("-", ""); //Elimino el guion para validar
        String errorMsg = "DNI incorrecto. Vuelva a intentarlo";
        if (auxDNI.length() == 9) {
            Pattern patron = Pattern.compile("[0-9]{8}[A-Z a-z]"); //Utilizo un patron de expresion regular, para validar 8 numeros y 1 letra.
            Matcher mat = patron.matcher(auxDNI);

            if (!mat.matches()) {
                System.out.println(errorMsg);
                return false;
            } else {
                this.DNI = DNI; //si cumple el patron asignado, guardo el DNI ingresado por teclado en el DNI de este usuario.
                return true;
            }
        }else{
            System.out.println(errorMsg);
            return false;
        }
    }

    @Override
    public String toString(){
        return "Nombre: "   + this.nombre +
                "\nEdad: "  + this.edad +
                "\nDNI: "   + this.DNI;
    }
}
