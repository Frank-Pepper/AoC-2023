package org.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineReader {

    private final String fileName;

    LineReader(String fileName) {
        File test = new File(".");
        try {
            System.out.println(test.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.fileName = fileName;
    }
    public String[] calculateDayX() {
        int Lenght = numberOfLines();
        String[] Result = new String[Lenght];
        File test = new File(fileName);
        try {
            System.out.println(test.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedReader b = new BufferedReader(new FileReader(fileName));
            String Line;
            int i = 0;
            while((Line = b.readLine()) != null) {
                Result[i] = Line;
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result;
    }

    public int numberOfLines() {
        int Result = 0;
        try {
            BufferedReader b = new BufferedReader(new FileReader(fileName));
            while((b.readLine()) != null) {
                Result++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Result;
    }

}