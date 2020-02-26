public class Ascensor {
    private int capacidadMaxima;
    private int capacidadActual;
    private int pisoActual;

    public Ascensor(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        capacidadActual = 0;
        pisoActual = 0;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public synchronized void entrar(int pisoOrigen) {
        try {
            while(pisoActual != pisoOrigen || capacidadActual == capacidadMaxima) {
                wait();
            }

            capacidadActual++;
            notifyAll();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void salir(int pisoDestino) {
        try {
            while(pisoActual != pisoDestino) {
                wait();
            }

            capacidadActual--;
            notifyAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void notificarAscensor() {
        notifyAll();
    }
}
