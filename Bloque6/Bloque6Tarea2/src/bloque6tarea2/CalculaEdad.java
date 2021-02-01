package bloque6tarea2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.Period;

public class CalculaEdad extends UnicastRemoteObject implements InterfaceEdad {

    public CalculaEdad() throws RemoteException {}//Constructor vacío
     

    public int calculaEdad(int dia, int mes, int año, int edad) throws RemoteException {// Implementación del método remoto
        LocalDate l = LocalDate.of(año, mes, dia);
        LocalDate now = LocalDate.now();
        edad = Period.between(l, now).getYears();
        return edad;
    }
}
