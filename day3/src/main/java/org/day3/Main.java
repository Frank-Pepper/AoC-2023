package org.day3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LineReader Reader = new LineReader("./day3/input.txt");
        Engine engine = new Engine(Reader.calculateDayX(), Reader.numberOfLines());
        System.out.println(Arrays.toString(engine.findParts()));
    }
}