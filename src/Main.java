import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator(0);
        //Crear lista de HIlos (linkedList)
        List<Thread> incrementThreads = new LinkedList<>();
        //Para acceder a un .get utilizaremos un arraylist porque es mas rapido.

        for (int i = 0; i < 100; i++) {

            Thread incrementThread = new Thread(new IncrementTask(accumulator, 1000));
            incrementThread.start();
            //Añadir el HIlo a la Lista
            incrementThread.add(incrementThreads);
        }
        for (Thread incrementThread:incrementThreads){

        try {
            //HAcer join de todos los hilos de la lista

            incrementThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(accumulator.getValue());
    }
}