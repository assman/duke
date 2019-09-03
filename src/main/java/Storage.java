package main.java;

import java.util.*;
import java.io.*;

public class Storage {
    public static void main(String[] args) {
    }

    public void load(TaskList tList) {
        try {
            FileInputStream fis = new FileInputStream("tasks.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            tList.setlist((ArrayList<Task>) ois.readObject());
            ois.close();
        } catch (Exception e) {
            try {
                FileOutputStream fos = new FileOutputStream("tasks.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(tList.getlist());
                oos.close();
            } catch (Exception ee) {
                Ui.respondToUser("OOPS, unable to write to file");
            }
        }
    }

    public void save(TaskList tList) {
        try {
            FileOutputStream fos = new FileOutputStream("tasks.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tList.getlist());
            oos.close();
        } catch (Exception e) {
            Ui.respondToUser("Error while saving your tasks :(");
        }
    }
}