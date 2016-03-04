package Evermaze;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Orb {
    
    public static int direction;
    private int y, x, width, height;
    private int damage, hitboxX, hitboxY;
    private boolean isVisible;
    private int timeExists;
    
    Image orb;
    Shape hitbox;
    
    public Orb(int a, int b) throws SlickException {
        
        this.x = a;
        this.y = b;
        this.isVisible = false;
        this.orb = new Image ("res/power_orbs/Ninja_12.png");       
        this.hitbox = new Rectangle (a, b, 32, 32);
        this.timeExists = 0;
        
    }
        
        public void settimeExists(int t) {
            
            this.timeExists = t;
            
        }
        
       
         /*
         * Getters and Setters are a common concept in Java.
         * A design guideline in Java, and object oriented
         * programming in general, is to encapsulate/isolate
         * values as much as possible.
         * Getters - Methods used to query the value of 
         * this.getLocationX();
         * Setters - methods that set values for instance
         * variables.
         */
        
    
    public int gettimeExists() {
        return this.timeExists;
    }
    
    public void countdown() {
        this.timeExists --;
        
    }
        
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHitboxX() {
        return hitboxX;
    }

    public void setHitboxX(int hitboxX) {
        this.hitboxX = hitboxX;
    }

    public int getHitboxY() {
        return hitboxY;
    }

    public void setHitboxY(int hitboxY) {
        this.hitboxY = hitboxY;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Image getOrb() {
        return orb;
    }

    public void setOrb(Image orb) {
        this.orb = orb;
    }

    public Shape getHitbox() {
        return hitbox;
    }

    public void setHitbox(Shape hitbox) {
        this.hitbox = hitbox;
    }
    
     public void direction(int i) {
        this.direction = i;
    }

    public int getdirection() {
        return this.direction;
    }
    
    //public void setLocation(int a, int b, Player, player) {
        
        
    //}
    
}
