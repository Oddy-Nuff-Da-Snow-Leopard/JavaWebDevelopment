package by.trjava.task04.main;

import by.trjava.task04.entity.Matrix;
import by.trjava.task04.entity.MatrixHandler;
import by.trjava.task04.entity.MatrixPrinter;
import by.trjava.task04.entity.MatrixRunnable;

import by.trjava.task04.service.ServiceFactory;
import by.trjava.task04.service.MatrixService;
import by.trjava.task04.service.exception.ServiceException;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final String SIZE_FILE_PATH = "resources/squareMatrixSize.txt";
    private static final String RESULT_FILE_PATH = "resources/result.txt";

    public static void main(String[] args) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        int N = 0;
        try {
            N = matrixService.getSquareMatrixSizeFromFile(SIZE_FILE_PATH);
        } catch (ServiceException ex) {
            ex.printStackTrace();
        }

        try {
            Files.deleteIfExists(Paths.get(RESULT_FILE_PATH));
        } catch (IOException ex) {

        }

        Matrix matrix = new Matrix(new int[N][N]);
        CyclicBarrier barrier = new CyclicBarrier(N, new MatrixPrinter(RESULT_FILE_PATH, matrix));
        MatrixHandler handler = new MatrixHandler(matrix);

        Random rnd = new Random();

        ExecutorService executorService = Executors.newFixedThreadPool(N);
        int Y = 3;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < N; j++) {
                executorService.execute(new MatrixRunnable(rnd.nextInt(10) + 10, j, handler, barrier, RESULT_FILE_PATH));
            }
        }
        executorService.shutdown();
    }
}