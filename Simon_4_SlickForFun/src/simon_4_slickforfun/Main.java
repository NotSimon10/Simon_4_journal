package simon_4_slickforfun;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {
    
    public static final int xSize = 1000;
    
    public static final int ySize = 750;
    
    public Main() {
        super("NotSimon's Snake Game");
    }
    
    public static void main(String [] args) throws SlickException {
        AppGameContainer agc = new AppGameContainer(new Main());
        agc.setDisplayMode(xSize, ySize, false);
        agc.start();
        int MaxFPS = 60;
        agc.setTargetFrameRate(MaxFPS);
        agc.setTargetFrameRate(60);  
    
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new Menu(xSize, ySize));
        
        this.addState(new MainGame(xSize, ySize));
        
        this.enterState(0);
    }
    
    public void enter(GameContainer gc, StateBasedGame sbg) {
        System.out.println("Entering State!");
    }
    
    public void leave(GameContainer gc, StateBasedGame sbg) {
        System.out.println("Leaving State!");
    }
    
}
