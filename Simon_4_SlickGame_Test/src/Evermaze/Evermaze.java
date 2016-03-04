package Evermaze;

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

import org.newdawn.slick.Sound;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;

import org.newdawn.slick.Image;

import org.newdawn.slick.Input;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

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

class blocked {

    public static boolean[][] blocked;

    public static boolean[][] getblocked() {

        return blocked;

    }

};

class itemwin {

    public int x;
    public int y;
    public static boolean isvisible = true;
    Image currentImage;
    Shape hitbox;
    Image antidote = new Image("res/portal.png");

    itemwin(int a, int b) throws SlickException {
        this.x = a;
        this.y = b;
        this.hitbox = new Rectangle(a, b, 32, 32);// 64 is the width of the item
        this.currentImage = antidote;

    }

}

public class Evermaze extends BasicGameState {
    public static Player player;
    public Poison portal, portal1;
    public Health health, health1;
    public itemwin antidote;
    public Spikes spike1;
    public Enemy enemy, enemy1, enemy2, enemy3, enemy4, enemy5, enemy6;
    public Orb orb, orb2, orb3, orb4;
    
    public ArrayList<Poison> portalz = new ArrayList();
    
    public ArrayList<Spikes> spike = new ArrayList();

    public ArrayList<Health> healthz = new ArrayList();

    public ArrayList<itemwin> stuffwin = new ArrayList();

    public ArrayList<Enemy> enemyz = new ArrayList();

    private boolean[][] hostiles;

    private static TiledMap grassMap;

    private static AppGameContainer app;

    private static Camera camera;

    public static int counter = 0;

    public static int level = 1;

	// player stuff
    //private Animation sprite, up, down, left, right, wait, aup, adown, aleft, aright;
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

    public Evermaze(int xSize, int ySize) {

    }

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {

        gc.setTargetFrameRate(60);

        gc.setShowFPS(false);

		// *******************
        // Scenerey Stuff
        // ****************
        grassMap = new TiledMap("res/htest3.tmx");

        // Ongoing checks are useful
        System.out.println("Tile map is this wide: " + grassMap.getWidth());

        camera = new Camera(gc, grassMap);

		// *********************************************************************************
        // player stuff --- these things should probably be chunked into methods
        // and classes
        // *********************************************************************************
        player = new Player();

		// *****************************************************************
        // Obstacles etc.
        // build a collision map based on tile properties in the TileD map
        blocked.blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];

		// System.out.println("Map height:" + grassMap.getHeight());
        // System.out.println("Map width:" + grassMap.getWidth());
        // There can be more than 1 layer. You'll check whatever layer has the
        // obstacles.
        // You could also use this for planning traps, etc.
        // System.out.println("Number of tile layers: "
        // +grassMap.getLayerCount());
        System.out.println("The grassmap is " + grassMap.getWidth() + "by "
                + grassMap.getHeight());

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {

            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {

				// int tileID = grassMap.getTileId(xAxis, yAxis, 0);
                // Why was this changed?
                // It's a Different Layer.
                // You should read the TMX file. It's xml, i.e.,human-readable
                // for a reason
                int tileID = grassMap.getTileId(xAxis, yAxis, 1);

                String value = grassMap.getTileProperty(tileID, "blocked", "false");

                if ("true".equals(value)) {

//                    System.out.println("The tile at x " + xAxis + " andy axis "
//                            + yAxis + " is blocked.");
                    blocked.blocked[xAxis][yAxis] = true;

                }

            }

        }

