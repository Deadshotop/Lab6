package src.commands;

import src.managers.HashTableManager;
import src.managers.IOManager;
import src.managers.StringManager;

import java.io.PrintWriter;

public class RemoveLowerKey extends AbstractCommand{
    private IOManager manager;

    public RemoveLowerKey(String name, HashTableManager products, IOManager manager, StringManager stringManager) {
        super(name, products, stringManager);
        this.manager = manager;
    }

    @Override
    public void execute() {
        Integer key = manager.getKey();
        if (key != null) {
            products.removeLowerKey(key);
        }
    }
}
