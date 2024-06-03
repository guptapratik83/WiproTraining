package jobsequencing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobSequencing {

    public static List<Job> jobSequencing(List<Job> jobs) {
        // Sort jobs in descending order of profit
        Collections.sort(jobs, (a, b) -> b.Profit - a.Profit);

        int n = jobs.size();

        // To keep track of free time slots
        boolean[] slots = new boolean[n];

        // To store result (sequence of jobs)
        Job[] result = new Job[n];

        // Iterate through all given jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (we start from the last possible slot)
            for (int j = Math.min(n, jobs.get(i).Deadline) - 1; j >= 0; j--) {
                // Free slot found
                if (!slots[j]) {
                    slots[j] = true;
                    result[j] = jobs.get(i);
                    break;
                }
            }
        }

        // Collect the result
        List<Job> jobSequence = new ArrayList<>();
        for (Job job : result) {
            if (job != null) {
                jobSequence.add(job);
            }
        }

        return jobSequence;
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 2, 100));
        jobs.add(new Job(2, 1, 19));
        jobs.add(new Job(3, 2, 27));
        jobs.add(new Job(4, 1, 25));
        jobs.add(new Job(5, 3, 15));

        List<Job> jobSequence = jobSequencing(jobs);

        System.out.println("The maximum profit sequence of jobs:");
        for (Job job : jobSequence) {
            System.out.println(job);
        }
    }
}
