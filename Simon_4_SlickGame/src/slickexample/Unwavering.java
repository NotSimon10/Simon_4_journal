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

	itemwin (int a, int b) throws SlickException {
		this.x = a;
		this.y = b;
		this.hitbox = new Rectangle(a, b, 32, 32);// 64 is the width of the item
		this.currentImage = antidote;

	}

}

class player {

	public static float x = 96f;

	public static float y = 228f;

	public static int health = 100000;
	
	public static float speed = .4f;

	static float hitboxX = x + 8f;

	static float hitboxY = y + 8f;

	private static int startX, startY, width = 30, height = 42;

	public static Shape rect = new Rectangle(getplayershitboxX(),
			getplayershitboxY(), width, height);

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

public class Unwavering extends BasicGameState {

	
	public Poison portal, portal1;
	public Health health, health1;
	public itemwin antidote;
        public Enemy enemy;

	public ArrayList<Poison> portalz = new ArrayList();

	public ArrayList<Health> healthz = new ArrayList();
	
	public ArrayList<itemwin> stuffwin = new ArrayList();
        
        public ArrayList<Enemy> enemyz = new ArrayList();

	private boolean[][] hostiles;

	private static TiledMap grassMap;

	private static AppGameContainer app;

	private static Camera camera;
	
	public static int counter = 0;

	// Player stuff

	private Animation sprite, up, down, left, right, wait;

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

	public Unwavering(int xSize, int ySize) {

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

		// Player stuff --- these things should probably be chunked into methods
		// and classes

		// *********************************************************************************

		SpriteSheet runningSS = new SpriteSheet(
				"res/hsprite.png",64, 64, 0);

		// System.out.println("Horizontal count: "
		// +runningSS.getHorizontalCount());

		// System.out.println("Vertical count: " +runningSS.getVerticalCount());

		up = new Animation();

		up.setAutoUpdate(true);

		up.addFrame(runningSS.getSprite(0, 8), 330);

		up.addFrame(runningSS.getSprite(1, 8), 330);

		up.addFrame(runningSS.getSprite(2, 8), 330);

		up.addFrame(runningSS.getSprite(3, 8), 330);

		up.addFrame(runningSS.getSprite(4, 8), 330);

		up.addFrame(runningSS.getSprite(5, 8), 330);

		up.addFrame(runningSS.getSprite(6, 8), 330);

		up.addFrame(runningSS.getSprite(7, 8), 330);

		up.addFrame(runningSS.getSprite(8, 8), 330);

		down = new Animation();

		down.setAutoUpdate(false);

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

				String value = grassMap.getTileProperty(tileID,	"blocked", "false");

				if ("true".equals(value)) {

					System.out.println("The tile at x " + xAxis + " andy axis "
							+ yAxis + " is blocked.");

					blocked.blocked[xAxis][yAxis] = true;

				}

			}

		}

		System.out.println("Array length" + blocked.blocked[0].length);

		// A remarkably similar process for finding hostiles

		hostiles = new boolean[grassMap.getWidth()][grassMap.getHeight()];

