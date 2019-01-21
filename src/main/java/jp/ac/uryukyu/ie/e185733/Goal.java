package jp.ac.uryukyu.ie.e185733;

public class Goal {
    static int mazeSize = 20;
    static int goalRow = 0, goalCol = mazeSize - 2, bossRow = goalRow++, bossCol = goalCol;
    static boolean[][] wall = Maze.Rtwall(goalRow, goalCol);//mazeをmainに

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
