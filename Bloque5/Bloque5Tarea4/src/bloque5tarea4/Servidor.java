/*
4.- Crear una aplicación distribuida con sockets UDP, a la que se le envíe un 
número y nos devuelva como resultado si el número es primo o no.
 */
package bloque5tarea4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

    public static void main(String[] args) throws SocketException {
        DatagramSocket socket = new DatagramSocket(4445); //Creamos socket UDP
        String n;
        int esPrimo = 0;
        String resp = null;
        try {
            System.out.println("Servidor preparado. . . . ");
            byte[] buf = new byte[128];
            //Preparamos la respuesta
            DatagramPacket paquete = new DatagramPacket(buf, buf.length);
            //Recibimos el datagrama
            socket.receive(paquete);
            n = new String(paquete.getData()); //Pasamos datos a String

            //Método para pasar de String a Int
            //int valor =Integer.parseInt(n);
            String[] values = n.split("-");
            int valor = Integer.parseInt(values[0]);
            System.out.println("Contenido del mensaje recibido . . . Número a evaluar: " + n);
            //Método para comprobar si es primo o no
            if (valor <= 1) { // Si es 1 o menor, directamente no será primo
                esPrimo = 0;
                resp = " NO es PRIMO";
            } else { // Si es mayor, realizo la comprobación
                for (int i = 2; i <= valor / 2; i++) {
                    if ((valor % i) == 0) {
                        esPrimo = 0;
                        resp = " NO es PRIMO";

                    } else {
                        esPrimo = 1;
                        resp = " Es PRIMO";
                    }
                }
            }

            System.out.println("*****Contenido del mensaje a enviar****\nEl número: " + valor + resp);
            String mensaje = "El número: " + valor + resp;

            buf = mensaje.getBytes(); //Para enviarlo necesitamos pasarlo a array de bytes
            InetAddress destino = paquete.getAddress(); //El destino lo sacamos del paquete recibido
            int puerto = paquete.getPort(); //Ídem con el puerto
            paquete = new DatagramPacket(buf, buf.length, destino, puerto);
            socket.send(paquete);
        } catch (IOException e) {
        }
        socket.close();
    }
}
