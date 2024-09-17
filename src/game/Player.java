package game;

public class Player {

    private String name;  // Player's name
    private char mark;  // Player's mark

    // Constructor to initialize the player's name and mark
    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    // Getter method for the player's name
    public String getName() {
        return name;
    }

    // Getter method for the player's mark
    public char getMark() {
        return mark;
    }

    //ToString method of how we want to print the player
    public String toString() {
        return getName() + "(" + getMark() + ")";
    }
}
