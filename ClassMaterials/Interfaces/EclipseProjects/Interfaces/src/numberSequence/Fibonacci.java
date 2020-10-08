package numberSequence;

public class Fibonacci implements Sequence {

    private int current;
    private int tracer;

    public Fibonacci() {
        this.current = 1;
        this.tracer  = 0;
    }

    @Override
    public int next() {
        int temp = this.current;
        this.current += this.tracer;
        this.tracer = temp;
        return temp;
    }

    @Override
    public void reset() {
        this.current = 1;
        this.tracer  = 0;
    }
    
}
