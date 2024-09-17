package tree;

import java.util.Scanner;

public class ReversedWords {
	
	// Method to check for reversed words
	public static int checkReversed() {
		int i, counter = 0;  // Initialize counter to count reversed words
		Scanner scanner = new Scanner(System.in);
		Node node = new Node();
		String scannerStr = scanner.next();  // Read the first input

		// Loop until "X" is entered
		while(!scannerStr.equals("X")) {
			StringBuilder reverseStr = new StringBuilder();  // StringBuilder to build reversed string

			// Reverse the input string
			for(i = 0; i < scannerStr.length(); i++) {
				reverseStr.append(scannerStr.charAt(scannerStr.length() - i - 1));
			}

			// Check if the reversed string exists in the Node
			if(node.num(reverseStr.toString()) > 0)
				counter++;

			// Add the original string to the Node
			node.add(scannerStr);

			// Read the next input
			scannerStr = scanner.next();
		}

		// Close the scanner
		scanner.close();
		return counter;  // Return the count of reversed words found
	}
}
