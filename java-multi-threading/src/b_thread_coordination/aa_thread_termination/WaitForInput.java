package b_thread_coordination.aa_thread_termination;

import java.io.IOException;

public class WaitForInput {

    public static void main(String[] args) {
        Thread thread = new Thread(new WaitingForUserInput());
        thread.setName("InputWaitingThread");
        thread.start();
    }

    private static class WaitingForUserInput implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Please enter the pass key: ");
                    char input = (char) System.in.read();
                    if (input == 'i') {
                        // System.exit(0);
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("An exception was caught " + e);
                // throw new RuntimeException(e);
            }
        }
    }
}
