package game;

import city.cs.engine.*;
import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * this is the declaration of the public class called Game.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private Score view;
    
    private int level;
    
    private Controller controller;
    
    
    
    /** Initialise a new Game. */
    public Game() {
        // make the world
        
        level = 1;
        world = new GameWorld();
        world.populate(this);

        // make a view
        //view = new UserView(world, 1200, 700);
        view = new Score(world, world.getPlayer(), 1200, 700);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        JFrame frame = new JFrame("Multi-level game");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        
        ExitPanel exitPanel = new ExitPanel(world);
        frame.add(exitPanel, BorderLayout.SOUTH);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);

        // start!
        world.start();
    }
    
    /** The player in the current level.
     * @return  */
    public Ball getPlayer() {
        return world.getPlayer();
    }
    
    /** Is the current level of the game finished?
     * @return  */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    
    /** Advance to the next level of the game. */
    public void goNextLevel() {
        //world.stop();
             
//            level++;
//            System.out.println("Going to next level...");
//
//            // get a new world
//            world = new GameWorld2();
//            // fill it with bodies
//            world.populate(this);
//            view.setPlayer(world.getPlayer());
//            // switch the keyboard control to the new player
//            controller.setBody(world.getPlayer());
//            // show the new world in the view
//            view.setWorld(world);
//
//            world.start();
        if (level == 3) {
            System.out.println("you win");
            System.exit(0);
        }
//        if (level == 4) {
//            System.out.println("Going to next level...");
//            level = 6;
//            // get a new world
//            world = new GameWorld3();
//            // fill it with bodies
//            world.populate(this);
//            view.setPlayer(world.getPlayer());
//            // switch the keyboard control to the new player
//            controller.setBody(world.getPlayer());
//            // show the new world in the view
//            view.setWorld(world);
//            
//            //view = new Score(world);
//
//            world.start();
//        }
        if (level == 2) {
            System.out.println("Going to next level...");
            level++;
            // get a new world
            world = new GameWorld3();
            // fill it with bodies
            world.populate(this);
            view.setPlayer(world.getPlayer());
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            
            //view = new Score(world);

            world.start();
        }
        
        else {
            System.out.println("Going to next level...");
            level++;
            // get a new world
            world = new GameWorld2();
            // fill it with bodies
            world.populate(this);
            view.setPlayer(world.getPlayer());
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            
            //view = new Score(world);

            world.start();
        }
        
//        else{
//            System.out.println("Going to next level...");
//            level++;
//            // get a new world
//            world = new GameWorld2();
//            // fill it with bodies
//            world.populate(this);
//            view.setPlayer(world.getPlayer());
//            // switch the keyboard control to the new player
//            controller.setBody(world.getPlayer());
//            // show the new world in the view
//            view.setWorld(world);
//            
//            //view = new Score(world);
//
//            world.start();
//            
//        }
            
   
    } 
        
    

    /** Run the game.
     * @param args */
    public static void main(String[] args) {
        new Game();
    }
}
