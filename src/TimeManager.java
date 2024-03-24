import java.util.TreeMap;

public class TimeManager {

    private final long startTime; // Stores the start time of the execution
    private final TreeMap<Integer,Long> optimaSolutionTime; // TreeMap to store the iteration and time
                                                            // when the optimal solution was found

    public TimeManager() {
        this.startTime = System.nanoTime(); // Record the start time in nanoseconds
        this.optimaSolutionTime = new TreeMap<>();
    }

    public long getFinalTime(){
        return System.nanoTime(); // Get the current time in nanoseconds
    }

    public long getTotalTime(){
        // Calculate the total time by subtracting the start time from the final time
        return getFinalTime()-startTime;
    }

    // Method to add the time when an optimal solution was found
    public void addOptimaSolutionTime(int iteration){
        // Store the iteration number and the time taken to find the optimal solution
        optimaSolutionTime.put(iteration, System.nanoTime()-startTime);
    }

    // Method to get the TreeMap containing the iteration and time when optimal solutions were found
    public TreeMap<Integer,Long> getOptimaSolutionTime(){
        return this.optimaSolutionTime;
    }

}
