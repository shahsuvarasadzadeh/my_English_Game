package myEngGame;

import java.io.Serializable;

public class Entity implements Serializable {
    private final String azWord;
    private final String engWord;
    public Entity(String azWord, String engWord) {
        this.azWord = azWord;
        this.engWord = engWord;
    }
    public String getAzWord() {
        return azWord;
    }
    public String getEngWord() {
        return engWord;
    }
    @Override
    public String toString() {
        return "Entity{" +
                ", azWord='" + azWord + '\'' +
                ", engWord='" + engWord + '\'' +
                '}';
    }
}
