package src.exceptions;
/**
 * Исключение неправильного ввода команды
 */
public class CommandNotFoundException extends Exception {
    public CommandNotFoundException(String msg) {
        super(msg);
    }
}
