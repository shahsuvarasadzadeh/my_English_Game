package myEngGame;

import service.Service;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static myEngGame.RunMethods.main2;

public class FileOp implements Service {
    Scanner sc = new Scanner(System.in);

    @Override
    public String add(String a, String b) {
        Entity e = new Entity(a, b);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(
                    "Game.txt", true));
            bufferedOutputStream.write(e.toString().getBytes());
            bufferedOutputStream.close();
        } catch (FileNotFoundException d) {
            throw new RuntimeException(d);
        } catch (IOException d) {
            throw new RuntimeException(d);
        }
        return Constants.WORD_ADDED.getS();
    }

    @Override
    public String updateById(String i) {
        String[] s = splitAndClear();
        for (int j = 0; j < s.length; j++) {
            String[] s1 = s[j].split(" - ");
            if (s1[0].equals(i)) {
                System.out.println(Constants.ADD_NEW_AZE_WORD.getS());
                s1[2] = sc.nextLine();
                System.out.println(Constants.ADD_NEW_ENG_WORD.getS());
                s1[4] = sc.nextLine();
                add(s1[2], s1[4]);
            } else {
                add(s1[2], s1[4]);
            }
        }
        return Constants.WORD_UPDATE.getS();
    }

    @Override
    public String deleteById(String i) {
        String[] s = splitAndClear();
        for (int j = 0; j < s.length; j++) {
            String[] s1 = s[j].split(" - ");
            if (s1[0].equals(i)) {
                s1[2] = "bos";
                s1[4] = "empty";
                add(s1[2], s1[4]);
            } else {
                add(s1[2], s1[4]);
            }
        }
        return Constants.WORD_DELETED.getS();
    }

    @Override
    public String[] splitAndClear() {
        String[] s = getAll().split("\n");
        try {
            FileOutputStream f = new FileOutputStream("Game.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    @Override
    public String getById(int id) {
        String[] s = getAll().split("\n");
        return s[id - 1];
    }

    @Override
    public String azeWord(int id) {
        String[] s = getById(id).split(" - ");
        return s[2];
    }

    @Override
    public String engWord(int id) {
        String[] s = getById(id).split(" - ");
        return s[4];
    }

    @Override
    public Integer randomNum() {
        Random random = new Random();
        int int_RANDOM = random.nextInt(countOfWords());
        if (int_RANDOM == 0) {
            randomNum();
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
    public Integer count(int a) {
        FileOp fileOp = new FileOp();
        int b = fileOp.randomNum();
        int count=0;
        int v=0;
        while (b!=0) {
            if (a == 1) {
                System.out.println(fileOp.azeWord(b));
                System.out.println(Constants.ADD_ENG_WORD.getS());
                v = v + fileOp.compareWords(fileOp.engWord(b), sc.next());
                System.out.println(Constants.DONE_OR_STOP.getS());
                switch (sc.nextInt()) {
                    case 1:
                        b = fileOp.randomNum();
                        break;
                    case 2:
                        b=0;
                        break;
                }
            } else if (a == 2) {
                System.out.println(fileOp.engWord(b));
                System.out.println(Constants.ADD_AZE_WORD.getS());
                v = v + fileOp.compareWords(fileOp.azeWord(b), sc.next());
                System.out.println(Constants.DONE_OR_STOP.getS());
                switch (sc.nextInt()) {
                    case 1:
                        b = fileOp.randomNum();
                        break;
                    case 2:
                        b=0;
                        break;
                }
            }
        }
           count=count+v;
        return count;
    }
    @Override
    public Integer countOfWords() {
        String[] s = getAll().split("\n");
        return s.length;
    }
    @Override
    public String id() {
        String[] words = getAll().split("\n");
        String[] w = words[words.length - 1].split(" - ");
        int i;
        if (w.length == 1) {
            i = 1;
        } else {
            i = Integer.parseInt(w[0]);
            i = i + 1;
        }
        String s = Integer.toString(i);
        return s;
    }

    @Override
    public String getAll() {
        String str = "";
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(
                    new FileInputStream("Game.txt"));
            int i = bufferedInputStream.read();
            while (i != -1) {
                str = str + (char) i;
                i = bufferedInputStream.read();
            }
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str.trim();
    }
}
