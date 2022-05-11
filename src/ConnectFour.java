package src;

public class ConnectFour implements BoardGame{

    private int[][] board; // game board for playing ConnectFour
    private int currentPlayer; // stores the current player's turn
    private Position[] winningPositions; //stores row+colum coordinates when someone wins
    private int winner; // stores which player wins (0 == draw)

    @Override
    public void newGame() {
        board = new int[6][7];
        winningPositions = new Position[4];
    }

    @Override
    public boolean gameOver() {
        return false;
    }

    @Override
    public int getWinner() {
        return currentPlayer;
    }

    @Override
    public Position[] getWinningPositions() {
        return new Position[0];
    }

    @Override
    public boolean columnFull(int column) {
        for(int r = 0; r < board.length; r++){
            if(board[r][column] == 0)
                return false;
        }
        return true;
    }

    @Override
    public void play(int column) {
        if (!columnFull(column)){
            for(int r = 0; r < board.length-1; r++){
                if(board[r+1][column] != 0)
                    board[r][column] = currentPlayer;
            }
        }
    }

    @Override
    public int[][] getBoard() {
        return new int[0][];
    }
}
