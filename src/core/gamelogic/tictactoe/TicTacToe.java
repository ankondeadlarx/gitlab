package core.gamelogic.tictactoe;

import core.gamelogic.Game;
import core.gamelogic.Player;

public class TicTacToe implements Game {

    private String board;
    private Player player1;
    private Player player2;

    // the board will be stored in a string in the following format:
    // "123456789" where 1-9 will be X, for player 1, O for player 2 or
    // the initial number for an unclaimed box.
    // _____________
    // | 1 | 2 | 3 |
    // | 4 | 5 | 6 |
    // | 7 | 8 | 9 |


    // default constructor
    public TicTacToe (Player player1, Player player2) {
        this.board = "123456789";
        this.player1 = player1;
        this.player2 = player2;
    }


    // for placing an X or O on the board
    public boolean place(char placement, int position) {
        if(this.board.charAt(position)=='X' ||
           this.board.charAt(position)=='O') {
            return false;
        }
        this.board = this.board.substring(0,position)+placement+this.board.substring(position+1);
        return true;
    }

    public String getBoard(){
        return board;
    }

    public boolean gameIsOver() {
        if(this.board.charAt(0)==this.board.charAt(1) && this.board.charAt(1)==this.board.charAt(2) ||
           this.board.charAt(3)==this.board.charAt(4) && this.board.charAt(4)==this.board.charAt(5) ||
           this.board.charAt(6)==this.board.charAt(7) && this.board.charAt(7)==this.board.charAt(8) ||
           this.board.charAt(0)==this.board.charAt(3) && this.board.charAt(3)==this.board.charAt(6) ||
           this.board.charAt(1)==this.board.charAt(4) && this.board.charAt(4)==this.board.charAt(7) ||
           this.board.charAt(2)==this.board.charAt(5) && this.board.charAt(5)==this.board.charAt(8) ||
           this.board.charAt(0)==this.board.charAt(4) && this.board.charAt(4)==this.board.charAt(8) ||
           this.board.charAt(2)==this.board.charAt(4) && this.board.charAt(4)==this.board.charAt(6)
        ){ // all possible ways to win
            return true;
        } else if (this.board.charAt(0)!='1' &&
                    this.board.charAt(1)!='2' &&
                    this.board.charAt(2)!='3' &&
                    this.board.charAt(3)!='4' &&
                    this.board.charAt(4)!='5' &&
                    this.board.charAt(5)!='6' &&
                    this.board.charAt(6)!='7' &&
                    this.board.charAt(7)!='8' &&
                    this.board.charAt(8)!='9'
                ){ // draw
            return true;
        }
        return false;
    }
}