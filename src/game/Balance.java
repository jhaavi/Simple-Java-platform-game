package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 *
 * @author greg
 */


/**
 * this is the declaration of the public Balance class. the class creates a
 * moving platform. it is declared publicly so that the class can be accessed
 * from other classes. it extends dynamic body as i require the balance beam to move.
 */
public class Balance extends DynamicBody {
    
    private static final Shape shape = new BoxShape(0.5f,7f);
    
    /**
     *
     * @param world
     */
    public Balance(World world) {
        
        super(world, shape);
        
        //setFillColor(Color.orange);
    }
}
