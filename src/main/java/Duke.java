package main.java;
import java.util.*;

import java.io.*;

/**
 * The Duke program implements an application that serves as a command line personal assistant
 * 
 * @author Varun Parmar
 */

public class Duke {
    private static final String LOGO = " ____        _        \n" + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n" + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";

    private TaskList taskList = new TaskList();
    private Storage storage = new Storage();
    private Parser parser = new Parser();

    public static void main(String[] args) {
        System.out.println("Hello I'm Duke\n" + "What can I do for you?\n" + "____________________________");
        Duke myDuke = new Duke();
        myDuke.run();
    }

    public void run() {
      this.storage.load(this.taskList);
      Scanner input = new Scanner(System.in);
      while(input.hasNextLine()){
        String inputString = input.nextLine();
        parser.processUserInput(inputString, this.taskList, this.storage);
      }
    }
}
