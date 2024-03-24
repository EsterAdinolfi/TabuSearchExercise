import java.util.ArrayList;
import java.util.Collections;

public class Move {
    private final int index1;
    private final int index2;

    public Move(int index1, int index2) {
        this.index1 = index1; // Index of the first job to swap
        this.index2 = index2; // Index of the second job to swap
    }

    public int getIndex1() {
        return index1;
    }

    public int getIndex2() {
        return index2;
    }

    // Override equals method to compare Move objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return index1 == move.index1 && index2 == move.index2;
    }

    // Method to perform the move by swapping two jobs in the list
    public ArrayList<Job> moves (ArrayList<Job> jobs, int i, int j){
        // Create a copy of the original list to avoid modifying it
        ArrayList<Job> swappedJobs = new ArrayList<>(jobs);
        // Perform the swap operation
        Collections.swap(swappedJobs,i,j);
        // Return the modified list with the swapped jobs
        return swappedJobs;
    }

}
