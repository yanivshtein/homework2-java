package game;

import java.util.Scanner;

public class Game extends Board {
    protected Player[] players;  // Array to hold the two players
    protected Scanner s;  // Scanner for user input

    // Constructor to initialize the game with the board dimensions and players
    public Game(int n, int m, Player p1, Player p2) {
        super(n, m);  // Call the superclass constructor to initialize the board
        s = new Scanner(System.in);
        players = new Player[2];
        players[0] = p1;
        players[1] = p2;
    }

    // Method to check if the move at position (i, j) results in a win
    protected boolean doesWin(int i, int j) {
        return i == 0 && j == 0;  //if player is in 0,0 he wins
    }

    // Method to handle one play for the player p
    protected boolean onePlay(Player p) {
        System.out.println(p.toString() + ", please enter row and column: ");
        int i = s.nextInt();
        int j = s.nextInt();
        while (!set(i, j, p)) {  // Repeat until a valid move is made
            System.out.println("There is a piece there already...");
            System.out.println(p.toString() + ", please enter row and column: ");
            i = s.nextInt();
            j = s.nextInt();
        }
        System.out.println(super.toString());
        return doesWin(i, j);  // Check if the move results in a win
    }

    // Method to start and play the game
    public Player play() {
        while (!isFull()) {  // Continue until the board is full
            if (onePlay(players[0])) {  // Player 1's turn
                s.close();
                return players[0];
            }
            if (onePlay(players[1])) {  // Player 2's turn
                s.close();
                return players[1];
            }
        }
        s.close();
        System.out.println("There was no win this game");
        return null;  // Return null if there is no winner
    }
}
