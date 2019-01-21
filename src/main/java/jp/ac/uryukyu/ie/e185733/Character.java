package jp.ac.uryukyu.ie.e185733;

public class Character {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public Character (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public void attack (Character opponent){
        if( this.dead == false) {
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

    public String getName(){
        return name;
    }
    public void setName() {
        this.name = name;
    }
}
