package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    private Ball bird;
    private SoundClip gameMusic;
    
    public Pickup(Ball bird) {
        this.bird = bird;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == bird) {
            try {
                gameMusic = new SoundClip("data/pickup.wav");   // Open an audio input stream
                gameMusic.play();  // Set it to continous playback (looping)
                //gameMusic.setVolume(0);
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException f) {
                System.out.println(f);
            }             
            bird.incrementOrangeCount();
            e.getReportingBody().destroy();
            
        }
    }
    
}
