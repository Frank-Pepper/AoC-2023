package org.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
    public int[] calculateDay4() {
        int Length = numberOfLines();
        int Result1 = 0;
        int Result2 = 0;
        int[] array = new int[Length];

        try {
            BufferedReader b = new BufferedReader(new FileReader(fileName));
            String Line;
            int index = 0;
            while((Line = b.readLine()) != null) {
                int wins = calculateMatchingCard(Line);
                Result1 += (int) Math.pow(2, wins - 1);

                array[index] += 1;
                for (int i = 1; i <= wins; i++) {
                    array[index+i] += array[index];
                }
                index++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i : array){
            Result2 += i;
        }
        return new int[]{Result1, Result2};
    }

    public int calculateMatchingCard(String text) {
        int wins = 0;
        String[] data = text.split(": +");
        String[] numbers = data[1].split("\\| +");
        String[] yourNumbers = numbers[0].split(" +");
        String[] winningNumbers = numbers[1].split(" +");
        System.out.println(Arrays.toString(yourNumbers));
        System.out.println(Arrays.toString(winningNumbers));
        Set<String> set = new HashSet<>(Arrays.asList(winningNumbers));
        for (String yourNumber : yourNumbers) {
            if (!set.add(yourNumber)) {
                wins++;
            }
        }
        return Math.max(wins, 0);
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