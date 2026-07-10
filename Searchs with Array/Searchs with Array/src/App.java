import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {
        int size = 1000000;
        int target = ThreadLocalRandom.current().nextInt(1, size + 1);

        System.out.println("Searching for " + target + " in an array of size " + size);

        MyThreads thread1 = new MyThreads("Linear", SearchTypes.LINEAR, size, target);
        MyThreads thread2 = new MyThreads("Binary", SearchTypes.BINARY, size, target);

        thread1.setStartTime();
        thread1.start();

        thread2.setStartTime();
        thread2.start();

        thread1.join();
        thread1.setEndTime();

        thread2.join();
        thread2.setEndTime();

        System.out.println(thread1.getName() + " execution time: " + thread1.getProcessDuration() + " ms with: " + thread1.getChecks() + " checks");
        System.out.println(thread2.getName() + " execution time: " + thread2.getProcessDuration() + " ms with: " + thread2.getChecks() + " checks");
    }
}
