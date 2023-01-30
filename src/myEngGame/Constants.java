package myEngGame;

public enum Constants {
    START("if you are admin add number [1]\n" +
            "if you are user add any number other than [1]"),
    STEP1("1. get all file\n" +
            "2. add file\n" +
            "3. update file\n" +
            "4. delete file\n" +
            "5. back"),
    PLAY("1. Aze :\n" +
            "2. Eng :\n" +
            "4. Back to Main Menu"),
    DONE_OR_STOP("1. Done\n" +
            "2. Stop\n"),
    WRONG_INPUT("pls add correct input") , ADD_AZE_WORD("add azeWord :") , ADD_ENG_WORD("add engWord :") ,
    WORD_UPDATE("Word Updated") , WORD_ADDED("Word Added") , WORD_DELETED("Word Deleted") ,
    ADD_WORDS_ID("Add Words Id :") , ADD_NEW_AZE_WORD("Add new azeWord :") , ADD_NEW_ENG_WORD("Add new engWord :"),
    NORMAL("Normal") , BAD("Bad") , GOOD("Good") , DO_YOU_WANT_HELP("Do you want help :\n" +
            "1. Yes\n" +
            "2. No") , DO_YOU_WANT_HELP_AGAIN("Do you want help Again :\n" +
            "1. Yes\n" +
            "2. No");
    private final String s;
    Constants(String s) {
        this.s=s;
    }
    public String getS() {
        return s;
    }
}
