package bloque4tarea3;

import static java.lang.Thread.sleep;
import java.util.ArrayList;

public class Cama {

    private ArrayList<Integer> arl;
    private int maximo = 0, in = 0, out = 0, numElem = 0;

    public Cama(int max) {
        this.maximo = max;
        this.arl = new ArrayList<>();
    }

    public synchronized void dormir(int id) throws InterruptedException {

        while (numElem == maximo) { //Si el ArrayList está lleno... Espera
            wait();
        }

        //Vamos añadiendo los pollos
        arl.add(id);
        System.out.println("El pollo: " + id + " está durmiendo");
        numElem++;
        in = (in + 1) % maximo;
        // El pollo realizará la acción durante unos segundos
        int tiempo = (19000 + (int) (-15000 * Math.random()));
        sleep(tiempo);
        id = arl.get(0);
        arl.remove(0);
        numElem = numElem - 1;
        out = (out + 1) % maximo;
        notifyAll(); 

    }

}
