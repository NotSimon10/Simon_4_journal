package array;

import java.util.Random;
import java.util.Scanner;


public class Array { 
    
    public static String choose;
    public static int lose;
    
    //Inventory Related
    public static final Random rand = new Random();
    public static int min = 2;
    public static int max = 19;
    public static boolean inventory = false;
    public static int coins;
    public static int coinX = rand.nextInt(max - min + 1) + min;
    public static int coinY = rand.nextInt(max - min + 1) + min;
    
    public static Player player;
    public static Enemy enemy;
    public static Traps traps;
    public static Treasure treasure;

    public static void main(String[] args) throws InterruptedException {
        game();
    }

    public static void story() throws InterruptedException {
        
        player = new Player(9, 9);
        enemy = new Enemy(enemy.enemyX, enemy.enemyY, enemy.enemyX2, enemy.enemyY2);
        traps = new Traps(traps.trapX, traps.trapY);
        treasure = new Treasure(treasure.treasureX, treasure.treasureY);
        game();
    }

    public static void game() {

        X();
        Y();
        enemy();
        Map();
        Movement();
    }

    public static void Map() {
        char[][] map = new char[20][20];
        map[player.InputY - 1][player.InputX - 1] = '@'; //map[InputX-1][InputY-1] = 'x';
        map[traps.trapY - 1][traps.trapX - 1] = '*';
        map[traps.trapYone - 1][traps.trapXone - 1] = '*';
        map[traps.trapYtwo - 1][traps.trapXtwo - 1] = '*';
        map[traps.trapYthree - 1][traps.trapXthree - 1] = '*';
        map[traps.trapYfour - 1][traps.trapXfour - 1] = '*';
        map[traps.trapYfive - 1][traps.trapXfive - 1] = '*';
        map[traps.trapYsix - 1][traps.trapXsix - 1] = '*';
        map[traps.trapYseven - 1][traps.trapXseven - 1] = '*';
        map[traps.trapYeight - 1][traps.trapXeight - 1] = '*';
        map[traps.trapYnine - 1][traps.trapXnine - 1] = '*';
        map[treasure.treasureY - 1][treasure.treasureX - 1] = 'T';
        map[treasure.treasureY2 - 1][treasure.treasureX2 - 1] = 'T';
        map[treasure.treasureY3 - 1][treasure.treasureX3 - 1] = 'T';
        map[enemy.enemyY - 1][enemy.enemyX - 2] = 'E';
        map[enemy.enemyY2 - 1][enemy.enemyX2 - 2] = 'E';
        map[coinY][coinX] = '◎';
        for (int i = 0; i <= map[0].length - 1; i++) {
            for (int j = 0; j <= map[1].length - 1; j++) {
                if (j < map[1].length - 1) {
                    if (i == 0) {

                        System.out.print("▬▬▬");
                    } else if (i == 19) {

                        System.out.print("▬▬▬");
                    } else if (j == 0) {
                        System.out.print("▐");
                    } else if (j == 19) {
                        System.out.print("▐");
                    } else if (map[i][j] != '@' && map[i][j] != '*' && map[i][j] != 'E' && map[i][j] != 'T' && map[i][j] != '◎') { //map[i][j] != 'x' 
                        System.out.print(" • ");
                    } else {
                        System.out.print(" " + map[i][j] + " ");
                    }
                } else {
                    if (i == 0) {

                        System.out.println("");
                    } else if (i == 19) {
                        System.out.println("");
                    } else if (j == 0) {
                        System.out.println("▐");
                    } else if (j == 19) {
                        System.out.println("▐");
                    } else if (map[i][j] != '@' && map[i][j] != '*' && map[i][j] != 'E' && map[i][j] != 'T' && map[i][j] != '◎') { //map[i][j] != 'x'
                        System.out.println(" • ");
                    } else {
                        System.out.println(" " + map[i][j] + " ");
                    }
                }
            }
        }

        Movement();
    }

