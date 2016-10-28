package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * this is the declaration of the public Background2 class. this class provides the background
 * image for level one of the game. it is declared publicly so that the class can be accessed
 * from other classes. it extends static body as i require the background to stay in one position
 * and not be affected by gravity.
 */
public class Background2 extends StaticBody {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.

    /**
     *this creates a shape that the image sits on. a shape of type Shape is created. The co-ordinate of the shape is set to somewhere
     * off the game screen so that the box doesn't come into contact with player.
     */
    public static Shape shape = new BoxShape(0,-100);

    /**
     *this line creates a image of type BodyImage and states where the image can be found as well as the size/scale of the image
     */
    public static BodyImage image = new BodyImage("data/background2.gif", 40);
    
    /**
     *
     * @param world
     */
    public Background2(World world) {
        
        
        
        super(world, shape);
        //GhostlyFixture gf = new GhostlyFixture(this,shape);
        //this.setGravityScale(0);
        addImage(image);
 
        
    }

    

    

    

  
}

