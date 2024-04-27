package org.dayX;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LineReader Reader = new LineReader("./dayTemplate/input.txt");
        System.out.println(Arrays.toString(Reader.calculateDayX()));
    }
}