    public static void X() {
        Scanner x = new Scanner(System.in);
        System.out.println("Type a number 1-20 for the x value.");
        player.InputX = x.nextInt();
        if (player.InputX < 1 || player.InputX > 20) {
            System.out.println("Please choose another number.");
            X();
        }

    }

    public static void Y() {
        Scanner y = new Scanner(System.in);
        System.out.println("Type a number 1-20 for the y value.");
        player.InputY = y.nextInt();
        if (player.InputY < 1 || player.InputY > 20) {
            System.out.println("Please choose another number.");
            Y();
        }
    }

    static void Movement() {
        Scanner Move = new Scanner(System.in);        
        System.out.println("Do you want to go North[N], South[S], East[E], West[W]\nNortheast[NE], Southeast[SE], Northwest[NW], or Southwest[SW]?");
        player.move = Move.nextLine().toLowerCase();
        if (player.move.contains("n") && player.move.contains("e")) {
            player.InputY--;
            player.InputX++;
            enemy();
        } else if (player.move.contains("n") && player.move.contains("e")) {
            player.InputY--;
            player.InputX++;
            enemy();
        } else if (player.move.contains("s") && player.move.contains("e")) {
            player.InputY++;
            player.InputX++;
            enemy();
        } else if (player.move.contains("n") && player.move.contains("w")) {
            player.InputY--;
            player.InputX--;
            enemy();
        } else if (player.move.contains("s") && player.move.contains("w")) {
            player.InputY++;
            player.InputX--;
            enemy();
        } else if (player.move.contains("s") && player.move.contains("e")) {
            player.InputY++;
            player.InputX++;
            enemy();
        } else if (player.move.contains("n")) {
            if (player.InputY > 0 && player.InputY < 2) {
                player.InputY = 21;
            }
            if (enemy.enemyY > 0 && enemy.enemyY < 2) {
                enemy.enemyY = 20;
            }
            if (enemy.enemyY2 > 0 && enemy.enemyY2 < 2) {
                enemy.enemyY2 = 20;
            }
            player.InputY--;
            enemy();
        } else if (player.move.contains("s")) {
            if (player.InputY > 19 && player.InputY < 21) {
                player.InputY = 0;
            }
            if (enemy.enemyY > 19 && enemy.enemyY < 21) {
                enemy.enemyY = 1;
            }
            if (enemy.enemyY2 > 19 && enemy.enemyY2 < 21) {
                enemy.enemyY2 = 1;
            }
            player.InputY++;
            enemy();
        } else if (player.move.contains("e")) {
            if (player.InputX > 19 && player.InputX < 21) {
                player.InputX = 0;
            }
            if (enemy.enemyX > 19 && enemy.enemyX < 21) {
                enemy.enemyX = 1;
            }
            if (enemy.enemyX2 > 19 && enemy.enemyX2 < 21) {
                enemy.enemyX2 = 1;
            }
            player.InputX++;
            enemy();
        } else if (player.move.contains("w")) {
            if (player.InputX > 0 && player.InputX < 2) {
                player.InputX = 20;
            }
            if (enemy.enemyX > 0 && enemy.enemyX < 2) {
                enemy.enemyX = 20;
            }
            if (enemy.enemyX2 > 0 && enemy.enemyX2 < 2) {
                enemy.enemyX2 = 20;
            }
            player.InputX--;
            enemy();

        } else {
            System.out.println("Input not parsed.");
            Movement();
        }
    }

