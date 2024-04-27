package org.day1;

public class CalibrationCalculator {

    public int findFirstDigit(String text) {
        int index = text.length();
        String[] data = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int result = 0;
        for (int i = 0; i < 9; i++) {
            if (text.contains(data[i]) && (text.indexOf(data[i]) < index)) {
                index = text.indexOf(data[i]);
                result = i + 1;
            }
        }
        for (int i = 0; i < text.length(); i++) {
            int digit = text.charAt(i) - 48;
            if (digit > 0 && digit < 10) {
                if ( i < index) {
                    return digit;
                }
            }
        }
        return result;
    }

    public int findSecondDigit(String text) {
        int index = -1;
        int Length = text.length();
        String[] data = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int result = 0;
        for (int i = 0; i < 9; i++) {
            if (text.lastIndexOf(data[i]) > index) {
                index = text.lastIndexOf(data[i]);
                result = i + 1;
            }
        }
        for (int i = Length - 1; i > -1; i--) {
            int digit = text.charAt(i) - 48;
            if (digit > 0 && digit < 10) {
                if ( i > index) {
                    return digit;
                }
            }
        }
        return result;
    }

    public int findNumber(String text) {
        int FirstDigit = 0;
        int SecondDigit = 0;
        int Length = text.length();
        for (int i = 0; i < Length; i++) {
            int digit = text.charAt(i) - 48;
            if (digit > 0 && digit < 10) {
                FirstDigit = digit;
                break;
            }
        }
        for (int i = 0; i < Length; i++) {
            int index = Length - i - 1;
            int digit = text.charAt(index) - 48;
            if (digit > 0 && digit < 10) {
                SecondDigit = digit;
                break;
            }
        }
        return 10 * FirstDigit + SecondDigit;
    }

    public int findDigit(String text) {
        int FirstDigit = findFirstDigit(text);
        int SecondDigit = findSecondDigit(text);
        return 10 * FirstDigit + SecondDigit;
    }

}
