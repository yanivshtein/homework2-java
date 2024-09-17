package tasks;

import java.util.HashMap;

public class Tasks {

    private int[][] tasks;  // Matrix to represent task dependencies
    private int num;  // Number of tasks

    // Constructor to initialize the tasks matrix and number of tasks
    public Tasks(int num) {
        this.tasks = new int[num][num];
        this.num = num;
    }

    // Method to set a dependency where task1 depends on task2
    public boolean dependsOn(int task1, int task2) {
        // make sure numbers are in range
        if (task1 >= num || task2 >= num || task1 < 0 || task2 < 0) {
            return false;
        }
        tasks[task1][task2] = 1;  // Set the dependency in the matrix
        return true;
    }

    // Method to put the numbers in order of their dependency
    public int[] order() {
        HashMap<Integer, Integer> set = new HashMap<>(num);  // To keep track of ordered tasks
        int counter = 0;  // Counter to help check if there is a circular dependencies
        int[] orderedTasks = new int[num];  // Array to store the ordered tasks

        // Iterate through tasks to determine the order
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                // If task j has no dependencies and is not already ordered
                if (checkIfEmpty(j) && !set.containsValue(j)) {
                    removeTask(j);  // Remove task j from the matrix
                    set.put(counter, j);  // Add task j to the ordered set
                    orderedTasks[counter] = j;  // Add task j to the ordered array
                    counter++;
                    break;
                }
            }
        }

        // If there is a circular dependency, return null
        if (counter != num) {
            return null;
        }
        return orderedTasks;
    }

    // Helper method to check if a row (task) has no dependencies
    private boolean checkIfEmpty(int row) {
        for (int i = 0; i < num; i++) {
            if (tasks[row][i] == 1) {  // If there is a dependency
                return false;
            }
        }
        return true;
    }

    // Helper method to remove a task from the matrix (clear its dependencies)
    private void removeTask(int row) {
        for (int i = 0; i < num; i++) {
            tasks[i][row] = 0;
        }
    }
}
