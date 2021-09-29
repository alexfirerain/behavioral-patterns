import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //
        Frog frog = new Frog( 0, 10, 5 );
        Scanner gamer = new Scanner( System.in );
        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;
        while (true) {
            //считываем ввод и конструируем команду, если
            //пользователь не хотел выйти
            String input = gamer.nextLine();

            if (input.equals( "<<" )) {
                if (curCommand < 0) {
                    System.out.println( "Нечего отменять!" );
                } else {
                    commands.get( curCommand ).undoIt();
                    curCommand--;
                }
            } else if (input.equals( ">>" )) {
                if (curCommand == commands.size() - 1) {
                    System.out.println( "Нечего отменять!" );
                } else {
                    curCommand++;
                    commands.get( curCommand ).doIt();
                }
            } else { //пользователь ввёл новое движение для лягушки
                if (curCommand != commands.size() - 1) {
                    //удаляем все команды которые были отменены
                }
                FrogCommand cmd = FrogCommands.jumpCommand( frog, 2 );
                curCommand++;
                commands.add( cmd );
                cmd.doIt();
            }

            //рисуем поле после команды
            frog.draw();
        }

    }
}