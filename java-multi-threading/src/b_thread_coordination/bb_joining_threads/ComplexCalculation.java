package b_thread_coordination.bb_joining_threads;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ComplexCalculation {

    public static void main(String[] args) throws InterruptedException {
        calculateResult(new BigInteger(Long.toString(4L)), new BigInteger(Long.toString(4L)), new BigInteger(Long.toString(4L)), new BigInteger(Long.toString(3L)));
    }

    private static BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result = BigInteger.ZERO;
        List<PowerCalculatingThread> threads = new ArrayList<>();

        threads.add(new PowerCalculatingThread(base1, power1));
        threads.add(new PowerCalculatingThread(base2, power2));

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join(2000);
        }

        for (int i = 0; i < threads.size(); i++) {
            PowerCalculatingThread powerCalculatingThread = threads.get(i);
            if(powerCalculatingThread.isFinished()){
                result = result.add(powerCalculatingThread.getResult());
            }
        }

        long longVal = Long.parseLong(result.toString());
        System.out.println((int) longVal);
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private final BigInteger base;
        private final BigInteger power;

        private boolean isFinished = false;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            long tempResult = (long) Math.pow(Double.parseDouble(base.toString()), Double.parseDouble(power.toString()));
            result = new BigInteger(Long.toString(tempResult));
            isFinished = true;
        }

        public BigInteger getResult() {
            return result;
        }

        public boolean isFinished() {
            return isFinished;
        }
    }
}
