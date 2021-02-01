package bloque3tarea4;

public class Cocinero extends Thread {

    private String id;
    private Estanteria est;

    public Cocinero(String id, Estanteria est) {
        this.id = id;
        this.est = est;
    }

    public void run() {
        String comanda;
        while (true) { // El cocinero no se sabe cuántas comandas llevará
            try {
                comanda = est.leerComanda();
                System.out.println("El " + id + " prepara la comanda para el " + comanda); //Imprimiremos 20 lecturas de temperatura
                sleep(400);
            } catch (InterruptedException e) {
            }
        }
    }

}
