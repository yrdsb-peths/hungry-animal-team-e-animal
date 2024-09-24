import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label titleLabel = new Label("Hungry Animal", 60);
        addObject(titleLabel,300,104);
        
        Label label = new Label("Use \u2190 \u2192 to Move", 40);
        addObject(label,300,281);
        
        Label label2 = new Label("Press <space> to Start", 40);
        addObject(label2,300,332);
    }
}
