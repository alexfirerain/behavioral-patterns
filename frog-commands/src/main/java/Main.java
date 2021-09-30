import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;
    public static final int POSITION = 5;
    public static final char FROG_SYMBOL = '@';

    public static void main(String[] args) {
        Frog frog = new Frog(MIN_POSITION, MAX_POSITION, POSITION, FROG_SYMBOL);
        Scanner gamer = new Scanner(System.in);
        List<FrogCommand> history = new ArrayList<>();
        int curCommand = -1;

        System.out.println("\nДобро пожаловать к Лягушке-Попрыгушке!");
        frog.draw();
        System.out.println("""
                Она знает следующие команды:
                \t+x = прыжок направо на 'x' клеток
                \t-x = прыжок налево на 'x' клеток
                \t<< = отмена действия
                \t>> = возврат отменённого действия
                \t!! = повтор последнего выполненного действия
                \t 0 = прыжок на месте → завершение игры""");
        while (true) {
            // считываем ввод
            String input = gamer.nextLine();
            // если пользователь желает выйти, выходим
            if ("0".equals(input)) break;

            switch (input) {

                case "<<":
                    if (curCommand < 0) {
                        System.out.println("Нечего отменять!");
                        frog.draw();
                    } else
                        history.get(curCommand--).undoIt();
                    break;

                case ">>":
                    if (curCommand == history.size() - 1) {
                        System.out.println("Нечего возвращать!");
                        frog.draw();
                    } else
                        history.get(++curCommand).doIt();
                    break;

                case "!!":
                    if (curCommand < 0) {
                        System.out.println("Нечего повторять!");
                        frog.draw();
                    } else {
                        //если есть старая ветка отменённых команд, удаляем её
                        if (curCommand != history.size() - 1)
                            history.subList(curCommand + 1, history.size()).clear();
                        //делаем новую команду из предыдущей
                        FrogCommand cmd = history.get(curCommand);
                        // если выполнима
                        if (cmd.doIt()) {
                            // добавим в историю
                            history.add(cmd);
                            // и продвинем указатель
                            curCommand++;
                        }
                    }
                    break;

                default:  //пользователь ввёл новое движение для лягушки
                    if (!input.startsWith("+") && !input.startsWith("-")) {
                        System.out.println("ква ква");
                        continue;
                    }
                    int steps;
                    try {
                        steps = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("ква ква");
                        continue;
                    }
                    //если есть старая ветка отменённых команд, удаляем её
                    if (curCommand != history.size() - 1)
                        history.subList(curCommand + 1, history.size()).clear();

                    // создаём новую команду
                    FrogCommand cmd = FrogCommands.jumpCommand(frog, steps);
                    // если она выполнима
                    if (cmd.doIt()) {
                        // записываем её в историю
                        history.add(cmd);
                        // и продвигаем указатель текущей команды
                        curCommand++;
                    }
                    break;
            }
        }
        System.out.println("Прощаемся с Лягушкой, спасибо за тренировку!");
    }
}