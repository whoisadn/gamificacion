/*
3.- Crear una aplicación distribuida con sockets TCP, a la
que se le envíe un número y nos devuelva como resultado si
el número es primo o no.
 */
package bloque5tarea3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Socket cliente;
        DataInputStream entrada;
        DataOutputStream salida;
        
        int n;
        int esPrimo; //1 es primo, 0 no es primo
        Scanner sc = new Scanner(System.in);

        try {
            cliente = new Socket(InetAddress.getLocalHost(), 5000); //Creamos el socket para conectarnos al puerto 5000 del servidor
            entrada = new DataInputStream(cliente.getInputStream()); //Creamos los canales de E/S
            salida = new DataOutputStream(cliente.getOutputStream());
            
            System.out.println("Vamos a enviar un mensaje . . . .");
            
            System.out.println("**Introduce un número entero: ** ");
            n = sc.nextInt();
            System.out.println("Vamos a comprobar si " + n+ " es primo");

            //Enviamos el numero al servidor
            salida.writeInt(n);
                        
            esPrimo = entrada.readInt(); //Leemos la respuesta
            String resp;
            
            if (esPrimo == 1){
                resp = " Es PRIMO";
            }else{
                resp = " NO es PRIMO";
            }
            System.out.println("El servidor nos devuelve si es primo . . . . El número " + n + resp);
            entrada.close(); //Cerramos los flujos de entrada y salida
            salida.close();
            cliente.close(); //Cerramos la conexión
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