        //System.out.println("Array length" + blocked.blocked[0].length);
        // A remarkably similar process for finding hostiles
        hostiles = new boolean[grassMap.getWidth()][grassMap.getHeight()];

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int xBlock = (int) xAxis;
                int yBlock = (int) yAxis;
                if (!blocked.blocked[xBlock][yBlock]) {
                    if (yBlock % 7 == 0 && xBlock % 15 == 0) {
                        Poison i = new Poison(xAxis * SIZE, yAxis * SIZE);
                        portalz.add(i);
                        //stuff1.add(h);
                        hostiles[xAxis][yAxis] = true;
                    }
                }
            }
        }

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int xBlock = (int) xAxis;
                int yBlock = (int) yAxis;
                if (!blocked.blocked[xBlock][yBlock]) {
                    if (xBlock % 9 == 0 && yBlock % 25 == 0) {
                        Health h = new Health(xAxis * SIZE, yAxis * SIZE);
                        //	stuff.add(i);
                        healthz.add(h);
                        hostiles[xAxis][yAxis] = true;
                    }
                }
            }
        }

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int xBlock = (int) xAxis;
                int yBlock = (int) yAxis;
                if (!blocked.blocked[xBlock][yBlock]) {
                    if (xBlock % 9 == 0 && yBlock % 10 == 0) {
                        Enemy h = new Enemy(xAxis * SIZE, yAxis * SIZE);
                        //	stuff.add(i);
                        enemyz.add(h);
                        hostiles[xAxis][yAxis] = true;
                    }
                }
            }
        }
        
            for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int xBlock = (int) xAxis;
                int yBlock = (int) yAxis;
                if (!blocked.blocked[xBlock][yBlock]) {
                    if (xBlock % 3 == 0 && yBlock % 30 == 0) {
                        Spikes h = new Spikes(xAxis * SIZE, yAxis * SIZE);
                        //	stuff.add(i);
                        spike.add(h);
                        hostiles[xAxis][yAxis] = true;
                    }
                }
            }
        }

        portal1 = new Poison(100, 100);
        portal = new Poison(450, 400);
        portalz.add(portal1);
        portalz.add(portal);

        //enemy = new Enemy(100, 100);
        enemy1 = new Enemy(1750, 1048);
        //enemyz.add(enemy);
        enemyz.add(enemy1);
        spike1 = new Spikes(100, 100);
        spike.add(spike1);

        health = new Health(100, 150);
        health1 = new Health(450, 100);
        healthz.add(health);
        healthz.add(health1);

        antidote = new itemwin(3004, 92);
        stuffwin.add(antidote);

        orb = new Orb((int) player.x + 10, (int) player.y - 10);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {

        camera.centerOn((int) player.x, (int) player.y);

        camera.drawMap();

        camera.translateGraphics();

		// it helps to add status reports to see what's going on
        // but it gets old quickly
        // System.out.println("Current X: " +player.x + " \n Current Y: "+ y);
        
        player.sprite.draw((int) player.x, (int) player.y);

        //g.drawString("x: " + (int) player.x + "  y: " + (int) player.y, player.x, player.y - 10);
        g.drawString("Health: " + player.health / 1000, camera.cameraX + 885,
                camera.cameraY);
        
        g.drawString("Score: " + player.health / 100 , camera.cameraX + 475, camera.cameraY + 0);
       

        g.drawString("Swiftness: " + (int) (player.speed * 10), camera.cameraX + 885,
                camera.cameraY + 15);

        //g.draw(player.rect);
        g.drawString("Time Passed: " + counter / 1000, camera.cameraX, camera.cameraY);

        g.drawString("Level: " + level, camera.cameraX, camera.cameraY + 15);
        // moveenemies();

        //g.draw(orb.hitbox);
        if (orb.isIsVisible()) {
            orb.orb.draw(orb.getX(), orb.getY());
        }

        for (Poison n : portalz) {
            if (n.isvisible) {
                n.currentImage.draw(n.x, n.y);
                // draw the hitbox
                //g.draw(i.hitbox);

            }
        }

        for (Enemy n : enemyz) {
            if (n.health < 1) {
                n.isvisible = false;
            }
            if (n.isvisible) {

                n.currentanime.draw(n.Bx, n.By);
                // draw the hitbox
                //g.draw(i.hitbox);

            }
        }
        
        for (Spikes s : spike) {
             if (s.isvisible) {
                s.currentImage.draw(s.x, s.y);
             }
         
        }

        for (Health h : healthz) {
            if (h.isvisible) {
                h.currentImage.draw(h.x, h.y);
                // draw the hitbox
                //g.draw(h.hitbox);

            }
        }

        for (itemwin w : stuffwin) {
            if (w.isvisible) {
                w.currentImage.draw(w.x, w.y);
                // draw the hitbox
                //g.draw(w.hitbox);

            }
        }

        if (orb.isIsVisible()) {
            orb.orb.draw(orb.getX(), orb.getY());
        }

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {

        Menu.music.play();
        
        counter += delta;

        Input input = gc.getInput();

        float fdelta = delta * player.speed;

        player.setpdelta(fdelta);

        double rightlimit = (grassMap.getWidth() * SIZE) - (SIZE * 0.75);

        // System.out.println("Right limit: " + rightlimit);
        float projectedright = player.x + fdelta + SIZE;

        boolean cangoright = projectedright < rightlimit;

        // there are two types of fixes. A kludge and a hack. This is a kludge.
        if (input.isKeyDown(Input.KEY_UP)) {

            orb.direction = 1;

            player.sprite = player.up;
            //moveenemies();
            float fdsc = (float) (fdelta - (SIZE * .15));

            if (!(isBlocked(player.x, player.y - fdelta) || isBlocked(
                    (float) (player.x + SIZE + 1.5), player.y - fdelta))) {

                player.sprite.update(delta);

                // The lower the delta the slower the sprite will animate.
                player.y -= fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_DOWN)) {

            orb.direction = 2;

            player.sprite = player.down;
            //     moveenemies();

            if (!isBlocked(player.x, player.y + SIZE + fdelta)
                    || !isBlocked(player.x + SIZE - 1, player.y + SIZE + fdelta)) {

                player.sprite.update(delta);

                player.y += fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_LEFT)) {

            orb.direction = 3;

            player.sprite = player.left;
            //      moveenemies();

            if (!(isBlocked(player.x - fdelta, player.y) || isBlocked(player.x
                    - fdelta, player.y + SIZE - 1))) {

                player.sprite.update(delta);

                player.x -= fdelta;

            }

        } else if (input.isKeyDown(Input.KEY_RIGHT)) {

            orb.direction = 4;

            player.sprite = player.right;
                      //  moveenemies();

            // the boolean-kludge-implementation
            if (cangoright
                    && (!(isBlocked(player.x + SIZE + fdelta,
                            player.y) || isBlocked(player.x + SIZE + fdelta, player.y
                            + SIZE - 1)))) {

                player.sprite.update(delta);

                player.x += fdelta;

            } // else { System.out.println("Right limit reached: " +
            // rightlimit);}

        } else if (input.isKeyPressed(Input.KEY_SPACE)) {

            Menu.sound.play();
            
            orb.settimeExists(25);
            orb.setX((int) player.x);
            orb.setY((int) player.y);
            orb.hitbox.setX(orb.getX());
            orb.hitbox.setY(orb.getY());
            orb.setIsVisible(!orb.isIsVisible());

        }
        player.rect.setLocation(player.getplayershitboxX(),
                player.getplayershitboxY());

        for (Enemy e : enemyz) {
            if (Math.abs(player.x - e.Bx) < 500) {
                e.move();
            }
        }

        for (Enemy e : enemyz) {

            if (orb.hitbox.intersects(e.rect)) {

                e.isvisible = false;

            }

        }

        if (orb.isIsVisible()) {

            if (orb.gettimeExists() > 0) {
                if (orb.getdirection() == 1) {
                    if (!(isBlocked(orb.getX(), orb.getY() - fdelta) || isBlocked((float) (orb.getX() + SIZE + 1.5), orb.getY() - fdelta))) {

                        orb.setX((int) player.x);
                        orb.setY((orb.getY() - 10));
                    }
                } else if (orb.getdirection() == 2) {
                    if (!isBlocked(orb.getX(), orb.getY() + SIZE + fdelta) || !isBlocked(orb.getX() + SIZE - 1, orb.getY() + SIZE + fdelta)) {

                        orb.setX((int) player.x);
                        orb.setY((orb.getY() + 10));
                    }
                } else if (orb.getdirection() == 3) {
                    if (!(isBlocked(orb.getX() - fdelta, orb.getY()) || isBlocked(orb.getX() - fdelta, orb.getY() + SIZE - 1))) {
                        orb.setX((orb.getX() - 10));
                        orb.setY(orb.getY());
                    }
                } else if (orb.getdirection() == 4) {
                    if (cangoright && (!(isBlocked(orb.getX() + SIZE + fdelta, orb.getY()) || isBlocked(orb.getX() + SIZE + fdelta, orb.getY()
                            + SIZE - 1)))) {

                        orb.setX((orb.getX() + 10));
                        orb.setY(orb.getY());
                    }
                }

                orb.hitbox.setX(orb.getX());
                orb.hitbox.setY(orb.getY());
                orb.countdown();

            } else {

                orb.setIsVisible(false);

            }

        }
        
      

        for (Enemy e : enemyz) {

            if (player.rect.intersects(e.rect)) {
                //System.out.println("yay");
                if (e.isvisible) {
                    player.health -= 500;
                    e.timeshit += 1;
                                    
                }
            }
        }
        
          for (Spikes s : spike) {

          if (player.rect.intersects(s.hitbox)) {
                //System.out.println("yay");
                if (s.isvisible) {
                    Menu.scream.play();
                    player.health -= 10000;
                    s.isvisible = false;
                }
                
            }
        }


        for (Poison p : portalz) {

            if (player.rect.intersects(p.hitbox)) {
                //System.out.println("yay");
                if (p.isvisible) {
                    Menu.scream.play();
                    player.health -= 10000;
                    p.isvisible = false;
                }

            }
        }

        for (Health h : healthz) {

            if (player.rect.intersects(h.hitbox)) {
                //System.out.println("yay");
                if (h.isvisible) {
                    
                    player.health += 10000;
                    h.isvisible = false;
                }

            }
        }

        for (itemwin w : stuffwin) {

            if (player.rect.intersects(w.hitbox)) {
                //System.out.println("yay");
                if (w.isvisible) {
                    w.isvisible = false;
                    makevisible();
                    player.x = 42;
                    player.y = 42;
                    sbg.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

                }

            }
        }

        //player.health -= counter/1000;
        if (player.health <= 0) {
            makevisible();
            Menu.scream.play();
            sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }

    }

    public void moveenemies() throws SlickException {
        for (Enemy n : enemyz) {
            n.move();
        }
    }

    public int getID() {

        return 1;

    }

    public void makevisible() {
        for (Health h : healthz) {

            h.isvisible = true;
        }

        for (Poison i : portalz) {

            i.isvisible = true;
        }
    }

    private boolean isBlocked(float tx, float ty) {

        int xBlock = (int) tx / SIZE;

        int yBlock = (int) ty / SIZE;

        return blocked.blocked[xBlock][yBlock];

        // this could make a better kludge
    }

}
