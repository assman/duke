package main.java;
import java.util.*;

import java.io.*;

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
<<<<<<< HEAD
      while(input.hasNextLine()){
        String inputString = input.nextLine();
        parser.processUserInput(inputString, this.taskList, this.storage);
      }
=======
      String inputString = null;
      inputString = input.nextLine();
      return inputString;
  }

    public void processUserInput(String userInput) {
        String[] parts = userInput.split(" ", 2);
        switch(parts[0]) {
            case "done":
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
              break;
            case "delete":
              if(Integer.parseInt(parts[1]) > taskList.size()){
                respondToUser("Task not found");
              }
              else {
                Task deletedTask = taskList.get(Integer.parseInt(parts[1]) - 1);
                taskList.remove(Integer.parseInt(parts[1]) - 1);
                respondToUser("Noted. I've removed this task: \n" +
                              deletedTask.toString() + "\n" +
                              "Now you have " + taskList.size() + " tasks in the list.");
              }
              break;
            case "bye":
              respondToUser("Bye. Hope to see you again soon!");
              this.save();
              System.exit(0);
              break;
            case "find":
              String searchQuery = parts[1];
              ArrayList<Task> searchResult = new ArrayList<Task>();
              for (Task task : taskList) {
                  if(task.toString().contains(searchQuery)){
                      searchResult.add(task);
                  }
              }
              if(searchResult.size() > 0){
                System.out.println("-----------------------\nHere are the matching tasks in your list:");
                for (int i = 0; i < searchResult.size(); i++) {
                    System.out.println(i + 1 + ": " + searchResult.get(i).toString());
                }
                System.out.println("-----------------------\n");
              }
              else {
                respondToUser("Sorry, no such tasks found :(");
              }
              break;
            case "todo":
              try {
                if(parts[1].isBlank() | parts[1].isEmpty()){
                  respondToUser("☹ OOPS!!! The description of a todo cannot be empty.");
                  break;
                }
                Todo todo = new Todo(parts[1]);
                taskList.add(todo);
                respondToUser("Got it. I've added this task:  \n" +
                              todo.toString() + "\n" + 
                              "Now you have " + taskList.size() + " tasks in the list.");
              } catch (ArrayIndexOutOfBoundsException exception) {
                respondToUser("☹ OOPS!!! The description of a todo cannot be empty.");
              }
              break;
            case "deadline":
              try {
                if(parts[1].isBlank() | parts[1].isEmpty()){
                  respondToUser("☹ OOPS!!! The description of a deadline cannot be empty.");
                  break;
                }
                String[] deadline_parts = parts[1].split(" /by ", 2);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                LocalDateTime dateTime;
                try{
                  dateTime = LocalDateTime.parse(deadline_parts[1], formatter);
                }
                catch(Exception e){
                  respondToUser("Invalid Date/Time. Please use the format dd-MM-yyyy HH:mm");
                  break;                
                }
                Deadline deadline = new Deadline(deadline_parts[0], dateTime);
                taskList.add(deadline);
                respondToUser("Got it. I've added this task:  \n" +
                              deadline.toString() + "\n" + 
                              "Now you have " + taskList.size() + " tasks in the list.");
              } catch (ArrayIndexOutOfBoundsException exception) {
                respondToUser("☹ OOPS!!! The description of a deadline cannot be empty.");
              }
              break;
            case "event":
              try {
                if(parts[1].isBlank() | parts[1].isEmpty()){
                  respondToUser("☹ OOPS!!! The description of a event cannot be empty.");
                  break;
                }
                String[] event_parts = parts[1].split(" /at ", 2);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                LocalDateTime dateTime;
                try{
                  dateTime = LocalDateTime.parse(event_parts[1], formatter);
                }
                catch(Exception e){
                  respondToUser("Invalid Date/Time. Please use the format dd-MM-yyyy HH:mm");
                  break;                
                }
                Event event = new Event(event_parts[0], dateTime);
                taskList.add(event);
                respondToUser("Got it. I've added this task:  \n" +
                              event.toString() + "\n" + 
                              "Now you have " + taskList.size() + " tasks in the list.");
              } catch (ArrayIndexOutOfBoundsException exception) {
                respondToUser("☹ OOPS!!! The description of a event cannot be empty.");
              }
              break;
            default:
              respondToUser("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
          }
          
          processUserInput(getInput());

>>>>>>> 1817a7e3f6c446420db62d9fd99ac4a41b05a831
    }
}
