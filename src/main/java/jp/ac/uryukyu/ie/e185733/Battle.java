package jp.ac.uryukyu.ie.e185733;



public class Battle {
    static int phitPoint = 30;
    static int pattack = 5;
    static boolean pdead = false;
    static int bhitPoint = 50;
    static int battack =7;
    static boolean bdead = false;

    public static void Battle(){
        int bdamege,pdamege;
        while (pdead == false){
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
    }

    static void TurnEnd(int bdamege, int pdamage){
        bhitPoint -= bdamege;
        System.out.printf("ボスのHPは%s",bhitPoint);
        phitPoint -= pdamage;
        System.out.printf("プレイヤーのHPは%s",phitPoint);
        if (bhitPoint < 0){
            bdead = true;
            System.out.printf("ボスは倒れた。");
            System.out.println();
        }
        if (phitPoint < 0) {
            pdead = true;
            System.out.printf("プレイヤーは倒れた。");
            System.out.println();
        }
    }
}
