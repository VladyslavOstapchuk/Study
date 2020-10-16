package zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        readFile("data/countries.txt");
    }


    public static void readFile(String fileName) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);

            System.out.println(scanner.nextLine());
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine() + "\n");
            }
            System.out.println(stringBuilder.toString());
        } catch (FileNotFoundException f) {
            System.err.println("file is not found");
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
