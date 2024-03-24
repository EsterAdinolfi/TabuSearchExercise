public class Neighbor {
    private final Solution solution;
    private final Move move;

    public Neighbor(Solution solution, Move move) {
        this.solution = solution; // Solution of the neighbor
        this.move = move; // Move applied to generate the neighbor
    }

    public Solution getSolution() {
        return solution;
    }


    public Move getMove() {
        return move;
    }

    // Override equals method to compare Neighbor objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbor neighbor = (Neighbor) o;
        return solution.equals(neighbor.getSolution()) && move.equals(neighbor.getMove());
    }

    // Method to get the objective function value of the solution
    public int getObjFunValue (){
        return getSolution().getObjFunValue();
    }



}
