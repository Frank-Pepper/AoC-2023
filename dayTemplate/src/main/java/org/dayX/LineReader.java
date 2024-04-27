package org.dayX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
    public int[] calculateDayX() {
        int Result1 = 0;
        int Result2 = 0;
        File test = new File(fileName);
        try {
            System.out.println(test.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            BufferedReader b = new BufferedReader(new FileReader(fileName));
            String Line;
            while((Line = b.readLine()) != null) {
//                Result1 += func1(Line);
//                Result2 += func2(Line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new int[]{Result1, Result2};
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