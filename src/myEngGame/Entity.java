package myEngGame;

import java.io.Serializable;

public class Entity implements Serializable {
    FileOp fileOp = new FileOp();
    private String id;
    private String azWord;
    private String engWord;

    public Entity(String azWord, String engWord) {
        this.azWord = azWord;
        this.engWord = engWord;
    }

    public String getId() {
        return id;
    }

    public String getAzWord() {
        return azWord;
    }

    public String getEngWord() {
        return engWord;
    }

    @Override
    public String toString() {
        return fileOp.id() + " - " +
                " azWord - " + azWord + " - " +
                " engWord - " + engWord + '\n';
    }
}
