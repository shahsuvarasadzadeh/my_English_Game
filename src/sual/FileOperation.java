package sual;

import myEngGame.Entity;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperation {
    static Scanner sc = new Scanner(System.in);

    public static void add() {
        List<Entity> list = new ArrayList<>();
        Entity e1 = new Entity(sc.nextLine(), sc.nextLine());
        Entity e2 = new Entity(sc.nextLine(), sc.nextLine());
        list.add(e1);
        list.add(e2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Game.txt", true);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(list);
            fileOutputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getAll() {

        try  {
            FileInputStream fileInputStream=new FileInputStream("Game.txt");
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            // Read the list from the file
            List<Entity> my = (List<Entity>) ois.readObject();
            // Iterate through the list and print the name of each object
            for (Entity obj : my) {
                System.out.println(obj.getAzWord()+"-"+obj.getEngWord());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
