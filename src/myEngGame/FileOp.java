package myEngGame;

import service.Service;
import java.io.*;
import java.util.*;

public class FileOp implements Service {
    Scanner sc = new Scanner(System.in);
    @Override
    public String add(String a, String b) {
        try {
            FileInputStream fileInputStream = new FileInputStream("Game.txt");
            if (fileInputStream == null) {
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
    public Double m3(int a, int b) {
        return help(a, b);
    }
    @Override
    public String count(int a) {
        FileOp fileOp = new FileOp();
        int b = fileOp.randomNum(countOfWords() + 1);
        double d = 0;
        double count = 0;
        double cnt = 0;
        int v = 0;
        while (b != 0) {
            cnt++;
            if (a == 1) {
                System.out.println(fileOp.engAndAzeWord(b, 1));
                System.out.println(Constants.DO_YOU_WANT_HELP.getS());
                int l = sc.nextInt();
                while (l == 1) {
                    l++;
                    d += toChar(b, 2);
                }
                System.out.println(Constants.ADD_ENG_WORD.getS());
                v = v + fileOp.compareWords(fileOp.engAndAzeWord(b, 2), sc.next());
                System.out.println(Constants.DONE_OR_STOP.getS());
                switch (sc.nextInt()) {
                    case 1:
                        b = fileOp.randomNum(countOfWords() + 1);
                        break;
                    case 2:
                        b = 0;
                        break;
                }
            } else if (a == 2) {
                System.out.println(fileOp.engAndAzeWord(b, 2));
                System.out.println(Constants.DO_YOU_WANT_HELP.getS());
                int l = sc.nextInt();
                while (l == 1) {
                    l++;
                    d += toChar(b, 1);
                }
                System.out.println(Constants.ADD_AZE_WORD.getS());
                v = v + fileOp.compareWords(fileOp.engAndAzeWord(b, 1), sc.next());
                System.out.println(Constants.DONE_OR_STOP.getS());
                switch (sc.nextInt()) {
                    case 1:
                        b = fileOp.randomNum(countOfWords() + 1);
                        break;
                    case 2:
                        b = 0;
                        break;
                }
            }
        }
        count = (count + v) * 10 - d;
        double z = count * 100 / (cnt * 10);
        String s = "Your Score : " + count + "/" + cnt * 10 + "[" + z + "%" + "]";
        if (z < 51) {
            s = s + Constants.BAD.getS();
        } else if (z > 51 && z < 81) {
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
                str.append(obj.getAzWord()).append("-").append(obj.getEngWord()).append("\n");
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
    public Double toChar(int id, int index) {
        int x = 0;
        double d = 0;
        List<Double> doub = new ArrayList<>();
        String str = engAndAzeWord(id, index);
        List<Character> list = new ArrayList<>();
        List<Character> lis = new ArrayList<>();
        Set<Integer> hash_Set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            list.add((str.charAt(i)));
            lis.add('.');
        }
        hash_Set.add(-1);
        while (x == 0) {
            x = randomNum(str.length() + 1) - 1;
            if (!hash_Set.contains(x)) {
                d++;
                for (int i = 0; i < str.length(); i++) {
                    if (i == x) {
                        lis.set(x, list.get(x));
                        hash_Set.add(x);
                    }
                    System.out.print(lis.get(i));
                }
                System.out.println();
                System.out.println(Constants.DO_YOU_WANT_HELP_AGAIN.getS());
                if (sc.nextInt() == 1) {
                    x = 0;
                } else {
                    x = 1;
                }
            } else {
                x = 0;
            }
            if (hash_Set.size() == str.length() + 1)
                x = 1;
        }
        double v = str.length();
        doub.add((10.0 / v) * d);
        d = 0;
        for (Double aDouble : doub) {
            d += aDouble;
        }
        return d;
    }
    @Override
    public Double help(int b, int a) {
        return toChar(b, a);
    }
    private static void m1(List<Entity> my) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Game.txt"))) {
            oos.writeObject(my);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
