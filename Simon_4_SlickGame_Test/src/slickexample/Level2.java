 package slickexample;

import org.newdawn.slick.state.*;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.logging.Level;

import java.util.logging.Logger;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;

import org.newdawn.slick.AppGameContainer;

import org.newdawn.slick.BasicGame;

import org.newdawn.slick.Font;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;

import org.newdawn.slick.Image;

import org.newdawn.slick.Input;

import org.newdawn.slick.SlickException;

import org.newdawn.slick.SpriteSheet;

import org.newdawn.slick.TrueTypeFont;

import org.newdawn.slick.geom.Rectangle;

import org.newdawn.slick.geom.Shape;

import org.newdawn.slick.state.BasicGameState;

import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import org.newdawn.slick.tiled.TiledMap;
import org.w3c.dom.css.Rect;
import static slickexample.Unwavering.level;

class blocked2 {

    public static boolean[][] blocked2;

    public static boolean[][] getblocked2() {

        return blocked2;

    }

};

class iwin {

    public int x;
    public int y;
    public static boolean isvisible = true;
    Image currentImage;
    Shape hitbox;
    Image antidote = new Image("res/portal.png");

    iwin(int a, int b) throws SlickException {
        this.x = a;
        this.y = b;
        this.hitbox = new Rectangle(a, b, 32, 32);
        this.currentImage = antidote;

    }

}

class player2 {
    
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

    public static Animation playeranime;

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

}

public class Level2 extends BasicGameState {

    public Enemy2 enemy;
    
    public ArrayList<Enemy2> enemyz = new ArrayList();
    
    private boolean[][] hostiles;

    private static TiledMap grass2Map2;

    private static AppGameContainer app;

    private static Camera camera;

    public static int counter = 0;
    
    public static int level = 2;

	// Player stuff
    private Animation sprite, up, down, left, right, wait, aup, adown, aleft, aright;

    /**
     *
     * The collision map indicating which tiles block movement - generated based
     *
     * on tile properties
     */
	// changed to match size of sprites & map
    private static final int SIZE = 64;

	// screen width and height won't change
    private static final int SCREEN_WIDTH = 1000;

    private static final int SCREEN_HEIGHT = 750;

