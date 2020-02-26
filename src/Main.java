import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();

        Ascensor a = new Ascensor(10);

        int pisoOrigen, pisoDestino;
        for(int i = 0; i < 10; i++) {
            do {
                pisoOrigen = (int) (Math.random() * 10);
                pisoDestino = (int) (Math.random() * 10);
            }while(pisoOrigen == pisoDestino);

            personas.add(new Persona("Persona " + i, pisoOrigen, pisoDestino, a));
        }

        Motor m = new Motor(a);
        m.start();

        for(Persona p : personas) {
            p.start();
        }
    }
}
