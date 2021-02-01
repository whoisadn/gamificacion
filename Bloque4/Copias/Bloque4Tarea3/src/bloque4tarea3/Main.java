package bloque4tarea3;

public class Main {

    public static void main(String[] args) {
        //Variables compartidas, las protegeremos con monitores
        //Un arrayList limitará los pollos por acción
        Comedero comedero = new Comedero(4);
        Bebedero bebedero = new Bebedero(8);
        Cama cama = new Cama(10);
        // Los 28 hilos representan los pollos
        for (int i = 1; i <= 28; i++) {
            Pollo pollo = new Pollo(comedero, bebedero, cama, i);
            pollo.start();
        }
    }

}
