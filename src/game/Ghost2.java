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
public class Ghost2 extends DynamicBody {
    private static final Shape shape = new PolygonShape(-0.46f*3,-0.449f*3, 0.452f*3,-0.443f*3, 
            0.441f*3,0.09f*3, 0.129f*3,0.449f*3, -0.155f*3,0.447f*3, -0.462f*3,0.052f*3, -0.462f*3,-0.297f*3);
    
    private static final BodyImage image = new BodyImage("data/ghost2.gif", 3f);
    
    public Ghost2 (World world) {
        
        super(world, shape);
        addImage(image);
        //setFillColor(Color.black);
    }
}
