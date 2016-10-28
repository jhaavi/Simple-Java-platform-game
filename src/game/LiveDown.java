package game;

import city.cs.engine.*;
import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Collision listener that allows the bird to collect things.
 */
public class LiveDown implements CollisionListener {
    private Ball bird;
    private SoundClip gameMusic;
    
    public LiveDown(Ball bird) {
        this.bird = bird;
    }

    @Override
    public void collide(CollisionEvent d) {
        if (d.getOtherBody() == bird) {
            //death.incrementOrangeCount();
            //bird.destroy();
            try {
                gameMusic = new SoundClip("data/die.wav");   // Open an audio input stream
                gameMusic.play();  // Set it to continous playback (looping)
                //gameMusic.setVolume(0);
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }             
            bird.decreaseLives();
            //d.getReportingBody().setFillColor(Color.white);
            
        }
    }
    
}
