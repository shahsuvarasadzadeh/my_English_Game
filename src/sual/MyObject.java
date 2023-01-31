package sual;

import java.io.Serializable;

public class MyObject implements Serializable {

    private String name;

    public MyObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
