package src.managers;

import java.io.PrintWriter;

public class StringManager {
    private PrintWriter printWriter;

    public StringManager(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    private int numOfLines(String str){
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }
    public void multiLine(String str){
        printWriter.println(numOfLines(str));
        printWriter.println(str);
    }
    public void multiLine(int str){
        printWriter.println(1);
        printWriter.println(str);
    }
}
