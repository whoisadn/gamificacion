package bloque4tarea2;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

public class Comedero {
    //  El semáforo nos ayudará a asegurar la exclusión mutua de la sección crítica
    private Semaphore exclusionMutua = new Semaphore(4);
    //Constructor vacío
    public Comedero() {
    }

    public void comer(int id) throws InterruptedException {

        try {
            exclusionMutua.acquire();
            System.out.println("El pollo: " + id + " está comiendo");
            int tiempo = (6000 + (int) (-2000 * Math.random()));
            sleep(tiempo);

        } finally {
            exclusionMutua.release(4);
        }
    }
}
