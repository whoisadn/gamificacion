
package bloque4tarea1;

import static java.lang.Thread.sleep;

public class Camarero extends Thread {

    private String id;
    private Estanteria est;

    public Camarero(String id, Estanteria est) {
        this.id = id;
        this.est = est;
    }

    public void run() {
        String comanda;
        int i = 0;
        while (true) { // El camarero no se sabe cuántas comandas llevará

            try {
                comanda = id + " ---->" + i;
                i++;
                est.escribirComanda(comanda);
                sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

}
