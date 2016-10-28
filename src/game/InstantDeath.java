package game;

import city.cs.engine.*;
import java.awt.Color;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Collision listener that allows the bird to collect things.
 */
public class InstantDeath implements CollisionListener {
    private Ball bird;
    private SoundClip gameMusic;
    
    public InstantDeath(Ball bird) {
        this.bird = bird;
    }

    @Override
    public void collide(CollisionEvent d) {
        if (d.getOtherBody() == bird) {
            //death.incrementOrangeCount();
            //bird.destroy();
//            try {
//                gameMusic = new SoundClip("data/die.wav");   // Open an audio input stream
//                gameMusic.loop();  // Set it to continous playback (looping)
//            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
//                System.out.println(e);
//            }            
            System.out.println("Instant Death!! You Lose.");
            System.exit(0);
            
            //d.getReportingBody().setFillColor(Color.white);
            
        }
    }
    
}
