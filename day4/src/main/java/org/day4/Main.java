package org.day4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LineReader Reader = new LineReader("./day4/input.txt");
        System.out.println(Arrays.toString(Reader.calculateDay4()));
    }
}
