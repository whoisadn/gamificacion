
package bloque3tarea3;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class VCompartida {
private ArrayList<String> arl; //Array de comandas
    private int maximo = 0, in = 0, out = 0, numElem = 0;
    Lock cerrojo = new ReentrantLock();
    private Condition lleno = cerrojo.newCondition();
    private Condition vacio = cerrojo.newCondition();

    public VCompartida(int max) {
        this.maximo = max;
        this.arl = new ArrayList<>();
    }

    

    public void escribirVoto(String voto) throws InterruptedException {
        cerrojo.lock();
        while (numElem == maximo) { //Si el ArrayList está lleno... Espera
            lleno.await();

        }
        try {
            //Vamos añadiendo los votos de la clase productor
            arl.add(voto);
            numElem++;
            in = (in + 1) % maximo;

            vacio.signal(); //El ArrayList ya no está vacío
        } finally {
            cerrojo.unlock();
        }
    }

    public String leerVoto() throws InterruptedException {
        cerrojo.lock();
        while (numElem == 0) { //Si el ArrayList está vacio... Espera
            vacio.await();
        }
        try {
            String voto = arl.get(0);
            arl.remove(0);
            numElem = numElem - 1;
            out = (out + 1) % maximo;
            lleno.signal(); //El ArrayList ya no está lleno
            return (voto);
        } finally {
            cerrojo.unlock();
        }
    }
}
