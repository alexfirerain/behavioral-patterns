import java.util.Arrays;

/**
 * Игровое Прыжковое Поле, предназначенное для прыжков Лягушки в одном измерении.
 */
public class JumpField {
    private final int MIN_POSITION, MAX_POSITION;
    /**
     * Шаблон отображения пустого Поля без Лягушки.
     */
    private final char[] BLANK_FIELD;
    private final char frogSymbol;

    /**
     * Новое Прыжковое Поле для Лягушки.
     * @param min_position координата крайне левого поля.
     * @param max_position координата крайне правого поля.
     * @param frogSymbol   {@code char}, представляющий Лягушку на Поле.
     */
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

    /**
     * Отрисовывает текущую игровую ситуацию на Поле.
     * @param position клетка, на которой находится Лягушка.
     */
    public void showField(int position) {
        char[] output = Arrays.copyOf(BLANK_FIELD, BLANK_FIELD.length);
        output[position - MIN_POSITION + 2] = frogSymbol;
        System.out.println(output);
    }

    /**
     * Отрисовывает текущую игровую ситуацию на Поле при попытке недопустимого хода за левую границу.
     * @param position координата клетки, на которой остаётся Лягушка после предыдущего хода.
     */
    public void leftOutError(int position) {
        char[] output = Arrays.copyOf(BLANK_FIELD, BLANK_FIELD.length);
        output[position - MIN_POSITION + 2] = frogSymbol;
        output[0] = 'Х';
        System.out.println("Недопустимый ход!");
        System.out.println(output);
    }

    /**
     * Отрисовывает текущую игровую ситуацию на Поле при попытке недопустимого хода за правую границу.
     * @param position координата клетки, на которой остаётся Лягушка после предыдущего хода.
     */
    public void rightOutError(int position) {
        char[] output = Arrays.copyOf(BLANK_FIELD, BLANK_FIELD.length);
        output[position - MIN_POSITION + 2] = frogSymbol;
        output[output.length - 1] = 'Х';
        System.out.println("Недопустимый ход!");
        System.out.println(output);
    }

    /**
     * Проверяет, не выходит ли запрашиваемая координата за пространство игрового По́ля.
     * @param target координата клетки, на которую предполагается делать ход.
     * @return {@code true}, если координата находится за границами По́ля.
     *         {@code false}, если координата находится в пределах По́ля.
     */
    public boolean isOutOfRange(int target) {
        return target < MIN_POSITION || target > MAX_POSITION;
    }
}
