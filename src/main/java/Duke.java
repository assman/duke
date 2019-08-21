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
        String[] parts = userInput.split(" ", 2);
        if (parts[0].equals("done")){
            if(Integer.parseInt(parts[1]) > todoList.size()){
                respondToUser("Task not found");
            }
            else {
            todoList.get((Integer.parseInt(parts[1]) - 1)).setDone(true);
            respondToUser("Nice! I've marked this task as done: \n" +
                          todoList.get((Integer.parseInt(parts[1]) - 1)).getStatusIcon() +
                          todoList.get((Integer.parseInt(parts[1]) - 1)).getTitle());
            }
        }
        else {
        if (userInput.equals("bye")) {
            respondToUser("Bye. Hope to see you again soon!");
            System.exit(0);
        } else if (userInput.equals("list")) {
            System.out.println("-----------------------");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println(i + 1 + ": " + "[" + todoList.get(i).getStatusIcon() + "]" + todoList.get(i).getTitle());
            }
            System.out.println("-----------------------\n");
            processUserInput(getInput());
        } else {
            todoList.add(new Todo(userInput));
            String output = userInput;
            respondToUser("added: " + output);
        }
          processUserInput(getInput());
        }

    }

    public void respondToUser(String userResponse) {
        System.out.println("-----------------------\n" + userResponse + "\n-----------------------\n");
    }

}
