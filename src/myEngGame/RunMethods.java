package myEngGame;
import java.util.Scanner;
public class RunMethods {
   static Scanner sc=new Scanner(System.in);
    public static void main2() {
        System.out.println(Constants.START.getS());
        if (sc.nextInt() == 1) {
            System.out.println(Constants.STEP1.getS());
            main1();
        } else {
            System.out.println(Constants.PLAY.getS());
            play();
        }
    }
    public static void main1() {
        int i=0;
        FileOp fileOp = new FileOp();
        switch (sc.nextInt()) {
            case 1:
                System.out.println(Constants.LEVEL.getS());
                    System.out.println(fileOp.getAll(fileOp.level(sc.nextInt())));
                System.out.println(Constants.BACK_TO_START_MENU.getS());
                    if (sc.nextInt()==1){
                        main2();
                    }
                break;
            case 2:
                System.out.println(Constants.LEVEL.getS());
                String path=fileOp.level(sc.nextInt());
                while (i==0) {
                    System.out.println(Constants.ADD_AZE_WORD.getS());
                    String a = sc.next();
                    System.out.println(Constants.ADD_ENG_WORD.getS());
                    String b = sc.next();
                    System.out.println(fileOp.add(a, b, path));
                    System.out.println(Constants.BACK.getS());
                    int r= sc.nextInt();
                    if (r==1){
                        i=1;
                    }
                    else if (r==2){
                        main2();
                    }
                }
                break;
            case 3:
                int z=0;
                System.out.println(Constants.LEVEL.getS());
                path=fileOp.level(sc.nextInt());
                while (z==0) {
                    System.out.println(Constants.ADD_WORDS_ID.getS());
                    int c = sc.nextInt();
                    System.out.println(Constants.ADD_NEW_AZE_WORD.getS());
                    String a = sc.next();
                    System.out.println(Constants.ADD_NEW_ENG_WORD.getS());
                    String b = sc.next();
                    System.out.println(fileOp.updateById(c, a, b, path));
                    int r= sc.nextInt();
                    if (r==1){
                        z=1;
                    }
                    else if (r==2){
                        main2();
                    }
                }
                break;
            case 4:
                int p=0;
                while (p==0) {
                    System.out.println(Constants.ADD_WORDS_ID.getS());
                    int q = sc.nextInt();
                    System.out.println(Constants.LEVEL.getS());
                    System.out.println(fileOp.deleteById(q, fileOp.level(sc.nextInt())));
                    System.out.println(Constants.BACK.getS());
                    int r= sc.nextInt();
                    if (r==1){
                        p=1;
                    }
                    else if (r==2){
                        main2();
                    }
                }
                break;
            case 5:
                System.out.println(Constants.LEVEL.getS());
                System.out.println(fileOp.createFile(fileOp.level(sc.nextInt())));
                System.out.println(Constants.BACK_TO_START_MENU.getS());
                if (sc.nextInt()==1){
                    main2();
                }
                break;
            case 6:
                main2();
                break;
            default:
                System.out.println(Constants.WRONG_INPUT.getS());
                main1();
        }
    }
    public static void play() {
        FileOp fileOp = new FileOp();
        switch (sc.nextInt()) {
            case 1:
                System.out.println(Constants.LEVEL_AZE.getS());
                System.out.println(fileOp.count(1, fileOp.level(sc.nextInt())));
                break;
            case 2:
                System.out.println(Constants.LEVEL.getS());
                System.out.println(fileOp.count(2, fileOp.level(sc.nextInt())));
                break;
            case 3:
                main2();
                break;
            default:
                System.out.println(Constants.WRONG_INPUT.getS());
                play();
        }
    }
}
