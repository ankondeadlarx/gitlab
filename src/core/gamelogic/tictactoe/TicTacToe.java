public class TicTacToe extends AbstractGame {

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
    // '---'---'---'

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

    public Player getWinner(){
        if(this.board.charAt(0)=='X' && this.board.charAt(0)==this.board.charAt(1) && this.board.charAt(1)==this.board.charAt(2) ||
                this.board.charAt(3)=='X' && this.board.charAt(3)==this.board.charAt(4) && this.board.charAt(4)==this.board.charAt(5) ||
                this.board.charAt(6)=='X' && this.board.charAt(6)==this.board.charAt(7) && this.board.charAt(7)==this.board.charAt(8) ||
                this.board.charAt(0)=='X' && this.board.charAt(0)==this.board.charAt(3) && this.board.charAt(3)==this.board.charAt(6) ||
                this.board.charAt(1)=='X' && this.board.charAt(1)==this.board.charAt(4) && this.board.charAt(4)==this.board.charAt(7) ||
                this.board.charAt(2)=='X' && this.board.charAt(2)==this.board.charAt(5) && this.board.charAt(5)==this.board.charAt(8) ||
                this.board.charAt(0)=='X' && this.board.charAt(0)==this.board.charAt(4) && this.board.charAt(4)==this.board.charAt(8) ||
                this.board.charAt(2)=='X' && this.board.charAt(2)==this.board.charAt(4) && this.board.charAt(4)==this.board.charAt(6) ||
                !player2.isOnline()){
            return player1;
        } else if(this.board.charAt(0)=='O' && this.board.charAt(0)==this.board.charAt(1) && this.board.charAt(1)==this.board.charAt(2) ||
                this.board.charAt(3)=='O' && this.board.charAt(3)==this.board.charAt(4) && this.board.charAt(4)==this.board.charAt(5) ||
                this.board.charAt(6)=='O' && this.board.charAt(6)==this.board.charAt(7) && this.board.charAt(7)==this.board.charAt(8) ||
                this.board.charAt(0)=='O' && this.board.charAt(0)==this.board.charAt(3) && this.board.charAt(3)==this.board.charAt(6) ||
                this.board.charAt(1)=='O' && this.board.charAt(1)==this.board.charAt(4) && this.board.charAt(4)==this.board.charAt(7) ||
                this.board.charAt(2)=='O' && this.board.charAt(2)==this.board.charAt(5) && this.board.charAt(5)==this.board.charAt(8) ||
                this.board.charAt(0)=='O' && this.board.charAt(0)==this.board.charAt(4) && this.board.charAt(4)==this.board.charAt(8) ||
                this.board.charAt(2)=='O' && this.board.charAt(2)==this.board.charAt(4) && this.board.charAt(4)==this.board.charAt(6) ||
                !player1.isOnline()){
            return player2;
        } else {
            return null;
        }
    }

    public Player getLoser(){
        Player winner = getWinner();
        if(player1==winner){
            return player2;
        } else if(player2==winner){
            return player1;
        }
        return null;
    }

    public boolean gameIsOver() {
        return drew() || getWinner() != null || playerQuit();
    }

    public boolean drew() {
        if(getWinner()==null){
            return false;
        }
        return this.board.charAt(0) != '1' &&
                this.board.charAt(1) != '2' &&
                this.board.charAt(2) != '3' &&
                this.board.charAt(3) != '4' &&
                this.board.charAt(4) != '5' &&
                this.board.charAt(5) != '6' &&
                this.board.charAt(6) != '7' &&
                this.board.charAt(7) != '8' &&
                this.board.charAt(8) != '9';
    }

    public boolean playerQuit(){
        return !player1.isOnline() || !player2.isOnline();
    }

}