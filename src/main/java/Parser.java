package main.java;

import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parser {
    public void processUserInput(String userInput, TaskList taskList, Storage storage) {
        String[] parts = userInput.split(" ", 2);
        switch(parts[0]) {
            case "done":
              if(Integer.parseInt(parts[1]) > taskList.size()){
                Ui.respondToUser("Task not found");
              }
              else {
               taskList.get((Integer.parseInt(parts[1]) - 1)).setDone(true);
              Ui.respondToUser("Nice! I've marked this task as done: \n" +
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
              try {
                if(parts[1].isBlank() | parts[1].isEmpty()){
                    Ui.respondToUser("Which task do you want to delete?");
                    break;
                  }
                  if(Integer.parseInt(parts[1]) > taskList.size()){
                    Ui.respondToUser("Task not found");
                  }
                  else {
                    Task deletedTask = taskList.get(Integer.parseInt(parts[1]) - 1);
                    taskList.getlist().remove(Integer.parseInt(parts[1]) - 1);
                    Ui.respondToUser("Noted. I've removed this task: \n" +
                                  deletedTask.toString() + "\n" +
                                  "Now you have " + taskList.size() + " tasks in the list.");
                  }
              } catch (ArrayIndexOutOfBoundsException exception) {
                  Ui.respondToUser("Which task do you want to delete?");
              }
              break;
            case "find":
              try {
                if(parts[1].isBlank() | parts[1].isEmpty()){
                    Ui.respondToUser("☹ OOPS!!! The search query cannot be empty.");
                    break;
                  }
                String searchQuery = parts[1];
                ArrayList<Task> searchResult = new ArrayList<Task>();
                for (Task task : taskList.getlist()) {
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
                    Ui.respondToUser("Sorry, no such tasks found :(");
                }
              } catch (ArrayIndexOutOfBoundsException exception) {
                    Ui.respondToUser("☹ OOPS!!! The search query cannot be empty.");
              }
              break;
            case "bye":
              Ui.respondToUser("Bye. Hope to see you again soon!");
              storage.save(taskList);
              System.exit(0);
              break;
            case "todo":
              try {
                if(parts[1].isBlank() | parts[1].isEmpty()){
                  Ui.respondToUser("☹ OOPS!!! The description of a todo cannot be empty.");
                  break;
                }
                Todo todo = new Todo(parts[1]);
                taskList.addTask(todo);
                Ui.respondToUser("Got it. I've added this task:  \n" +
                              todo.toString() + "\n" + 
                              "Now you have " + taskList.size() + " tasks in the list.");
              } catch (ArrayIndexOutOfBoundsException exception) {
                Ui.respondToUser("☹ OOPS!!! The description of a todo cannot be empty.");
              }
              break;
            case "deadline":
              try {
                if(parts[1].isBlank() | parts[1].isEmpty()){
                  Ui.respondToUser("☹ OOPS!!! The description of a deadline cannot be empty.");
                  break;
                }
                String[] deadline_parts = parts[1].split(" /by ", 2);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                LocalDateTime dateTime;
                try{
                  dateTime = LocalDateTime.parse(deadline_parts[1], formatter);
                }
                catch(Exception e){
                  Ui.respondToUser("Invalid Date/Time. Please use the format dd-MM-yyyy HH:mm");
                  break;                
                }
                Deadline deadline = new Deadline(deadline_parts[0], dateTime);
                taskList.addTask(deadline);
                Ui.respondToUser("Got it. I've added this task:  \n" +
                              deadline.toString() + "\n" + 
                              "Now you have " + taskList.size() + " tasks in the list.");
              } catch (ArrayIndexOutOfBoundsException exception) {
                Ui.respondToUser("☹ OOPS!!! The description of a deadline cannot be empty.");
              }
              break;
            case "event":
              try {
                if(parts[1].isBlank() | parts[1].isEmpty()){
                  Ui.respondToUser("☹ OOPS!!! The description of a event cannot be empty.");
                  break;
                }
                String[] event_parts = parts[1].split(" /at ", 2);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                LocalDateTime dateTime;
                try{
                  dateTime = LocalDateTime.parse(event_parts[1], formatter);
                }
                catch(Exception e){
                  Ui.respondToUser("Invalid Date/Time. Please use the format dd-MM-yyyy HH:mm");
                  break;                
                }
                Event event = new Event(event_parts[0], dateTime);
                taskList.addTask(event);
                Ui.respondToUser("Got it. I've added this task:  \n" +
                              event.toString() + "\n" + 
                              "Now you have " + taskList.size() + " tasks in the list.");
              } catch (ArrayIndexOutOfBoundsException exception) {
                Ui.respondToUser("☹ OOPS!!! The description of a event cannot be empty.");
              }
              break;
            default:
              Ui.respondToUser("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
          }
     }
}