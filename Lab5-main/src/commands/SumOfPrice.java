package src.commands;

import src.managers.HashTableManager;
import src.managers.StringManager;

import java.io.PrintWriter;

public class SumOfPrice extends AbstractCommand{
    public SumOfPrice(String name, HashTableManager products, StringManager stringManager) {
        super(name, products, stringManager);
    }

    @Override
    public void execute() {
        stringManager.multiLine(products.sumOfPrice().toString());
    }
}
