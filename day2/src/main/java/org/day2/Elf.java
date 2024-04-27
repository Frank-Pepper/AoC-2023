package org.day2;

public class Elf {
    private final int red;
    private final int green;
    private final int blue;

    Elf(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int playGame(String text) {
        String[] table = text.split(":");
        String[] gameTable = table[0].split(" ");
        int gameId = Integer.parseInt(gameTable[1]);
        String[] tours = table[1].split(";");
        for (String s : tours) {
            String[] pull = s.split(",");
            for (String p : pull) {
                String[] pullColor = p.split(" ");
                int value = Integer.parseInt(pullColor[1]);
                String color = pullColor[2];
                switch (color) {
                    case "red" -> {
                        if (value > red) {
                            return 0;
                        }
                    }
                    case "green" -> {
                        if (value > green) {
                            return 0;
                        }
                    }
                    case "blue" -> {
                        if (value > blue) {
                            return 0;
                        }
                    }
                }

            }
        }
        return gameId;
    }

    public int gamePower(String text) {
        int Red = 0;
        int Green = 0;
        int Blue = 0;
        String[] table = text.split(":");
        String[] tours = table[1].split(";");
        for (String s : tours) {
            String[] pull = s.split(",");
            for (String p : pull) {
                String[] pullColor = p.split(" ");
                int value = Integer.parseInt(pullColor[1]);
                String color = pullColor[2];
                switch (color) {
                    case "red" -> Red = Math.max(Red, value);
                    case "green" -> Green = Math.max(Green, value);
                    case "blue" -> Blue = Math.max(Blue, value);
                }
            }
        }
        return Red * Green * Blue;
    }

}
