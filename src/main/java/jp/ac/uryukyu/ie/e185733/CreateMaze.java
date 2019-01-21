package jp.ac.uryukyu.ie.e185733;

import java.util.Random;

public class CreateMaze {
    public void CreateMaze(mazeSize){
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
}
