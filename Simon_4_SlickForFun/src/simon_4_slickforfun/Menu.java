
package simon_4_slickforfun;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

    public Image startimage;
    
    public static Music startmusic;
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
        startimage = new Image("res/Menu.png");
        startmusic = new Music("res/Music.wav");
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        
        startimage.draw();
        
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
      
    }
    
    @Override
    public int getID() {
        return 0;
    }
    
    Menu(int xSize, int ySize) {
        
    }
    
}
