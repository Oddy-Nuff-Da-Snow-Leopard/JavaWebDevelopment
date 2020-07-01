package by.trjava.task04.entity;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixHandler {

    private static final ReentrantLock LOCKER = new ReentrantLock();

    private final Matrix matrix;

    public MatrixHandler(Matrix matrix) {
        this.matrix = matrix;
    }

    public void changeDiagonalElement(int i, int value) throws InterruptedException {
        try {
            LOCKER.lock();

            int[][] m = matrix.getMatrix();
            m[i][i] = value;

            Random rnd = new Random();
            int j = rnd.nextInt(m[i].length - 1);
            if (rnd.nextBoolean()) {
                m[i][j]++;
            } else {
                m[j][i]++;
            }

            matrix.setMatrix(m);
        } finally {
            LOCKER.unlock();
        }
    }

    public int countSum(int index) throws InterruptedException {
        int sum = 0;
        try {
            LOCKER.lock();
            int[][] m = matrix.getMatrix();
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    if (i == index || j == index) {
                        sum += m[i][j];
                    }
                }
            }
        } finally {
            LOCKER.unlock();
        }
        return sum;
    }
}
