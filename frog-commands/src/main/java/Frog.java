/**
 * Игровая Лягушка на игровом Поле.
 */
public class Frog {
    /**
     * Поле, по которому прыгает Лягушка.
     */
    private final JumpField field;
    /**
     * Положение Лягушки на Поле.
     */
    protected int position;

    /**
     * Создаёт новую Лягушку на определённой клетке нового Поля.
     * @param min_position наименьшая (левая) координата для Поля.
     * @param max_position наибольшая (правая) координата для Поля.
     * @param position     клетка, на которой Лягушка сидит в настоящий момент.
     * @param frogSymbol   {@code char}, используемый для представления Лягушки.
     */
    public Frog(int min_position, int max_position, int position, char frogSymbol) {
        field = new JumpField(min_position, max_position, frogSymbol);
        if (field.isOutOfRange(position))
            throw new IllegalArgumentException("Лягушка не нашла игровое поле!");
        this.position = position;
    }

    /**
     * Осуществляет прыжок Лягушки влево или вправо.
     * @param steps количество клеток, на которые Лягушка смещается в результате хода.
     *              Положительное значение соответствует прыжку вправо, а отрицательное – влево.
     * @return {@code true} в случае успешного прыжка,
     *          {@code false}, если прыжок оказался невозможен из-за ограничений По́ля.
     */
    public boolean jump(int steps) {
        int target = position + steps;
        if (field.isOutOfRange(target)) {
            if (steps > 0)
                field.rightOutError(position);
            else
                field.leftOutError(position);
            return false;
        }
        position = target;
        draw();
        return true;
    }

    /**
     * Отрисовывает Лягушку на Поле в ея текущем положении.
     */
    public void draw() {
        field.showField(position);
    }
}
