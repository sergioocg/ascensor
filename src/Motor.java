public class Motor extends Thread {
    private int pisoActual;
    private Ascensor ascensor;
    boolean bajando;

    public Motor(Ascensor ascensor) {
        this.ascensor = ascensor;
        pisoActual = 0;
        bajando = false;
    }

    /**
     * Se encarga de hacer subir y bajar al Ascensor
     */
    @Override
    public void run() {
        for(;;) {
            System.out.println("\nPLANTA " + ascensor.getPisoActual());

            if(!bajando) { // Está subiendo
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                pisoActual++;
                ascensor.setPisoActual(pisoActual);
                ascensor.notificarAscensor();

                if (ascensor.getPisoActual() == 10) {
                    bajando = true;
                }
            }
            else {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                pisoActual--;
                ascensor.setPisoActual(pisoActual);
                ascensor.notificarAscensor();

                if(ascensor.getPisoActual() == 0) {
                    bajando = false;
                }
            }
        }
    }
}
