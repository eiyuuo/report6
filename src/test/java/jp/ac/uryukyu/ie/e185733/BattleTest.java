package jp.ac.uryukyu.ie.e185733;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    /**
     * bdeadがNullじゃないかの確認
     */
    @Test
    void turnEnd() {
        int bdamage =5;
        int pdamage =3;
        int bhitPint =6;
        int phitPint =3;
        assertNotNull(Battle.bdead);

    }
}