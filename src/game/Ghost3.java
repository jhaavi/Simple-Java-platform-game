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
public class Ghost3 extends DynamicBody {
    private static final Shape shape = new PolygonShape(-0.5f*2.5f,-0.497f*2.5f, -0.5f*2.5f,0.105f*2.5f,
            -0.14f*2.5f,0.496f*2.5f, 0.153f*2.5f,0.495f*2.5f, 0.489f*2.5f,0.067f*2.5f, 0.492f*2.5f,-0.495f*2.5f);
    
    private static final BodyImage image = new BodyImage("data/ghost3.gif", 2.5f);
    
    public Ghost3 (World world) {
        
        super(world, shape);
        addImage(image);
        //setFillColor(Color.black);
    }
}
