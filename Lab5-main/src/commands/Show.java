package src.commands;

import src.managers.HashTableManager;
import src.managers.StringManager;

import java.io.PrintWriter;

public class Show extends AbstractCommand{
    public Show(String name, HashTableManager products, StringManager stringManager) {
        super(name, products, stringManager);
    }

    @Override
    public void execute() {
        stringManager.multiLine(products.print());
    }
}
