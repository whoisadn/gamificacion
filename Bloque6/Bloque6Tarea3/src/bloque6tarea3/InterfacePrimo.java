
package bloque6tarea3;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface InterfacePrimo extends Remote{
        int compruebaPrimo(int numero, int esPrimo) throws RemoteException; //Método que se publica

}
