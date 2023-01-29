package service;

import myEngGame.Entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public interface Service {
     String getAll();
     String add(String a, String b);
     String updateById(int a, String b, String c);
     String deleteById(int i);
     String getById(int id);
     String engAndAzeWord(int id, int index);
     Integer randomNum(int id);
     Integer compareWords(String a, String b);
     Double m3(int a, int b);
     String count(int a);
     Integer countOfWords();
     String add1(String a, String b);
     String add2(FileInputStream fileInputStream, String a, String b);
     List<Entity> m() throws IOException, ClassNotFoundException;
     Double toChar(int id, int index);
     Double help(int b, int a);


}
