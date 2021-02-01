package bloque4tarea2;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

public class Bebedero {

    private Semaphore exclusionMutua = new Semaphore(8);

    public Bebedero() {
    }

    public void beber(int id) throws InterruptedException {

        try {
            exclusionMutua.acquire();
            System.out.println("El pollo: " + id + " está bebiendo");
            int tiempo = (3000 + (int) (-1000 * Math.random()));
            sleep(tiempo);

        } finally {
            exclusionMutua.release(8);
        }
    }
}
