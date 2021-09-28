public class FrogCommands {
    public static FrogCommand jumpCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
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
