import java.io.Console;
import java.util.Scanner;
public class Duke {
    private static final String LOGO = " ____        _        \n"
                                     + "|  _ \\ _   _| | _____ \n"
                                     + "| | | | | | | |/ / _ \\\n"
                                     + "| |_| | |_| |   <  __/\n"
                                     + "|____/ \\__,_|_|\\_\\___|\n";
    public static void main(String[] args) {
        System.out.println("Hello I'm Duke\n" + "What can I do for you?\n" + "____________________________");
        processUserInput(getInput());
    }

    public static String getInput() {
        Scanner input = new Scanner(System.in);
        String inputString = null;
        inputString = input.nextLine();
        return inputString;
     }

    public static void processUserInput(String userInput) {
        String output = userInput;
        if(userInput.equals("bye")) {
            respondToUser("Bye. Hope to see you again soon!");
            System.exit(0);
        }
        else {
            respondToUser(output);
            processUserInput(getInput());
        }
        
    }

    public static void respondToUser(String userResponse) {
        System.out.println("-----------------------\n" + userResponse + "\n-----------------------\n");
    }

}


