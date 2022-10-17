package a_thread_creation.cc_thread_inheritance;

public class ExtendThreadClass {
    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }

    public static class NewThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }
}
