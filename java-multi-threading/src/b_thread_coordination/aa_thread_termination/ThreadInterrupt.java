package b_thread_coordination.aa_thread_termination;

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());
        thread.start();
        thread.interrupt();
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("Exiting the blocking thread");
                // throw new RuntimeException(e);
            }
        }
    }
}
