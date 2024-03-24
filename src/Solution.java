import java.util.ArrayList;

public class Solution {
    private final ArrayList<JobSolution> solution;

    public Solution(ArrayList<JobSolution> solution) {
        this.solution = solution;
    }

    public ArrayList<JobSolution> getSolution() {
        return solution;
    }

    public int getObjFunValue(){
        // The objective function value is the tardiness of the last job in the schedule
        return solution.getLast().getT();
    }

    // Override equals method to compare Solution objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solutionO = (Solution) o;
        // Comparing each job solution in the list
        for (int i=0; i<solution.size(); i++){
            if (!solution.get(i).equals(solutionO.getSolution())){
                return false;
            }
        }
        return true;
    }
}
