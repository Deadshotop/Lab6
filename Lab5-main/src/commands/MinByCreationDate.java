package src.commands;

import src.managers.HashTableManager;
import src.managers.StringManager;

import java.io.PrintWriter;

public class MinByCreationDate extends AbstractCommand{
    public MinByCreationDate(String name, HashTableManager products, StringManager stringManager) {
        super(name, products, stringManager);
    }

    @Override
    public void execute() {
        stringManager.multiLine(products.minByCreationDate().toString());
    }
}
