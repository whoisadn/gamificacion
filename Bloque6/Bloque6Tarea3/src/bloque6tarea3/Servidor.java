
package bloque6tarea3;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

    
    public static void main(String[] args) {
         try {
            //Crea instancia del objeto que implementa la interfaz (objeto a registrar):
            System.out.println("Servidor Arrancado....");

            CompruebaPrimo obj = new CompruebaPrimo();
            Registry registry = LocateRegistry.createRegistry(1099); //Arranca rmiregistry local en el puerto 1099
            Naming.rebind("//127.0.0.1/ObjetoPrimo", obj); //Hace visible el objeto para clientes
            System.out.println("El Objeto CompruebaPrimo ha quedado registrado");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
