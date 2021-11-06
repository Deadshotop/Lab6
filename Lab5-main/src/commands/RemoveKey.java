package src.commands;

import src.managers.HashTableManager;
import src.managers.IOManager;
import src.managers.StringManager;


public class RemoveKey extends AbstractCommand{
    private IOManager manager;
    private String string = "Not found this key in collection";
    public RemoveKey(String name, HashTableManager products, IOManager manager, StringManager stringManager) {
        super(name, products, stringManager);
        this.manager = manager;
    }

    @Override
    public void execute() {
        Integer key = manager.getKey();
        if (key != null){
            if (!products.removeByKey(key)) {
                stringManager.multiLine(string);
            }
        }
    }
}
