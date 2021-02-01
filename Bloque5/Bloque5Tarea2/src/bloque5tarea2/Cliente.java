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
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        DatagramSocket socket = new DatagramSocket(); //Creamos el socket UDP
        InetAddress destino = InetAddress.getByName("localhost"); //Obtenemos la direccion de localhost
        String fechaNacimiento = null; //Inicializamos el mensaje a null
        Scanner sc = new Scanner(System.in);
        System.out.println("Cliente preparado . . . .");
        System.out.println("**Introduce tu fecha de nacimiento con formato DD-MM-AAAA- (IMPORTANTE EL GUION FINAL)** ");
        fechaNacimiento = sc.nextLine();
        System.out.println("Vamos a enviar el mensaje . . . ." + fechaNacimiento);
        //Definimos el numero de bytes del bufer
        //El buffer servirá para almacenar la info que envisaremos de manera temporal
        //en caso de que haya demoras
        byte[] buf = fechaNacimiento.getBytes(); //Para enviar tiene que ser byte[]
        //Paquete con el datagrama a enviar, contine: mensaje, longitud, puerto de destino y origen
        DatagramPacket paquete = new DatagramPacket(buf, buf.length, destino, 4445);
        socket.send(paquete); //enviamos 
        buf = new byte[128];

        String inp = sc.nextLine();

        // convert the String input into the byte array. 
        buf = inp.getBytes();

        paquete = new DatagramPacket(buf, buf.length);
        socket.receive(paquete);
        String recibido = new String(paquete.getData()); //Pasamos datos a String
        System.out.println(recibido);
        socket.close();
    }
}
