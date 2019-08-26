import java.util.*;

public class Duke {
    private static final String LOGO = " ____        _        \n" + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n" + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";

    private ArrayList<Task> taskList = new ArrayList<Task>();

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
        switch(parts[0]) {
            case "done":
              // code block
              if(Integer.parseInt(parts[1]) > taskList.size()){
                respondToUser("Task not found");
              }
              else {
               taskList.get((Integer.parseInt(parts[1]) - 1)).setDone(true);
              respondToUser("Nice! I've marked this task as done: \n" +
                            taskList.get((Integer.parseInt(parts[1]) - 1)).toString());
              }
              break;
            case "list":
              System.out.println("-----------------------\nHere are the tasks in your list:");
              for (int i = 0; i < taskList.size(); i++) {
                  System.out.println(i + 1 + ": " + taskList.get(i).toString());
              }
              System.out.println("-----------------------\n");
              processUserInput(getInput());
              break;
            case "bye":
              respondToUser("Bye. Hope to see you again soon!");
              System.exit(0);
              break;
            case "todo":
              Todo todo = new Todo(parts[1]);
              taskList.add(todo);
              respondToUser("Got it. I've added this task:  \n" +
                             todo.toString() + "\n" + 
                             "Now you have " + taskList.size() + " tasks in the list.");
              break;
            case "deadline":
              String[] deadline_parts = parts[1].split(" /by ", 2);
              Deadline deadline = new Deadline(deadline_parts[0], deadline_parts[1]);
              taskList.add(deadline);
              respondToUser("Got it. I've added this task:  \n" +
                             deadline.toString() + "\n" + 
                             "Now you have " + taskList.size() + " tasks in the list.");
              break;
            case "event":
              String[] event_parts = parts[1].split(" /at ", 2);
              Event event = new Event(event_parts[0], event_parts[1]);
              taskList.add(event);
              respondToUser("Got it. I've added this task:  \n" +
                             event.toString() + "\n" + 
                             "Now you have " + taskList.size() + " tasks in the list.");
              break;
            default:
              respondToUser("Command not found");
          }
          processUserInput(getInput());

    }

    public void respondToUser(String userResponse) {
        System.out.println("-----------------------\n" + userResponse + "\n-----------------------\n");
    }

}
