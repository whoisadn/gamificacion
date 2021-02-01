/*
3.- Crear una aplicación distribuida con sockets TCP, a la
que se le envíe un número y nos devuelva como resultado si
el número es primo o no.
 */
package bloque5tarea3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.Period;


public class Servidor {

    
    public static void main(String[] args) {

        ServerSocket servidor;
        Socket conexion;
        DataOutputStream salida;
        DataInputStream entrada;
        
        int n, esPrimo = 0;

        try {
            servidor = new ServerSocket(5000); //Creamos un ServerSocket en el Puerto 5000, aquí es donde escucharemos al cliente
            System.out.println("Servidor Arrancado....");
            
                conexion = servidor.accept(); //Esperamos una conexión
                System.out.println("Conexión establecida desde: " + conexion.getInetAddress().getHostName());
                entrada = new DataInputStream(conexion.getInputStream()); //Abrimos los canales de E/S
                salida = new DataOutputStream(conexion.getOutputStream());
                
                //Leemos los mensajes del
                n = entrada.readInt();                
                System.out.println("Contenido del mensaje recibido . . . Número a evaluar: "+ n );

                if (n <= 1) { // Si es 1 o menor, directamente no será primo
                    esPrimo = 0;
                } else { // Si es mayor, realizo la comprobación
                    for (int i = 2; i <= n / 2; i++) {
                        if ((n % i) == 0) {
                            esPrimo = 0;
                        } else {
                            esPrimo = 1;
                        }
                    }
                }
                
                System.out.println("Contenido del mensaje a enviar: " + esPrimo);
                
                salida.writeInt(esPrimo); //Le respondemos
                entrada.close(); //Cerramos los flujos de entrada y salida
                salida.close();
                conexion.close(); //Y cerramos la conexión
           
        } catch (IOException e) {
        }
    }
}

