 
package bloque3tarea2;


public class Hilo1 extends Thread {

    private Buffer buffer;

    public Hilo1(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int temperatura;
        for (int i = 1; i <= 20; i++) { //Vamos a leer 20 temperaturas
            try {
//Vamos a generar la temperatura de forma aleatoria entre 1 y 100ªC
                temperatura = (100 + (int) (-100 * Math.random()));
                buffer.leerTemperatura(temperatura); //Metodo leer temperatura de la clase buffer
//System.out.println("La temperatura leída es: " + temperatura);
            } catch (InterruptedException e) {
            }
        }

    }
}
