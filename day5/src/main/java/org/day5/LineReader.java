package org.day5;

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
    public int[] calculateDay5() {
        int Result1 = 0;
        int Result2 = 0;
        String seeds;
        long[] seed;


        try {
            BufferedReader b = new BufferedReader(new FileReader(fileName));
            String Line = b.readLine();
            seeds = Line.replaceFirst("seeds: ", "");
            seed = Arrays.stream(seeds.split(" ")).mapToLong(Long::parseLong).toArray();
            Gardener gardener = new Gardener(seed);

            System.out.println(Arrays.toString(seed));
            while((Line = b.readLine()) != null) {
                    gardener.assignTransforamtion(b, Line);
            }
            //gardener.transform();
            //gardener.findSmallestTransformation();
            gardener.bruteForce();
            System.out.println(seed.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        System.out.println(gardener.seedToSoil);
//        System.out.println(soilToFertilizer);
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