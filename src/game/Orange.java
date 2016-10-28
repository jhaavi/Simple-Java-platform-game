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
public class Orange extends DynamicBody {
    private static final Shape shape = new PolygonShape(-0.014f,-0.434f, -0.458f,0.06f,
            -0.46f,0.314f, -0.142f,0.384f, 0.418f,0.366f, 0.416f,-0.084f, 0.178f,-0.306f);
    
    private static final BodyImage image = new BodyImage("data/heart.gif", 1f);
    
    public Orange(World world) {
        
        super(world, shape);
        addImage(image);
        //setFillColor(Color.orange);
    }
}
