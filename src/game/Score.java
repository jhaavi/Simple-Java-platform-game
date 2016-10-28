package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;

/**
 * extended view
 */
public class Score extends UserView {
    Ball bird;
    
    
    
    public Score(World world, Ball bird, int width, int height) {
        super(world, width, height);
        this.bird = bird;
        
    }
    
   public void setPlayer(Ball bird){
       this.bird = bird;
       
   }

    
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString("Score: " + bird.getOrangeCount(), 10, 20);
        
        
    }
}