    public Level2(int xSize, int ySize) {

    }

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {

        gc.setTargetFrameRate(60);

        gc.setShowFPS(false);

		// *******************
		// Scenerey Stuff
		// ****************
        grass2Map2 = new TiledMap("res/hmap2.tmx");

		// Ongoing checks are useful
        System.out.println("Tile map is this wide: " + grass2Map2.getWidth());

        camera = new Camera(gc, grass2Map2);

		// *********************************************************************************
		// Player stuff --- these things should probably be chunked into methods
        // and classes
		// *********************************************************************************
        
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

		// *****************************************************************
		// Obstacles etc.
		// build a collision map based on tile properties in the TileD map
        blocked2.blocked2 = new boolean[grass2Map2.getWidth()][grass2Map2.getHeight()];

		// System.out.println("Map height:" + grassMap.getHeight());
		// System.out.println("Map width:" + grassMap.getWidth());
		// There can be more than 1 layer. You'll check whatever layer has the
        // obstacles.
		// You could also use this for planning traps, etc.
		// System.out.println("Number of tile layers: "
        // +grassMap.getLayerCount());
        System.out.println("The grassmap is " + grass2Map2.getWidth() + "by "
                + grass2Map2.getHeight());

        for (int xAxis = 0; xAxis < grass2Map2.getWidth(); xAxis++) {

            for (int yAxis = 0; yAxis < grass2Map2.getHeight(); yAxis++) {

				// int tileID = grassMap.getTileId(xAxis, yAxis, 0);
				// Why was this changed?
				// It's a Different Layer.
				// You should read the TMX file. It's xml, i.e.,human-readable
                // for a reason
                int tileID = grass2Map2.getTileId(xAxis, yAxis, 0);

                String value = grass2Map2.getTileProperty(tileID, "blocked", "false");

                if ("true".equals(value)) {

                    System.out.println("The tile at x " + xAxis + " andy axis "
                            + yAxis + " is blocked2.");

                    blocked2.blocked2[xAxis][yAxis] = true;

                }

            }

        }


//        
//      for (int xAxis = 0; xAxis < grass2Map2.getWidth(); xAxis++) {
//            for (int yAxis = 0; yAxis < grass2Map2.getHeight(); yAxis++) {
//                int xBlock = (int) xAxis;
//                int yBlock = (int) yAxis;
//                if (!blocked.blocked[xBlock][yBlock]) {
//                    if (xBlock % 9 == 0 && yBlock % 25 == 0) {
//                        Enemy h = new Enemy(xAxis * SIZE, yAxis * SIZE);
//                        //	stuff.add(i);
//                        enemyz.add(h);
//                        hostiles[xAxis][yAxis] = true;
//                    }
//                }
//            }
//        }
      
        
        

        
          enemy = new Enemy2(100,100);
          enemyz.add(enemy);
          
          
        
//        health = new Health(100, 150);
//        health1 = new Health(450, 100);
//        healthz.add(health);
//        healthz.add(health1);

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {

        camera.centerOn((int) player.x, (int) player.y);

        camera.drawMap();

        camera.translateGraphics();

		// it helps to add status reports to see what's going on
		// but it gets old quickly
		// System.out.println("Current X: " +player.x + " \n Current Y: "+ y);
        sprite.draw((int) player.x, (int) player.y);

        //g.drawString("x: " + (int) player.x + "  y: " + (int) player.y, player.x, player.y - 10);

        g.drawString("Health: " + player.health / 1000, camera.cameraX + 885,
                camera.cameraY + 10);

        g.drawString("Swiftness: " + (int) (player.speed * 10), camera.cameraX + 880,
                camera.cameraY + 25);

		//g.draw(player.rect);
        g.drawString("Time Passed: " + counter / 1000, camera.cameraX , camera.cameraY);
        
        g.drawString("Level: " + level, camera.cameraX, camera.cameraY + 15);
        // moveenemies();
        //g.draw(player.myweapon);

for (Enemy2 h : enemyz) {
    
 
    if (h.isvisible) {
                h.currentanime.draw(h.Bx, h.By);
				

// draw the hitbox
               //g.draw(h.hitbox);
    
            }
        }


//        for (Health h : healthz) {
//            if (h.isvisible) {
//                h.currentImage.draw(h.x, h.y);
//				// draw the hitbox
//                //g.draw(h.hitbox);
//
//            }
//        }

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {

        
        counter += delta;

        Input input = gc.getInput();

        float fdelta = delta * player.speed;

        player.setpdelta(fdelta);

        double rightlimit = (grass2Map2.getWidth() * SIZE) - (SIZE * 0.75);

		// System.out.println("Right limit: " + rightlimit);
        float projectedright = player.x + fdelta + SIZE;

        boolean cangoright = projectedright < rightlimit;

		// there are two types of fixes. A kludge and a hack. This is a kludge.
        if (input.isKeyDown(Input.KEY_UP)) {

            player.direction = 1;
            
            sprite = up;
            //  moveenemies();
            float fdsc = (float) (fdelta - (SIZE * .15));

            if (!(isBlocked2(player.x, player.y - fdelta) || isBlocked2(
                    (float) (player.x + SIZE + 1.5), player.y - fdelta))) {

                sprite.update(delta);

				// The lower the delta the slower the sprite will animate.
                player.y -= fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            
            player.direction = 2;
            
            sprite = down;
            //     moveenemies();

            if (!isBlocked2(player.x, player.y + SIZE + fdelta)
                    || !isBlocked2(player.x + SIZE - 1, player.y + SIZE + fdelta)) {

                sprite.update(delta);

                player.y += fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_LEFT)) {

            player.direction = 3;
            
            sprite = left;
            //      moveenemies();

            if (!(isBlocked2(player.x - fdelta, player.y) || isBlocked2(player.x
                    - fdelta, player.y + SIZE - 1))) {

                sprite.update(delta);

                player.x -= fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_RIGHT)) {

            player.direction = 4;
            
            sprite = right;
                      //  moveenemies();

			// the boolean-kludge-implementation
            if (cangoright
                    && (!(isBlocked2(player.x + SIZE + fdelta,
                            player.y) || isBlocked2(player.x + SIZE + fdelta, player.y
                            + SIZE - 1)))) {

                sprite.update(delta);

                player.x += fdelta;

            } // else { System.out.println("Right limit reached: " +
            // rightlimit);}

        } else if (input.isKeyDown(Input.KEY_SPACE)) {
            
            if(player.direction == 1) {
                sprite = aup;
                sprite.update(delta);
            }
            
            else if(player.direction == 2) {
                sprite = adown;
                sprite.update(delta);
            }
            
            else if(player.direction == 3) {
                sprite = aleft;
                sprite.update(delta);
            }
            
            else if(player.direction == 4) {
                   sprite = aright;
                   sprite.update(delta);
            }
            
            player.myweapon.setLocation(player.x, player.y);
        }
            
            
            for (Enemy2 e : enemyz) {
            if (Math.abs(player.x - e.Bx) < 500) {
                e.move();
                
            
            
            }
            
            for (Enemy2 h : enemyz) {

            if (player.rect.intersects(h.rect)) {
                if (h.isvisible) {
                    player.health -= 500;
                   
                }

            }
        }

//        for (Health h : healthz) {
//
//            if (player.rect.intersects(h.hitbox)) {
//                //System.out.println("yay");
//                if (h.isvisible) {
//
//                    player.health += 10000;
//                    h.isvisible = false;
//                }
//
//            }
//        }

        if (player.health <= 0) {
            makevisible();
            sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }

        }
    }

    public int getID() {

        return 5;

    }

    public void makevisible() {
//        for (Health h : healthz) {
//
//            h.isvisible = true;
         }

       

    private boolean isBlocked2(float tx, float ty) {

        int xBlock = (int) tx / SIZE;

        int yBlock = (int) ty / SIZE;

        return blocked2.blocked2[xBlock][yBlock];

		// this could make a better kludge
    }

}

