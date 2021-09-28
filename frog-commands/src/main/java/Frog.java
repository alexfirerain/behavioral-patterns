public class Frog {
    private JumpField field;

    protected int position;

    public Frog(int min_position, int max_position, int position) {
        field = new JumpField(min_position, max_position);
        this.position = position;
    }

    public boolean jump(int steps) {
        return false;
    }
}
