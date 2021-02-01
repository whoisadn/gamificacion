/*
2.- Crear una aplicación distribuida con sockets UDP, a la
que enviemos nuestra fecha de nacimiento y nos devuelva
como resultado la edad que tenemos.
 */
package bloque5tarea2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalDate;
import java.time.Period;

public class Servidor {

    public static void main(String[] args) throws SocketException {
        DatagramSocket socket = new DatagramSocket(4445); //Creamos socket UDP
        String fechaNacimiento = null;
        int edad;
        try {
            System.out.println("Servidor preparado. . . . ");
            byte[] buf = new byte[128];
            //Preparamos la respuesta
            DatagramPacket paquete = new DatagramPacket(buf, buf.length);
            //Recibimos el datagrama
            socket.receive(paquete);
            fechaNacimiento = new String(paquete.getData()); //Pasamos datos a String
            //System.out.println(fechaNacimiento);
            
            //Método para fragmentar el String
            String[] values = fechaNacimiento.split("-");
            int dia = Integer.parseInt(values[0]);
            int mes = Integer.parseInt(values[1]);
            int año = Integer.parseInt(values[2]);
            System.out.println("****Datos introducidos****\nDia:" + dia + "\nMes:" + mes + "\nAño:" + año);
            //Método para calcular la edad a partir de la fecha introducido respecto a la actual
            LocalDate l = LocalDate.of(año, mes, dia);
            LocalDate now = LocalDate.now();
            edad = Period.between(l, now).getYears();

            System.out.println("*****Contenido del mensaje a enviar****\n Tu edad es: " + edad);

            String mensaje = "Tu edad es: " + edad;

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
