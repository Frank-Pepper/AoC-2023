package org.day1;

import java.io.*;

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
    public int[] calculateDay1() {
        CalibrationCalculator calculator = new CalibrationCalculator();
        int Result1 = 0;
        int Result2 = 0;

        try {
            BufferedReader b = new BufferedReader(new FileReader(fileName));
            String Line;
            while((Line = b.readLine()) != null) {
                Result1 += calculator.findNumber(Line);
                Result2 += calculator.findDigit(Line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new int[]{Result1, Result2};
    }
}