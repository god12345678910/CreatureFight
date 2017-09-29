import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreatureWorld extends World
{
    private Creature playerOneCreature;
    private Creature playerTwoCreature;
    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 900, 1); 
        playerOneCreature = new Charmander(this);
        playerTwoCreature = new Pikachu(this);
        

        prepareCreatures();
    }
    
    private void prepareCreatures()
    {
       addObject(playerOneCreature, playerOneCreature.getImage().getWidth() - playerOneCreature.getImage().getWidth()/2, getHeight()- playerOneCreature.getImage().getHeight()/2);
       addObject( new Button(Color.RED,50), getWidth()/2 , getHeight() - 100); 
       addObject(playerTwoCreature, getWidth() - playerTwoCreature.getImage().getWidth()/2, playerTwoCreature.getImage().getHeight()/2);
       addObject( new Button(Color.RED,50), getWidth()/2 , getHeight() - 825); 

    }
    
    public Creature getPlayerOne()
    {
        return playerOneCreature;
    }
    
    public Creature getPlayerTwo()
    {
        return playerTwoCreature;
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
    }
}
