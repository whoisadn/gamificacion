
package bloque3tarea3;

public class Main {

    public static void main(String[] args) {
        VCompartida vc = new VCompartida(20); //Clase común al productor y consumidor    
        //2 Hilos para la clase Productora
        Cabina c1 = new Cabina("Voto 1", vc);
        Cabina c2 = new Cabina("Voto 2", vc);
        //1 Hilo para la clase Consumidora, el sistema central de recuento
        Sistema s1 = new Sistema(vc);
        
        c1.start();
        c2.start();
        s1.start();
    }
    
}
