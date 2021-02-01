package bloque3tarea2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    private Object[] buffer;
    private int maximo = 0, in = 0, out = 0, numElem = 0;
    Lock cerrojo = new ReentrantLock();
    private Condition lleno = cerrojo.newCondition();
    private Condition vacio = cerrojo.newCondition();

    public Buffer(int max) {
        this.maximo = max;
        this.buffer = new Object[max];
    }

    public void leerTemperatura(int temperatura) throws InterruptedException {
        cerrojo.lock();
        while (numElem == maximo) { //Buffer lleno
            lleno.await();
        }

        try {
            buffer[in] = temperatura; //Vamos añadiendo las temperaturas aleatorias de la clase hilo h1
            numElem++;
            in = (in + 1) % maximo;
            vacio.signal(); //Buffer ya no está vacío
        } finally {
            cerrojo.unlock();
        }
    }

    public Object mostrarTemperatura() throws InterruptedException {
        cerrojo.lock();
        while (numElem == 0) { //Buffer vacío
            vacio.await();
        }
        try {
            int temperatura = (int) buffer[out];
            buffer[out] = null;
            numElem = numElem - 1;
            out = (out + 1) % maximo;
            lleno.signal(); //Buffer ya no está lleno
            return (temperatura);
        } finally {
            cerrojo.unlock();
        }
    }
}
