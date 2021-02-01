
package bloque6tarea2;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface InterfaceEdad extends Remote {
    int calculaEdad(int dia, int mes, int año, int edad) throws RemoteException; //Método que se publica
    
}
