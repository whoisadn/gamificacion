package bloque4tarea3;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Comedero {

    private ArrayList<Integer> arl;
    private int maximo = 0, in = 0, out = 0, numElem = 0;

    public Comedero(int max) {
        this.maximo = max;
        this.arl = new ArrayList<>();
    }

    public synchronized void comer(int id) throws InterruptedException {

        while (numElem == maximo) { //Si el ArrayList está lleno... Espera
            wait();
        }

        //Vamos añadiendo los pollos
        arl.add(id);
        System.out.println("El pollo: " + id + " está comiendo");

        numElem++;
        in = (in + 1) % maximo;
        // El pollo realizará la acción durante unos segundos

        int tiempo = (6000 + (int) (-2000 * Math.random()));
        sleep(tiempo);
        id = arl.get(0);
        arl.remove(0);
        numElem = numElem - 1;
        out = (out + 1) % maximo;
        notifyAll(); //El ArrayList ya no está vacío

    }

}
