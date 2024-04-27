package org.day2;

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
    public int[] calculateDay2() {
        Elf elf = new Elf(12, 13, 14);
        int Result1 = 0;
        int Result2 = 0;

        try {
            BufferedReader b = new BufferedReader(new FileReader(fileName));
            String Line;
            while((Line = b.readLine()) != null) {
                Result1 += elf.playGame(Line);
                Result2 += elf.gamePower(Line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new int[] {Result1, Result2};
    }
}