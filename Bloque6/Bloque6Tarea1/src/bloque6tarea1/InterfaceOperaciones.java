
package bloque6tarea1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceOperaciones extends Remote {
        int multiplicacion(int num1, int num2, int solucion) throws RemoteException; //Método que se publica
        int potencia(int num1, int num2, int solucion) throws RemoteException;
}
