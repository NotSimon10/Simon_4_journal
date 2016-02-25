package simon_4_snake;

import org.newdawn.slick.Graphics;

public class NumberDisplay  {
   
    private String label;
    private int value;
    
    private int offset = 0;
    public NumberDisplay(String label, int value) {
        this.label = label;
        this.value = value;
        offset = label.length()*8+5;
    }

    public NumberDisplay(String label) {
        this(label, 0);

    }
    public void increase(){
        value++;
    }
    public void increase(int amount){
        value+=amount;
    } 
    
   
    
    public void render(Graphics g){
    g.drawString(label, 10, 10);
    g.drawString(": "+ value, offset, 10);
}
}