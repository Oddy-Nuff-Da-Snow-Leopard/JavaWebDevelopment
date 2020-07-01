package by.trjava.task04.entity;

import java.io.FileWriter;
import java.io.IOException;

public class Printer {

    public static void printInFile(String filePath, String str) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.append(str);
            fileWriter.append("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
