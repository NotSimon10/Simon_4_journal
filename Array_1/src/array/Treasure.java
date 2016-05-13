package array;

import java.util.Random;

public class Treasure {
    
    public static final Random rand = new Random();
    public static int max = 19;
    public static int min = 2;
    public static int treasureX = rand.nextInt(max - min + 1) + min;
    public static int treasureY = rand.nextInt(max - min + 1) + min;
    public static int treasureX2 = rand.nextInt(max - min + 1) + min;
    public static int treasureY2 = rand.nextInt(max - min + 1) + min;
    public static int treasureX3 = rand.nextInt(max - min + 1) + min;
    public static int treasureY3 = rand.nextInt(max - min + 1) + min;
    
    public Treasure(int a, int b) {
        this.treasureX = a;
        this.treasureY = b;
    }

    public static int getMax() {
        return max;
    }

    public static void setMax(int max) {
        Treasure.max = max;
    }

    public static int getMin() {
        return min;
    }

    public static void setMin(int min) {
        Treasure.min = min;
    }

    public static int getTreasureX() {
        return treasureX;
    }

    public static void setTreasureX(int treasureX) {
        Treasure.treasureX = treasureX;
    }

    public static int getTreasureY() {
        return treasureY;
    }

    public static void setTreasureY(int treasureY) {
        Treasure.treasureY = treasureY;
    }

    public static int getTreasureX2() {
        return treasureX2;
    }

    public static void setTreasureX2(int treasureX2) {
        Treasure.treasureX2 = treasureX2;
    }

    public static int getTreasureY2() {
        return treasureY2;
    }

    public static void setTreasureY2(int treasureY2) {
        Treasure.treasureY2 = treasureY2;
    }

    public static int getTreasureX3() {
        return treasureX3;
    }

    public static void setTreasureX3(int treasureX3) {
        Treasure.treasureX3 = treasureX3;
    }

    public static int getTreasureY3() {
        return treasureY3;
    }

    public static void setTreasureY3(int treasureY3) {
        Treasure.treasureY3 = treasureY3;
    }
    
    
    
}
