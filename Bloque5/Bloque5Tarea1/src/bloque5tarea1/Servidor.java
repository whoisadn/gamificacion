/*
 1.- Crear una aplicación distribuida con sockets TCP, a la
que enviemos nuestra fecha de nacimiento y nos devuelva
como resultado la edad que tenemos.
 */
package bloque5tarea1;

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
        
        int dia, mes, año, edad;
        
        try {
            servidor = new ServerSocket(5000); //Creamos un ServerSocket en el Puerto 5000, aquí es donde escucharemos al cliente
            System.out.println("Servidor Arrancado....");
            
                conexion = servidor.accept(); //Esperamos una conexión
                System.out.println("Conexión establecida desde: " + conexion.getInetAddress().getHostName());
                entrada = new DataInputStream(conexion.getInputStream()); //Abrimos los canales de E/S
                salida = new DataOutputStream(conexion.getOutputStream());
                
                //Leemos los mensajes del
                dia = entrada.readInt(); 
                mes = entrada.readInt();
                año = entrada.readInt();
                System.out.println("Contenido del mensaje recibido . . . Fecha de nacimiento: "+ dia + "/" + mes + "/" + año );
                
                LocalDate l = LocalDate.of(año, mes, dia);
                LocalDate now = LocalDate.now();
                edad = Period.between(l, now).getYears();
 
                System.out.println("Contenido del mensaje a enviar: Tu edad es: " + edad);
                
                salida.writeInt(edad); //Le respondemos
                entrada.close(); //Cerramos los flujos de entrada y salida
                salida.close();
                conexion.close(); //Y cerramos la conexión
           
        } catch (IOException e) {
        }
    }
}

