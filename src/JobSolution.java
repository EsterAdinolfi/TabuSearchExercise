import java.util.Objects;

public class JobSolution {
    private final int C; // Completion time of job
    private final int v; // Max between C-due date and 0
    private final int T; // Job tardiness
    private final Job job; // Job associated with the solution

    public JobSolution(int c, int v, int t, Job job) {
        this.C = c;
        this.v = v;
        this.T = t;
        this.job = job;
    }

    public int getC() {
        return C;
    }

    public int getV() {
        return v;
    }

    public int getT() {
        return T;
    }

    public Job getJob() {
        return job;
    }

    // Override equals method to check if two JobSolution objects are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobSolution that = (JobSolution) o;
        return C == that.C && v == that.v && T == that.T && job.equals(that.job);
    }

}
