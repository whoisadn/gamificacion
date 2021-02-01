package bloque3tarea1;

public class Consumidor extends Thread {

    private Temperatura temp;

    public Consumidor(Temperatura temp) {
        this.temp = temp;
    }

    public void run() {
        int temperatura;
        for (int i = 0; i <= 20; i++) {
            try {
                temperatura = (int) temp.mostrarTemperatura();
                System.out.println("La temperatura mostrada es es: " + temperatura); //Imprimiremos 20 lecturas de temperatura
                sleep(400);
            } catch (InterruptedException e) {
            }
        }
    }
}
