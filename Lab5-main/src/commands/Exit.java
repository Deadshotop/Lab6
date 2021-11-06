package src.commands;

import src.managers.HashTableManager;
import src.managers.StringManager;


public class Exit extends AbstractCommand{
    private String string = "The end of session";
    public Exit(String name, HashTableManager products, StringManager stringManager) {
        super(name, products, stringManager);
    }

    @Override
    public void execute() {
        stringManager.multiLine(string);
        setExit(true);
    }
}
