import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creating manager objects and the Tabu Search algorithm
        // Manages solutions
        SolutionManager solutionManager = new SolutionManager();
        // Manages neighborhoods
        NeighborhoodManager neighborhoodManager = new NeighborhoodManager();
        // Tabu Search algorithm
        TabuSearch tabuSearch = new TabuSearch();

        // Defining parameters for the algorithm
        int tabuListSize = 3; // Size of the tabu list
        int maxIteration = 10; // Maximum number of iterations
        int choice = 1; // Initial choice: 1 for random job order,
                        // otherwise reorder jobs so that the p-value of each job is increasing

        // Time management
        TimeManager timeManager = new TimeManager(); // Manages execution time referred to optimal solutions

        // Creating an initial instance of jobs
        ArrayList<Job> jobsInstance = Job.createInstance(); // Creating an instance of jobs

        // Executing the Tabu Search algorithm
        tabuSearch.executeTabuSearch(solutionManager, neighborhoodManager, timeManager,
                jobsInstance, tabuListSize, maxIteration, choice);

        // Printing the results
        // Printing the total time taken
        ViewPrint.printTotalTime(timeManager.getTotalTime());
        // Printing the time of the optimal solution
        ViewPrint.printOptimaSolutionTime(timeManager.getOptimaSolutionTime());
    }
}