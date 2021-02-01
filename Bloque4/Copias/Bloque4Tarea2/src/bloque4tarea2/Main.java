package bloque4tarea2;

public class Main {

    public static void main(String[] args) {
        //Variables compartidas, hay que proteger la sección crítica con Semáforos
        Comedero comedero = new Comedero();
        Bebedero bebedero = new Bebedero();
        Cama cama = new Cama();
        // Los 28 hilos representan los pollos
        for (int i = 1; i <= 28; i++) {
            Pollo pollo = new Pollo(comedero, bebedero, cama, i);
            pollo.start();
        }
    }

}
