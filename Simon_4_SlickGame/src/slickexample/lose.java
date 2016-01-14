package slickexample;


import org.newdawn.slick.Color;
import org.newdawn.slick.Image;


import org.newdawn.slick.Game;


import org.newdawn.slick.GameContainer;


import org.newdawn.slick.Graphics;


import org.newdawn.slick.Input;


import org.newdawn.slick.SlickException;


import org.newdawn.slick.state.BasicGameState;


import org.newdawn.slick.state.StateBasedGame;


import org.newdawn.slick.state.transition.FadeInTransition;


import org.newdawn.slick.state.transition.FadeOutTransition;



public class lose extends BasicGameState {


    


    private StateBasedGame game;
    public Image startimage;

    


     public lose(int xSize, int ySize) {



    }



    


    public void init(GameContainer container, StateBasedGame game)


            throws SlickException {
    	startimage = new Image("res/LossScreen.png");


        this.game = game;



// TODO AutoÃ¢â‚¬Âgenerated method stub


    }



   


    public void render(GameContainer container, StateBasedGame game, Graphics g)


            throws SlickException {
    	
    	startimage.draw();



// TODO AutoÃ¢â‚¬Âgenerated method stub


        g.setColor(Color.white);


        //g.drawString("You LOSE!", 450, 200);
        g.drawString("press 1 to try again", 400, 320);


       


    }



    


    public void update(GameContainer container, StateBasedGame game, int delta)


            throws SlickException {


// TODO AutoÃ¢â‚¬Âgenerated method stub


    }



  


    public int getID() {


// TODO AutoÃ¢â‚¬Âgenerated method stub


        return 2;


    }



    @Override


    public void keyReleased(int key, char c) {


        switch (key) {


            case Input.KEY_1:

                player.health  = 100000;
                player.speed = .4f;
                Unwavering.counter = 0;
                itemwin.isvisible = true;
                player.x = 96f;
                player.y = 228f;
                //redo potions and reset cordinates of player
                game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));


                break;


            case Input.KEY_2:


// TODO: Implement later


                break;


            case Input.KEY_3:


// TODO: Implement later


                break;


            default:


                break;


        }


    }


}

