package src.commands;

import src.managers.HashTableManager;
import src.managers.IOManager;
import src.managers.StringManager;
import src.product.Person;

import java.io.PrintWriter;

public class CountByOwner extends AbstractCommand{
    private IOManager manager;

    public CountByOwner(String name, HashTableManager products, IOManager manager, StringManager stringManager) {
        super(name, products, stringManager);
        this.manager = manager;
    }

    @Override
    public void execute() {
        Person owner = manager.getOwner();
        if (owner != null) {
            stringManager.multiLine(products.countByOwner(owner));
        }
    }
}
