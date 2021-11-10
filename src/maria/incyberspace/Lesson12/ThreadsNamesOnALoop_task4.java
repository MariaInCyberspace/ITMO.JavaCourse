package maria.incyberspace.Lesson12;

public class ThreadsNamesOnALoop_task4 {
    public static void main(String[] args) {
        Object monitor = new Object(); // A monitor object the threads will share
        // The threads will acquire and release the monitor one by one endlessly
        new MyThread(monitor).start();
        new MyThread(monitor).start();
    }
}

class MyThread extends Thread {
    private final Object monitor;

    MyThread(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            //When a thread invokes a synchronized method,
            // it automatically acquires the monitor for that method's object
            // So, the thread seizes the monitor
            synchronized (monitor) {
                try {
                    System.out.println("I'm " + getName());
                    monitor.notify(); // Wake up the thread that waits for this object
                    // Release the monitor
                    monitor.wait(); // And wait until you're awakened by being notified
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
