package src.server;


import java.io.*;
import java.util.Scanner;

public class Server {
    public Server() {
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        EchoServer echoServer = new EchoServer();
        echoServer.start(6666);
    }
}
