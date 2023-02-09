package myEngGame;
public enum Constants {
    START("************************************************\n" +
            "* if you are admin add number [1]              *\n" +
            "************************************************\n" +
            "* if you are user add any number other than [1]*\n" +
            "************************************************"),
    STEP1("************************************************\n" +
            "1. get all file                                *\n" +
            "************************************************\n" +
            "2. add file                                    *\n" +
            "************************************************\n" +
            "3. update file                                 *\n" +
            "************************************************\n" +
            "4. delete file                                 *\n" +
            "************************************************\n" +
            "5. create New file                             *\n" +
            "************************************************\n" +
            "6. back                                        *\n"),
    PLAY("************************************************\n" +
            "1. Aze :                                       *\n" +
            "************************************************\n" +
            "2. Eng :                                       *\n" +
            "************************************************\n" +
            "3. Back to Main Menu                           *\n" +
            "************************************************"),
    DONE_OR_STOP("************************************************\n" +
            "1. Done                                        *\n" +
            "2. Stop                                        *\n" +
            "************************************************"),
    WRONG_INPUT("************************************************\n" +
            "* pls add correct input                        *\n" +
            "************************************************"),
    ADD_AZE_WORD(
            "************************************************\n" +
            "* add azeWord                                  *\n" +
                    "************************************************"),
    ADD_ENG_WORD("************************************************\n" +
            "* add engWord                                  *\n" +
            "************************************************"),
    WORD_UPDATE(
            "************************************************\n" +
                    "* Word Updated                                 *\n" +
                    "************************************************"),
    WORD_ADDED(
            "************************************************\n" +
            "* Word Added                                   *\n" +
            "************************************************"),
    WORD_DELETED(
            "************************************************\n" +
                    "* Word Deleted                                 *\n" +
                    "************************************************"),
    ADD_WORDS_ID(
            "************************************************\n" +
            "* Add Words Id :                               *\n" +
            "************************************************"),
    ADD_NEW_AZE_WORD(
            "************************************************\n" +
            "* Add new azeWord :                            *\n" +
            "************************************************"),
    ADD_NEW_ENG_WORD(
            "************************************************\n" +
            "* Add new engWord :                            *\n" +
            "************************************************"),
    NORMAL(
            "************************************************\n" +
            "* Normal                                       *\n" +
            "************************************************"),
    BAD(
            "************************************************\n" +
            "* Bad                                          *\n" +
            "************************************************"),
    GOOD(
            "************************************************\n" +
            "* Good                                         *\n" +
            "************************************************"),
    DO_YOU_WANT_HELP(
            "************************************************\n" +
            "* Do you want help :                           *\n" +
            "* 1. Yes                                       *\n" +
            "* 2. No                                        *\n" +
            "************************************************"),
    DO_YOU_WANT_HELP_AGAIN(
            "************************************************\n" +
                    "* Do you want help Again :                     *\n" +
                    "* 1. Yes                                       *\n" +
                    "* 2. No                                        *\n" +
                    "************************************************"),
    LEVEL(
            "************************************************\n" +
                    "* Choose Your Level:                           *\n" +
                    "* 1. Elementary                                *\n" +
                    "* 2. Intermediate                              *\n" +
                    "* 3. Advanced                                  *\n" +
                    "************************************************" ),
    LEVEL_AZE(
                    "************************************************\n" +
            "* Seviyenizi secin :                           *\n" +
            "* 1. Baslangic                                *\n" +
            "* 2. Orta                                     *\n" +
            "* 3. Yuksek                                  *\n" +
            "************************************************"),
    PATH("C:\\Users\\Public\\") , SCORE("Your Score : "),
    H1("************************************************\n"), H2("* "),
    SORRY("sorry we have same problems ......"), FILE_CREATED("File created: "),
    FILE_ALREADY_EXIST("File already exists."), ERROR_OCCURRED("An error occurred."),
    ELEMENTARY("Elementary.txt"),ADVANCED("Advanced.txt"),INTERMEDIATE("Intermediate.txt"),
    BACK_TO_START_MENU("************************************************\n" +
            "* [1]- Back to menu :                          *\n" +
            "* [Any number] - STOP :                        *\n" +
            "************************************************\n"+
            "* add input : "),
    BACK("************************************************\n" +
            "* [1]- STOP:                                   *\n" +
            "* [2]- Back to menu :                          *\n" +
            "* [Any number] - Done :                        *\n" +
            "************************************************\n"+
            "* add input : ");
    private final String s;
    Constants(String s) {
        this.s = s;
    }
    public String getS() {
        return s;
    }
}
