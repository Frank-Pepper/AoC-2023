package org.day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Engine {
    String[] data;
    int length;

    ArrayList<Set<Integer>> table;

    Engine(String[] data, int length) {
        this.data = data;
        this.length = length;
        this.table = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            this.table.add(new HashSet<>());
        }
    }

    public int[] findParts() {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < data.length; i++) {
            String s = data[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c != '.') {
                    if (c > 57 || c < 48) {
                        sum1 += findNeigbours(j, i);
                    }
                }
            }
        }
        for (Set<Integer> t: table) {
            t.clear();
        }
        for (int i = 0; i < length; i++) {
            String s = data[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c != '.') {
                    if (c > 57 || c < 48) {
                        sum2 += findGears(j, i);
                    }
                }
            }
        }
        return new int[] {sum1, sum2};
    }

    public int findNeigbours(int x, int y) {
        int sum = 0;
        List<Integer> list = calculate(x, y);

        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    public int findGears(int x, int y) {
        if (data[y].charAt(x) == '*') {
            List<Integer> list = calculate(x, y);
            if (list.size() == 2) {
                return list.get(0) * list.get(1);
            }
        }
        return 0;
    }

    public List<Integer> calculate(int x, int y) {
        List<Integer> list = new ArrayList<>();
        int value;
        for (int i = y - 1; i <= y + 1; i++) {
            if (i >= 0 && i < length) {
                for (int j = x - 1; j <= x + 1; j++) {
                    if (j >= 0 && j < data[y].length()) {
                        if (data[i].charAt(j) != '.' && !(j == x && i == y)) {
                            value = calculateNumber(j, i);
                            if (value != 0) {
                                list.add(value);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    public int calculateNumber(int x, int y) {
        int index = x;
        int Result = 0;
        String s = data[y];
        while (index >= 0 && s.charAt(index) > 47 && s.charAt(index) < 58) {
            index--;
        }
        index++;
        while (index < s.length() && s.charAt(index) > 47 && s.charAt(index) < 58) {
            Result = Result * 10 + s.charAt(index) - 48;
            if (!table.get(y).add(index)) {
                return 0;
            }
            index += 1;
        }
        return Result;
    }
}
