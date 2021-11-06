package src.commands;

import src.managers.HashTableManager;
import src.managers.StringManager;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Save extends AbstractCommand{

    private final String path;
    private String str1 = "File not found";
    private String str2 = "You have no rights to write in this file";
    public Save(String name, HashTableManager products, String path, StringManager stringManager) {
        super(name, products, stringManager);
        this.path = path;
    }

    @Override
    public void execute() {
        try (FileOutputStream writer = new FileOutputStream(path)) {
            products.write(writer);
        } catch (FileNotFoundException e) {
            stringManager.multiLine(str1);
        } catch (IOException e) {
            stringManager.multiLine(str2);
        }
    }
}
