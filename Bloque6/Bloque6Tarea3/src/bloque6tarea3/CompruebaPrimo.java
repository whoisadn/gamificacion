
package bloque6tarea3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class CompruebaPrimo extends UnicastRemoteObject implements InterfacePrimo  {
     public CompruebaPrimo() throws RemoteException {}//Constructor vacío
     

    public int compruebaPrimo(int numero, int esPrimo) throws RemoteException {// Implementación del método remoto
        if (numero <= 1) { // Si es 1 o menor, directamente no será primo
                    esPrimo = 0;
                } else { // Si es mayor, realizo la comprobación
                    for (int i = 2; i <= numero / 2; i++) {
                        if ((numero % i) == 0) {
                            esPrimo = 0;
                        } else {
                            esPrimo = 1;
                        }
                    }
                }
        return esPrimo;
    }
}
