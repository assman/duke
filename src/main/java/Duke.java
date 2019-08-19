import java.util.*;

public class Duke {
    private static final String LOGO = " ____        _        \n" + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n" + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";

    private ArrayList<Todo> todoList = new ArrayList<Todo>();

    public static void main(String[] args) {
        System.out.println("Hello I'm Duke\n" + "What can I do for you?\n" + "____________________________");
        Duke myDuke = new Duke();
        myDuke.processUserInput(getInput());
    }

    public static String getInput() {
        Scanner input = new Scanner(System.in);
        String inputString = null;
        inputString = input.nextLine();
        return inputString;
    }

    public void processUserInput(String userInput) {
        if (userInput.equals("bye")) {
            respondToUser("Bye. Hope to see you again soon!");
            System.exit(0);
        } else if (userInput.equals("list")) {
            System.out.println("-----------------------");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println(i + 1 + ": " + todoList.get(i).title);
            }
            System.out.println("-----------------------\n");
            processUserInput(getInput());
        } else {
            todoList.add(new Todo(userInput));
            String output = userInput;
            respondToUser("added: " + output);
            processUserInput(getInput());
        }

    }

    public void respondToUser(String userResponse) {
        System.out.println("-----------------------\n" + userResponse + "\n-----------------------\n");
    }

}
