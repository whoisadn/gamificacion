
package bloque6tarea1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Operaciones extends UnicastRemoteObject implements InterfaceOperaciones{
     public Operaciones() throws RemoteException {}//Constructor vacío
     

    public int multiplicacion(int num1, int num2, int solucion) throws RemoteException {// Implementación del método remoto
        solucion = (num1 * num2);
        return solucion;
    }
     public int potencia(int num1, int num2, int solucion) throws RemoteException {// Implementación del método remoto
        solucion = (int) Math.pow(num1, num2);
        return solucion;
    }
       
}



