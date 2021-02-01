
package bloque4tarea3;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pollo extends Thread {

    
    private Comedero comedero;
    private Bebedero bebedero;
    private Cama cama;
    private int id;
    //El pollo tiene un identificador y una actividad aleatoria en cada momento.
    public Pollo(Comedero comedero, Bebedero bebedero, Cama cama, int id) { 
        this.comedero = comedero;
        this.bebedero = bebedero;
        this.cama = cama; 
        this.id = id;
    }

    public void run() {
        //Primero, aseguraremos que la actividad inicial de todos los pollos/hilos será la de pasear
        int accion;
        accion = 1;
        while (true) {
            //En un bucle infinito, se realizarán las actividades aleatorias
            switch (accion) {
                case 1:
                    System.out.println("El pollo: " + id + " está paseando");
                    int tiempo = (9000 + (int) (-5000 * Math.random()));
                     {
                        try {
                            sleep(tiempo);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Pollo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case 2: {
                    try {
                        comedero.comer(id);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Pollo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 3: {
                    try {
                        bebedero.beber(id);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Pollo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 4: {
                    try {
                        cama.dormir(id);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Pollo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
            //Aquí generaremos un valor aleatorio entre 1 y 4, que decidirá la siguiente acción del pollo
            accion = (4 + (int) (-4 * Math.random()));

        }
    }

}
