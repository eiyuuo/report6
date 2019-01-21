package jp.ac.uryukyu.ie.e185733;

public class Battle {
    static int phitPoint;
    static int pattack;
    static boolean pdead;
    static int bhitPoint;
    static int battack;
    static boolean bdead;

    public static void Battle(){
        int bdamege,pdamege;
        if(bdead == false) {
            bdamege = (int) (Math.random() * pattack);
            System.out.printf("プレイヤーの攻撃！ボスに%sのダメージを与えた。\n", bdamege);

            if (pdead == false) {
                pdamege = (int) (Math.random() * battack);
                System.out.printf("ボスの攻撃！プレイヤーに%sのダメージを与えた。\n", pdamege);
                TurnEnd(bdamege, pdamege);
            }
        }
    }

    static void TurnEnd(int bdamege, int pdamage){
        bhitPoint -= bdamege;
        phitPoint -= pdamage;
        if (bhitPoint < 0){
            bdead = true;
            System.out.printf("ボスは倒れた。");
        }
        if (phitPoint < 0) {
            pdead = true;
            System.out.printf("プレイヤーは倒れた。");
        }
    }
}
