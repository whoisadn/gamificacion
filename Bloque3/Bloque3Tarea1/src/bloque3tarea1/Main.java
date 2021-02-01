package bloque3tarea1;

public class Main {

    public static void main(String[] args) {
        Temperatura temp = new Temperatura(10); //Clase común al productor y consumidor
        Consumidor c = new Consumidor(temp);
        Productor p = new Productor(temp);

        p.start();

        try {

            p.join();
            c.start();
        } catch (Exception e) {
        }
    }

}
