package src.exceptions;
/**
 * Исключение при рекурсивном вызове скрипта
 */
public class RecursiveScript extends Exception {
    public RecursiveScript(String msg) {
        super(msg);
    }
}
