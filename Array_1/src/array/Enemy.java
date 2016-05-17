
package array;

import java.util.Random;

public class Enemy {
    
    public static int min = 2;
    public static int max = 19;
    public static final Random rand = new Random();
    public static int enemyX = rand.nextInt(max - min + 1) + min;
    public static int enemyY = rand.nextInt(max - min + 1) + min;
    public static int enemyX2 = rand.nextInt(max - min + 1) + min;
    public static int enemyY2 = rand.nextInt(max - min + 1) + min;
    public static boolean e1 = true;
    public static boolean e2 = true;

    public Enemy(int a, int b, int c, int d) {
        enemyX = a;
        enemyY = b;
        enemyX2 = c;
        enemyY2 = d;
    }

    public static int getEnemyX() {
        return enemyX;
    }

    public static void setEnemyX(int enemyX) {
        Enemy.enemyX = enemyX;
    }

    public static int getEnemyY() {
        return enemyY;
    }

    public static void setEnemyY(int enemyY) {
        Enemy.enemyY = enemyY;
    }

    public static int getEnemyX2() {
        return enemyX2;
    }

    public static void setEnemyX2(int enemyX2) {
        Enemy.enemyX2 = enemyX2;
    }

    public static int getEnemyY2() {
        return enemyY2;
    }

    public static void setEnemyY2(int enemyY2) {
        Enemy.enemyY2 = enemyY2;
    }

    public static boolean isE1() {
        return e1;
    }

    public static void setE1(boolean e1) {
        Enemy.e1 = e1;
    }

    public static boolean isE2() {
        return e2;
    }

    public static void setE2(boolean e2) {
        Enemy.e2 = e2;
    }
    
}
