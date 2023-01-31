package service;

import myEngGame.Entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public interface Service {
     String getAll(String path);
     String add(String a, String b,String path);
     String updateById(int a, String b, String c,String path);
     String deleteById(int i, String path);
     String getById(int id,String path);
     String engAndAzeWord(int id, int index,String path);
     Integer randomNum(int id);
     Integer compareWords(String a, String b);
     Double m3(int a, int b,String path);
     String count(int a,String path);
     Integer countOfWords(String path);
     String add1(String a, String b,String path);
     String add2(FileInputStream fileInputStream, String a, String b,String path);
     List<Entity> m(String path) throws IOException, ClassNotFoundException;
     Double toChar(int id, int index,String path);
     Double help(int b, int a,String path);
     String createFile(String path);


}
