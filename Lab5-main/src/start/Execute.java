package src.start;

import src.commands.*;
import src.exceptions.CommandNotFoundException;
import src.exceptions.RecursiveScript;
import src.managers.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.TreeSet;


public class Execute {

    //private static boolean exitProcess = false;
    private BufferedReader in;
    private final String path;
    private final HashTableManager products;
    private final ConsoleManager consoleManager;
    private FileManager fileManager;
    private final StringManager stringManager;

    public Execute(PrintWriter printWriter, BufferedReader in) {
        this.stringManager = new StringManager(printWriter);
        this.in = in;
        path = System.getenv().get("FILE6");
        products = new HashTableManager();
        try{
            fileManager = new FileManager(products, path, false, new TreeSet<File>(), stringManager, this);
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Something wrong with the file");
        } catch (RecursiveScript e) {}
        consoleManager = new ConsoleManager(products, stringManager, in);
    }

    private AbstractCommand findCommand(String command, HashTableManager products, IOManager manager, StringManager stringManager) throws CommandNotFoundException {
        switch (command) {
            case "help":
                return new Help(command, products, stringManager);
            case "info":
                return new Info(command, products, stringManager);
            case "show":
                return new Show(command, products, stringManager);
            case "insert":
                return new Insert(command, products, manager, stringManager);
            case "update":
                return new Update(command, products, manager, stringManager);
            case "remove_key":
                return new RemoveKey(command, products, manager, stringManager);
            case "clear":
                return new Clear(command, products, stringManager);
            case "exit":
                return new Exit(command, products, stringManager);
            case "save":
                //stringManager.multiLine("You are not allowed to do this");/Users/andrejpetrenko/IdeaProjects/Lab5-main/src/product/File.csv
                return new Save("File.csv", products, "/Users/andrejpetrenko/IdeaProjects/Lab5-main/src/product/File.csv", stringManager);
            case "execute_script":
                return new ExecuteScript(command, products, manager.getName(), manager, stringManager, this);
            case "replace_if_lowe":
                return new ReplaceIfLowe(command, products, manager, stringManager);
            case "remove_greater_key":
                return new RemoveGreaterKey(command, products, manager, stringManager);
            case "remove_lower_key":
                return new RemoveLowerKey(command, products, manager, stringManager);
            case "sum_of_price":
                return new SumOfPrice(command, products, stringManager);
            case "min_by_creation_date":
                return new MinByCreationDate(command, products, stringManager);
            case "count_by_owner":
                return new CountByOwner(command, products, manager, stringManager);
            default:
                throw new CommandNotFoundException("Command \"" + command + "\" doesn't exist");
        }
    }

    public boolean doCommand(String command) {

        boolean exit = false;
        try{
            AbstractCommand com = findCommand(command, products, consoleManager, stringManager);
            System.out.println(com);
            com.execute();
            System.out.println("command executed");
            //System.out.println(com.isExit());
            //System.out.println(consoleManager.isExit());
            if (com.isExit() || consoleManager.isExit()) {
                exit = true;
                System.out.println("command executed");
                stringManager.multiLine("Command executed");

            }
        } catch (CommandNotFoundException e) {
            stringManager.multiLine(e.getMessage());
        }

        return exit;
    }

}
