import java.util.ArrayList;

public class NeighborhoodManager {

    // Method to generate all neighbors for a given solution
    public Neighborhood generateAllNeighbors(SolutionManager solutionManager,Solution currentSolution) {
        Neighborhood neighbors = new Neighborhood();

        // Creating a new job array to calculate new job solutions
        ArrayList<Job> jobs = new ArrayList<>(currentSolution.getSolution().size());
        for (JobSolution jobSol : currentSolution.getSolution()){
            jobs.add(jobSol.getJob());
        }

        // Generating all possible neighbors by swapping pairs of jobs
        for (int i = 0; i < jobs.size(); i++) {
            for (int j = i + 1; j < jobs.size(); j++) {
                Move move = new Move(i, j);
                ArrayList<Job> newJobs = move.moves(jobs, i, j);
                // Creating a new feasible solution for each neighbor
                Solution newJobSol = solutionManager.createFeasibleSol(newJobs);
                neighbors.addNeighbor(new Neighbor(newJobSol, move));
            }
        }
        return neighbors;
    }

    // Method to find a new neighbor that is not in the tabu list
    public Neighbor findNewNeighbor (Neighborhood neighborhood, Solution currentSolution, TabuList tabuList){
        int currentMinValue = currentSolution.getObjFunValue();
        Neighbor newNeighbor;
        boolean conditionSatisfied = false;
        do {
            // Finding the neighbor with the minimum objective function value
            newNeighbor = neighborhood.findNeighborMinValue(currentMinValue);
            // Checking if the neighbor is in the tabu list
            if (tabuList.isViolated(newNeighbor.getMove()))
                // Removing the neighbor if it violates the tabu list
                neighborhood.removeNeighbor(newNeighbor);
            else {
                // Setting the condition to exit the loop if a suitable neighbor is found
                conditionSatisfied = true;
            }
        } while (!conditionSatisfied);
        return newNeighbor;
    }

    // Method to obtain a new neighbor for the current solution
    public Neighbor obtainNewNeighbor(SolutionManager solutionManager,Solution currentSolution, TabuList tabuList, int iteration) {
        // Generating all neighbors for the current solution
        Neighborhood neighborhood = generateAllNeighbors(solutionManager,currentSolution);
        ViewPrint.printNeighborhoodFound(iteration, neighborhood);
        // Finding a new neighbor that is not in the tabu list
        return findNewNeighbor(neighborhood, currentSolution, tabuList);
    }




}
