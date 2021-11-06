package src.commands;

import src.managers.HashTableManager;
import src.managers.StringManager;

import java.io.PrintWriter;


public class Info extends AbstractCommand {
    private String string = "Type: Product\n" + "Initialization date: " + products.getDate() + "\nSize: " + products.size();
    public Info(String name, HashTableManager products, StringManager stringManager) {
        super(name, products, stringManager);
    }

    @Override
    public void execute() {
        stringManager.multiLine(string);
    }
}
