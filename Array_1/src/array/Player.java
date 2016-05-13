package array;

public class Player {
 
    public static int InputX;
    public static int InputY;
    public static String move;
    public static String totalhealth;
    public static int health = 5;
    public static int score;
    public static String health5 = "♥♥♥♥♥";
    public static String health4 = "♥♥♥♥";
    public static String health3 = "♥♥♥";
    public static String health2 = "♥♥";
    public static String health1 = "♥";
    
    public Player(int a, int b) {
        this.InputX = a;
        this.InputY = b;
        this.health = 5;
        this.score = 0;
    }

    public static int getInputX() {
        return InputX;
    }

    public static void setInputX(int InputX) {
        Player.InputX = InputX;
    }

    public static int getInputY() {
        return InputY;
    }

    public static void setInputY(int InputY) {
        Player.InputY = InputY;
    }

    public static String getMove() {
        return move;
    }

    public static void setMove(String move) {
        Player.move = move;
    }

    public static String getTotalhealth() {
        return totalhealth;
    }

    public static void setTotalhealth(String totalhealth) {
        Player.totalhealth = totalhealth;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Player.health = health;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Player.score = score;
    }

    public static String getHealth5() {
        return health5;
    }

    public static void setHealth5(String health5) {
        Player.health5 = health5;
    }

    public static String getHealth4() {
        return health4;
    }

    public static void setHealth4(String health4) {
        Player.health4 = health4;
    }

    public static String getHealth3() {
        return health3;
    }

    public static void setHealth3(String health3) {
        Player.health3 = health3;
    }

    public static String getHealth2() {
        return health2;
    }

    public static void setHealth2(String health2) {
        Player.health2 = health2;
    }

    public static String getHealth1() {
        return health1;
    }

    public static void setHealth1(String health1) {
        Player.health1 = health1;
    }
    
}