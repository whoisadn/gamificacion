
package bloque4tarea1;

public class Main {

    public static void main(String[] args) {
        Estanteria est = new Estanteria(20); //Clase común al productor y consumidor
        //2 Hilos para la clase Productora
        Camarero ca1 = new Camarero("Camarero 1", est);
        Camarero ca2 = new Camarero("Camarero 2", est);
        //2 Hilos para la clase Consumidora
        Cocinero co1 = new Cocinero("Cocinero 1", est);
        Cocinero co2 = new Cocinero("Cocinero 2", est);
           

        ca1.start();
        ca2.start();
        co1.start();
        co2.start();
    }

}
