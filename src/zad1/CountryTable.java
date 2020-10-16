package zad1;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CountryTable {
    private String countriesFileName;

    public CountryTable(String countriesFileName) {
        this.countriesFileName = countriesFileName;
    }

    public JTable create() {
        JTable countries = new JTable();
        FileReader fileReader = null;

        String columns = "";
        String data = "";

        try {
            fileReader = new FileReader(countriesFileName);
            Scanner scanner = new Scanner(fileReader);
            StringBuilder stringBuilder = new StringBuilder();

            columns = scanner.nextLine();

            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine() + "\n");
            }
            data = stringBuilder.toString();

        } catch (FileNotFoundException f) {
            System.err.println("file is not found");

        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("columns:\n" + columns + "\n");
        String[] line = columns.split("\t");
        for (String l : line) {
            System.out.println(line.toString());
        }
        System.out.println("data:\n" + data + "\n");
        return countries;
    }

    private String[] toRows(String string) {
        return string.split("\t");
    }

    public static void usingSplit() {
        String text = "Ala ma kota";

        //.split("delimiter") returns array of lines

        String[] lines = text.split(" ");

        System.out.println("////Split");
        for (String line : lines) System.out.println(line);

    }
}
