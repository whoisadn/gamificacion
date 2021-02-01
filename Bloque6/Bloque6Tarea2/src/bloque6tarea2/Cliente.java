package bloque6tarea2;

import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        int dia, mes, año, edad;
        edad = 0;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("**Introduce tu fecha de nacimiento** ");
            System.out.println("Introduce Dia: ");
            dia = sc.nextInt();
            System.out.println("Introduce Mes: ");
            mes = sc.nextInt();
            System.out.println("Introduce Año: ");
            año = sc.nextInt();

            //Localiza el objeto distribuido:
            InterfaceEdad obj = (InterfaceEdad) Naming.lookup("//127.0.0.1/ObjetoEdad");
            edad = obj.calculaEdad(dia, mes, año, edad); //Llama al método calcularEdad

            System.out.println("Tu edad es: " + edad);
        } catch (Exception e) {
            System.out.println("Excepción : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
