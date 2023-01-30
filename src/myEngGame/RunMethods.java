package myEngGame;
import java.util.Scanner;
public class RunMethods {
    public static void main2() {
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
        FileOp fileOp = new FileOp();
        switch (sc.nextInt()) {
            case 1:
                System.out.println(fileOp.getAll());
                break;
            case 2:
                System.out.println(Constants.ADD_AZE_WORD.getS());
                String a = sc.next();
                System.out.println(Constants.ADD_ENG_WORD.getS());
                String b = sc.next();
                    System.out.println(fileOp.add(a, b));
                break;
            case 3:
                System.out.println(Constants.ADD_WORDS_ID.getS());
                int c=sc.nextInt();
                System.out.println(Constants.ADD_NEW_AZE_WORD.getS());
                a=sc.next();
                System.out.println(Constants.ADD_NEW_ENG_WORD.getS());
                b=sc.next();
                System.out.println(fileOp.updateById(c,a,b));
                break;
            case 4:
                System.out.println(Constants.ADD_WORDS_ID.getS());
                System.out.println(fileOp.deleteById(sc.nextInt()));
                break;
            case 5:
                main2();
                break;
            default:
                System.out.println(Constants.WRONG_INPUT.getS());
                main1();
        }
    }
    public static void play() {
        Scanner sc = new Scanner(System.in);
        FileOp fileOp = new FileOp();
        switch (sc.nextInt()) {
            case 1:
                System.out.println(fileOp.count(1));
                break;
            case 2:
                System.out.println(fileOp.count(2));
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
