package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author greg
 */

/**
 * A world with some bodies.
 */
public class GameWorld extends GameLevel implements ActionListener {
    
    private Ball bird;
    private Background background;
    private Balance balance;
    private Star star;
    private Instruction instruction;
    private static final int NUM_ORANGES = 6;
    private Score2 score2;
    private SoundClip gameMusic;
    private Timer timer;
    private static final int fuelCount = 8;
    private int time;
    
    
    public void populate(Game game) {
        super.populate(game);
        time = 300000;
        timer = new Timer(time, this);
        timer.setInitialDelay(300000);
        timer.start();
      
            
        
        
        System.out.println(time);
        
        { // make the ground
            try {
                gameMusic = new SoundClip("data/main.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
                gameMusic.setVolume(0.2f);
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }            
            Shape shape = new BoxShape(40, 0.5f);
            Body ground = new StaticBody(this, shape);
            ground.setPosition(new Vec2(0, -17.5f));
            ground.setFillColor(Color.black);
          
        }
        {
                 
            
//            timer = new Timer(1000, this);
//            timer.setInitialDelay(100); 
//            timer.start();
        }
        {
            Shape leftWallShape = new BoxShape(0.5f, 20);
            Body sides = new StaticBody(this, leftWallShape);
            sides.setFillColor(Color.black);
            sides.setPosition(new Vec2(-30.5f,0));
        }
        {
            
            Shape rightWallShape = new BoxShape(0.5f, 20);
            Body sides = new StaticBody(this, rightWallShape);
            sides.setFillColor(Color.black);
            sides.setPosition(new Vec2(30.5f, 0));
       
        }

        { // make platforms
            Shape shape = new BoxShape(6, 0.5f);
            Body platform1 = new StaticBody(this, shape);
            platform1.setPosition(new Vec2(-11, 2f));
            platform1.setFillColor(Color.black);
                      
            Body platform2 = new StaticBody(this, shape);
            platform2.setPosition(new Vec2(8, -4f));
            platform2.setFillColor(Color.BLACK);
            
            Body platform3 = new StaticBody(this,shape);
            platform3.setFillColor(Color.black);
            platform3.setPosition(new Vec2(28,2f));
            
            Body platform4 = new StaticBody(this,shape);
            platform4.setFillColor(Color.black);
            platform4.setPosition(new Vec2(-34,-5));
            
            
        }
        

        
        {
            Shape shape = new BoxShape(4, 10f);
            Body step = new StaticBody(this,shape);
            step.setFillColor(Color.black);
            step.setPosition(new Vec2(-27,-20f));
            
            Body step1 = new StaticBody(this,shape);
            step1.setFillColor(Color.black);
            step1.setPosition(new Vec2(26,-20f));
        }
        

        
  


//        { // make a character
//            bird = new Ball(this);
//            bird.setPosition(new Vec2(0, -6));
//            
//                
//        }

        
        {
            for (int i = 0; i < 11; i++) {
                Body orange = new Orange(this);
                orange.setPosition(new Vec2(i*8-10, 8));
                orange.addCollisionListener(new Pickup(getPlayer()));
                
            }
        }
        

        
        {
            

            Body death = new Ghost1(this);
            death.setPosition(new Vec2(-12,-17 ));            
            death.addCollisionListener(new LiveDown(getPlayer()));
            
                        
            Body death1 = new Ghost2(this);
            death1.setPosition(new Vec2(7f, 0));
            death1.addCollisionListener(new LiveDown(getPlayer()));
            
            Body death2 = new Ghost3(this);
            death2.setPosition(new Vec2(12, -17));
            death2.addCollisionListener(new LiveDown(getPlayer()));
            
              
//            Body star = new Star(this);
//            star.setPosition(new Vec2(0,12.5f));
//            star.addCollisionListener(new StarEnd(getPlayer()));
           
        }
            
            
            
        
        {
            balance= new Balance(this);
            balance.setPosition(new Vec2(0,9));
            balance.setFillColor(Color.black);
            balance.setAngleDegrees(90);
        }
        {
            Shape shape = new CircleShape(1);
            Body c1 = new StaticBody(this,shape);
            c1.setPosition(new Vec2(0,8));
            c1.setFillColor(Color.black);
        }
        
        
        
    
//        {
//            Body death4 = new Ghost2(this);
//            death4.setPosition(new Vec2(10, 15));
//            death4.addCollisionListener(new Die(bird));
//        }
//        
        {
//            Body death5 = new Ghost3(this);
//            death5.setPosition(new Vec2(10, 15));
//            death5.addCollisionListener(new Die(bird));
        }
        {
            instruction = new Instruction(this);
            instruction.setPosition(new Vec2(-20,10));
        }
//        {
//            score2 = new Score2(this);
//            score2.setPosition(new Vec2(0,0)); 
//        }
        

        
        {
            
            background = new Background(this);
            background.setPosition(new Vec2(0,0));
        }
        
   
    }
    
//    public Ball getPlayer() {
//        return bird;
//    }

    /**
     *
     * @param ae
     */
    
    public void actionPerformed(ActionEvent ae){
        System.exit(0);
    }
    
    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(0, 0);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getOrangeCount() == NUM_ORANGES;
    }
}
