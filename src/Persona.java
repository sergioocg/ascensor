public class Persona extends Thread {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    private String nombre;
    private int pisoOrigen, pisoDestino;
    private Ascensor ascensor;

    public Persona(String nombre, int pisoOrigen, int pisoDestino, Ascensor ascensor) {
        this.nombre = nombre;
        this.pisoOrigen = pisoOrigen;
        this.pisoDestino = pisoDestino;
        this.ascensor = ascensor;
    }

    @Override
    public void run() {
        for(;;) {
            ascensor.entrar(pisoOrigen);
            System.out.println(ANSI_RED + nombre + " ha entrado al ascensor." +
                    "\n\t- Planta destino: " + pisoDestino + ANSI_RESET);

            ascensor.salir(pisoDestino);
            System.out.println(ANSI_GREEN + nombre + " ha salido del ascensor. " + ANSI_RESET);
        }
    }
}
