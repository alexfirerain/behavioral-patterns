/**
 * Фабрика приказов для лягушки
 */
public class FrogCommands {
    /**
     * Создаёт приказ о лягушачьем прыжке.
     * @param frog лягушка, которая прыгает
     * @param steps клетки, на сколько прыгает: положительное значение соответствую прыжку направо, а отрицательное - прыжку налево
     * @return прыжок лягушки
     */
    public static FrogCommand jumpCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит, // вряд ли она её выполнит, потому что такое название метода нарушает яванскую конвенцию о наименованиях
        // если вызвать .undo(), то лягушка её отменит
        return new FrogCommand() {
            @Override
            public boolean doIt() {
                return frog.jump(steps);
            }
            @Override
            public boolean undoIt() {
                return frog.jump(-steps);
            }
        };
    }
}
