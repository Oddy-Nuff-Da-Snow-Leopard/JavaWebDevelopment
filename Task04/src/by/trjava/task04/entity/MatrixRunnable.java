package by.trjava.task04.entity;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class MatrixRunnable implements Runnable {

    private final int threadId;
    private final int index;

    private final MatrixHandler handler;
    private final CyclicBarrier barrier;
    private final String filePath;

    public MatrixRunnable(int threadId, int index, MatrixHandler handler,
            CyclicBarrier barrier, String filePath) {
        this.threadId = threadId;
        this.handler = handler;
        this.barrier = barrier;
        this.index = index;
        this.filePath = filePath;
    }

    public void run() {
        Printer.printInFile(filePath, "Thread " + threadId + " started!");
        try {
            TimeUnit.SECONDS.sleep(1);
            handler.changeDiagonalElement(index, threadId);
            int sum = handler.countSum(index);
            Printer.printInFile(filePath, "Thread " + threadId + " finished! " + "Sum = " + sum);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException ex) {
                ex.printStackTrace();
            }
        }
    }
}
