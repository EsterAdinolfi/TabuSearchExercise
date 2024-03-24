import java.util.ArrayList;

public class TabuSearch {


    // Method to execute the Tabu Search algorithm
    public void executeTabuSearch(SolutionManager solutionManager, NeighborhoodManager neighborhoodManager,
                                  TimeManager timeManager, ArrayList<Job> jobsInstance,
                                  int tabuListSize, int maxIteration, int choice) {
        // Creating the initial feasible solution
        Solution currentSolution = solutionManager.createInitialFeasibleSolution(jobsInstance, choice);
        // Printing the initial feasible solution
        ViewPrint.printInitialFeasibleSolution(currentSolution);

        // Initializing the Tabu List
        TabuList tabuList = new TabuList(tabuListSize);

        // Main loop of the Tabu Search algorithm
        boolean stop = false;
        for (int iteration = 1; !stop; iteration++) {
            // Obtaining a new neighbor solution
            // As it is implemented, in N(x) we only find solutions different from x


            Neighbor newNeighbor = neighborhoodManager.obtainNewNeighbor(solutionManager, currentSolution, tabuList, iteration);
            // Updating the current solution
            currentSolution = newNeighbor.getSolution();

            // Checking for an optimal solution (specific to the problem). Testing I found that 19 is the optimal value.
            // I use this information to obtain time informations
            if (currentSolution.getObjFunValue()==19){
                // Adding the iteration when the optimal solution is found
                timeManager.addOptimaSolutionTime(iteration);
            }

            // Printing the details of the new solution
            ViewPrint.printNewSolutionFound(newNeighbor, tabuList);
            // Checking if the stopping criterion is satisfied
            stop = isStopCriterionSatisfied(iteration, maxIteration);
        }

    }

    // Method to check if the stopping criterion is satisfied
    public boolean isStopCriterionSatisfied(int iteration, int maxIteration){
        // Stopping when the maximum number of iterations is reached
        return iteration >= maxIteration;
    }
}
