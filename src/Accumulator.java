public class Accumulator {
    private int value;

    public Accumulator(int value) {
        this.value = value;
    }

    public synchronized void increment() {
        // value 1
        // 1. 1 + 1 = 2
        // 2. value = 2

        // value = 3
        // H1 1. 3 + 1 = 4
        // H1 2  value=4
        // H2 1. 4 + 1 = 4
        // H2 2  value=5
        value = value + 1; // values++; o value+=1;
    }

    public int getValue() {
        return value;
    }


}