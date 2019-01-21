package jp.ac.uryukyu.ie.e185733;

public class Battle {
    public int phitPoint;
    public int pattack;
    public boolean pdead;
    public int bhitPoint;
    public int battack;
    public boolean bdead;

    public  Battle(){
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

    public void TurnEnd(int bdamege, int pdamage){
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
