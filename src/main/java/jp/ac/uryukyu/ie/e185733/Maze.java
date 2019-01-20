package jp.ac.uryukyu.ie.e185733;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Maze {
    static int mazeSize = 0;

    static boolean[][] wall;
    static int row;
    static int col;
    static Stack<Integer> rowStack = new Stack<Integer>();
    static Stack<Integer> colStack = new Stack<Integer>();
    static int usrRow = mazeSize - 1,usrCol = 1, goalRow = 0, goalCol = mazeSize - 2;

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java Maze [mazeSize]");
            return;
        }

        mazeSize = Integer.parseInt(args[0]);
        wall = new boolean[mazeSize][mazeSize];

        createMaze();
        resetUsr();
        resetGoal();

        Scanner scan = new Scanner(System.in);
        String keys = "";
        char key;
        long start = System.currentTimeMillis(), end;

        while(true) {
            printMaze();
            keys = scan.next();
            key = keys.charAt(keys.length() - 1);
            moveUsr(key);

            if (usrRow == goalRow && usrCol == goalCol) {
                end = System.currentTimeMillis();
                break;
            }
        }
    }

    static void  createMaze() {
        for (int i = 0; i <mazeSize; i++ ) {
            for (int j = 0; j< mazeSize; j++) {
                wall[i][j] = true;
            }
        }
        Random rnd = new Random();
        row = rnd.nextInt(mazeSize - 2) + 1;
        col = rnd.nextInt(mazeSize - 2) + 1;
        wall[row][col] = false;
        rowStack.push(row);
        colStack.push(col);

        boolean continueFlag = true;

        while (continueFlag) {
            extendPath();
            continueFlag = false;

            while (!rowStack.empty() && ! colStack.empty()) {
                row = rowStack.pop();
                col = colStack.pop();

                if (/*row % 2 == 0 && col % 2 == 0 && */ canExtendpath()) {
                    continueFlag = true;
                    break;
                }
            }
        }
    }

    static  void printMaze() {
        for (int i = 0; i < mazeSize; i++){
            for (int j = 0; j < mazeSize; j++){
                if (i == usrRow && j == usrCol) {
                    System.out.print("**");
                }else if (i == goalRow && j == goalCol) {
                    System.out.print("LO");
                }else if (wall[i][j]) {
                    System.out.print("[]");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();

        }
    }

    static void extendPath() {
        boolean extendFlag = true;

        while(extendFlag) {
            extendFlag = extendPathSub();
        }
    }

    static boolean extendPathSub() {
        Random rmd = new Random();
        int direction = rmd.nextInt(4);

        for (int i = 0; i < 4; i++) {
            direction = (direction + 1) % 4;
            if (canExtendPathWithDir(direction)) {
                movePoint(direction);
                return true;
            }
        }
        return false;
    }

    static boolean canExtendPathWithDir(int direction){
        int exRow = row, exCol = col;

        switch (direction) {
            case 0:
                exRow--;
                break;
            case 1:
                exRow++;
                break;
            case 2:
                exCol--;
                break;
            case 3:
                exCol++;
                break;
        }
        if (countSurroundingPath(exRow,exCol) > 1) {
            return false;
        }
        return true;
    }

    static int countSurroundingPath(int row,int col) {
        int num = 0;
        if (row - 1 < 0 || !wall[row - 1][col]){
            num++;
        }
        if (row + 1 > mazeSize -1 || !wall[row +1][col]){
            num++;
        }
        if (col -1 < 0 || !wall[row][col -1]) {
            num++;
        }
        if (col + 1 >mazeSize -1 ||!wall[row][col +1]){
            num++;
        }

        return num;
    }

    static void movePoint(int direction) {
        switch (direction) {
            case 0:
                row--;
                break;
            case 1:
                row++;
                break;
            case 2:
                col--;
                break;
            case 3:
                col++;
                break;
        }
        wall[row][col] = false;
        rowStack.push(row);
        colStack.push(col);
    }
    static boolean canExtendpath(){
        return (canExtendPathWithDir(0)||canExtendPathWithDir(1)||canExtendPathWithDir(2)||canExtendPathWithDir(3));
    }

    static void resetUsr(){
        usrRow = mazeSize - 1;
        usrCol = 1;

        while (true) {
            if (wall[usrRow -1][usrCol]) {
                usrCol++;
            }else {
                break;
            }
        }
        wall[usrRow][usrCol] = false;
    }

    static void resetGoal() {
        goalRow = 0;
        goalCol = mazeSize - 2;

        while (true) {
            if (wall[goalRow + 1][goalCol]) {
                goalCol--;
            } else {
                break;
            }
        }

        wall[goalRow][goalCol] = false;
    }

    static void moveUsr(char key) {
        String errMes = "You can not move there.";
        int exUsrRow = usrRow, exUsrCol = usrCol;

        switch (key) {
            case 'w':	// 上
                exUsrRow--;
                break;
            case 's':	// 下
                exUsrRow++;
                break;
            case 'a':	// 左
                exUsrCol--;
                break;
            case 'd':	// 右
                exUsrCol++;
                break;
            case 'R':	// リスタート
                resetUsr();
                return;
            case 'N':	// 新規ゲームの開始
                createMaze();
                resetUsr();
                resetGoal();
                return;
            default:
                System.out.println(errMes);
                return;
        }

        if (exUsrRow > mazeSize - 1 || wall[exUsrRow][exUsrCol]) {
            System.out.println(errMes);
            return;
        }

        usrRow = exUsrRow;
        usrCol = exUsrCol;
    }







}
