package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * this is the declaration of the Controller class. this class creates all the controls
 * for the player. it sets the speed of the players movements. it is declared publicly
 * so that the class can be accessed
 * from other classes. 
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 14;
    private static final float WALKING_SPEED = 7;
    
    private Walker body;
    private SoundClip gameMusic;
    
    /**
     *
     * @param body
     */
    public Controller(Walker body) {
        this.body = body;
    }
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { // J = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
                try {
                    gameMusic = new SoundClip("data/jump.wav");   // Open an audio input stream
                    gameMusic.play();  // Set it to continous playback (looping)
                //gameMusic.setVolume(0);
                } catch (UnsupportedAudioFileException|IOException|LineUnavailableException g) {
                    System.out.println(g);
                } 
            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.startWalking(-WALKING_SPEED); // 1 = walk left
            
        } else if (code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // 2 = walk right
        }
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
        }
    }
    
    /**
     *
     * @param body
     */
    public void setBody(Walker body) {
        this.body = body;
    }
}
