
package bloque3tarea3;


public class Cabina extends Thread{
    private String id;
    private VCompartida vc;

    public Cabina(String id, VCompartida vc) {
        this.id = id;
        this.vc = vc;
    }
 
    public void run() {
        String voto;
        int i = 0;
        while (true) { // Tendremos infinitos votos
            try {
                voto = id + " ---->" + i;
                i++;
                vc.escribirVoto(voto);
                sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

}