    public static void enemy() {
        System.out.println("Your location is: " + (player.InputX) + ", " + (player.InputY) + ".");
        System.out.println("The first enemy's location is: " + (enemy.enemyX) + ", " + (enemy.enemyY) + " and second's is: " + (enemy.enemyX2) + ", " + (enemy.enemyY2) + ".");
        if(player.health == 5) {
            player.totalhealth = player.health5;
        }
        if(player.health == 4) {
            player.totalhealth = player.health4;
        }
        if(player.health == 3) {
            player.totalhealth = player.health3;
        }
        if(player.health == 2) {
            player.totalhealth = player.health2;
        }
        if(player.health == 1) {
            player.totalhealth = player.health1;
        }
        if(player.health == 0) {
            lost();
            lose = 0;
        }
        System.out.println("Your health is currently: " + player.totalhealth + ".");
        
        System.out.println("Your Score is: " + player.score);
        if (player.InputX == treasure.treasureX2 && player.InputY == treasure.treasureY2) {
            treasure.treasureX2 = 1;
            treasure.treasureY2 = 1;
            player.score++;
        if (player.score == 3) {
            System.out.println("");
            System.out.println
                     ("db    db  .d88b.  db    db    db   d8b   db d888888b d8b   db \n"
                    + "`8b  d8' .8P  Y8. 88    88    88   I8I   88   `88'   888o  88 \n"
                    + " `8bd8'  88    88 88    88    88   I8I   88    88    88V8o 88 \n"
                    + "   88    88    88 88    88    Y8   I8I   88    88    88 V8o88 \n"
                    + "   88    `8b  d8' 88b  d88    `8b d8'8b d8'   .88.   88  V888 \n"
                    + "   YP     `Y88P'  ~Y8888P'     `8b8' `8d8'  Y888888P VP   V8P ");
            lose = 10;
            lost();
        }
        }
        else if (player.InputX == treasure.treasureX && player.InputY == treasure.treasureY) {
            treasure.treasureX = 1;
            treasure.treasureY = 1;
            player.score++;
        if (player.score == 3) {
            System.out.println("");
            System.out.println
                     ("db    db  .d88b.  db    db    db   d8b   db d888888b d8b   db \n"
                    + "`8b  d8' .8P  Y8. 88    88    88   I8I   88   `88'   888o  88 \n"
                    + " `8bd8'  88    88 88    88    88   I8I   88    88    88V8o 88 \n"
                    + "   88    88    88 88    88    Y8   I8I   88    88    88 V8o88 \n"
                    + "   88    `8b  d8' 88b  d88    `8b d8'8b d8'   .88.   88  V888 \n"
                    + "   YP     `Y88P'  ~Y8888P'     `8b8' `8d8'  Y888888P VP   V8P ");
            lose = 10;
            lost();
        }
        }
        else if (player.InputX == treasure.treasureX3 && player.InputY == treasure.treasureY3) {
            treasure.treasureX3 = 1;
            treasure.treasureY3 = 1;
            player.score++;
        if (player.score == 3) {
            System.out.println("");
            System.out.println          
                     ("db    db  .d88b.  db    db    db   d8b   db d888888b d8b   db \n"
                    + "`8b  d8' .8P  Y8. 88    88    88   I8I   88   `88'   888o  88 \n"
                    + " `8bd8'  88    88 88    88    88   I8I   88    88    88V8o 88 \n"
                    + "   88    88    88 88    88    Y8   I8I   88    88    88 V8o88 \n"
                    + "   88    `8b  d8' 88b  d88    `8b d8'8b d8'   .88.   88  V888 \n"
                    + "   YP     `Y88P'  ~Y8888P'     `8b8' `8d8'  Y888888P VP   V8P ");
            lose = 10;
            lost();
        }
        }
        
        if (player.InputX == traps.trapX && player.InputY == traps.trapY){
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;
//            lose = 0;
//            lost();
            traps.trapX = 1;
            traps.trapY = 1; 
        }
        else if (player.InputX == traps.trapXone && player.InputY == traps.trapYone) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;
//            lose = 0;
//            lost();
            traps.trapXone = 1;
            traps.trapYone = 1; 
        }
        else if (player.InputX == traps.trapXtwo && player.InputY == traps.trapYtwo) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;
//            lose = 0;
//            lost();
            traps.trapXtwo = 1;
            traps.trapYtwo = 1; 
        }
        else if (player.InputX == traps.trapXthree && player.InputY == traps.trapYthree) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;
//            lose = 0;
//            lost();
            traps.trapXthree = 1;
            traps.trapYthree = 1; 
        }
        else if (player.InputX == traps.trapXfour && player.InputY == traps.trapYfour) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;
