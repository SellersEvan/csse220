package numberSequence;

class AddSeveral implements Sequence {

    private int current;
    private int step;

    public AddSeveral( int step ) {
        this.step    = step;
        this.current = 0;
    }

    @Override
    public int next() {
        this.current += this.step;
        return current;
    }

    @Override
    public void reset() {
        current = 0;
    }

}