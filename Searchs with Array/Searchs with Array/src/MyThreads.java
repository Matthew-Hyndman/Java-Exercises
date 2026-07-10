import java.time.Duration;
import java.time.Instant;

public class MyThreads extends Thread {

    private Instant startTime;
    private Instant endTime;
    private SearchTypes searchType;
    private int size;
    private int target;

    private int checks; // Variable to store the number of checks performed during the search

    public MyThreads(String threadName, SearchTypes searchType, int size, int target) {
        this.setName(threadName);
        this.searchType = searchType;
        this.size = size;
        this.target = target;
    }

    @Override
    public void run() {
       MySearch search = new MySearch();
       this.checks = search.search(size, target, searchType);
    }

   /**
     * sets the start time of the thread execution to the current time. 
     * This method is typically called before the thread starts processing 
     * its assigned lines to record when the thread began its work.
     */
    public void setStartTime() {
        this.startTime = Instant.now();
    }

    /**
     * sets the end time of the thread execution to the current time. 
     * This method is typically called after the thread has finished processing.
     */
    public void setEndTime() {
        this.endTime = Instant.now();
    }

    /**
     * calculates and returns the duration of the thread's execution in milliseconds. 
     * It uses the startTime and endTime to compute the duration using the Duration class.
     * @return the duration of the thread's execution in milliseconds
     */
    public long getProcessDuration() {
        return (Duration.between(startTime, endTime)).toMillis();
    }

    /**
     * returns the number of checks performed during the search.
     * @return the number of checks performed
     */
    public int getChecks() {
        return checks;
    }
}

