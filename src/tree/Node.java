package tree;

public class Node {
    private int count = 0;  // Counter to keep track of occurrences of a string
    private Node[] children = new Node['z' - 'a' + 1];  // Array to hold child nodes for each character


    // Method to return the count of occurrences of a string
    public int num(String s) {
        if(s.equals("")) {  // Check if the string is empty
            return count;  // Return the count if empty string is reached
        }
        // If the child node for the first character of the string is null, return 0
        if(children[s.charAt(0) - 'a'] == null) {
            return 0;
        }
        // Recurse for the rest of the string
        return children[s.charAt(0) - 'a'].num(s.substring(1));
    }

    // Method to add a string to the tree
    public void add(String s) {
        if(s.equals("")) {  // Check if the string is empty
            count++;  // Increment the count if empty string is reached
        } else {
            // If the child node for the first character of the string is null, create a new node
            if(children[s.charAt(0) - 'a'] == null) {
                Node node = new Node();
                children[s.charAt(0) - 'a'] = node;
                node.add(s.substring(1));  // Recurse for the rest of the string
            } else {
                // Recurse for the rest of the string if the child node already exists
                children[s.charAt(0) - 'a'].add(s.substring(1));
            }
        }
    }
}
