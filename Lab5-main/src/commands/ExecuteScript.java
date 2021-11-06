package src.commands;

import src.exceptions.RecursiveScript;
import src.managers.FileManager;
import src.managers.HashTableManager;
import src.managers.IOManager;
import src.managers.StringManager;
import src.start.Execute;

import java.io.FileNotFoundException;


public class ExecuteScript extends AbstractCommand{
    private String path;
    private IOManager manager;
    private Execute execute;
    private String string = "File not found";
    public ExecuteScript(String name, HashTableManager products, String path, IOManager manager, StringManager stringManager, Execute execute) {
        super(name, products, stringManager);
        this.path = path;
        this.manager = manager;
        this.execute = execute;
    }

    @Override
    public void execute() {
        try {
            FileManager fileManager = new FileManager(products, path, true, manager.getHistory(), stringManager, execute);
            fileManager.readData();
            if (fileManager.isExit()) {
                exit = true;
            }
        } catch (FileNotFoundException | NullPointerException e) {

        } catch (RecursiveScript recursiveScript) {
            stringManager.multiLine(recursiveScript.getMessage());
        }
    }
}
