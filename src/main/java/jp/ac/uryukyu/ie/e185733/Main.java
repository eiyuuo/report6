package jp.ac.uryukyu.ie.e185733;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int mazeSize = 20;
    static boolean[][] wall;
    static int row;
    static int col;
    static int usrRow = mazeSize - 1, usrCol = 1, goalRow = 0, goalCol = mazeSize - 2, bossRow = goalRow +1, bossCol = goalCol;

    public static void main(String[] args) {
        wall = new boolean[mazeSize][mazeSize];

        CreateMaze.createMaze();
        PlayerMove.resetUsr();
        Goal.resetGoal();
        Goal.resetBoss();

        Scanner scan = new Scanner(System.in);
        String keys = "";
        char key;
        long start = System.currentTimeMillis(), end;

        while (true) {
            printMaze();
            keys = scan.next();
            key = keys.charAt(keys.length() - 1);
            PlayerMove.PlayerMove(key);
            usrCol = PlayerMove.usrCol;
            usrRow = PlayerMove.usrRow;
            if(usrRow == bossRow && usrCol == bossCol){
                Battle.Battle();
            }

        }
    }
    static  void printMaze() {
        for (int i = 0; i < mazeSize; i++){
            for (int j = 0; j < mazeSize; j++){
                if (i == usrRow && j == usrCol) {
                    System.out.print("**");
                }else if (i == goalRow && j == goalCol) {
                    System.out.print("GO");
                }else if (i == bossRow && j == bossCol) {
                    System.out.print("BO");
                }else if (wall[i][j]) {
                    System.out.print("[]");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();

        }
    }
}
