package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 * creates the default template for each level to build on . the class is declared
 * publicly so that the class can be called from other classes.
 */
public abstract class GameLevel extends World {
    private Ball player;
    private SoundClip gameMusic;
    
    /**
     *
     * @return
     */
    public Ball getPlayer() {
        return player;
    }
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     * @param game
     */
    public void populate(Game game) {
     
        player = new Ball(this);
        player.setPosition(startPosition());
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
    }
    
    /** The initial position of the player.
     * @return  */
    public abstract Vec2 startPosition();
    
    /** The position of the exit door.
     * @return  */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete?
     * @return  */
    public abstract boolean isCompleted();
}
