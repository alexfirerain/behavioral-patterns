import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    private final int min;
    private final int max;

    public Randoms(int min, int max) {
        random = new Random();
        this.min = Math.min(min, max);
        this.max = Math.max(min, max);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            final int range = max - min + 1;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return min + random.nextInt(range);
            }
        };
    }

    //...
}
