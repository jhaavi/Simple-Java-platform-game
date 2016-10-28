package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 *
 * @author greg
 */


/**
 * this is the declaration of the public Boss class. the class creates the
 * boss for the final level of the game. it is declared publicly so that the class can be accessed
 * from other classes. 
 */
public class Boss extends Walker {
    private static final Shape shape = new PolygonShape(-0.384f*12,-0.408f*12, 0.396f*12,-0.397f*12, 
            0.384f*12,0.047f*12, 0.105f*12,0.371f*12, -0.148f*12,0.364f*12, -0.385f*12,-0.041f*12);
    
    
    private static final BodyImage image = new BodyImage("data/boss.gif", 12f);
    
    /**
     *
     * @param world
     */
    public Boss (World world) {
        
        super(world, shape);
        addImage(image);
        
        //setFillColor(Color.black);
    }
}
