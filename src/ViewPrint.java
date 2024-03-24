import java.util.TreeMap;

public class ViewPrint {

    public ViewPrint() {
    }

    // Method to print information about a feasible solution
    public static void printInfoSolution(Solution feasibleSol) {
        for (JobSolution jobSol : feasibleSol.getSolution()){
            System.out.println(ViewInfoString.infoJobSolution(jobSol));
        }
    }

    // Method to print information about the initial feasible solution
    public static void printInitialFeasibleSolution(Solution currentSolution) {
        System.out.println(ViewInfoString.infoInitialFeasibleSolution(currentSolution));
    }

    // Method to print information about a newly found solution and the tabu list
    public static void printNewSolutionFound(Neighbor newNeighbor, TabuList tabuList) {
        System.out.println(ViewInfoString.infoNeighbor(newNeighbor));
        System.out.printf("The value of the objective function is: %d\n", newNeighbor.getObjFunValue());
        System.out.println(ViewInfoString.infoTabuList(tabuList));
    }

    // Method to print the total time used by the program
    public static void printTotalTime(long totalTime){
        System.out.println(ViewInfoString.infoTotalTime(totalTime));
    }

    // Method to print information about the times the algorithm reaches the optimum solution
    public static void printOptimaSolutionTime(TreeMap<Integer,Long> optimaSolutionTime){
        System.out.println(ViewInfoString.infoOptimaSolutionTime(optimaSolutionTime));
    }

    // Method to print information about a neighborhood found at a specific iteration
    public static void printNeighborhoodFound(int iteration, Neighborhood neighborhood) {
        System.out.println("Iteration: " + iteration +"\n"+ ViewInfoString.infoNeighborhoodFound(neighborhood));
    }

}
