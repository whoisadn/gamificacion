package bloque6tarea1;

import static java.lang.System.exit;
import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        int num1, num2, resultado;
        resultado = 0;
        int opcion;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("******CALCULADORA******");
            System.out.println("Introduce un primer valor: ");
            num1 = sc.nextInt();
            System.out.println("Introduce un segundo valor: ");
            num2 = sc.nextInt();

            System.out.println("¿Qué operación deseas realizar?  1-> Multiplicacion   2-> Potencia");
            opcion = sc.nextInt();
            //Localiza el objeto distribuido:
            InterfaceOperaciones obj = (InterfaceOperaciones) Naming.lookup("//127.0.0.1/ObjetoOperaciones");
            
            if (opcion == 1) {
                System.out.println("Opción de multiplicación");
                resultado = obj.multiplicacion(num1, num2, resultado); 
            } else if (opcion == 2) {
                System.out.println("Opción de potencia");
                resultado = obj.potencia(num1, num2, resultado);
            } else {
                System.out.println("Opción no válida");
                exit(opcion);
            }
            
            System.out.println("Resultado de la operacion " + resultado);
        } catch (Exception e) {
            System.out.println("Excepción : " + e.getMessage());
            e.printStackTrace();
        }

    }

}
