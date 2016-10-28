package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Simple character
 */
public class Instruction extends StaticBody {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.
    public static Shape shape = new BoxShape(0,-1);

    public static BodyImage image = new BodyImage("data/sign.gif", 12);
    
    public Instruction(World world) {
        
        
        
        super(world, shape);
        //GhostlyFixture gf = new GhostlyFixture(this,shape);
        //this.setGravityScale(0);
        addImage(image);
 
        
    }

    

    

    

  
}
