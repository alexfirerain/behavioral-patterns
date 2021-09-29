import java.util.Arrays;

public class JumpField {
    private final int MIN_POSITION, MAX_POSITION;
    private final char[] BLANK_FIELD;
    private final char frogSymbol;

    public JumpField(int min_position, int max_position, char frogSymbol) {
        this.frogSymbol = frogSymbol;
        MIN_POSITION = Math.min(min_position, max_position);
        MAX_POSITION = Math.max( min_position, max_position );
        int FIELD_SPAN = MAX_POSITION - MIN_POSITION + 1;
        BLANK_FIELD = new char[FIELD_SPAN + 4];
        BLANK_FIELD[0] = ' ';
        BLANK_FIELD[1] = '[';
        BLANK_FIELD[FIELD_SPAN + 2] = ']';
        BLANK_FIELD[FIELD_SPAN + 3] = ' ';
        Arrays.fill(BLANK_FIELD, 2, FIELD_SPAN + 2, '_');
    }

    public static void main(String[] args) {
        JumpField jf = new JumpField(0, 10, 'O' );
        System.out.println(jf.BLANK_FIELD );
        jf.showField(5);
        jf.leftOutError(5);
        jf.rightOutError(5);
    }

    public void showField(int position) {
        char[] output = Arrays.copyOf(BLANK_FIELD, BLANK_FIELD.length);
        output[position - MIN_POSITION + 2] = frogSymbol;
        System.out.println(output);
    }
    public void leftOutError(int position) {
        char[] output = Arrays.copyOf(BLANK_FIELD, BLANK_FIELD.length);
        output[position - MIN_POSITION + 2] = frogSymbol;
        output[0] = 'Х';
        System.out.println("Недопустимый ход!");
        System.out.println(output);
    }
    public void rightOutError(int position) {
        char[] output = Arrays.copyOf(BLANK_FIELD, BLANK_FIELD.length);
        output[position - MIN_POSITION + 2] = frogSymbol;
        output[output.length - 1] = 'Х';
        System.out.println("Недопустимый ход!");
        System.out.println(output);
    }
    public boolean isOutOfRange(int target) {
        return target < MIN_POSITION || target > MAX_POSITION;
    }
}
