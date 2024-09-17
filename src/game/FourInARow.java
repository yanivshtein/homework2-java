package game;

public class FourInARow extends Game {

    // Constructor to initialize the FourInARow game with two players
    public FourInARow(String player1, String player2) {
        super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));  // Call the superclass constructor with a 6x7 board
    }

    // Override the doesWin method to check for a win
    @Override
    protected boolean doesWin(int i, int j) {
        return maxLineContaining(i, j) == 4;  // Check if there is a line of 4 marks
    }

    // Override the onePlay method
    @Override
    protected boolean onePlay(Player p) {
        System.out.println(p.toString() + ", please enter column:");
        int col = s.nextInt();
        // Check if the column is full and exists
        while (!isEmpty(0, col)) {
            System.out.println("The column is full or does not exist...");
            System.out.println(p.toString() + ", please enter column:");
            col = s.nextInt();
        }
        // Find the next open spot in the column
        int i = 5;
        while (!isEmpty(i, col)) {
            i--;
        }
        set(i, col, p);  // Place the player's mark at the found position
        System.out.println(super.toString());
        return doesWin(i, col);  // Check if the move results in a win
    }
}
