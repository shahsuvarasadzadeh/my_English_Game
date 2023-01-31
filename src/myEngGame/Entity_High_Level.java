package myEngGame;

public class Entity_High_Level {
    private String aze_Word;
    private String eng_Word;
    private Integer level;

    public Entity_High_Level(String aze_Word, String eng_Word, Integer level) {
        this.aze_Word = aze_Word;
        this.eng_Word = eng_Word;
        this.level = level;
    }

    public String getAze_Word() {
        return aze_Word;
    }

    public String getEng_Word() {
        return eng_Word;
    }

    public Integer getLevel() {
        return level;
    }
    @Override
    public String toString() {
        return "Entity_High_Level{" +
                "aze_Word='" + aze_Word + '\'' +
                ", eng_Word='" + eng_Word + '\'' +
                ", level=" + level +
                '}';
    }
}
