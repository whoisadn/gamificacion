
package bloque4tarea1;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Estanteria {

    private ArrayList<String> arl; //Array de comandas
    private int maximo = 0, in = 0, out = 0, numElem = 0;
    

    public Estanteria(int max) {
        this.maximo = max;
        this.arl = new ArrayList<>();
    }

    public synchronized void escribirComanda(String comanda) throws InterruptedException {
        while (numElem == maximo) { //Si el ArrayList está lleno... Espera
                wait();
        }
        
            //Vamos añadiendo las comandas de la clase productor-cocinero
            arl.add(comanda);
            numElem++;
            in = (in + 1) % maximo;
            notifyAll(); //El ArrayList ya no está vacío

    }

    public synchronized String leerComanda() throws InterruptedException {
        while (numElem == 0) { //Si el ArrayList está vacio... Espera
            wait();
        }
            String comanda = arl.get(0);
            arl.remove(0);
            numElem = numElem - 1;
            out = (out + 1) % maximo;
            notifyAll(); //El ArrayList ya no está lleno
            return (comanda);
        
    }
}
