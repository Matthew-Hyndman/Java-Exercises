import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class MyThreads extends Thread {

    private int wordCount;
    private List<String> lines;
    private int start;
    private int end;
    private Instant startTime;
    private Instant endTime;

    public MyThreads(String threadName, List<String> lines, int start, int end) {
        this.setName(threadName);
        this.lines = lines;
        this.start = start;
        this.end = end;
        this.wordCount = 0;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            // Split the line into words using whitespace as the delimiter and count the number of words
            String[] words = lines.get(i).split("\\s+");
            wordCount += words.length;
        }
    }

    public int getWordCount() {
        return wordCount;
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
}
