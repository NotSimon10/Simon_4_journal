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

public class Menu extends BasicGameState {

    private StateBasedGame game;

    public Image startimage;

    public Menu(int xSize, int ySize) {

    }

    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {

        startimage = new Image("res/menu.png");

        this.game = game;

// TODO AutoÃ¢â‚¬Âgenerated method stub
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {

// TODO AutoÃ¢â‚¬Âgenerated method stub
        g.setColor(Color.white);

        startimage.draw();

        //g.drawString("stuff", 300, 200);
        //g.drawString("collect the antidote before time runs out! red potions are health and yellow potions make you run faster", 50, 300);
        //g.drawString("1. Play Game", 50, 100);
        //g.drawString("2. High Scores(", 50, 120);
        //g.drawString("3. Quit", 50, 140);
    }

    public void update(GameContainer container, StateBasedGame game, int delta)
            throws SlickException {

// TODO AutoÃ¢â‚¬Âgenerated method stub
    }

    public int getID() {

// TODO AutoÃ¢â‚¬Âgenerated method stub
        return 0;

    }

    @Override

    public void keyReleased(int key, char c) {

        switch (key) {

            case Input.KEY_1:

                game.enterState(1, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

                break;

            case Input.KEY_2:

                game.enterState(4, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

// TODO: Implement later
                break;

            case Input.KEY_3:
                
                game.enterState(5, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

// TODO: Implement later
                break;

            default:

                break;

        }

    }

}
