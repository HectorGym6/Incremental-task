public class Accumulator {
    private int value;
     public Accumulator(int value){
         this.value = value;
     }
     public void increment(){ value = value + 1;}
    public int getValue() { return value; }
}
