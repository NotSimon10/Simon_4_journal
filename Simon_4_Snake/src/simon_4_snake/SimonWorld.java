package simon_4_snake;


import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.geom.Rectangle;

public class SimonWorld {
    
    private List<Snake> pieces = new ArrayList<Snake>();
    private List<Food> nonMovers = new ArrayList<Food>();
    private Rectangle screen;
    private NumberDisplay score;
    
    public SimonWorld(Rectangle screen) {
        this.screen = screen;
        score = new NumberDisplay("Score");
    }

    public Rectangle getScreen() {
        return screen;
    }
    
    public void add(Food gp) {
        nonMovers.add(gp);
        if (gp instanceof Food) {
            nonMovers.add((Food) gp);
        }
    }
    
        public List<Snake> getAllPieces() {
        return pieces;
    }

  
        public NumberDisplay getScore(){
        return score;
    }
        
        public void detectCollisions() {
        for (Snake gp : getAllPieces()) {
            gp.collide(getIntersectingPieces(gp));
        }
        }
        
        public boolean doTheyIntersect(Snake a, Snake b) {
        return a.getRect().intersects(b.getRect());
    }
        
        public List<Snake> getIntersectingPieces(Snake thing) {
        ArrayList<Snake> objs = new ArrayList<Snake>();
        for (Snake gp : getAllPieces()) {
            if (gp != thing && thing.getRect().intersects(gp.getRect())) {
                objs.add(gp);
            }
        }
        return objs;
    }

        public List<Snake> getMovers() {
        return pieces;
    }
        
}
