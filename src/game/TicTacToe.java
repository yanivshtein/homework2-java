package game;

public class TicTacToe extends Game {

    // Constructor to initialize the TicTacToe game with two players
    public TicTacToe(String player1, String player2) {
        super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));  // Call the superclass constructor with a 3x3 board
    }

    // Override the doesWin method to check for a win
    @Override
    protected boolean doesWin(int row, int col) {
        return maxLineContaining(row, col) == 3;  // Check if there is a line of 3 marks
    }
}
