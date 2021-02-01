
package bloque3tarea2;

public class Main {

    
    public static void main(String[] args) {
        Buffer buf = new Buffer(10); //Objeto compartido buffer de tamaño 10
        Hilo1 h1 = new Hilo1(buf);
        Hilo2 h2 = new Hilo2(buf);
        h1.start();
        h2.start();
    }
}
