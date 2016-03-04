/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evermaze;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author NotSimon
 */
class Player {
    
    public static int direction;
    
    public static float x = 96f;

    public static float y = 228f;

    public static int health = 100000;

    public static float speed = .4f;

    static float hitboxX = x + 8f;

    static float hitboxY = y + 8f;

    private static int startX, startY, width = 30, height = 42;

    public static Shape rect = new Rectangle(getplayershitboxX(),
            getplayershitboxY(), width, height);

    public static Shape myweapon = new Rectangle(getplayershitboxX(),
            getplayershitboxY(), 128, 128);

    public static float pdelta;
    
    public static Animation up, down, left, right, aup, adown, aleft, aright, wait, sprite;

 //   public static Animation playeranime, adown, aright, aup, aright, aleft, up, down, left, right, sprite, wait;
    
    public Player() throws SlickException {
    
    SpriteSheet runningSS = new SpriteSheet(
                "res/hsprite.png", 64, 64, 0);

		// System.out.println("Horizontal count: "
        // +runningSS.getHorizontalCount());
		// System.out.println("Vertical count: " +runningSS.getVerticalCount());
        aright = new Animation();
        
        aright.addFrame(runningSS.getSprite(0, 15), 100);

        aright.addFrame(runningSS.getSprite(1, 15), 100);

        aright.addFrame(runningSS.getSprite(2, 15), 100);

        aright.addFrame(runningSS.getSprite(3, 15), 100);

        aright.addFrame(runningSS.getSprite(4, 15), 100);

        aright.addFrame(runningSS.getSprite(5, 15), 100);

        aright.addFrame(runningSS.getSprite(6, 15), 100);
        
        //aright.setAutoUpdate(false);
        
        aup = new Animation();
        
        aup.addFrame(runningSS.getSprite(0, 12), 100);

        aup.addFrame(runningSS.getSprite(1, 12), 100);

        aup.addFrame(runningSS.getSprite(2, 12), 100);

        aup.addFrame(runningSS.getSprite(3, 12), 100);

        aup.addFrame(runningSS.getSprite(4, 12), 100);

        aup.addFrame(runningSS.getSprite(5, 12), 100);

        aup.addFrame(runningSS.getSprite(6, 12), 100);
        
        //aup.setAutoUpdate(false);

        up = new Animation();

        up.addFrame(runningSS.getSprite(0, 8), 330);

        up.addFrame(runningSS.getSprite(1, 8), 330);

        up.addFrame(runningSS.getSprite(2, 8), 330);

        up.addFrame(runningSS.getSprite(3, 8), 330);

        up.addFrame(runningSS.getSprite(4, 8), 330);

        up.addFrame(runningSS.getSprite(5, 8), 330);

        up.addFrame(runningSS.getSprite(6, 8), 330);

        up.addFrame(runningSS.getSprite(7, 8), 330);

        up.addFrame(runningSS.getSprite(8, 8), 330);

        adown = new Animation();

        adown.addFrame(runningSS.getSprite(0, 14), 100);

        adown.addFrame(runningSS.getSprite(1, 14), 100);

        adown.addFrame(runningSS.getSprite(2, 14), 100);

        adown.addFrame(runningSS.getSprite(3, 14), 100);

        adown.addFrame(runningSS.getSprite(4, 14), 100);

        adown.addFrame(runningSS.getSprite(5, 14), 100);

        adown.addFrame(runningSS.getSprite(6, 14), 100);
        
         //adown.setAutoUpdate(false);
        
        aleft = new Animation();

        aleft.addFrame(runningSS.getSprite(0, 13), 100);

        aleft.addFrame(runningSS.getSprite(1, 13), 100);

        aleft.addFrame(runningSS.getSprite(2, 13), 100);

        aleft.addFrame(runningSS.getSprite(3, 13), 100);

        aleft.addFrame(runningSS.getSprite(4, 13), 100);

        aleft.addFrame(runningSS.getSprite(5, 13), 100);

        aleft.addFrame(runningSS.getSprite(6, 13), 100);
        
        //aleft.setAutoUpdate(false);
        
        down = new Animation();

        //down.setAutoUpdate(false);

        down.addFrame(runningSS.getSprite(0, 10), 330);

        down.addFrame(runningSS.getSprite(1, 10), 330);

        down.addFrame(runningSS.getSprite(2, 10), 330);

        down.addFrame(runningSS.getSprite(3, 10), 330);

        down.addFrame(runningSS.getSprite(4, 10), 330);

        down.addFrame(runningSS.getSprite(5, 10), 330);

        down.addFrame(runningSS.getSprite(6, 10), 330);

        down.addFrame(runningSS.getSprite(7, 10), 330);

        down.addFrame(runningSS.getSprite(8, 10), 330);

        left = new Animation();

        left.setAutoUpdate(false);

        left.addFrame(runningSS.getSprite(0, 9), 330);

        left.addFrame(runningSS.getSprite(1, 9), 330);

        left.addFrame(runningSS.getSprite(2, 9), 330);

        left.addFrame(runningSS.getSprite(3, 9), 330);

        left.addFrame(runningSS.getSprite(4, 9), 330);

        left.addFrame(runningSS.getSprite(5, 9), 330);

        left.addFrame(runningSS.getSprite(6, 9), 330);

        left.addFrame(runningSS.getSprite(7, 9), 330);

        left.addFrame(runningSS.getSprite(8, 9), 330);

        right = new Animation();

        right.setAutoUpdate(false);

        right.addFrame(runningSS.getSprite(0, 11), 330);

        right.addFrame(runningSS.getSprite(1, 11), 330);

        right.addFrame(runningSS.getSprite(2, 11), 330);

        right.addFrame(runningSS.getSprite(3, 11), 330);

        right.addFrame(runningSS.getSprite(4, 11), 330);

        right.addFrame(runningSS.getSprite(5, 11), 330);

        right.addFrame(runningSS.getSprite(6, 11), 330);

        right.addFrame(runningSS.getSprite(7, 11), 330);

        right.addFrame(runningSS.getSprite(8, 11), 330);

        wait = new Animation();

        wait.setAutoUpdate(true);

        wait.addFrame(runningSS.getSprite(0, 14), 733);

        wait.addFrame(runningSS.getSprite(1, 14), 733);

        wait.addFrame(runningSS.getSprite(2, 14), 733);

        wait.addFrame(runningSS.getSprite(3, 14), 733);

		// wait.addFrame(runningSS.getSprite(2, 14), 733);
		// wait.addFrame(runningSS.getSprite(5, 14), 333);
        sprite = wait;
        
    }

    public static void setpdelta(float somenum) {

        pdelta = somenum;

    }

    public static float getpdelta() {

        return pdelta;

    }

    public static float getplayersX() {

        return x;

    }

    public static float getplayersY() {

        return y;

    }

    public static float getplayershitboxX() {

        return x + 18f;

    }

    public static float getplayershitboxY() {

        return y + 18f;

    }

    public static void setplayershitboxX() {

        hitboxX = getplayershitboxX();

    }

    public static void setplayershitboxY() {

        hitboxY = getplayershitboxY();

    }
    
//    public void direction(int i) {
//        this.direction = i;
//    }
//
//    public int getdirection() {
//        return this.direction;
//    }
    
}
