package jp.ac.uryukyu.ie.e185733;

/**
 * ゴールに関係するもののクラス
 * ゴールの場所、リセット、ゴールの前のボスの場所を決める
 */
public class Goal {
    static int mazeSize = 20;
    static int goalRow = Main.goalRow, goalCol = Main.goalCol, bossRow = Main.bossRow, bossCol = Main.bossCol;
    static boolean[][] wall = Main.wall;
    /**
     * ゲームを初期化する時に使う
     * ゴールの位置をリセット
     */
    public static void resetGoal() {
        goalRow = 0;
        goalCol = mazeSize - 2;

        while (true) {
            if (wall[goalRow + 1][goalCol]) {
                goalCol--;
            } else {
                break;
            }
        }
    }

    /**
     * ゲームを初期化する時に使う
     * ボスの位置をリセットする
     */
    public static void resetBoss() {
        bossRow = goalRow++;
        bossCol = goalCol;

        while (true) {
            if (wall[bossRow + 1][bossCol]) {
                goalCol--;
            } else {
                break;
            }
        }
    }
}
