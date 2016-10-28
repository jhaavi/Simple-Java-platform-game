package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


/**
 * this is the declaration of the public Ball class. the class creates the
 * main charecter bird for the game. it is declared publicly so that the class can be accessed
 * from other classes. it extends Walker as the user controls the bird and it needs to be able to move.
 */
public class Ball extends Walker {

    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.
    
    private static final Shape shape = new PolygonShape(-0.148f*4,-0.419f*4, -0.46f*4,-0.191f*4, 
            -0.419f*4,0.11f*4, -0.163f*4,0.324f*4, 0.278f*4,0.276f*4, 0.419f*4,-0.066f*4, 0.211f*4,-0.385f*4);

    private static final BodyImage image = new BodyImage("data/play1.png", 4f);

    private int orangeCount;
    private int lives;
    //public EndGame endGame;
    
    /**
     *
     * @param world
     */
    public Ball(World world) {
        super(world, shape);
        addImage(image);
        orangeCount = 0;
        lives = 3;
        //SolidFixture fixture = new SolidFixture(this, shape, 5.0f);
        //fixture.setRestitution(0.5f);
        
    }

    /**
     *this is a public method to get the number of oranges the user has picked up. 
     * @return
     */
    public int getOrangeCount() {
        return orangeCount;
        
    }

    /**
     *this is a public method to make the system print the number of oranges that have been 
     * picked up.
     */
    public void incrementOrangeCount() {
        orangeCount++;
        System.out.println("Tasty!  Heart count = " + orangeCount);
    }
    
    /**
     *this is a public method to  decrease the number of lives when the player interacts with a ghost.
     * it also checks if the number of lives is 0 then the system exits and the game closes.
     */
    public void decreaseLives(){
        lives--;
        System.out.println("You lost a life. Lives: " + lives);
        if (lives == 0){
            //System.exit(0);
            //endGame.end();
            //endGame.Endgame();
            System.out.println("You Lose");
            System.exit(0);
            
            //endGame.endGame();
            
            
            
        }
    }


      
    
    
    
}
