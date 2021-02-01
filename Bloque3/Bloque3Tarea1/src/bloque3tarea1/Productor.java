package bloque3tarea1;

public class Productor extends Thread {

    private Temperatura temp;

    public Productor(Temperatura temp) {
        this.temp = temp;
    }

    public void run() {
        int temperatura;
        for (int i = 0; i <= 20; i++) { //Vamos a leer 20 temperaturas
            try {
                //Vamos a generar la temperatura de forma aleatoria entre 1 y 100ªC
                temperatura = (100 + (int) (-100 * Math.random()));
                //Metodo leer temperatura de la clase compartida
                temp.leerTemperatura(temperatura);
            } catch (InterruptedException e) {
            }
        }

    }

}
