package main.java;
import java.util.*;
import java.io.*;

public class Duke {
    private static final String LOGO = " ____        _        \n" + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n" + "| |_| | |_| |   <  __/\n" + "|____/ \\__,_|_|\\_\\___|\n";

    private ArrayList<Task> taskList = new ArrayList<Task>();

    public static void main(String[] args) {
        System.out.println("Hello I'm Duke\n" + "What can I do for you?\n" + "____________________________");
        Duke myDuke = new Duke();
        
        try{
          FileInputStream fis = new FileInputStream("tasks.txt");
          ObjectInputStream ois = new ObjectInputStream(fis);
          myDuke.taskList = (ArrayList<Task>) ois.readObject();
          ois.close();
          }
          catch(Exception e){
            try{
              FileOutputStream fos = new FileOutputStream("tasks.txt");
              ObjectOutputStream oos = new ObjectOutputStream(fos);
              oos.writeObject(myDuke.taskList);
              oos.close();
              }
              catch(Exception ee){
                myDuke.respondToUser("OOPS, unable to write to file");
              }
          }
          myDuke.processUserInput(getInput());
    }

    public void addTask(Task task) {
      this.taskList.add(task);
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
              try{
                FileOutputStream fos = new FileOutputStream("tasks.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(taskList);
                oos.close();
                }
                catch(Exception e){
                  e.printStackTrace();
                }
              System.exit(0);
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
                Deadline deadline = new Deadline(deadline_parts[0], deadline_parts[1]);
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
                Event event = new Event(event_parts[0], event_parts[1]);
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
          // try (BufferedWriter bw = new BufferedWriter(new FileWriter("tasks.txt"))) {
				  //   for (Task t: taskList) {
				  //       bw.write(t + "\n");
				  //   }

				  //   bw.close();

          // } catch (IOException e) {
          //     e.printStackTrace();
          // }
          
          processUserInput(getInput());

    }

    public void respondToUser(String userResponse) {
        System.out.println("-----------------------\n" + userResponse + "\n-----------------------\n");
    }

}
