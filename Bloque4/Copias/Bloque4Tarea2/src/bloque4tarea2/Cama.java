package bloque4tarea2;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

public class Cama {

    private Semaphore exclusionMutua = new Semaphore(10);

    public Cama() {
    }

    public void dormir(int id) throws InterruptedException {

        try {
            exclusionMutua.acquire();
            System.out.println("El pollo: " + id + " está durmiendo");
            int tiempo = (19000 + (int) (-15000 * Math.random()));
            sleep(tiempo);

        } finally {
            exclusionMutua.release(10);
        }
    }

}
