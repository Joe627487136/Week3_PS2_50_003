package Week3;

import java.util.Scanner;

/**
 * Created by zhouxuexuan on 11/2/17.
 */

public class TicTacToeGameManager {
    public boolean Gamefinsh = false;

    public void rungame(){
        TicTacToe game = new TicTacToe();
        System.out.print("Game start! \n \n");
        while (Gamefinsh ==false){
            String player = game.getPlayer();
            Scanner sc = new Scanner(System.in);
            System.out.print(player + ", please input row: \n");
            int row = sc.nextInt();
            System.out.print(player + ", please input column: \n");
            int col = sc.nextInt();
            game.placeMark(row,col);
            game.printBoard();
            if (game.checkForWin()) {
                System.out.println("Winner is " + player + "!");
                Gamefinsh=true;
            }
            else if (game.isBoardFull()) {
                System.out.println("Round draw! Please restart!");
                Gamefinsh=true;
            }
            game.changePlayer();
        }
    }
}
