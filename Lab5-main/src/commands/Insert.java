package src.commands;

import src.managers.HashTableManager;
import src.managers.IOManager;
import src.managers.StringManager;
import src.product.Product;


public class Insert extends AbstractCommand{

    private IOManager manager;
    private String string = "Incorrect data in script";
    public Insert(String name, HashTableManager products, IOManager manager, StringManager stringManager) {
        super(name, products, stringManager);
        this.manager = manager;
    }

    @Override
    public void execute() {
        Integer key = manager.getKey();
        Product product = manager.getProduct();
        System.out.println("22");
        if (product != null || key != null) {
            System.out.println("24");
            products.insert(key, product);
        } else {
            stringManager.multiLine(string);
            System.out.println("28");
        }
    }
}
