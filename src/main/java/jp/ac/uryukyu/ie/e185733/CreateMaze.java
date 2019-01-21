package jp.ac.uryukyu.ie.e185733;

import java.util.Random;
import java.util.Stack;

/**
 * 迷路を作るクラス
 * 穴掘り法を使っている。
 */
public class CreateMaze {
    static int mazeSize = Main.mazeSize;
    static boolean[][] wall = Main.wall ;
    static int row = Main.row;
    static int col = Main.col;
    static Stack<Integer> rowStack = new Stack<Integer>();
    static Stack<Integer> colStack = new Stack<Integer>();

    /**
     *最初に迷路を全て壁にする
     * ランダムな場所を道にしてそこから道を伸ばしていく
     */
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

    /**
     *すいませんわかんないです
     */
    static void extendPath() {
        boolean extendFlag = true;

        while(extendFlag) {
            extendFlag = extendPathSub();
        }
    }

    /**
     *上のフラグを操作する
     * @return　道にしていいか否かをbooleanで表している
     */
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

    /**
     *おそらく道にする方向を決めるメソッド
     * @param direction　上下左右のいづれかの方向を数字で表現している
     * @return
     */
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

    /**
     *2マス先が壁かどうかを調べるメソッド
     * @param row　調べる地点のたて位置
     * @param col　調べる地点のヨコ位置
     * @return
     */
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

    /**
     *
     * @param direction
     */
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

    /**
     *
     * @return
     */
    static boolean canExtendpath(){
        return (canExtendPathWithDir(0)||canExtendPathWithDir(1)||canExtendPathWithDir(2)||canExtendPathWithDir(3));
    }
}
