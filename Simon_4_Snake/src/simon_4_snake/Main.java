package simon_4_snake;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Main extends BasicGame {
    public Food food;
    public ArrayList<Food> foodz = new ArrayList();
    
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    private final int a = 10;
    public static SimonWorld sw;
    
    Food[] pellets = new Food[300];
    int current = 0;

    public Main(String title) {
        super(title);
    }

    public static void main(String[] args) {
        start();
    }

    public static void start() {

        try {
            AppGameContainer game = new AppGameContainer(new Main("Simon Snake"));
            game.setMaximumLogicUpdateInterval(60);
            game.setDisplayMode(Main.WIDTH, Main.HEIGHT, false);
            game.setTargetFrameRate(60);
            game.setAlwaysRender(true);
            game.setVSync(true);
            game.setShowFPS(false);
            game.start();
        } catch (SlickException e) {
        }
    }

   
    public void init(GameContainer gc) throws SlickException {
       
        sw = new SimonWorld( new Rectangle(0, 0, Main.WIDTH, Main.HEIGHT));
        food = new Food(200, 20);
        foodz.add(food);
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        
        try {
            changeBackground(g);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Snake go: sw.getAllPieces())
            go.getImage().draw(go.getX(), go.getY());
        g.setWorldClip(sw.getScreen());
        
        sw.getScore().render(g);
        
        
        for (Food n : foodz) {
            if (n.isvisible) {
                n.currentImage.draw(n.x, n.y);
        
        
    }
    }
    }

    public void update(GameContainer gc, int delta) throws SlickException {
         for(Snake mover: sw.getMovers())
                {
                    mover.move();
                    mover.checkEdge();
                }
                
                sw.detectCollisions();
    }
    
    public void changeBackground(Graphics g) throws SlickException, InterruptedException{
    Thread.sleep(500);
    g.setBackground(new org.newdawn.slick.Color(255, 179, 179));
    Thread.sleep(500);
    g.setBackground(new org.newdawn.slick.Color(255, 179, 179));
}
}
