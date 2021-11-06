package src.commands;

import src.managers.HashTableManager;
import src.managers.StringManager;


public class Clear extends AbstractCommand{
    private String string = "Collection is empty";
    public Clear(String name, HashTableManager products, StringManager stringManager) {
        super(name, products, stringManager);
    }

    @Override
    public void execute() {
        products.clear();
        stringManager.multiLine(string);
    }
}