		for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
			for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
				int xBlock = (int) xAxis;
				int yBlock = (int) yAxis;
				if (!blocked.blocked[xBlock][yBlock]) {
					if (yBlock % 7 == 0 && xBlock % 15 == 0 ) {
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
					if (xBlock % 9 == 0	&& yBlock % 25 == 0) {
						Health h = new Health(xAxis * SIZE, yAxis * SIZE);
					//	stuff.add(i);
						healthz.add(h);
						hostiles[xAxis][yAxis] = true;
					}
				}
			}
		}

		portal1 = new Poison(100, 100);
                portal = new Poison(450, 400);
		portalz.add(portal1);
		portalz.add(portal);
                
                enemy = new Enemy(100,100);
                enemyz.add(enemy);
		
		health = new Health(100,150);
		health1 = new Health(450,100);	
		healthz.add(health);
		healthz.add(health1);
		
		antidote = new itemwin(3004,92);
		stuffwin.add(antidote);
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
		
		g.drawString("x: " + (int)player.x + "  y: " +(int)player.y , player.x, player.y - 10);

		g.drawString("Health: " + player.health/1000, camera.cameraX + 10,
				camera.cameraY + 10);
		
		g.drawString("speed: " + (int)(player.speed *10), camera.cameraX + 10,
				camera.cameraY + 25);

		//g.draw(player.rect);

		g.drawString("time passed: " +counter/1000, camera.cameraX +600,camera.cameraY );
		// moveenemies();

		for (Poison n : portalz) {
			if (n.isvisible) {
				n.currentImage.draw(n.x, n.y);
				// draw the hitbox
				//g.draw(i.hitbox);

			}
		}
                
                for (Enemy n : enemyz) {
                                if (n.isvisible) {
                                    
				n.currentanime.draw(n.Bx, n.By);
				// draw the hitbox
				//g.draw(i.hitbox);

			}
                }
		
		
		for (Health h : healthz) {
			if (h.isvisible) {
				h.currentImage.draw(h.x, h.y);
				// draw the hitbox
				//g.draw(h.hitbox);

			}
		}
		
		for (itemwin w: stuffwin) {
			if (w.isvisible) {
				w.currentImage.draw(w.x, w.y);
				// draw the hitbox
				//g.draw(w.hitbox);

			}
		}

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)

	throws SlickException {
		
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
                        
			sprite = up;
                           moveenemies();
			float fdsc = (float) (fdelta - (SIZE * .15));

			if (!(isBlocked(player.x, player.y - fdelta) || isBlocked(
					(float) (player.x + SIZE + 1.5), player.y - fdelta))) {

				sprite.update(delta);

				// The lower the delta the slower the sprite will animate.

				player.y -= fdelta;

			}

		} else if (input.isKeyDown(Input.KEY_DOWN)) {

			sprite = down;
                        moveenemies();

			if (!isBlocked(player.x, player.y + SIZE + fdelta)

			|| !isBlocked(player.x + SIZE - 1, player.y + SIZE + fdelta)) {

				sprite.update(delta);

				player.y += fdelta;

			}

		} else if (input.isKeyDown(Input.KEY_LEFT)) {

			sprite = left;
                        moveenemies();

			if (!(isBlocked(player.x - fdelta, player.y) || isBlocked(player.x

			- fdelta, player.y + SIZE - 1))) {

				sprite.update(delta);

				player.x -= fdelta;

			}

		} else if (input.isKeyDown(Input.KEY_RIGHT)) {

			sprite = right;
                        moveenemies();

			// the boolean-kludge-implementation

			if (cangoright
					&& (!(isBlocked(player.x + SIZE + fdelta,

					player.y) || isBlocked(player.x + SIZE + fdelta, player.y
							+ SIZE - 1)))) {

				sprite.update(delta);

				player.x += fdelta;

			} // else { System.out.println("Right limit reached: " +
				// rightlimit);}

		}

		player.rect.setLocation(player.getplayershitboxX(),
				player.getplayershitboxY());

		for (Enemy e : enemyz) {

			if (player.rect.intersects(e.rect)) {
				//System.out.println("yay");
				if (e.isvisible) {

					player.health -= 10000;
                                        e.timeshit+=1;
                                        if(e.timeshit > 2) {
                                            
                                        
                                      
					e.isvisible = false;
				}
                        }
                }
                }
                
                        
                for (Poison p : portalz) {

			if (player.rect.intersects(p.hitbox)) {
				//System.out.println("yay");
				if (p.isvisible) {

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
					sbg.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
					
				}

			}
		}
		 
		player.health -= counter/1000;
		if(player.health <= 0){
			makevisible();
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

	public void makevisible(){
		for (Health h : healthz) {
			
		h.isvisible = true;}
		
		for (Poison i : portalz) {
			
			i.isvisible = true;}
		}
	
	private boolean isBlocked(float tx, float ty) {

		int xBlock = (int) tx / SIZE;

		int yBlock = (int) ty / SIZE;

		return blocked.blocked[xBlock][yBlock];

		// this could make a better kludge

	}

}
