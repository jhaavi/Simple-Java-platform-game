package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 *
 * @author greg
 */


/**
 * An orange.
 */
public class Ghost1 extends Walker {
    private static final Shape shape = new PolygonShape(0.448f*3,-0.474f*3, 0.449f*3,0.202f*3,
            0.116f*3,0.458f*3, -0.128f*3,0.452f*3, -0.461f*3,0.04f*3, -0.462f*3,-0.449f*3, -0.005f*3,-0.464f*3);
    
    
    private static final BodyImage image = new BodyImage("data/ghost1.gif", 3f);
    
    /**
     *
     * @param world
     */
    public Ghost1 (World world) {
        
        super(world, shape);
        addImage(image);
        
        //setFillColor(Color.black);
    }
}
