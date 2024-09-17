package tasks;

import java.util.HashMap;

public class NamedTasks extends Tasks {

    private String[] names;  // Array to store task names
    private HashMap<String, Integer> map;  // Map to associate task names with their indices

    // Constructor to initialize the named tasks
    public NamedTasks(String[] names) {
        super(names.length);  // Call the superclass constructor with the number of tasks
        this.names = names;
        map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (map.containsKey(names[i])) {
                System.out.println("key already exists");
                continue;  // Skip adding if the name already exists
            }
            map.put(names[i], i);  // Map each task name to its index
        }
    }

    // Method to set a dependency where task1 depends on task2 using task names
    public boolean dependsOn(String task1, String task2) {
        // Validate task names
        if (!map.containsKey(task2) || !map.containsKey(task1)) {
            return false;
        }
        return this.dependsOn(map.get(task1), map.get(task2));  // Call the superclass method with indices
    }

    // Method to determine the order of tasks by their names
    public String[] nameOrder() {
        int[] numOrdered = this.order();  // Get the order of tasks by their indices
        if (numOrdered == null) {
            return null;  // Return null if tasks cannot be ordered
        }
        String[] orderedNames = new String[names.length];  // Array to store the ordered task names
        for (int i = 0; i < names.length; i++) {
            orderedNames[i] = names[numOrdered[i]];  // Map ordered indices to task names
        }
        return orderedNames;
    }
}
