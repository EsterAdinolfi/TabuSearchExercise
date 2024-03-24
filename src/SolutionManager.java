import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Integer.max;

public class SolutionManager {

    public SolutionManager() {
    }

    // Method to create the initial feasible solution
    public Solution createInitialFeasibleSolution(ArrayList<Job> jobs, int choice){
        // Creating a copy of the jobs list to avoid modifying the original
        ArrayList<Job> copiedJobs = new ArrayList<>(jobs);

        // Shuffle the jobs to create a random initial order if choice is 1,
        // otherwise reorder the jobs so that the p-value of each job is increasing
        if (choice==1){
            Collections.shuffle(copiedJobs);
        } else {
            Collections.sort(copiedJobs);
        }

        // Creating the initial feasible solution
        Solution feasibleSol = createFeasibleSol(copiedJobs);

        // Printing information about the created solution
        ViewPrint.printInfoSolution(feasibleSol);
        return feasibleSol;
    }

    // Method to create a feasible solution from a list of jobs
    public Solution createFeasibleSol(ArrayList<Job> copiedJobs) {
        // Creating an ArrayList to hold the feasible solution
        ArrayList<JobSolution> feasibleSol = new ArrayList<>(copiedJobs.size());
        int cBefore = 0;
        int tBefore = 0;

        // Iterating through the list of jobs to calculate completion time (c), tardiness (v), and total tardiness (t)
        for(int i=0; i<copiedJobs.size();i++){
            Job currentJob = copiedJobs.get(i);
            if (i>0){
                // Getting the completion time and total tardiness of the previous job
                cBefore = feasibleSol.get(i-1).getC(); // c[i-1]
                tBefore = feasibleSol.get(i-1).getT(); // t[i-1]
            }
            // Calculating completion time (c) and tardiness (v) for the current job
            int c = cBefore + currentJob.p;
            int v = max (c- currentJob.d,0);
            // Calculating total tardiness (t) for the current job
            int t = tBefore + currentJob.w * v;

            // Creating a JobSolution object for the current job and adding it to the feasible solution list
            feasibleSol.add(i,new JobSolution(c,v,t,currentJob));
        }
        // Returning a new Solution object containing the feasible solution
        return new Solution(feasibleSol);
    }

}
