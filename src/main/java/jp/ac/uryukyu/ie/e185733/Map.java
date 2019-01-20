package jp.ac.uryukyu.ie.e185733;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Map {
    static int MazeSize = 20;
    static boolean[][] wall;
    static int row;
    static int col;
    static Stack<Integer> rowStack = new Stack<Integer>();
    static Stack<Integer> colStack = new Stack<Integer>();
    static int usrRow = MazeSize - 1,usrCol = 1, goalRow = 0, goalCol = MazeSize - 2;

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java Maze [mazeSize]");
            return;
        }

        MazeSize = Integer.parseInt(args[0]);
        wall = new boolean[MazeSize][MazeSize];


        Scanner scan = new Scanner(System.in);
        String keys = "";
        char key;
        long start = System.currentTimeMillis(), end;

        while(true) {
            keys = scan.next();
            key = keys.charAt(keys.length() - 1);

            if (usrRow == goalRow && usrCol == goalCol) {
                end = System.currentTimeMillis();
                break;
            }
        }
    }
}
