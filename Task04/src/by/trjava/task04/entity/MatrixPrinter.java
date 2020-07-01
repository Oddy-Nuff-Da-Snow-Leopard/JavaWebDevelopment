package by.trjava.task04.entity;

import java.io.FileWriter;
import java.io.IOException;

public class MatrixPrinter implements Runnable {

    private final Matrix matrix;
    private final String filepath;

    public MatrixPrinter(String filepath, Matrix matrix) {
        this.matrix = matrix;
        this.filepath = filepath;
    }

    @Override
    public void run() {
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.append("\nMatrix after threads work:\n");
            fileWriter.append(matrix.toString());
            fileWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
