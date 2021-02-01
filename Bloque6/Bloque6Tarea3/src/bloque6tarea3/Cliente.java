
package bloque6tarea3;

import java.rmi.Naming;
import java.util.Scanner;


public class Cliente {

    public static void main(String[] args) {
        int numero, esPrimo;
        esPrimo = 0;
        String resp;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("**Introduce un número entero: ** ");
            numero = sc.nextInt();
            System.out.println("Vamos a comprobar si " + numero+ " es primo");

            //Localiza el objeto distribuido:
            InterfacePrimo obj = (InterfacePrimo) Naming.lookup("//127.0.0.1/ObjetoPrimo");
            esPrimo = obj.compruebaPrimo(numero, esPrimo); //Llama al método calcularEdad

            if (esPrimo == 1){
                resp = " Es PRIMO";
            }else{
                resp = " NO es PRIMO";
            }
            System.out.println("El número " + numero + resp);
            
        } catch (Exception e) {
            System.out.println("Excepción : " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
