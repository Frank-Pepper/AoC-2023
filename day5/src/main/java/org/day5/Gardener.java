package org.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Gardener {

    long[] seed;
    ArrayList<Long> transformation;
    ArrayList<Long> soilToFertilizer;
    ArrayList<Long> fertilizerToWater;
    ArrayList<Long> waterToLight;
    ArrayList<Long> lightToTemperature;
    ArrayList<Long> temperatureToHumidity;
    ArrayList<Long> humidityToLocation;

    ArrayList<Long>[] datas;

    Gardener(long[] seed) {
        this.seed = seed;
    }

    public void assignTransforamtion(BufferedReader b, String Line) {
        switch (Line) {
            case "seed-to-soil map:" -> transformation = inputTransfomation(b);
            case "soil-to-fertilizer map:" -> soilToFertilizer = inputTransfomation(b);
            case "fertilizer-to-water map:" -> fertilizerToWater = inputTransfomation(b);
            case "water-to-light map:" -> waterToLight = inputTransfomation(b);
            case "light-to-temperature map:" -> lightToTemperature = inputTransfomation(b);
            case "temperature-to-humidity map:" -> temperatureToHumidity = inputTransfomation(b);
            case "humidity-to-location map:" -> humidityToLocation = inputTransfomation(b);
        }
    }

    public void transform() {
        this.datas = new ArrayList[] {transformation, soilToFertilizer, fertilizerToWater, waterToLight, lightToTemperature, temperatureToHumidity, humidityToLocation};
        long[] seed2 = seed;
        System.out.println(Arrays.toString(seed2));

        for (ArrayList<Long> transformation : datas) {
            //System.out.println(transformation);
            for (int i = 0; i < seed2.length; i++) {
                for (int j = 0; j < transformation.size() - 3; j += 3) {
                    if (seed2[i] > transformation.get(j + 1) && seed2[i] <= transformation.get(j + 1) + transformation.get(j + 2)) {
                        System.out.println(seed2[i] + " " + transformation.get(i) + " " + transformation.get(i+1) + " " + transformation.get(i+2) + "  " + i);
                        seed2[i] += transformation.get(j) - transformation.get(j + 1);
                        j++;
                        break;
                    }
                }
            }
        }
        long value = seed2[0];
        for (long l : seed2) {
            value = Long.min(value, l);
        }
        System.out.println(Arrays.toString(seed2));
        System.out.println(value);
    }

    public void findSmallestTransformation() {
        this.datas = new ArrayList[] {transformation, soilToFertilizer, fertilizerToWater, waterToLight, lightToTemperature, temperatureToHumidity, humidityToLocation};
        long[] seed2 = seed;
        long sum = 0;
        for (int i = 1; i < seed2.length; i += 2) {
            sum += seed2[i];
        }
        System.out.println(sum);


        for (ArrayList<Long> transformation : datas) {
            long value = 0;
            //System.out.println(transformation);
            for (int i = 0; i < seed2.length; i++) {
                for (int j = 0; j < transformation.size() - 3; j += 3) {
//                    if (seed2[i] > transformation.get(j + 1) && seed2[i] <= transformation.get(j + 1) + transformation.get(j + 2)) {
//                        System.out.println(seed2[i] + " " + transformation.get(i) + " " + transformation.get(i+1) + " " + transformation.get(i+2) + "  " + i);
//                        seed2[i] += transformation.get(j) - transformation.get(j + 1);
//                        j++;
//                        break;
//                    }
                    value = Long.min(value, transformation.get(i) - transformation.get(i+1));
                }
            }
            System.out.println(value);
        }

    }

    public void bruteForce() {
        long len = seed[1];
        long base = seed[0];
        Long[] arr = new Long[(int) len];
        System.out.println(arr.length);
    }


    public ArrayList<Long> inputTransfomation(BufferedReader b) {
        ArrayList<Long> seed = new ArrayList<>();
        String Line;
        String[] data;
        try {
            while ((Line = b.readLine()) != null) {
                data = Line.split(" ");
                //System.out.println(Arrays.toString(data) + data.length);
                if (data.length < 3) {
                    break;
                }
                for (String s : data) {
                    seed.add(Long.parseLong(s));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return seed;
    }
}
