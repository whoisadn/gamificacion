

package bloque3tarea3;

public class Sistema extends Thread {
    private VCompartida vc;

    public Sistema(VCompartida vc) {
        this.vc = vc;
    }

    public void run() {
        String voto;
        while (true) { // Tendremos infinitos votos
            try {
                voto = vc.leerVoto();
                System.out.println("El sistema prepara ->" + voto); //Imprimiremos 20 lecturas de temperatura
                sleep(400);
            } catch (InterruptedException e) {
            }
        }
    }

}
