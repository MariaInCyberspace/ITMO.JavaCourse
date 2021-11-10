package maria.incyberspace.Lesson12;

import java.util.concurrent.*;

public class AHundredThreadsPickingOnOneVariable_task3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Counter c = new Counter();
        startThreads(c);
        System.out.println("We're all finished. Counter is now: " + c.count);
    }

    public static void startThreads(Counter c) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                        System.out.println("I'm " + Thread.currentThread().getName() + ". Counter is: " + c.increment());
                }
            });
            thread.start();
            thread.join(); // Wait for the thread to die before creating another
        }
    }
}

class Counter {
    int count = -1;

    public int increment() {
        count = count + 1;
        return count;
    }
}
