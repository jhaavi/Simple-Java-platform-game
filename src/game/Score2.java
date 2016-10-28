package game;

import city.cs.engine.*;
import java.awt.Graphics2D;
import org.jbox2d.common.Vec2;

/**
 * Simple character
 */
public class Score2 extends StaticBody {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.
    public static Shape shape = new BoxShape(0,-100);
    private Ball bird;

    //public static BodyImage image = new BodyImage("data/background.gif", 40);
    
    public Score2(World world) {
        
        
        
        super(world);
        //GhostlyFixture gf = new GhostlyFixture(this,shape);
        //this.setGravityScale(0);
        
 
        
    }
    
   
    protected void paintForeground(Graphics2D g) {
        g.drawString("Score: " + bird.getOrangeCount(), 10, 20);
        
    }

    

    

    

  
}
