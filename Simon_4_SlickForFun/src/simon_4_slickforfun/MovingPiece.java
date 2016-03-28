package simon_4_slickforfun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class MovingPiece {
    
    public static int direction;
    
    public static float x = 96f;

    public static float y = 228f;

    public static int health = 100000;

    public static float speed = .4f;

    static float hitboxX = x + 8f;

    static float hitboxY = y + 8f;
        
    public int X;
	
    public int Y;
	
    public boolean isvisible = true;
	
    Image currentImage;
    
    public static Shape hitbox;
    
    private static int startX, startY, width = 30, height = 30;
    
    public static Shape rect = new Rectangle(getMovingPieceshitboxX(),
            getMovingPieceshitboxY(), width, height);
	
    Image piece = new Image("res/MovingPiece.png");
 
    MovingPiece(int a, int b) throws SlickException {
        this.X = a;
	this.Y = b;
	this.hitbox = new Rectangle(a, b, 32, 32);
	this.currentImage = piece;
    }
    
    public static float getplayersX() {

        return x;

    }

    public static float getplayersY() {

        return y;

    }

    public static float getMovingPieceshitboxX() {

        return x + 18f;

    }

    public static float getMovingPieceshitboxY() {

        return y + 18f;

    }

    public static void setplayershitboxX() {

        hitboxX = getMovingPieceshitboxX();

    }

    public static void setplayershitboxY() {

        hitboxY = getMovingPieceshitboxY();

    }
 
}
