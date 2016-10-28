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
public class Star extends DynamicBody {
    private static final Shape shape = new PolygonShape(-0.008f*3,0.474f*3, -0.274f*3,-0.016f*3, 
            -0.318f*3,-0.452f*3, 0.334f*3,-0.438f*3, 0.288f*3,0.04f*3);
    
    private static final BodyImage image = new BodyImage("data/star.gif", 3f);
    
    public Star (World world) {
        
        super(world, shape);
        addImage(image);
        //setFillColor(Color.black);
    }
}
