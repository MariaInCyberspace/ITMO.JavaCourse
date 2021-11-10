package maria.incyberspace.Lesson12;

public class ThreadState_task2 {

    public static void main(String[] args) {
        getThreadState();
    }

    public static void getThreadState() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " is " + getState());
            }
        };
        // Before starting
        System.out.println(thread.getName() + " is " + thread.getState());
        thread.start();

        try { // Wait for the thread to die
            thread.join();
        } catch (InterruptedException ex) {
            ex.getStackTrace();
        }
        // Print its state now that it's been terminated
        System.out.println(thread.getName() + " is " + thread.getState());
    }
}
