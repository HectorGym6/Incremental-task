import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator(0);

        // CREAR LISTA DE HILOS
        List<Thread> incrementThreads = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Thread incrementThread = new Thread(new IncrementTask(accumulator, 100));
            incrementThread.start();
            // AÑADIR EL HILO A LA LISTA
            incrementThreads.add(incrementThread);
        }

        for (Thread incrementThread:incrementThreads) {
            try {
                incrementThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(accumulator.getValue());
    }
}