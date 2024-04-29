package org.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

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
    public int[] calculateDay6() {
        int Result1 = 0;
        int Result2 = 0;

        try {
            BufferedReader b = new BufferedReader(new FileReader(fileName));
            String Line = b.readLine();
            String[] times = Line.split(" +");
            String[] distance = b.readLine().split(" +");

            int[] time = new int[times.length - 1];
            int[] dist = new int[distance.length - 1];

            for (int i = 1; i < times.length; i++) {
                time[i - 1] = Integer.parseInt(times[i]);
            }

            for (int i = 1; i < times.length; i++) {
                dist[i - 1] = Integer.parseInt(distance[i]);
            }

            Result1 = calculatePart1(time, dist);
            Result2 = calculatePart2(time, dist);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new int[]{Result1, Result2};
    }

    public int calculatePart1(int[] time, int[] dist) {
        int result = 1;
        for (int i = 0; i < time.length; i++) {
            int value = 0;
            for (int j = 0; j < time[i]; j++) {
                if (j * (time[i] - j) > dist[i]) {
                    value = time[i] - 2 * j + 1;
                    break;
                }
            }
            result *= value;
        }
        return result;
    }

    public int calculatePart2(int[] time, int[] dist) {
        int completeTime = time[0];
        for (int i = 1; i < time.length; i ++) {
            int mul = 1;
            while (mul < time[i]) {
                mul *= 10;
            }
            completeTime = completeTime * mul + time[i];
        }
        long completeDist = dist[0];
        for (int i = 1; i < dist.length; i ++) {
            int mul = 1;
            while (mul < dist[i]) {
                mul *= 10;
            }
            completeDist = completeDist * mul + dist[i];
        }

        for (int i = 1; i < completeTime; i++) {
            if ((long) i * (completeTime - i ) > completeDist) {
                System.out.println(i + " " + (completeTime - i));
                return completeTime - 2 * i + 1;
            }
        }
        return 0;
    }

}