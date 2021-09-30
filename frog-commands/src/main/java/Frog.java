public class Frog {
    private final JumpField field;

    protected int position;

    public Frog(int min_position, int max_position, int position, char frogSymbol) {
        field = new JumpField(min_position, max_position, frogSymbol);
        if (field.isOutOfRange(position))
            throw new IllegalArgumentException("Лягушка не нашла игровое поле!");
        this.position = position;
    }

    public boolean jump(int steps) {
        int target = position + steps;
        if (field.isOutOfRange(target)) {
            if (steps > 0)
                field.rightOutError( position );
            else
                field.leftOutError( position );
            return false;
        }
        position = target;
        draw();
        return true;
    }

    public void draw() {
        field.showField(position);
    }
}
