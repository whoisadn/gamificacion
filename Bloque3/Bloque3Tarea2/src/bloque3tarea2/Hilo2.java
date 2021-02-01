package bloque3tarea2;

public class Hilo2 extends Thread {

    private Buffer buffer;

    public Hilo2(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int temperatura;
        for (int i = 1; i <= 20; i++) {
            try {
                temperatura = (int) buffer.mostrarTemperatura();
                System.out.println("La temperatura mostrada es es: " + temperatura); //Imprimiremos 20 lecturas de temperatura
            } catch (InterruptedException e) {
            }
        }
    }
}
