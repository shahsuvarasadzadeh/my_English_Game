package myEngGame;
import service.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class FileOp implements Service {
    Scanner sc = new Scanner(System.in);
    @Override
    public String add(String a, String b) {
        List<Entity> my = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("Game.txt");
            if (fileInputStream.equals(null)) {
                add1(a, b);
            } else {
                add2(fileInputStream, a, b);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return Constants.WORD_ADDED.getS();
    }
    @Override
    public String updateById(int i, String a, String b) {
        List<Entity> my;
        try {
            my = m();
            my.set(i, new Entity(a, b));
            m1(my);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return Constants.WORD_UPDATE.getS();
    }
    @Override
    public String deleteById(int i) {
        List<Entity> my;
        try {
            my = m();
            my.remove(i - 1);
            m1(my);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return Constants.WORD_DELETED.getS();
    }
    @Override
    public String getById(int id) {
        String[] s = getAll().split("\n");
        return s[id - 1];
    }
    @Override
    public String engAndAzeWord(int id, int index) {
        String[] s = getById(id).split("-");
        return s[index - 1];
    }
    @Override
    public Integer randomNum(int id) {
        Random random = new Random();
        int int_RANDOM = random.nextInt(id);
        if (int_RANDOM == 0) {
            return randomNum(id);
        }
        return int_RANDOM;
    }
    @Override
    public Integer compareWords(String a, String b) {
        int count = 0;
        if (a.equals(b)) {
            count++;
        }
        return count;
    }
    @Override
    public String count(int a) {
        FileOp fileOp = new FileOp();
        int b = fileOp.randomNum(countOfWords()+1);
        int count = 0;
        int cnt = 0;
        int v = 0;
        while (b != 0) {
            cnt++;
            if (a == 1) {
                System.out.println(fileOp.engAndAzeWord(b, 1));
                System.out.println(Constants.ADD_ENG_WORD.getS());
                v = v + fileOp.compareWords(fileOp.engAndAzeWord(b, 2), sc.next());
                System.out.println(Constants.DONE_OR_STOP.getS());
                switch (sc.nextInt()) {
                    case 1:
                        b = fileOp.randomNum(countOfWords()+1);
                        break;
                    case 2:
                        b = 0;
                        break;
                }
            } else if (a == 2) {
                b = fileOp.randomNum(countOfWords()+1);
                System.out.println(fileOp.engAndAzeWord(b, 2));
                System.out.println(Constants.ADD_AZE_WORD.getS());
                v = v + fileOp.compareWords(fileOp.engAndAzeWord(b, 1), sc.next());
                System.out.println(Constants.DONE_OR_STOP.getS());
                switch (sc.nextInt()) {
                    case 1:
                        b = fileOp.randomNum(countOfWords()+1);
                        break;
                    case 2:
                        b = 0;
                        break;
                }
            }
        }
        count = count + v;
        int d = count * 100 / cnt;
        String s = "Your Score : " + count + "/" + cnt + "[" + d + "%" + "]";
        if (d < 51) {
            s = s + Constants.BAD.getS();
        } else if (d > 51 && d < 81) {
            s = s + Constants.NORMAL.getS();
        } else {
            s = s + Constants.GOOD.getS();
        }
        return s;
    }
    @Override
    public Integer countOfWords() {
        String[] s = getAll().split("\n");
        return s.length;
    }
    @Override
    public String add1(String a, String b) {
        List<Entity> my = new ArrayList<>();
        my.add(new Entity(a, b));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Game.txt"))) {
            oos.writeObject(my);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Constants.WORD_ADDED.getS();
    }
    @Override
    public String add2(FileInputStream fileInputStream, String a, String b) {
        List<Entity> my = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            my = (List<Entity>) ois.readObject();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            add1(a, b);
        }
        my.add(new Entity(a, b));
        m1(my);
        return Constants.WORD_ADDED.getS();
    }
    @Override
    public String getAll() {
        List<Entity> my;
        StringBuilder str = new StringBuilder();
        try {
            my = m();
            for (Entity obj : my) {
                str.append(obj.getAzWord() + "-" + obj.getEngWord() + "\n");
            }
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("sorry we have same problems ......");
        }
        return str.toString().trim();
    }
    @Override
    public List<Entity> m() throws IOException, ClassNotFoundException {
        List<Entity> my;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Game.txt"));
        my = (List<Entity>) ois.readObject();
        return my;
    }

    @Override
    public String toChar(int id,int index,int x) {
        String str = engAndAzeWord(id,index);
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        return String.valueOf(arr[x]);
    }

    public static void m1(List<Entity> my) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Game.txt"))) {
            oos.writeObject(my);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