//            lose = 0;
//            lost();
            traps.trapXfour = 1;
            traps.trapYfour = 1; 
        }
        else if (player.InputX == traps.trapXfive && player.InputY == traps.trapYfive) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;
//            lose = 0;
//            lost();
            traps.trapXfive = 1;
            traps.trapYfive = 1; 
        }
        else if (player.InputX == traps.trapXsix && player.InputY == traps.trapYsix) {
            System.out.println("\nYou hit a trap! You lose a heart");
            player.health--;
//            lose = 0;
//            lost();
            traps.trapXsix = 1;
            traps.trapYsix = 1; 
        }
        else if (player.InputX == traps.trapXseven && player.InputY == traps.trapYseven) {
            System.out.println("\nYou hit a trap! You lose a heart");
            player.health--;
//            lose = 0;
//            lost();
            traps.trapXseven = 1;
            traps.trapYseven = 1; 
        }
        else if (player.InputX == traps.trapXeight && player.InputY == traps.trapYeight) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;
//            lose = 0;
//            lost();
            traps.trapXeight = 1;
            traps.trapYeight = 1; 
        }
        else if (player.InputX == traps.trapXnine && player.InputY == traps.trapYnine) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;
//            lose = 0;
//            lost();
            traps.trapXnine = 1;
            traps.trapYnine = 1; 
        }

        if (player.InputX == enemy.enemyX && player.InputY == enemy.enemyY) {
            player.health--;
            enemy.enemyX = 2;
            enemy.enemyY = 2;
            enemy.e1 = false;
            System.out.println("\nYou got hit by an enemy!");
            //lose = 0;
            //lost();
        }
          if (player.InputX == enemy.enemyX2 && player.InputY == enemy.enemyY2) {
            player.health--;
            enemy.enemyX2 = 2;
            enemy.enemyY2 = 1;
            enemy.e2 = false;
            System.out.println("\nYou got hit by an enemy!");
            //lose = 0;
            //lost();
        }
        
        if(player.InputX > enemy.enemyX2 && enemy.e2 == true) {
            enemy.enemyX2++;
        }
        if(player.InputY > enemy.enemyX2 && enemy.e2 == true) {
            enemy.enemyY2++;
        }
        if(player.InputX < enemy.enemyX2 && enemy.e2 == true) {
            enemy.enemyX2--;
        }
        if(player.InputY < enemy.enemyY2 && enemy.e2 == true) {
            enemy.enemyY2--;
        }
        
        if(player.InputX > enemy.enemyX && enemy.e1 == true) {
            enemy.enemyX++;
        }
        if(player.InputY > enemy.enemyX && enemy.e1 == true) {
            enemy.enemyY++;
        }
        if(player.InputX < enemy.enemyX && enemy.e1 == true) {
            enemy.enemyX--;
        }
        if(player.InputY < enemy.enemyY && enemy.e1 == true) {
            enemy.enemyY--;
        }
        Map();
    }

    public static void lost() {
        Scanner scan = new Scanner(System.in);
        if (lose < 1) {
            System.out.println("");
            System.out.println
                     ("db    db  .d88b.  db    db    db       .d88b.  .d8888. d88888b \n"
                    + "`8b  d8' .8P  Y8. 88    88    88      .8P  Y8. 88'  YP 88'     \n"
                    + " `8bd8'  88    88 88    88    88      88    88 `8bo.   88ooooo \n"
                    + "   88    88    88 88    88    88      88    88   `Y8b. 88~~~~~ \n"
                    + "   88    `8b  d8' 88b  d88    88booo. `8b  d8' db   8D 88.     \n"
                    + "   YP     `Y88P'  ~Y8888P'    Y88888P  `Y88P'  `8888Y' Y88888P");
            System.out.println("");
        }
        System.out.println("\nDo you want to play again?");
        choose = scan.nextLine().toLowerCase();
        if (choose.contains("no")) {
            System.exit(0);
        } else if (choose.contains("yes")) {
            System.out.println("\nLet's play again!\n");
            game();
        } else {
            lost();
        }
    }

}
