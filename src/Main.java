public class Main {
    public static void main(String[] args) {
        Accumulator accumulator = new Accumulator(0);

        for (int i = 0; i < 100; i++) {

            Thread incrementThread = new Thread(new IncrementTask(accumulator, 1000));
            incrementThread.start();
        }
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(accumulator.getValue());
    }
}