package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.Color;

/**
 *
 * @author greg
 */

/**
 * A world with some bodies.
 */
public class GameWorld4 extends GameLevel {
    
    private Ball bird;
    private Background4 background;
    private Balance balance;
    private Star star;
    private Instruction instruction;
    private static final int NUM_ORANGES = 6;
    
    
    public void populate(Game game) {
        super.populate(game);
        
        { // make the ground
            Shape shape = new BoxShape(40, 0.5f);
            Body ground = new StaticBody(this, shape);
            ground.setPosition(new Vec2(0, -17.5f));
            ground.setFillColor(Color.black);
          
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
            platform1.setPosition(new Vec2(-18, 2f));
            platform1.setFillColor(Color.black);
                      
            Body platform2 = new StaticBody(this, shape);
            platform2.setPosition(new Vec2(16, -4f));
            platform2.setFillColor(Color.BLACK);
            
            Body platform3 = new StaticBody(this,shape);
            platform3.setFillColor(Color.black);
            platform3.setPosition(new Vec2(20,2f));
            
            Body platform4 = new StaticBody(this,shape);
            platform4.setFillColor(Color.black);
            platform4.setPosition(new Vec2(-18,-5));
            
        }
        

        
        {
            Shape shape = new BoxShape(4, 10f);
            Body step = new StaticBody(this,shape);
            step.setFillColor(Color.black);
            step.setPosition(new Vec2(-27,-20f));
            
            Body step1 = new StaticBody(this,shape);
            step1.setFillColor(Color.black);
            step1.setPosition(new Vec2(5,-20f));
        }
        

        
  


        { // make a character
//            bird = new Ball(this);
//            bird.setPosition(new Vec2(0, -6));
            
                
        }

        
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
            death1.setPosition(new Vec2(20f, 0));
            death1.addCollisionListener(new LiveDown(getPlayer()));
            
            Body death2 = new Ghost3(this);
            death2.setPosition(new Vec2(17, -17));
            death2.addCollisionListener(new LiveDown(getPlayer()));
            
            Body death3 = new Ghost3(this);
            death3.setPosition(new Vec2(-18, -4));
            death3.addCollisionListener(new LiveDown(getPlayer()));
            
//              
//            Body star = new Star(this);
//            star.setPosition(new Vec2(0,12.5f));
//            star.addCollisionListener(new StarEnd(bird));
           
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
//            instruction = new Instruction(this);
//            instruction.setPosition(new Vec2(-20,10));
        }
        

        
        {
            
            background = new Background4(this);
            background.setPosition(new Vec2(0,0));
        }
        
   
    }
    
//    public Ball getPlayer() {
//        return bird;
//    }
    
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(0,12);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getOrangeCount() == NUM_ORANGES;
    }
}
