package bloque3tarea4;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Estanteria {

    private ArrayList<String> arl; //Array de comandas
    private int maximo = 0, in = 0, out = 0, numElem = 0;
    Lock cerrojo = new ReentrantLock();
    private Condition lleno = cerrojo.newCondition();
    private Condition vacio = cerrojo.newCondition();

    public Estanteria(int max) {
        this.maximo = max;
        this.arl = new ArrayList<>();
    }

    public void escribirComanda(String comanda) throws InterruptedException {
        cerrojo.lock();
        while (numElem == maximo) { //Si el ArrayList está lleno... Espera
            lleno.await();

        }
        try {
            //Vamos añadiendo las comandas de la clase productor-cocinero
            arl.add(comanda);
            numElem++;
            in = (in + 1) % maximo;

            vacio.signal(); //El ArrayList ya no está vacío
        } finally {
            cerrojo.unlock();
        }
    }

    public String leerComanda() throws InterruptedException {
        cerrojo.lock();
        while (numElem == 0) { //Si el ArrayList está vacio... Espera
            vacio.await();
        }
        try {
            String comanda = arl.get(0);
            arl.remove(0);
            numElem = numElem - 1;
            out = (out + 1) % maximo;
            lleno.signal(); //El ArrayList ya no está lleno
            return (comanda);
        } finally {
            cerrojo.unlock();
        }
    }
}
