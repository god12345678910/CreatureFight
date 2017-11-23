import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Name: ChukwuDalu Onwuekwe
 * Course: CS20S
 * Teacher: Mr. Hardman
 * Lab #2, Program #1
 * Date Last Modified: Nob/2/17
 *
 */

public class CreatureWorld extends World
{
    private Creature playerOneCreature;
    private Creature playerTwoCreature;
    private boolean playerOneTurn;
    private String playerOneName;
    private String playerTwoName;
    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;
    private boolean start;
    private boolean playerOneMenusAdded;
    private boolean playerTwoMenusAdded;
    
    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1); 
        playerOneCreature = new Charmander(this);
        
        playerTwoCreature = new Pikachu(this);
        
        start = true;

        prepareCreatures();
        
        Greenfoot.start();
    }
    
    private void prepareCreatures()
    {
       addObject(playerOneCreature, playerOneCreature.getImage().getWidth() - playerOneCreature.getImage().getWidth()/2, getHeight()- playerOneCreature.getImage().getHeight()/2);
       
       addObject(playerTwoCreature, getWidth() - playerTwoCreature.getImage().getWidth()/2, playerTwoCreature.getImage().getHeight()/2); 

    }
    
    public Creature getPlayerOne()
    {
        return playerOneCreature;
    }
    
    public Creature getPlayerTwo()
    {
        return playerTwoCreature;
    }
    
    public boolean isPlayerOneTurn()
    {
       return playerOneTurn; 
    }
    
    public void setTurnNumber(boolean turn)
    {
        playerOneTurn = turn;
    }
    
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        List allObjects = getObjects(null);

        if( start == true )
        {
            playerOneName = JOptionPane.showInputDialog(" Player One, please enter your name:", null);          
            playerTwoName = JOptionPane.showInputDialog(" Player Two, please enter your name:", null);           
            oneFightMenu = new  Menu( " Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
            oneSwitchMenu = new Menu( " Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            addObject( oneFightMenu, 173, getHeight() - 100);
            addObject( oneSwitchMenu, 241, getHeight() - 100);
            twoFightMenu = new Menu( "Fight","Tackle\n Thunderbolt",24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
            twoSwitchMenu = new Menu( "switch","lapras\n pidgeot",24,Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );

            addObject( twoSwitchMenu, 199, 75 );
            addObject( twoFightMenu, 131, 75 );
          
          
            start = false;
	        playerOneTurn = true;
        }
        else if(playerOneTurn == true )
        {
            showText(playerOneName + "it's your Turn", getWidth() / 2, getHeight() / 2 );
            showText( "" , getWidth() /2, getHeight()/2 + 26);
        }
        else
        {
            showText(playerTwoName + "it's your Turn" , getWidth() / 2, getHeight() / 2);
            showText( "" , getWidth() /2, getHeight()/2 + 26);
        }
        
        
        if( playerOneCreature.getHealthBar().getCurrent() <=0)
        {
            removeObjects(allObjects);
            showText( " Player Two Wins! " , getWidth() / 2, getHeight() / 2);
            showText( "" , getWidth() /2, getHeight()/2 + 26);
            Greenfoot.stop();
        }
        
        if( playerTwoCreature.getHealthBar().getCurrent() <=0)
        {
            removeObjects(allObjects);
            showText( " Player One Wins! " , getWidth() / 2, getHeight() / 2);
            showText( "" , getWidth() /2, getHeight()/2 + 26);
            Greenfoot.stop();
        }
    }
}
