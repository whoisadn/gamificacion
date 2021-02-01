package bloque4tarea3;

import static java.lang.Thread.sleep;
import java.util.ArrayList;

public class Bebedero {

    private ArrayList<Integer> arl; //Array de pollos
    private int maximo = 0, in = 0, out = 0, numElem = 0;

    public Bebedero(int max) {
        this.maximo = max;
        this.arl = new ArrayList<>();
    }

    public synchronized void beber(int id) throws InterruptedException {

        while (numElem == maximo) { //Si el ArrayList está lleno... Espera
            wait();
        }

        //Vamos añadiendo los pollos
        arl.add(id);
        System.out.println("El pollo: " + id + " está bebiendo");
        numElem++;
        in = (in + 1) % maximo;
        // El pollo realizará la acción durante unos segundos
        int tiempo = (3000 + (int) (-1000 * Math.random()));
        sleep(tiempo);
        //Cuando acaba, lo quitamos del array
        id = arl.get(0);
        arl.remove(0);
        numElem = numElem - 1;
        out = (out + 1) % maximo;
        notifyAll(); 

    }

}
