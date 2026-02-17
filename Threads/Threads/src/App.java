import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Read all lines from the specified text file into a List of Strings
        List<String> lines = Files.readAllLines(Paths.get("Threads\\Threads\\src\\chapter-one-dracula.txt"));
        //allocate the number of threads and the number of lines each thread will process
        int totalThreads = 4;
        int linesPerThread = lines.size() / totalThreads;

        System.out.println("\n -- Using MyThreads (extending Thread) -- \n");
        // Create and start the threads, assigning each thread a portion of the lines to process
        MyThreads[] threads = new MyThreads[totalThreads];
        for (int i = 0; i < totalThreads; i++) {
            // Calculate the start and end indices for the lines that this thread will process
            int start = i * linesPerThread;
            int end;
            if(i == totalThreads - 1){ 
                end = lines.size(); 
            } else { 
                end = start + linesPerThread;
            }
            // Create a new MyThreads instance for this thread
            threads[i] = new MyThreads("Thread-" + i, lines, start, end);
            //set thread start time for performance measurement
            threads[i].setStartTime();
            //start the thread
            threads[i].start();
        }

        int totalWordCount = 0;
        for (MyThreads thread : threads) {
            // Wait for the thread to finish its execution
            thread.join();
            //set thread end time
            thread.setEndTime();
            // Accumulate the word count from this thread into the total word count
            totalWordCount += thread.getWordCount();
            // Print the name of the thread, the number of words it processed, and the time it took to process those words
            System.out.println(thread.getName() + " processed " + thread.getWordCount() + " words in " + thread.getProcessDuration() + " ms");
        }

        // Print the total word count processed by all threads
        System.out.println("Total word count: " + totalWordCount);

        
    }
}
