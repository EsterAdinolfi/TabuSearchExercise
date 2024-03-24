import java.util.ArrayList;

public class Job implements Comparable {
    public int w; // Penalty for tardiness
    public int p; // Processing time
    public int d; // Due date
    public int number; // Job number

    public Job(int w, int p, int d, int number) {
        this.w = w;
        this.p = p;
        this.d = d;
        this.number = number;
    }

    // Method to create an instance of jobs
    public static ArrayList<Job> createInstance(){
        ArrayList<Job> jobs = new ArrayList<>(6);
        jobs.add(new Job(1,6,9,1));
        jobs.add(new Job(1,4,12,2));
        jobs.add(new Job(1,8,15,3));
        jobs.add(new Job(1,2,8,4));
        jobs.add(new Job(1,10,20,5));
        jobs.add(new Job(1,3,22,6));
        return jobs;
    }

    // Overriding the equals method to compare if two jobs are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return w == job.w && p == job.p && d == job.d && number == job.number;
    }

    // Overriding the compareTo method to compare jobs based on their processing time (p)
    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.p,((Job) o).p);
    }
}
