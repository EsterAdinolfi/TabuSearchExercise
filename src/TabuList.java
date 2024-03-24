import java.util.LinkedList;

public class TabuList {
    private final int maxSize;
    private final LinkedList<Move> tabuListMoves;

    public TabuList(int maxSize) {
        this.maxSize = maxSize; // Maximum size of the tabu list
        this.tabuListMoves = new LinkedList<>();
    }

    public LinkedList<Move> getTabuListMoves() {
        return tabuListMoves;
    }

    // Method to update the tabu list with a new move
    public void updateTabuList(Move move) {
        if (tabuListMoves.size() >= maxSize) {
            // Remove the oldest move if the list is full
            tabuListMoves.removeLast();
        }
        // Add the new move to the beginning of the list
        tabuListMoves.addFirst(move);
    }

    // Method to check if the tabu list contains a specific move
    public boolean contains(Move move1) {
        for (Move move : tabuListMoves){
            if (move1.equals(move)) {
                // Return true if the move is found in the tabu list
                return true;
            }
        }
        // Return false if the move is not found in the tabu list
        return false;
    }

    // Method to check if a move violates the tabu list
    public boolean isViolated (Move move){
        if (contains(move)){
            // If the move is in the tabu list, it is violated
            return true;
        }
        else {
            // If the move is not in the tabu list, update the list and return false
            updateTabuList(move);
            return false;
        }
    }
}