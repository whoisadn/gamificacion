/*
 1.- Crear una aplicación distribuida con sockets TCP, a la
que enviemos nuestra fecha de nacimiento y nos devuelva
como resultado la edad que tenemos.
 */
package bloque5tarea1;

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
        
        int dia, mes, año, edad;
        Scanner sc = new Scanner(System.in);

        try {
            cliente = new Socket(InetAddress.getLocalHost(), 5000); //Creamos el socket para conectarnos al puerto 5000 del servidor
            entrada = new DataInputStream(cliente.getInputStream()); //Creamos los canales de E/S
            salida = new DataOutputStream(cliente.getOutputStream());
            
            System.out.println("Vamos a enviar un mensaje . . . .");
            
            System.out.println("**Introduce tu fecha de nacimiento** ");
                System.out.println("Introduce Dia: ");
                dia = sc.nextInt();
                System.out.println("Introduce Mes: ");
                mes = sc.nextInt();
                System.out.println("Introduce Año: ");
                año = sc.nextInt();
                
            //Enviamos los 3 mensajes al servidor
            salida.writeInt(dia);
            salida.writeInt(mes);
            salida.writeInt(año);
            
            edad = entrada.readInt(); //Leemos la respuesta
            
            System.out.println("Se enviara tu fecha de nacimiento -> " + dia+ "/" + mes+ "/" + año);
            
            System.out.println("El servidor nos devuelve la edad . . . . Tu edad es " + edad);
            entrada.close(); //Cerramos los flujos de entrada y salida
            salida.close();
            cliente.close(); //Cerramos la conexión
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
