public class Frog {
    private final JumpField field;

    protected int position;

    public Frog(int min_position, int max_position, int position) {
        field = new JumpField(min_position, max_position, 'O');
        this.position = position;
    }

    public boolean jump(int steps) {
        return false;
    }
    public void draw() {
        field.showField(position);
    }
}
