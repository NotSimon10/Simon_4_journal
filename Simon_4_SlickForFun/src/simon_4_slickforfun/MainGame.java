package simon_4_slickforfun;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainGame extends BasicGameState {

    public static MovingPiece MovingPieces;
    
    public static int counter = 0;
    
    private static final int SIZE = 64;
   
    public ArrayList<MovingPiece> piece = new ArrayList();
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        MovingPieces = new MovingPiece(100, 100);
        piece.add(MovingPieces);
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        
        g.setBackground(Color.magenta);
        g.draw(MovingPiece.rect);
       
         for (MovingPiece p : piece) {
            if (p.isvisible) {
                p.currentImage.draw(p.x, p.y);
        }
        }
        }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        
            Input input = gc.getInput();
            
            counter += delta;
            
            float fdelta = delta * MovingPiece.speed;

               if(input.isKeyDown(Input.KEY_UP)) {
                    
                float fdsc = (float) (fdelta - (SIZE * .15));

                MovingPiece.y -= fdelta;
               
               }
               
               if(input.isKeyDown(Input.KEY_DOWN)) {

                MovingPiece.y += fdelta;
               
               }
               
               if(input.isKeyDown(Input.KEY_LEFT)) {

                MovingPiece.x -= fdelta;
               
               }
               
               if(input.isKeyDown(Input.KEY_RIGHT)) {

                MovingPiece.x += fdelta;
               
               }
               
                MovingPiece.rect.setLocation(MovingPiece.getMovingPieceshitboxX(),
                MovingPiece.getMovingPieceshitboxY());
        
             for (MovingPiece p : piece) {

                 }
                 }
        
    @Override
    public int getID() {
        return 1;
    }
    
    
    MainGame(int xSize, int ySize) {
        
    }
    
}
