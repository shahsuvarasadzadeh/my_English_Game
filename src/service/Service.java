package service;

public interface Service {

     String getAll();
     String id();
     String add(String a,String b);
     String updateById(String i);
     String deleteById(String i);
     String [] splitAndClear();
     String getById(int id);
     String azeWord(int id);
     String engWord(int id);
     Integer randomNum();
     Integer compareWords(String a,String b);
     Integer count(int a);
     Integer countOfWords();
}
