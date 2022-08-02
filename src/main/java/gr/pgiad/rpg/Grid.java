package main.java.gr.pgiad.rpg;

public class Grid {
    private int x_pos = 2;
    private int y_pos = 2;
    private int x_max = 4;
    private int y_max = 4;
    private String lastPosition = " ";
    // N: Non-Accessible, M: Market, " ": common square with 50% chance for battle
    private String[][] map = {
            {"N", "N", " ", "M", "M"},
            {"N", "N", " ", " ", " "},
            {"N", " ", "X", " ", " "},
            {"N", " ", " ", " ", "M"},
            {" ", " ", " ", "M", "M"}};

    public String[][] getMap() {
        return map;
    }

    public void setMap(String[][] map) {
        this.map = map;
    }

    public int getX_pos() {
        return x_pos;
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    public int getX_max() {
        return x_max;
    }

    public void setX_max(int x_max) {
        this.x_max = x_max;
    }

    public int getY_max() {
        return y_max;
    }

    public void setY_max(int y_max) {
        this.y_max = y_max;
    }

    public String getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(String lastPosition) {
        this.lastPosition = lastPosition;
    }

    public void print() {
        for(int j = 0; j < 5; j++) {
            System.out.print("*");
            for (int i = 0; i < 5; i++) {
                System.out.print("---*");
            }
            System.out.println();
            System.out.print("|");
            for (int i = 0; i < 5; i++) {
                System.out.print(" " + this.map[j][i] + " |");
            }
            System.out.println();
        }
        System.out.print("*");
        for (int i = 0; i < 5; i++) {
            System.out.print("---*");
        }
        System.out.println();
        System.out.println();
    }
}