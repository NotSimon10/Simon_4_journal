package simon_4_snake;

import java.util.List;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public abstract class Snake {    

    private Image snake;
    private int x, y;
    protected SimonWorld s;
    
      public Snake(Image snake, int x, int y, SimonWorld sw) {
        this.snake = snake;
        this.x = x;
        this.y = y;
        this.s = sw;
        
      }
        
      public Snake(Image snake, SimonWorld gw) {
        this(gw);
        this.snake = snake;
    }

    public Snake(int x, int y, SimonWorld sw) {
        this.x = x;
        this.y = y;
        this.s = sw;
        setImage("res/square.png");
    }

    public Snake(SimonWorld sw) {
        this((int)(Math.random()* sw.getScreen().getWidth()),(int)(Math.random()* sw.getScreen().getHeight()),sw);
        setImage("res/square.png");
    }
    

 public Image getImage() {
        return snake;
    }

    public void setImage(Image i) {
        snake = i;
    }
    public void setImage(String file){
        try{
            setImage(new Image(file));
        }
        catch(Exception e){System.out.println("file not valid");}
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return snake.getWidth();
    }

    public int getHeight() {
        return snake.getHeight();
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, getWidth(), getHeight());
    }

    public abstract void collide(List<Snake> objects);
    
    public abstract void move();

    public abstract void checkEdge();


}


