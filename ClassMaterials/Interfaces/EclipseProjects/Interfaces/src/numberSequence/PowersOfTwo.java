package numberSequence;

public class PowersOfTwo implements Sequence {

    private int current;

    public PowersOfTwo() {
        this.current = 1;
    }

    @Override
    public int next() {
        this.current *= 2;
        return this.current/2;
    }

    @Override
    public void reset() {
        this.current = 1;
    }
    
}
