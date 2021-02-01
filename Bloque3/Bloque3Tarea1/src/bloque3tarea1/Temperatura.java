package bloque3tarea1;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Temperatura {

    private ArrayList<Integer> arl; //Array de temperaturas

    Lock cerrojo = new ReentrantLock();

    public Temperatura(int max) {
        this.arl = new ArrayList<>();

    }

    public void leerTemperatura(Integer temperatura) throws InterruptedException {
        cerrojo.lock();
        try {
            //Vamos añadiendo las temperaturas aleatorias de la clase productor
            arl.add(temperatura);
            //System.out.println(arl.get(0));
        } finally {
            cerrojo.unlock();
        }
    }

    public Integer mostrarTemperatura() throws InterruptedException {
        cerrojo.lock();
        try {
            int temperatura = arl.get(0);
            arl.remove(0);
            return (temperatura);
            //return (999);
        } finally {
            cerrojo.unlock();
        }
    }
}
  

