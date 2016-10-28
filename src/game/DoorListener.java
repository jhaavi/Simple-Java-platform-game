package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class DoorListener implements CollisionListener {
    private Game game;
    private GameWorld3 gameworld;
    private SoundClip gameMusic;
    
    /**
     *
     * @param game
     */
    public DoorListener(Game game) {
        this.game = game;
    }

    /**
     *this method checks if all the hearts have been collected and calls the level up
     * method if the player touches the level up icon
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        Ball player = game.getPlayer();
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            try {
                gameMusic = new SoundClip("data/levelup.wav");   // Open an audio input stream
                gameMusic.play();  // Set it to continous playback (looping)
                //gameMusic.setVolume(0);
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException f) {
                System.out.println(f);
            } 
            

            
            game.goNextLevel();
            

        }
    }
}
