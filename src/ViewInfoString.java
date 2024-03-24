import java.util.TreeMap;

public class ViewInfoString {

    // Method to generate information about a job solution
    public static String infoJobSolution(JobSolution jobSolution) {
        return "Job: " + jobSolution.getJob().number + "\n\tC = " + jobSolution.getC()
                + "\n\tv = " + jobSolution.getV() + "\n\tT = " + jobSolution.getT();
    }


    // Method to generate information about a move
    public static String infoMove (Move move){
        return "("+(move.getIndex1()+1)+","+(move.getIndex2()+1)+")";
    }

    // Method to generate information about a neighbor solution
    public static String infoNeighbor(Neighbor neighbor){
        return "Solution selected: " + infoSolutionFound(neighbor.getSolution())+"\t" +
                "Move inserts in Tabu List: " + infoMove(neighbor.getMove());
    }

    // Method to generate information about a neighborhood
    public static String infoNeighborhoodFound(Neighborhood neighborhood) {
        String infoNeigh = "Neighborhood found: " ;
        int i = 1;
        for (Neighbor neighbor : neighborhood.getNeighborhood()){
            infoNeigh += "\n" + i +")\t" + "Solution found: " + infoSolutionFound(neighbor.getSolution()) +
                    "\tMove used: "+
                    infoMove(neighbor.getMove());
            i++;
        }
        return infoNeigh;
    }

    // Method to generate information about the initial feasible solution
    public static String infoInitialFeasibleSolution (Solution solution){
        return "Innitial Feasible solution found:" + infoSolutionFound(solution)
                + "\nThe value of the objective function is: " + solution.getObjFunValue();
    }

    // Method to generate information about a solution
    public static String infoSolutionFound(Solution solution) {
        String infoSolution = "" ;
        for (JobSolution sol : solution.getSolution()){
            infoSolution += sol.getJob().number + " ";
        }
        return infoSolution;
    }

    // Method to generate information about the tabu list
    public static String infoTabuList(TabuList tabuList){
        String info = "Tabu List: ";
        int i = 1;
        for (Move move : tabuList.getTabuListMoves()){
            info += "Move " + i + ": " + infoMove(move) +"\t";
            i++;
        }
        return info;
    }

    // Method to generate information about the total time used by the program
    public static String infoTotalTime(long totalTime) {
        return "Total time used by program: " + totalTime + " e-9 seconds";
    }

    // Method to generate information about the times the algorithm reaches the optimum solution
    public static String infoOptimaSolutionTime(TreeMap<Integer,Long> optimaSolutionTime){
        String info = "Times the algorithm reaches the optimum solution: \n";
        for(int iteration : optimaSolutionTime.navigableKeySet()){
            long time = optimaSolutionTime.get(iteration);
            info += "Iteration: " + iteration + ",\tTime: " + time + " e-9 seconds\n";
        }
        return info;
    }
}
