package src.server;

import src.managers.StringManager;
import src.start.Execute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private StringManager stringManager;
    private BufferedReader in;
    private Execute execute;
    private Scanner scanner;
    private String inputLine;
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        stringManager = new StringManager(out);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        execute = new Execute(out, in);
        System.out.println("Start of session");
        while (true) {
            System.out.println("Client is choosing command");
            inputLine = in.readLine();
            System.out.println(inputLine);
            if(inputLine == null){
                break;
            }
            if (execute.doCommand(inputLine)){
                stringManager.multiLine("end of session");
                serverSocket.close();
            }
            //saveScenario();
        }
    }

//    public void saveScenario(){
//        System.out.println("If you want to save the collection to a csv file, type SAVE else skip");
//        scanner = new Scanner(System.in);
//        String arg = scanner.nextLine();
//
//        if(arg.equals("SAVE")) {
//            save();
//            System.out.println("Collection successfully saved");
//        } else if (arg.equals("")){
//            System.out.println("Continue without saving");
//            return;
//        }
//        else {
//            System.out.println("There is no such command on server");
//        }
//    }
//    public void save(){
//        String arg = scanner.nextLine();
//        execute.doCommand(arg);
//    }
}

