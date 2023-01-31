package sual;
import myEngGame.Entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
        public static void main(String[] args) {

            List<Entity> my = null;
            try  {
                FileInputStream fileInputStream=new FileInputStream("myList.txt");
                ObjectInputStream ois = new ObjectInputStream(fileInputStream);
                 my = (List<Entity>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            my.add(new Entity("object4","object1"));
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myList.txt"))) {
                // Write the list to the file
                oos.writeObject(my);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try  {
                FileInputStream fileInputStream=new FileInputStream("myList.txt");
                ObjectInputStream ois = new ObjectInputStream(fileInputStream);
                my = (List<Entity>) ois.readObject();
                for (Entity obj : my) {
                    System.out.println(obj.getAzWord()+"-"+obj.getEngWord());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

