package jp.ac.uryukyu.ie.e185733;

public class PlayerMove {
    static int mazeSize = 20;
    static int usrRow = mazeSize - 1,usrCol = 1;

    public static void PlayerMove(char key){
        //String errMes = "You can not move there.";
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
                //createMaze();
                //resetUsr();
                //resetGoal();
                return;
            default:
                System.out.println("その方向には進めません \n can not move in this direction");
                return;
        }

        //if (exUsrRow > mazeSize - 1 || wall[exUsrRow][exUsrCol]) {
        //    System.out.println(errMes);
        //    return;
        //}

        usrRow = exUsrRow;
        usrCol = exUsrCol;
    }

    public static void resetUsr(){
        usrRow = mazeSize - 1;
        usrCol = 1;

        while (true) {
            if (Maze.Rtwall(usrRow,usrCol)) {
                usrCol++;
            }else {
                break;
            }
        }
        Maze.Rtwall(usrRow,usrCol) = false;
    }
}
