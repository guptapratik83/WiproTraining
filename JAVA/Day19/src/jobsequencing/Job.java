package jobsequencing;

public class Job {
    public int Id;
    public int Deadline;
    public int Profit;
    
    public Job(int id, int deadline, int profit) {
        this.Id = id;
        this.Deadline = deadline;
        this.Profit = profit;
    }
    
    @Override
    public String toString() {
        return "Job[Id=" + Id + ", Deadline=" + Deadline + ", Profit=" + Profit + "]";
    }
}
