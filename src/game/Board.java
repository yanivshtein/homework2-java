package game;

public class Board {
    protected Player[][] board;  // 2D array to represent the game board
    protected int n, m;  // Dimensions of the board

    // Constructor to initialize the board with given dimensions
    public Board(int n, int m) {
        this.n = n;
        this.m = m;
        board = new Player[n][m];
    }

    // Method to set a player's mark at a specific position on the board
    protected boolean set(int i, int j, Player p) {
        if (!isEmpty(i, j))  // Check if the position is empty
            return false;
        board[i][j] = p;  // Place the player's mark
        return true;
    }

    // Method to check if a specific position on the board is empty
    public boolean isEmpty(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) {  // Check if the position is within bounds
            return false;
        }
        return board[i][j] == null;  // Return true if the position is empty
    }

    // Method to get the player at a specific position on the board
    public Player get(int i, int j) {
        if (isEmpty(i, j))
            return null;
        return board[i][j];
    }

    // Method to check if the board is full
    public boolean isFull() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isEmpty(i, j))
                    return false;
            }
        }
        return true;
    }

    //toString method to print what we want
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (get(i, j) != null) {
                    str.append(get(i, j).getMark());
                } else {
                    str.append(".");
                }
            }
            str.append("\n");
        }
        return str.toString();
    }

    // Helper method to check if a position exists on the board
    private boolean exist(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    // Method to find the maximum line length containing a specific position
    protected int maxLineContaining(int i, int j) {
        int max = 0;
        if (!exist(i, j))
            return -1;
        //adding the left up diagonal + right down diagonal
        int temp = rayLength(i, j, -1, -1) + rayLength(i, j, 1, 1) + 1;
        if (temp > max) max = temp;
        //adding the left down diagonal + right up diagonal
        temp = rayLength(i, j, -1, 1) + rayLength(i, j, 1, -1) + 1;
        if (temp > max) max = temp;
        //adding the up + down
        temp = rayLength(i, j, -1, 0) + rayLength(i, j, 1, 0) + 1;
        if (temp > max) max = temp;
        //adding the line across, left to right
        temp = rayLength(i, j, 0, -1) + rayLength(i, j, 0, 1) + 1;
        if (temp > max) max = temp;

        return max;
    }

    // Helper method to calculate the length of a line in a specific direction
    private int rayLength(int i, int j, int di, int dj) {
        int counter = 0;
        int y = i + di, x = j + dj;
        while (exist(y, x)) {
            if (isEmpty(y, x))
                break;
            if (board[i][j].getMark() != board[y][x].getMark())
                break;
            x += dj;
            y += di;
            counter++;
        }
        return counter;
    }
}
