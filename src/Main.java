public class Main {
    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator(0);
        //Crear lista de HIlos (linkedList)
        //Para acceder a un .get utilizaremos un arraylist porque es mas rapido. 

        for (int i = 0; i < 100; i++) {

            Thread incrementThread = new Thread(new IncrementTask(accumulator, 1000));
            incrementThread.start();
            //Añadir el HIlo a la Lista
        }
        try {
            //HAcer join de todos los hilos de la lista
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(accumulator.getValue());
    }
}